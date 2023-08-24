package io.mosip.testrig.residentui.testcase;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.mosip.testrig.residentui.utility.Commons;
import io.mosip.testrig.residentui.utility.JsonUtil;
import io.mosip.testrig.residentui.utility.MockSMTPListener;
import io.mosip.testrig.residentui.utility.ResidentBaseClass;

@Test(groups = "VPNEEI")
public class VerifyPhoneNumberEmailID extends ResidentBaseClass {

	public void VerifyEmailID() throws Exception {
		String externalemail = JsonUtil.JsonObjParsing(Commons.getTestData(), "externalemail");

		Commons.click(test, driver, By.id("dashboardCard4"));
		Commons.click(test, driver, By.id("emailChannelBtn-button"));
		Commons.enter(test, driver, By.id("uin"), vid);
		Commons.switchToFrameByIndex(test, driver, 0);
		Commons.click(test, driver, By.id("recaptcha-anchor"));
		driver.switchTo().parentFrame();
		Thread.sleep(3000);
		Commons.click(test, driver, By.id("sendOtpBtn"));
		// Commons.click(test,driver, By.xpath("//button[text()='Get OTP']"));
		String otp = MockSMTPListener.getOtp(10, externalemail);

		Commons.enter(test, driver, By.id("otp-input"), otp);
		Commons.click(test, driver, By.id("submitOtpBtn"));
		Commons.click(test, driver, By.id("confirmmessagepopup"));
	}

	public void VerifyEmailIDWIthInvalidVid() throws IOException, InterruptedException {
		Commons.click(test, driver, By.id("dashboardCard4"));
		Commons.click(test, driver, By.id("emailChannelBtn-button"));
		Commons.enter(test, driver, By.id("uin"), data);
		Commons.switchToFrameByIndex(test, driver, 0);
		Commons.click(test, driver, By.id("recaptcha-anchor"));
		driver.switchTo().parentFrame();
		Commons.click(test, driver, By.id("sendOtpBtn"));
		Commons.click(test, driver, By.id("confirmmessagepopup"));
	}

	public void VerifyPhoneWIthInvalidVid() throws IOException, InterruptedException {

		Commons.click(test, driver, By.id("dashboardCard4"));
		Commons.click(test, driver, By.id("phoneChannelBtn"));
		Commons.enter(test, driver, By.id("uin"), data);
		Commons.switchToFrameByIndex(test, driver, 0);
		Commons.click(test, driver, By.id("recaptcha-anchor"));
		driver.switchTo().parentFrame();
		Commons.click(test, driver, By.id("sendOtpBtn"));
		Commons.click(test, driver, By.id("confirmmessagepopup"));

	}

	public void VerifyEmailIDWIthInvalidOtp() throws Exception {
		String externalemail = JsonUtil.JsonObjParsing(Commons.getTestData(), "externalemail");
		Commons.click(test, driver, By.id("dashboardCard4"));
		Commons.click(test, driver, By.id("emailChannelBtn-button"));
		Commons.enter(test, driver, By.id("uin"), vid);
		Commons.switchToFrameByIndex(test, driver, 0);
		Commons.click(test, driver, By.id("recaptcha-anchor"));
		driver.switchTo().parentFrame();
		Thread.sleep(3000);
		Commons.click(test, driver, By.id("sendOtpBtn"));
		// Commons.click(test,driver, By.xpath("//button[text()='Get OTP']"));
		String otp = MockSMTPListener.getOtp(10, externalemail);

		Commons.enter(test, driver, By.id("otp-input"), otp + "23");
		Commons.click(test, driver, By.id("submitOtpBtn"));
		Commons.click(test, driver, By.id("confirmmessagepopup"));
	}

	public void VerifyEmailIDWIthoutOtp() throws Exception {
		String externalemail = JsonUtil.JsonObjParsing(Commons.getTestData(), "externalemail");
		Commons.click(test, driver, By.id("dashboardCard4"));
		Commons.click(test, driver, By.id("emailChannelBtn-button"));
		Commons.enter(test, driver, By.id("uin"), vid);
		Commons.switchToFrameByIndex(test, driver, 0);
		Commons.click(test, driver, By.id("recaptcha-anchor"));
		driver.switchTo().parentFrame();
		Thread.sleep(3000);
		Commons.click(test, driver, By.id("sendOtpBtn"));
		// Commons.click(test,driver, By.xpath("//button[text()='Get OTP']"));

		Commons.click(test, driver, By.id("submitOtpBtn"));

	}
}
