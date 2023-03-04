package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "C:\\Users\\abdelrahman.ahmed\\Downloads\\Test-master\\src\\main\\resources\\features",
        glue = {"org.example.stepDefinations"},
        tags = "@smoke",
        plugin = { "pretty",
        "html:target/cucumber.html",
        "json:target/cucumber.json",
        "junit:target/cukes.xml",
        "rerun:target/rerun.txt"}
)



public class runner extends AbstractTestNGCucumberTests {

}
