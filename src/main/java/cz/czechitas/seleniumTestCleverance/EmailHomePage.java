package cz.czechitas.seleniumTestCleverance;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public class EmailHomePage {

    private WebDriver driver;

    public EmailHomePage(WebDriver webDriver) {
        driver = webDriver;
    }

    public boolean UserLoggedIn() {
        WebElement iconEmailIsShown = driver.findElement(By.className("main-content__content"));
        return iconEmailIsShown.isDisplayed();
    }

    public void ClickOnNewEmail() {
        WebElement newMessageButton = driver.findElement(By.linkText("Napsat e-mail"));
        newMessageButton.click();
        System.out.println("New email button clicked");
    }

    public void FillRecipient(String recipientText) {
        WebElement recipientInput = driver.findElement(By.xpath("/html[1]/body[1]/section[1]/div[2]/dl[1]/div[2]/dd[1]/div[1]/input[1]"));
        recipientInput.sendKeys(recipientText);
        System.out.println("Filling recipient.");
    }

    public void FillSubject(String subjectText) {
        WebElement subjectInput = driver.findElement(By.xpath("/html[1]/body[1]/section[1]/div[2]/dl[1]/div[5]/dd[1]/input[1]"));
        subjectInput.sendKeys(subjectText);
        System.out.println("Filling subject.");
    }

    public void FillBodyEmailText(String bodyText) {
        WebElement bodyEmailText = driver.findElement(By.xpath("/html[1]/body[1]/section[1]/div[2]/div[2]/div[1]/div[1]"));
        bodyEmailText.sendKeys(bodyText);
        System.out.println("Filling email.");
    }

    public void ClickOnSendButton() {
        WebElement sendButton = driver.findElement(By.xpath("/html[1]/body[1]/section[1]/div[3]/button[1]/span[1]"));
        sendButton.click();
        System.out.println("Sending an email.");
    }

    public void RefreshInbox() {
        WebElement inboxButton = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/nav[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/a[1]/span[2]"));
        inboxButton.click();
        System.out.println("Refreshing inbox.");
    }

    public void MarkNewEmail() {
        WebElement newEmailreceived = driver.findElement(By.xpath("//*[@id=\"list\"]/div/div/ul/li[1]/label/span"));
        newEmailreceived.click();
        System.out.println("Opening new email");
    }

    public void PopUpWindowOznacit() {
        WebElement popUpPresunout = driver.findElement(By.xpath("//*[@id=\"content\"]/header/div[3]/span[2]/button[2]"));
        popUpPresunout.click();
        System.out.println("Pop up window open");
    }

    public void MarkEmailAsRead(){

        Drop dropDownMenu = new Select(driver.findElement(By.id("i05830420330756643"));
        //dropDwonMenu.selectByVisibleText("Doručené");
        //org.openqa.selenium.support.ui.Select package nelze nacist, nevim proc

        WebElement emailPrecten = driver.findElement(By.className("hover"));
        emailPrecten.click();
        System.out.println("Email oznacen za precteny.");
    }

    public void CheckEmail(){
       WebElement content = driver.findElement(By.xpath("//*[@id=\"list\"]/div/div"));
       String obsah = content.getText();
       if (obsah.contains("falco230@seznam.cz") && obsah.contains("Test")){
           System.out.println("Email prijat");
       }
        
    }
}
