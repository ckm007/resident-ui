package io.mosip.test.residentTest.testcase;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.mosip.test.residentTest.utility.Commons;
import io.mosip.test.residentTest.utility.JsonUtil;
import io.mosip.test.residentTest.utility.ResidentBaseClass;

public class BookinganAppointment extends ResidentBaseClass {

	@Test
	public void bookinganAppointment () throws Exception {
		 String externalemail=JsonUtil.JsonObjParsing(Commons.getTestData(),"externalemail");
		
		
		
		Commons.click(test,driver, By.id("dashboardCard3"));
		Commons.click(test,driver, By.xpath("(//div[text()=' LOGIN'])[2]"));
		Commons.click(test,driver, By.xpath("//mat-select[@role='listbox']"));
		//Commons.dropdown(driver, By.id("mat-select-0"));
		//Commons.dropdown(driver, By.id("mat-select-0"), "français");
		//Commons.enter(driver, By.id("inputFieldContact"), "Resident_AddIdentity_ValidParam_smoke_Pos@mosip.net");
		
		
		
		
		
	}
}