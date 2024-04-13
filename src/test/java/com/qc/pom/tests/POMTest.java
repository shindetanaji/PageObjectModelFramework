package com.qc.pom.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qc.pom.pages.DashboardPage;
import com.qc.pom.pages.LoginPage;

public class POMTest extends BaseIntegration {

	@Test(dataProvider = "loginData")
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
	
	@Test
	public void doRegister() {
		
	}
}
