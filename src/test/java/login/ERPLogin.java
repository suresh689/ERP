package login;
import datadriven.*;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class ERPLogin {
	public WebDriver driver;
	public ExcelLibrary xlib;
	
  @BeforeClass
  public void beforeClass() {
	  xlib=new ExcelLibrary();
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
	  driver.get("https://my-pgi.com/KnowledgePro/Login.do");
	  
	  	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  
	  
		  String un=xlib.getExcelData("login", 1, 0);
		  driver.findElement(By.name("userName")).sendKeys(un);
		  String pwd=xlib.getExcelData("login", 1, 1);
		  driver.findElement(By.name("password")).sendKeys(pwd);
	  
	  
	  
	  /*
	  ResourceBundle rb=ResourceBundle.getBundle("config");
	  String un=rb.getString("username");
	  String pwd=rb.getString("password");
	  
	  driver.findElement(By.name("userName")).sendKeys(un);
	  driver.findElement(By.name("password")).sendKeys(pwd);
	  */
	  driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
	  
	  
  }

  @AfterMethod
  public void afterMethod() {
	  
	  driver.findElement(By.xpath("(//a[@class=\"heading_white\"])[5]")).click();
	  
  }

  
  

  @AfterClass
  public void afterClass() {
	  
	  driver.close();
  }

}
