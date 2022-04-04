package stepDefination;



import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import pageObjects.CustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

public class BaseClass {
	
	public WebDriver driver;
	LoginPage lp;
	CustomerPage Cust;
	SearchCustomerPage Searchcust;
	public static Logger logger;
	public Properties configProp;
	// To generate unique email ID for customers
	
	public static String randomestring() {    //when we use static, you can call it without creating any object
		
		String generatedstring1=RandomStringUtils.randomAlphabetic(5);
		return(generatedstring1);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
