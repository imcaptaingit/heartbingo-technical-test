package uk.co.heartbingo.testbase;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import uk.co.heartbingo.propertyreader.PropertyReader;
import uk.co.heartbingo.utility.Utility;

/**
 * Author - Sarvat Shaikh
 * Project Name: heartbingo-technical-test
 */

public class BaseTest extends Utility {

    String browser = PropertyReader.getInstance().getProperty("browser");

    @BeforeMethod
    public void setUp(){
        selectBrowser(browser);
    }

    @AfterMethod
    public void tearDown(){
        closeBrowser();
    }
}
