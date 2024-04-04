package flowchartmaker.runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/featurefiles", glue = {
"flowchartmaker.steps", "flowchartmaker.hooks"},

monochrome = true, 
tags ="@Flowchart_TC",
dryRun =false,
plugin = { "json:target/cucumber-report-html.json", 
		"html:target/cucumber-report-html/reports.html",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "pretty" }

)
public class TestRunner extends AbstractTestNGCucumberTests{	
	
	@Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
        
    
    }
}






