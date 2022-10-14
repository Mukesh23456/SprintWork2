

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features="D:\\capgemini\\selenium\\selenium demo\\SprintWork2.0\\src\\test\\resources\\features",
glue= {"steps"},
plugin = { "html:target/cucumber_reports.html","json:target/cucumber.json","pretty:target/cucumber-pretty.txt",
		"usage:target/cucumber-usage.json","junit:target/cucumber-resources.xml"})


public class TestRunner extends AbstractTestNGCucumberTests{

}
