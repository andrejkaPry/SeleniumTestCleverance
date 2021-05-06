package cz.czechitas.seleniumTestCleverance;

import org.openqa.selenium.*;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver webDriver) {
        driver = webDriver;
    }

    public void FillEmailAdress(String emailAdress) {
        WebElement loginUserName = driver.findElement(By.id("login-username"));
        loginUserName.sendKeys(emailAdress);
        System.out.println("Find element and fill in an email adress " + emailAdress);
    }

    public void FillUserPassword(String password) {
        WebElement logInpassword = driver.findElement(By.id("login-password"));
        logInpassword.sendKeys(password);
        System.out.println("Find element and fill in user password " + password);
    }

    public EmailHomePage clickOnSignInButton(){
        System.out.println("Hledam button");
        WebElement clickOnSignInButton = driver.findElement(By.tagName("button"));
        clickOnSignInButton.click();
        System.out.println("Clicking on sign in button");
        return new EmailHomePage(driver);

    }
    //jackn573
    //Shining1980

    //falco230
    //ViennaIsCalling

}
