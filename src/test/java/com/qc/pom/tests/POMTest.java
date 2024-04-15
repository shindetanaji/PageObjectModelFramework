package com.qc.pom.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qc.pom.pages.DashboardPage;
import com.qc.pom.pages.LoginPage;
import com.qc.pom.pages.RegisterPage;

public class POMTest extends BaseIntegration {

	@Test(dataProvider = "loginData", priority = 1)
	public void doLogin(String testName, String uName, String uPass) {
		LoginPage login = new LoginPage(driver);
		if (testName.equals("Both are valid")) {
			DashboardPage dash = login.loginWithValid(uName, uPass);
			Assert.assertTrue(dash.verifyDashboardPageTitle());
			dash.doLogout();
		}else {
			login.loginWithInValid(uName, uPass);
			Assert.assertTrue(login.verifyLoginPageTitle());
		}
	}
	
	@Test(dataProvider = "registerData", priority = 2)
	public void doRegister(String testName, String uName, String uMobile, String uEmail, String uPass) {
		LoginPage login = new LoginPage(driver);
		if(driver.getTitle().equals("Queue Codes | Log in")) {
			login.clickOnRegister();
		}
		RegisterPage register = new RegisterPage(driver);
		register.doRegisterWithValid(uName, uMobile, uEmail, uPass);
		if(testName.equals("All are valid")) {
			Assert.assertTrue(register.verifyAlertMsg());
		}else {
			Assert.assertTrue(register.verifyRegisterTitle());
		}
	}
}
