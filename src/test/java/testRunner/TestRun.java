package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions
     (
	  features=".//Features/Customers.feature",
	  glue="stepDefination",
	  dryRun=false ,
	  monochrome=true,
	  plugin= {"json:target/cucumber.json"},
      tags = "(@regression or @sanity)"
      )



public class TestRun {

}
