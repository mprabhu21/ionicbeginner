package Nomisma_Admin_Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Check_For_URL {
	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Check the IP address
		String url= "http://192.168.0.2/nomismasolution_ci/admin/index/dlogin.html";
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		String Title = driver.getTitle();
        System.out.println("Title:" + Title);

	}
	 public void Login() throws InterruptedException 
	 {
		 String url= "http://192.168.0.2/nomismasolution_ci/admin/index/dlogin.html";
			driver = new ChromeDriver();
			driver.get(url);
			driver.manage().window().maximize();
			Thread.sleep(2000);			
	        driver.findElement(By.id("username")).sendKeys("admin@nomismasolution.com");	        
	        driver.findElement(By.id("password")).sendKeys("test");
	        driver.findElement(By.id("submit")).click();
	 }

}
