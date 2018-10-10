package Nomisma_Admin_Login;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.NoSuchElementException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Check_For_Login {
	   static WebDriver driver;
	   
	  
	

	public static void main(String[] args) throws IOException, InterruptedException {
				// TODO Auto-generated method stub
		
		
		File src=new File("E:\\Workspace\\Excel\\Nomisma_SME_Login_Credentials.xlsx");
		FileInputStream fis=new FileInputStream(src);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheetAt(0);
		int rowcount=sheet.getLastRowNum();
		System.out.println("Total no. of rows"+" "+rowcount);
		
		
		for (int i=0;i<=rowcount;i++)
		{
			//Another way of getting data from EXCEL
			/*for(int i=0;i<=1;i++) 
			 {
			Row row = sheet.getRow(i);
			Cell cell = row.getCell(j);
			System.out.println(sheet.getRow(i).getCell(j));
					
			}*/		    		
			String email=sheet.getRow(i).getCell(0).getStringCellValue();
			System.out.println("Email"+" - "+email);
			String password=sheet.getRow(i).getCell(1).getStringCellValue();
			System.out.println("Password"+" - "+password);
			Thread.sleep(2000);
			driver.findElement(By.id("username")).clear();
	        driver.findElement(By.id("username")).sendKeys(email);
	        driver.findElement(By.id("password")).clear();
	        driver.findElement(By.id("password")).sendKeys(password);
	        driver.findElement(By.id("submit")).click();
	        
	       /* String Message=driver.findElement(By.xpath(".//*[@id='loginform']/div[2]")).getText();              
	        String Expected_Message= "Username / Password is wrong, Please try again.";
	       
	        
	        	if(Expected_Message.equals(Message)) 
	            {
	        	System.out.println("Error Message"+" - "+Message);
	        	System.out.println("Login Failed");	        
	            
	        	}  
	        	else {	       
	        		
	        		System.out.println("Login Succefull");
	        	}*/	        	
	                        
	        }
		System.out.println("Credentials validation Successful");
		String Dashboard=driver.findElement(By.xpath(".//*[@id='wrapper']/div/div[2]/div/div")).getText();
		System.out.println(Dashboard);
		System.out.println("Dashbard opened Successfully");
		}    	  
		
		
}
