package cz.czechitas.seleniumTestCleverance;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

public class LoginTests {

    private WebDriver driver;

    @Before
    public void SetUp() {
    //    System.setProperty("webdriver.gecko.driver", "C://Java-Training//Selenium//geckodriver.exe");
    //    FirefoxOptions options = new FirefoxOptions();
    //    options.addArguments("-private");
    //    driver = new FirefoxDriver();
        
        System.setProperty("webdriver.chrome.driver", "C://Java-Training//chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--allow-running-insecure-content");

        driver = new ChromeDriver(options);
       

        driver.navigate().to("https://login.szn.cz/");
    }

    @Test
    public void Login_ValidUser() throws InterruptedException {

        //prihlaseni do email schranky
        LoginPage loginPage = new LoginPage(driver);
        loginPage.FillEmailAdress("falco230");
        Thread.sleep(2000);
        loginPage.FillUserPassword("ViennaIsCalling");
        Thread.sleep(2000);
        loginPage.clickOnSignInButton();
        Thread.sleep(5000);

        //odeslani noveho emailu
        EmailHomePage emailHomePage = new EmailHomePage(driver);
        emailHomePage.ClickOnNewEmail();
        Thread.sleep(5000);
        emailHomePage.FillRecipient("falco230@seznam.cz");
        Thread.sleep(2000);
        emailHomePage.FillSubject("Test");
        Thread.sleep(2000);
        emailHomePage.FillBodyEmailText("This is testing email.");
        Thread.sleep(2000);
        emailHomePage.ClickOnSendButton();
        Thread.sleep(40000);
        emailHomePage.RefreshInbox();
        Thread.sleep(5000);

        //oznaceni emailu a presunuti do prectenych
        emailHomePage.MarkNewEmail();
        Thread.sleep(5000);
        emailHomePage.PopUpWindowOznacit();
        Thread.sleep(20000);
       // emailHomePage.MarkEmailAsRead();
       // Thread.sleep(2000);

        //otestuje ze email s danym predmetem prisel
        emailHomePage.CheckEmail();
        
        System.out.println("done");

    }

    @After
    public void CleanUp() {
        driver.quit();
    }
}


