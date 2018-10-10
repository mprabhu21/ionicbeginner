package Nomisma_Admin_Login;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Check_for_Login_Error_Message {
	static WebDriver driver;

	public static void main(String[] args) throws IOException, InterruptedException   {
		// TODO Auto-generated method stub
		String url= "https://www.nomismasolution.co.uk/sme/admin/";
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
		Error_Message();
		Error_Message1();
		Error_Message2();
		Error_Message3();
		Reset_Button();
		}
	
	static void Error_Message() throws InterruptedException 
	{
		Thread.sleep(2000);
		driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("mn@mn.in");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("test");
		driver.findElement(By.id("submit")).click();
		String Expected_Message= "Username / Password is wrong, Please try again.";
		String Message=driver.findElement(By.xpath(".//*[@id='loginform']/div[2]")).getText();
		if(Expected_Message.equals(Message)) 
        {
    	System.out.println("Error Message"+" - "+Message);
    	System.out.println("Login Failed");	 
        
    	} 
		System.out.println("Message Successful");
	}
	
	static void Error_Message1() 
	{
		driver.findElement(By.id("submit")).click();
		String Expected_Message1= "Please enter email";
		String Message1=driver.findElement(By.xpath(".//*[@id='eval']")).getText();
		if(Expected_Message1.equals(Message1)) 
        {
    	System.out.println("Error Message"+" - "+Message1);
    	System.out.println("Login Failed");	 
        
    	} 
		System.out.println("Message1 Successful");
	}
	
	static void Error_Message2() throws InterruptedException 
	{
		Thread.sleep(2000);
		driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("mn@mn.in");
        driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("submit")).click();
		String Expected_Message2= "Please enter password";
		String Message2=driver.findElement(By.xpath(".//*[@id='eval']")).getText();
		if(Expected_Message2.equals(Message2)) 
        {
    	System.out.println("Error Message"+" - "+Message2);
    	System.out.println("Login Failed");	 
        
    	} 
		System.out.println("Message2 Successful");
	}
	
	static void Error_Message3() throws InterruptedException 
	{
		Thread.sleep(2000);
		driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("crmsupport");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("crmsupport");
		driver.findElement(By.id("submit")).click();
		String Expected_Message3= "The Email field must contain a valid email address.";
		String Message3=driver.findElement(By.xpath(".//*[@id='eval']")).getText();
		if(Expected_Message3.equals(Message3)) 
        {
    	System.out.println("Error Message"+" - "+Message3);
    	System.out.println("Login Failed");	 
        
    	} 
		System.out.println("Message3 Successful");
	}
	
	static void Reset_Button() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("crmsupport");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("crmsupport");
        Thread.sleep(2000);
        driver.findElement(By.xpath(".//*[@id='loginform']/div[5]/input[2]")).click();
        String Username=driver.findElement(By.id("username")).getAttribute("value");
        System.out.println(Username);
        if(Username.isEmpty()) 
        {
        	System.out.println("Reset Button works fine");
        }
	}

 }
