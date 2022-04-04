package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;

public class CustomerPage {
	public WebDriver ldriver;
	
	
	public CustomerPage(WebDriver driver)
	{
		ldriver= driver;
		PageFactory.initElements(driver, ldriver);
		
	}

	
	By txtcustomers=By.xpath("//a[@href='#']//p[contains(text(),'Customers')]");
	
	
	By txtcustoMenu =By.xpath("//a[@href='/Admin/Customer/List']//*[contains(text(),'Customers')]");
	
	By Searchemail=By.id("SearchEmail");
	
	By Searchbtn=By.id("search-customers");  
	
	By CustomerEmail=By.xpath("//input[@id='Email']");
	;
	
	By CustomerPassword=By.xpath("//input[@id='Password']");
	
	
	By Namecust=By.name("FirstName");
	
	
	By LastNamecust=By .name("LastName");
	
	
	By Malecust=By.xpath("//input[@id='Gender_Male']");
	
	By Femalecust= By.xpath("//input[@id='Gender_Female']");
    
	
	By Dateofbirth= By.xpath("//input[@id='DateOfBirth']");
	
	By DeleteRegbtn=By.xpath("//span[@title='delete']");
	
	By CustomerRole=By.xpath("//*[@id=\"customer-info\"]/div[2]/div[10]/div[2]/div/div[1]/div/div");
	
	
	By MgrofVendor=By.xpath("//*[@id=\"VendorId\"]");

	
	By Savebtn=By.name("save");
	
	By Dashboard=By.xpath("//p[contains(text(),'Dashboard')]");
	
	
	By genderCust=By.xpath("//label[contains(text(),'Gender')]");
	 
	By btnAddnew=By.xpath("//a[contains(@href,'/Admin/Customer/Create')]");
	
    By RolAdministators=By.xpath("//li[@id=\"a510f16a-b925-4cbe-9813-54ce672676a3\"]");
    
    By RolGuests= By.xpath("//li[contains(text(),'Guests')]");
    
    By RolRegisteed= By.xpath("//li[contains(text(),'Registered')]");
    
    By RolVendors= By.xpath(" //li[contains(text(),'Vendors')]");
    
    By Message=By.xpath("//div[@class='alert alert-success alert-dismissable']");
    
   
    
    
	
	public void setFirstname(String fname)
	{
		ldriver.findElement(Namecust).sendKeys(fname); 
	}
	
	
	public void setLastname(String lname)
	{
		ldriver.findElement(LastNamecust).sendKeys(lname);
	}
	
	public void setPassword(String Pword)
	{
		ldriver.findElement(CustomerPassword).sendKeys(Pword);
	}
	
	public void ClickCustomers()
	{
		ldriver.findElement(txtcustomers).click();
	}
	
	
	public void ClickCustomerMenu()
	{
		
		ldriver.findElement(txtcustoMenu).click();
	}
	
	public void Clicksavebutton()
	{
		ldriver.findElement(Savebtn).click();
		
	}
	
	public void AddnewCustomers()
	{
		ldriver.findElement(btnAddnew).click();
	}
	
	
	public void setemail(String email)
	{
		ldriver.findElement(CustomerEmail).sendKeys(email);
		
	}
	
	
	
	public void setManagerofvendor(String value)
	{
		Select drp=new Select(ldriver.findElement(MgrofVendor));
		drp.selectByVisibleText(value);
	}
	
	
	public void setGender(String gender)
	{
		
	  if(gender.equals("Male"))
	  {
		  ldriver.findElement(Malecust).click();
	  }
	  else if(gender.equals("Female"))
	  {
		 ldriver.findElement(Femalecust).click(); 
	  }
	  else
	  {
		  ldriver.findElement(Malecust).click(); //Default
	  }
		
	   
 	}
	
	public void setCustomerRoleM(String role) throws Exception
	{
	   if(!role.equals("vendors"))
	   {
		   ldriver.findElement(By.xpath(" //li[contains(text(),'Vendors')]"));
	   }
	    ldriver.findElement(CustomerRole).click();
		
	   WebElement listitem;
	   
	   Thread.sleep(3000);
	   
	   if(role.equals("Administrators"))
	   {
		   listitem=ldriver.findElement(RolAdministators);
	   }
	   else if(role.equals("Guests"))
	   {	   
		 listitem=ldriver.findElement(RolGuests);  
	   }
	   else if(role.equals("registered"))
	   {
		   listitem=ldriver.findElement(RolRegisteed);
	   }
	   
	}
	
	
	public void SetDateofbirth(String Dob)
	{
		ldriver.findElement(Dateofbirth).sendKeys(Dob);
	}
	
	public void ClickdeleteRegistered()
	{	
		ldriver.findElement(DeleteRegbtn).click();
	}
	
	public void ClickCustomerRoles()
	{
		ldriver.findElement(CustomerRole).click();
	}
	
    public void ClickRoleGuests()
    {
    	
    	ldriver.findElement(RolGuests).click();
    }
    
   
    	
    	
    	
    
    
    
    
    
    
    
    
    
    
    
}
