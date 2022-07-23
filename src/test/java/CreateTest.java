import net.bytebuddy.utility.RandomString;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CreateTest {


    WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "D:\\QA\\Selenium\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://shop.pragmatic.bg");
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void createUser() {
        WebElement myAccount = driver.findElement(By.cssSelector(".dropdown .hidden-xs"));
        myAccount.click();

        WebElement myAccountRegister = driver.findElement(By.xpath("//a[contains(@href,'register')]"));
        myAccountRegister.click();

        WebElement firstName = driver.findElement(By.id("input-firstname"));
        firstName.sendKeys("Pesho");

        WebElement lastName = driver.findElement(By.id("input-lastname"));
        lastName.sendKeys("Petkov");

        String randomMail = RandomStringUtils.randomAlphabetic(Integer.parseInt("6"));
        String randomMailCom = randomMail + "@oks.com";
        WebElement inputEmail = driver.findElement(By.id("input-email"));
        inputEmail.sendKeys(randomMailCom);

        WebElement Telephone = driver.findElement(By.id("input-telephone"));
        Telephone.sendKeys("0885545845");

        WebElement password = driver.findElement(By.id("input-password"));
        password.sendKeys("Pesho123");

        WebElement confurmPassword = driver.findElement(By.id("input-confirm"));
        confurmPassword.sendKeys("Pesho123");

        WebElement chechbox = driver.findElement(By.className(".agree"));
        chechbox.click();

        WebElement continueButton = driver.findElement(By.className(".pull-right .btn"));
        continueButton.click();

        Assert.assertTrue(Boolean.parseBoolean("Your Account Has Been Created!"));


    }

}
