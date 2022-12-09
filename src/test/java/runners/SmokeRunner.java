package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        // features we use to provide the path of all the features files
        features = "src/test/resources/features/",
        glue = "steps",
        //when you set dryRun to true, it stops actual execution
        //it will quickly scan all the gherkin steps whether they are implemented ot not
        dryRun = false,
        // when we set dry run to false, it starts execution again
        tags = "@test",

        // to remove irrelevant information from console, you need to set monocrome to true
        monochrome = true,
        // pretty keyword prints the steps in the console to increase readability
        plugin = {"pretty"}


)


public class SmokeRunner {

}
