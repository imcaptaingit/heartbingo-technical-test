package uk.co.heartbingo.testsuite;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import uk.co.heartbingo.customlisteners.CustomListeners;
import uk.co.heartbingo.pages.HomePage;
import uk.co.heartbingo.testbase.BaseTest;

/**
 * Author - Sarvat Shaikh
 * Project Name: heartbingo-technical-test
 */
@Listeners(CustomListeners.class)
public class HomePageTest extends BaseTest {
    HomePage homePage;

    @BeforeMethod
    public void inIt() {
        homePage = new HomePage();
    }

    @Test
    public void UserShouldBeAbleToAcceptAllCookies() throws InterruptedException {
        //Accepting cookies for the HomePage
        homePage.acceptingCookies();
        //Clicking on the MenuBar
        homePage.clickOnHamMenu();
        //Clicking on the search Option
        homePage.clickOnSearchMenu();
        //Enter the text in the search field
        homePage.enterTextToSearchElement("Casino");
        //Clicking on the Result shown in the search result
        homePage.clickOnResult();
        //Verifying the name of the Game showed in Result
        homePage.verifyGameName();
    }
}
