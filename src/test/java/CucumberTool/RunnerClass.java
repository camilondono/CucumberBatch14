package CucumberTool;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(  // copy absolute path we can also remove everything before src\\...... and it will work also
        features = "C:\\Users\\Camilo E Londono\\IdeaProjects\\CucumberBatch14\\src\\test\\java\\CucumberTool\\Login.feature"
)



public class RunnerClass {



}
