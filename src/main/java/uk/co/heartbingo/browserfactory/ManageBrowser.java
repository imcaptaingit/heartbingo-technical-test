package uk.co.heartbingo.browserfactory;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import uk.co.heartbingo.propertyreader.PropertyReader;

import java.time.Duration;

/**
 * Author - Sarvat Shaikh
 * Project Name: heartbingo-technical-test
 */

public class ManageBrowser {

    public static WebDriver driver;
    static String baseUrl = PropertyReader.getInstance().getProperty("baseUrl");
    private static final Logger log = LogManager.getLogger(ManageBrowser.class);

    public ManageBrowser() {
        PageFactory.initElements(driver,this);
        PropertyConfigurator.configure(System.getProperty("user.dir")+"/src/test/java/resources/propertiesfile/log4j2.properties");
    }

    public void selectBrowser(String browser){

        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
            log.info("Chrome Browser Launch.....");
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
            log.info("FireFox Browser Launch.....");
        } else if (browser.equalsIgnoreCase("ie")) {
            driver = new InternetExplorerDriver();
            log.info("Edge Browser Launch.....");
        } else {
            System.out.println("Wrong browser name");
            log.info("Wrong Browser Launch.....");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get(baseUrl);
    }

    public void closeBrowser(){
        if (driver!= null){
            driver.quit();
        }
    }
}
