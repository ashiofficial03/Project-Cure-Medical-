package com.automation.health.demo_healthpage;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class CureWebpage {
	ChromeOptions options;
	WebDriver driver;
	@BeforeSuite
	public void Setup() {
		options=new ChromeOptions();
		options.addArguments("--start-maximized");
		driver=new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}
	@Test(priority=1)
	@Severity(SeverityLevel.BLOCKER)
	@Description("Verify Login with valid username and password for Medical")
	public void loginwitvalid() throws InterruptedException {
		driver.get("https://katalon-demo-cura.herokuapp.com");
		driver.findElement(By.id("btn-make-appointment")).click();
		//p[@class="lead text-danger"]
		
		//Verifying first page
		Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/profile.php#login");
		//Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@placeholder=\"Username\"])[2]")).sendKeys("John Doe");
		driver.findElement(By.id("txt-password")).sendKeys("ThisIsNotAPassword");
		driver.findElement(By.id("btn-login")).click();
		Thread.sleep(2000);
		//Verifying second page
		Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/#appointment");
			//driver.findElement(By.id("sidebar-wrapper")).click();
			//Thread.sleep(2000);
			//driver.findElement(By.xpath("//a[@href=\"authenticate.php?logout\"]")).click();
			//hread.sleep(2000);
	}
}
