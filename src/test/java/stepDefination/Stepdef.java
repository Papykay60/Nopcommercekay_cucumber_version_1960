package stepDefination;





import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pageObjects.CustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

public class Stepdef extends BaseClass{
	public WebDriver driver;
	LoginPage lp;
	CustomerPage cust;
	SearchCustomerPage searchcust;
	
	@Before
	public void setup() throws IOException
	{	//Reading config.properties file
		configProp= new Properties(); // By creating this class we are instantiating Property we created B/class
		FileInputStream configpropfile=new FileInputStream("config.properties"); //import java.io
		configProp.load(configpropfile);
		logger=Logger.getLogger("Nopcommercekay");
		PropertyConfigurator.configure("Log4j.properties");
	  
		String br=configProp.getProperty("browser");
	
		if(br.equals("chrome"))
		{
	      System.setProperty("webdriver.chrome.driver",configProp.getProperty("chromepath"));
	      driver=new ChromeDriver();
		}
		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",configProp.getProperty("firefoxpath"));
		      driver=new FirefoxDriver();
		      
		}
		else if(br.equals("edge"))
		{
			System.setProperty("webdriver.edge.driver",configProp.getProperty("edgepath"));
		      driver=new EdgeDriver();
			
		}
		
		
		
		
		
		
		
		
	}
	
	
	@Given("User launch Chrome browser")
	public void user_launch_chrome_browser() throws InterruptedException {
		
	    lp=new LoginPage(driver);
	    logger.info("*********Launching browser");
	    Thread.sleep(5000);
	}

	

	@When("User opens URL {string}")
	public void user_opens_url(String url) throws InterruptedException {
	  driver.get(url); 
	  driver.manage().window().maximize();
	  logger.info("********Application Url open");
	  Thread.sleep(3000);
	}

	@When("user enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String email, String password) throws InterruptedException {
		lp.setemail(email);
	    lp.setpassword(password);
	    logger.info("******User enter login details");
	    Thread.sleep(3000);
	}

	@When("Click on Login button")
	public void click_on_login_button() throws Exception {
	   lp.Clicklogin();
	   logger.info("User click on login details");
	   Thread.sleep(3000);
	}

	@Then("page Title should be {string}")
	public void page_title_should_be(String title) throws Exception {
	    if(driver.getPageSource().contains("Login was unsuccessful")) {
	    	driver.close();
	    Assert.assertTrue(false);
	    } else {
	   
	    	Assert.assertEquals(title, driver.getTitle());
	    	logger.info("***********Login status confirmed");
	    	Thread.sleep(3000);
	    }  
	    
	}

	@When("User click on log out link")
	public void user_click_on_log_out_link() throws Exception {
	   lp.ClicklogOut();
	   logger.info("*******User log out of application");
	   Thread.sleep(3000);
	}

	@Then("close browser")
	public void close_browser() {
		logger.info("User log out of application");
	    driver.quit();
	}

	//Add a new Customer
	
	@Then("User view the Dashboard")
	public void user_view_the_dashboard() throws InterruptedException {
		
    lp= new LoginPage(driver);
	Assert.assertEquals("Dashboard / nopCommerce administration", lp.getPagetitle());
	Thread.sleep(3000);   
	}

	@When("User click on customers Menu")
	public void user_click_on_customers_menu() throws Exception {
		
	Cust= new CustomerPage(driver);
	Cust.ClickCustomers();
	Thread.sleep(3000);	   
	}

	@When("click on customers Menu item")
	public void click_on_customers_menu_item() throws Exception {	
	Cust.ClickCustomerMenu(); 
	Thread.sleep(4000);	
	}

	@When("click on Add new button")
	public void click_on_add_new_button() throws Exception {	
	Cust.AddnewCustomers();
	Thread.sleep(3000);
	}

	@Then("User can view Add new customer page")
	public void user_can_view_add_new_customer_page() throws Exception {
		
	Thread.sleep(3000);
	Assert.assertEquals("Add a new customer / nopCommerce administration", lp.getPagetitle());
	}

	@When("User enter customer info")
	public void user_enter_customer_info() throws Exception {
	  String email= randomestring()+"@gmail.com";
	  Cust.setemail(email);
	  Cust.setPassword("Mankay123");
	  
	  Cust=new CustomerPage(driver);
	  Cust.setFirstname("Kayode"); 
	  Cust.setLastname("Julius");
	  Cust.setGender("Male");
	  Cust.SetDateofbirth("12/09/2022");
	  Cust.ClickdeleteRegistered();
	  Cust.ClickCustomerRoles();
	  Cust.ClickRoleGuests();

	  
	 

	  Cust.setManagerofvendor("Vendor 2");
	  
	  Thread.sleep(3000);
	}

	@When("click on save button")
	public void click_on_save_button() {
		Cust.Clicksavebutton();
	    
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String string) {
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText()
				.contains("The new customer has been added successfully."));
	            
	}

	//Search Customer by Email
	
	
	@When("Enter customer Email")
	public void enter_customer_email() throws Exception {
		searchcust=new SearchCustomerPage(driver);
		searchcust.SetEmail("victoria_victoria@nopCommerce.com");
	    Thread.sleep(3000);
	}

	@When("Click on search button")
	public void click_on_search_button() throws Exception {
	  searchcust.ClickSearch();
	  Thread.sleep(2000);
	}

	@Then("User should found Email in the Search table")
	public void user_should_found_email_in_the_search_table() throws InterruptedException {
	boolean status =searchcust.searchCustomerEmail("victoria_victoria@nopCommerce.com");
	Assert.assertEquals(true,status);
	 Thread.sleep(2000);	
	}

	
	//Search customer by Name
	
	@When("Enter customer FirstName")
	public void enter_customer_first_name() throws Exception {
	   searchcust=new SearchCustomerPage(driver);
	   searchcust.SeachFirstname("Victoria");
	   Thread.sleep(2000);
	}

	@When("Enter by customer Lastname")
	public void enter_by_customer_lastname() throws InterruptedException {
	    searchcust.SearchLastname("Terces");
	    Thread.sleep(2000);
	}

	@Then("User should find Name in theSearch table")
	public void user_should_find_name_in_the_search_table() throws Exception {
	 boolean status = searchcust.searchCustomername("Victoria Terces");
	 Assert.assertEquals(true, status);
	 Thread.sleep(2000);
	}



	
	
	
	
	
	
	
	
	
	
	
}
	
	


