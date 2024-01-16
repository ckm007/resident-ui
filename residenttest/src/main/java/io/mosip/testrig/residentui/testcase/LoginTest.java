package io.mosip.testrig.residentui.testcase;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
// Generated by Selenium IDE
//import org.junit.Test;
//import org.junit.Before;
//import org.junit.After;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import io.mosip.testrig.residentui.kernel.util.ConfigManager;
import io.mosip.testrig.residentui.utility.BaseClass;
import io.mosip.testrig.residentui.utility.Commons;
import io.mosip.testrig.residentui.utility.JsonUtil;
import io.mosip.testrig.residentui.utility.MockSMTPListener;
import io.mosip.testrig.residentui.utility.TestRunner;

@Test(groups = "LG")
public class LoginTest extends BaseClass {
	// 
	@Test(priority = 0)
	public static void loginTest() throws Exception {

		String envPath = ConfigManager.getiam_adminportal_path();

		String otp = "";
		String externalemail = ConfigManager.getexternalemail();
		test = extent.createTest("Login Test with valid Vid/UIN", "verify Login");
		driver.get(envPath);
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Commons.clickWebelement(test, driver, By.xpath("//*[@id='UINservices']"));

		Commons.clickWebelement(test, driver, By.id("login_with_otp"));
		Thread.sleep(2000);	

		Commons.enter(test, driver, By.id("Otp_mosip-vid"), TestRunner.perpetualVid);

		try {
			Commons.clickWebelement(test, driver, By.id("get_otp"));

			otp = MockSMTPListener.getOtp(externalemail);
			//	otp="111111";
			System.out.println(otp);
			for (int i = 0; i <= otp.length() - 1; i++) {
				Commons.enter(test, driver, By.xpath("//*[@id='otp_verify_input']//div//input[" + (i + 1) + "]"),
						Character.toString(otp.charAt(i)));
			}
		}catch(Exception e) {
			Thread.sleep(10000);
			Commons.clickWebelement(test, driver, By.id("get_otp"));

			otp = MockSMTPListener.getOtp(externalemail);
			//otp="111111";
			System.out.println(otp);
			for (int i = 0; i <= otp.length() - 1; i++) {
				Commons.enter(test, driver, By.xpath("//*[@id='otp_verify_input']//div//input[" + (i + 1) + "]"),
						Character.toString(otp.charAt(i)));
			}
		}

		test.log(Status.INFO, "Extracted OTP");
		Thread.sleep(2000);

		Commons.click(test, driver, By.id("verify_otp"));
		test.log(Status.INFO, "Click on Verify");

		Thread.sleep(2000);
		try {
			driver.findElement(By.id("dismissBtn")).click();

		}catch(Exception a) {
			Commons.click(test,driver, By.id("authorize_scope"));Commons.click(test,driver, By.id("voluntary_claims"));
			test.log(Status.INFO, "ALL Checkboxes are selected");
			Commons.click(test,driver, By.id("continue"));
			Commons.click(test,driver, By.id("dismissBtn"));
		}
	}










	// @Test(priority = 0)
	public static void loginTestWithTempraryVID() throws Exception {
		String envPath = ConfigManager.getiam_adminportal_path();

		String otp = "";
		String externalemail = ConfigManager.getexternalemail();
		test = extent.createTest("Login Test with valid Vid/UIN", "verify Login");
		driver.get(envPath);
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Commons.clickWebelement(test, driver, By.xpath("//*[@id='UINservices']"));
		try {

			Commons.clickWebelement(test, driver, By.id("here_tab_id"));
			Commons.clickWebelement(test, driver, By.id("more_ways_to_sign_in"));
			Commons.clickWebelement(test, driver, By.id("login_with_otp"));
			Thread.sleep(2000);
		}catch(Exception e) {
			Commons.clickWebelement(test, driver, By.id("login_with_otp"));
			Thread.sleep(2000);	
		}
		Commons.enter(test, driver, By.id("Otp_mosip-vid"), TestRunner.temporaryVid);
		Commons.clickWebelement(test, driver, By.id("get_otp"));

		otp = MockSMTPListener.getOtp(externalemail);

		System.out.println(otp);
		for (int i = 0; i <= otp.length() - 1; i++) {
			Commons.enter(test, driver, By.xpath("//*[@id='otp_verify_input']//div//input[" + (i + 1) + "]"),
					Character.toString(otp.charAt(i)));
		}
		test.log(Status.INFO, "Extracted OTP");
		Thread.sleep(2000);

		Commons.click(test, driver, By.id("verify_otp"));
		test.log(Status.INFO, "Click on Verify");

		Thread.sleep(2000);
		try {
			driver.findElement(By.id("dismissBtn")).click();

		}catch(Exception a) {
			Commons.click(test,driver, By.id("authorize_scope"));Commons.click(test,driver, By.id("voluntary_claims"));
			test.log(Status.INFO, "ALL Checkboxes are selected");
			Commons.click(test,driver, By.id("continue"));
			Commons.click(test,driver, By.id("dismissBtn"));
		}
	}

	// @Test
	public static void loginTestWithOneTimeVID() throws Exception {
		String envPath = ConfigManager.getiam_adminportal_path();

		String otp = "";
		String externalemail = ConfigManager.getexternalemail();
		test = extent.createTest("Login Test with valid Vid/UIN", "verify Login");
		driver.get(envPath);
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Commons.clickWebelement(test, driver, By.xpath("//*[@id='UINservices']"));
		try {

			Commons.clickWebelement(test, driver, By.id("here_tab_id"));
			Commons.clickWebelement(test, driver, By.id("more_ways_to_sign_in"));
			Commons.clickWebelement(test, driver, By.id("login_with_otp"));
			Thread.sleep(2000);
		}catch(Exception e) {
			Commons.clickWebelement(test, driver, By.id("login_with_otp"));
			Thread.sleep(2000);	
		}
		Commons.enter(test, driver, By.id("Otp_mosip-vid"), TestRunner.onetimeuseVid);
		Commons.clickWebelement(test, driver, By.id("get_otp"));

		otp = MockSMTPListener.getOtp(externalemail);

		System.out.println(otp);
		for (int i = 0; i <= otp.length() - 1; i++) {
			Commons.enter(test, driver, By.xpath("//*[@id='otp_verify_input']//div//input[" + (i + 1) + "]"),
					Character.toString(otp.charAt(i)));
		}
		test.log(Status.INFO, "Extracted OTP");
		Thread.sleep(2000);

		Commons.click(test, driver, By.id("verify_otp"));
		test.log(Status.INFO, "Click on Verify");

		Thread.sleep(2000);
		try {
			driver.findElement(By.id("dismissBtn")).click();

		}catch(Exception a) {
			Commons.click(test,driver, By.id("authorize_scope"));Commons.click(test,driver, By.id("voluntary_claims"));
			test.log(Status.INFO, "ALL Checkboxes are selected");
			Commons.click(test,driver, By.id("continue"));
			Commons.click(test,driver, By.id("dismissBtn"));
		}
	}


}