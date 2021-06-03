package cet;
import login.*;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Cet extends ERPLogin  {
  @Test
  public void f() throws InterruptedException {
	  
	  int lastRowNumber=xlib.getLastRowNumber("cet");
	  driver.findElement(By.name("search")).sendKeys("counselor");
	  driver.findElement(By.id("div_234")).click();
	  
	  for(int i=1;i<=lastRowNumber;i++) {
		 String un=xlib.getExcelData("cet", i, 1);
	  //System.out.println(un);
	  //application number
	  driver.findElement(By.xpath("//input[@name=\"applnNo\"]")).sendKeys(un);
	  
	  //mobile number
	  //driver.findElement(By.xpath("//input[@name=\"mobileNo\"]")).sendKeys(un);
	  
	  //reference number	    
	  //driver.findElement(By.xpath("//input[@name=\"referenceNumber\"]")).sendKeys(un);
	  
	  //npf application number
	  //driver.findElement(By.xpath("//input[@name=\"npfApplnNo\"]")).sendKeys(un);
	  
	  
	  }
	  //Thread.sleep(5000);
  }
}
