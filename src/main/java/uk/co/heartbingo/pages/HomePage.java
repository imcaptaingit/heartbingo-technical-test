package uk.co.heartbingo.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import uk.co.heartbingo.utility.Utility;

/**
 * Author - Sarvat Shaikh
 * Project Name: heartbingo-technical-test
 */
public class HomePage extends Utility {

    private static final Logger log = LogManager.getLogger(HomePage.class);

    @CacheLookup
    @FindBy(xpath = "//button[@id='onetrust-accept-btn-handler']")
    WebElement acceptCookies;

    @CacheLookup
    @FindBy(xpath = "//span[@class='bvs-icon is-menu is-big floating-nav__header-item is-inverted']")
    WebElement clickOnHamBurgerMenu;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Search')]")
    WebElement clickOnSearchTab;

    @CacheLookup
    @FindBy(xpath = "//form[@class='search-form']//input[@type='text']")
    WebElement enterCasino;

    @CacheLookup
    @FindBy(xpath = "//ul[@class='casino-games__all']//li//a[@class='casino-game-wrapper']//div[@class='casino-game img-lazy img-loaded']//div[@class='casino-game__img']//picture//img[@class='casino-game__bg img-lazy img-loaded']")
    WebElement clickOnTheSearchResult;

    @CacheLookup
    @FindBy(xpath = "//h1[@class='bvs-header']")
    WebElement verifyGameHeader;

    public void acceptingCookies() throws InterruptedException {
        Thread.sleep(30);
        log.info("Accepting the Cookies on the page");
        clickOnElement(acceptCookies);

    }

    public void clickOnHamMenu() throws InterruptedException {
        Thread.sleep(30);
        log.info("Clicking on the HamBurger Menu");
        clickOnElement(clickOnHamBurgerMenu);

    }

    public void clickOnSearchMenu() throws InterruptedException {
        Thread.sleep(30);
        log.info("selecting the search bar option");
        clickOnElement(clickOnSearchTab);

    }

    public void enterTextToSearchElement(String Text) throws InterruptedException {
        Thread.sleep(20);
        log.info("Entering the text 'Casino' in the search field");
        sendTextToElement(enterCasino, Text);

    }

    public void clickOnResult() throws InterruptedException {
        Thread.sleep(20);
        log.info("selecting the desired game");
        clickOnElement(clickOnTheSearchResult);

    }

    public void verifyGameName() throws InterruptedException {
        Thread.sleep(30);
        log.info("Verifying the name of the desired game");
        String expectedMessage = "Casino Win Spin";
        String actualMessage = getTextFromElement(verifyGameHeader);
        Assert.assertEquals(expectedMessage, actualMessage, "Cannot see the Game");
    }

}
