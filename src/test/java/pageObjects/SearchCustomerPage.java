package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.Waithelper;

public class SearchCustomerPage {
	public WebDriver ldriver;
	
	public Waithelper waithelper;
	
	public  SearchCustomerPage(WebDriver rdriver)
	{
		
		ldriver= rdriver;
		PageFactory.initElements(ldriver, this);
		waithelper=new Waithelper(ldriver);
	}

	
	
	
	@FindBy(id="SearchEmail")
     WebElement txtEmail;
	
	@FindBy(xpath=("//input[@id='SearchFirstName']"))
	WebElement txtFirstname;
	
	@FindBy(xpath=("//input[@id='SearchLastName']"))
	WebElement txtLastname; 
	
	@FindBy(id="search-customers")
	WebElement btnSearch;
	
	@FindBy(xpath="//a[contains(@href,'/Admin/Customer/Create')]")
	WebElement btnAddnew;
	
	@FindBy(name="save")
	WebElement btnSave;
	
	@FindBy(xpath="//table[@id='customers-grid']//tbody/tr")
	List<WebElement>tableRows; 
			
	@FindBy(xpath="//table[@id='customers-grid']//tbody/tr/td")
	List<WebElement>tableColumns; 
	
	@FindBy(xpath="//table[@id='customers-grid']//tbody")
	WebElement table;
	
	@FindBy(xpath="//div[@class='content-wrapper']//div[@class='icon-collapse']")
	WebElement Searchdrpdown;
	    		
			
	 

	public void SetEmail(String email)
	{   
		waithelper.WaitForElement(txtEmail, 30);
		txtEmail.clear();
		txtEmail.sendKeys(email);
	}
		
    public void SeachFirstname( String fname)
    {   
    	waithelper.WaitForElement(txtFirstname, 30);
    	txtFirstname.clear();
    	txtFirstname.sendKeys(fname);
    }
	
    public void SearchLastname(String lname)
    {   
    	waithelper.WaitForElement(txtLastname, 30);
    	txtLastname.clear();
    	txtLastname.sendKeys(lname);
    }
	
   public void ClickSearch()
    {
	    waithelper.WaitForElement(btnSearch, 30);
  	    btnSearch.click();
    }
    
   public void SearchButtonDropDown()
   {
	   Searchdrpdown.click();
   }
   
    public int getNoOfRows()
    {
		return(tableRows.size());
    	
    }
    
    public int getNoOfColumn()
    {
		return (tableColumns.size());
    	
    }
         
    public void ClickAddNew()
    {
    	 btnAddnew.click();
    }
     
   public void ClickSave()
    {
    	 btnSave.click();
    }
     
    public boolean searchCustomerEmail(String email)
    {
    			
    	boolean flag=false;
    	
    	for(int i=1;i<=getNoOfRows();i++)
    	{
    		String  emailid=table.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr['i+i']/td[2]")).getText();
    				System.out.println(emailid);
    	
  				  if(emailid.equals(email))
		           {
		        	   flag=true;
		           }	         
  	
	     }
	
    	return flag; 

   
	
	
	

    }

     
    public boolean searchCustomername(String Name)
    {
    
    	boolean flag=false;
    	
    	for(int i=1;i<=getNoOfRows();i++)
    	{
    		String name=table.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr['i+i']/td[3]")).getText();
    	
            String names[]=name.split(" ");
    
          if(names[0].equals("Victoria")&& names[1].equals("Terces"))
            {
	         
            	flag=true;
            }
    	}
    	
		return flag;
    	
    }
}

