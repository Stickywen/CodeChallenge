package com.selenium.codechallenge.TheStraitsTimes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class loginPage {
	 WebDriver driver;
	
	public loginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
	}

	public void LoginPage()
	{
		 String errormsg = driver.findElement(By.xpath("//form[@id='loginForm']/p")).getText();
		 System.out.println(errormsg);
		 if (errormsg.contains("Invalid login"))
			{
				Assert.fail("Invalid login id and/or password, please try again.");
			}
			else
			{
				System.out.println("User logged on");
			}	
	}
	
	public void usercritera()
	{
		String username = "huang.wenwen@hotmail.com";
		String password = "Password2";
		
		driver.findElement(By.id("j_username")).sendKeys(username);
		driver.findElement(By.id("j_password")).sendKeys(password);
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
}
