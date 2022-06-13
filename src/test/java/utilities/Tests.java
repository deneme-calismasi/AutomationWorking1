package utilities;

import org.testng.annotations.Test;

public class Tests extends BaseTest {
    TaskMethods taskMethods;

    @Test
    public void testWorkAssignment() {
        taskMethods = new TaskMethods(driver);
        taskMethods.navigateToSiteUrl();
        taskMethods.login();
    }

}
