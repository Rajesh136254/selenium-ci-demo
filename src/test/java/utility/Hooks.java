package utility;

import io.cucumber.java.Before;
import io.cucumber.java.After;


import org.openqa.selenium.WebDriver;

public class Hooks {
    public static WebDriver driver;

    @Before
    public void setUp(){
        driver = BrowserDriver.getDriver();
    }
    @After
    public void tearDown(){
        BrowserDriver.closeDriver();
    }

}

