package com.selenium.codechallenge.TheStraitsTimes;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

	public class WebTest {

	WebDriver driver;
	String URL = "http://www.straitstimes.com/global";
	String username = "huang.wenwen@hotmail.com";
	String password = "Password1";
	
	@BeforeClass
	public void before()
	 {
		  System.setProperty("webdriver.ie.driver","C:\\Program Files\\Selenium\\Drivers\\IEDriverServer.exe");
		  driver = new InternetExplorerDriver();
	 }
	@Test
	public void Web()
	{
		//1. Go to the url “straitstimes.com”
		driver.get(URL);
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	    
	    try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    //2.Click on login
	    driver.findElement(By.linkText("LOGIN")).click();
	    Login();    
	    Article();
	}

	private void Article() {
		// TODO Auto-generated method stub
		driver.findElement(By.xpath("//div[7]/div/div/div/div[2]/a")).click();
		String title = driver.findElement(By.xpath("//section[@id='block-system-main']/div/div/div/header/h1")).getText();
		if(title.equals("White House denies being soft on Russia, says more sanctions to come"))
		{
			System.out.println("Main article is dislaying");
	
		}else
		{
			System.out.println("Main article is missing");
		}
		
		WebElement image = driver.findElement(By.xpath("//section[@id='block-system-main']/div/div[2]/div/div/div/div/figure/picture/img"));
		if (image.isDisplayed()){
			System.out.println("Picture is present");
		}else
		{
			System.out.println("Picture is missing" );
		}
	}

	private void Login() 
	{
	  //3. Login to the site with Login ID and password (please create one for yourself by signing up)
		driver.findElement(By.id("j_username")).sendKeys(username);
		driver.findElement(By.id("j_password")).sendKeys(password);
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		WebElement ID = driver.findElement(By.name("login-user-name"));
		String name = ID.getText();
		
		//4. Verify the user has been logged in		
		Assert.assertEquals(name,username,"Wrong user logged in");
	}
	
	
	}
	

