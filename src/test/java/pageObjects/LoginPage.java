 package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	public  LoginPage(WebDriver driver)
	{
	 	
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

	
	@FindBy(id="Email")
	WebElement txtEmail;
	
	@FindBy(name="Password")
	WebElement txtPassword;
	
	@FindBy(xpath="//button[contains(text(),'Log in')]")
	WebElement btnlogin;
	
	@FindBy(xpath="//a[contains(text(),'Logout')]")
	WebElement btnLogOut;
		
	
	public void setemail(String email)
	{
		txtEmail.clear();
		txtEmail.sendKeys(email);
	}
	
	public void setpassword(String pwd)
	{
		txtPassword.clear();
		txtPassword.sendKeys(pwd);
	}
	
	public void Clicklogin()
	{
		btnlogin.click();
		
	}
		
	public String getPagetitle()
	{
		return driver.getTitle();
	}
	
	 public void ClicklogOut()
     {
    	 btnLogOut.click();
     }
	 
	
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
}

