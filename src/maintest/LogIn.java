package maintest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LogIn {

    String baseUrl = "http://serenitybddpractice.com/ ";
    WebDriver driver;
    String expectedResult;
    String currentResult;
    String chromPath = System.getProperty("user.dir") + "/drivers/chromedriver";

    @BeforeTest
    public void loadBrowser() {
        System.setProperty("webdriver.chrome.driver", chromPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @BeforeMethod
    public void verifyTitle() {
        expectedResult = driver.getTitle();
        currentResult = driver.getTitle();
        Assert.assertEquals(currentResult, expectedResult, "The title is not the same");
    }


    @Test(priority = 1)
    public void methodLogIn() {
        driver.findElement(By.xpath("//div[@class='user-info']//a")).click();
        driver.findElement(By.xpath("//div[@class='col-md-6']//input[@name='email']")).sendKeys(CreateUser.user);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(CreateUser.password);
        driver.findElement(By.xpath("//button[@id='submit-login']")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        expectedResult = "My account";
        currentResult = driver.getTitle();
        Assert.assertEquals(currentResult, expectedResult, "The title is not the same");
    }

    @Test(priority = 2)
    public void myAccountInformation() {
        driver.findElement(By.id("identity-link")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        expectedResult = "Identity";
        currentResult = driver.getTitle();
        Assert.assertEquals(currentResult, expectedResult, "The title is not the same");
    }

    @Test(priority = 3)
    public void myAccountAdrress() {
        driver.findElement(By.xpath("//section[@id='wrapper']//li[2]//a[1]")).click();
        driver.findElement(By.id("address-link")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Select s = new Select(driver.findElement(By.name("id_country")));
        s.selectByValue("69");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@name='alias']")).sendKeys("TESTQA");
        driver.findElement(By.xpath("//input[@name='company']")).sendKeys("Prodigious");
        driver.findElement(By.xpath("//input[@name='vat_number']")).sendKeys("7460740");
        driver.findElement(By.xpath("//input[@name='address1']")).sendKeys("calle 26 # 92 32");
        driver.findElement(By.xpath("//input[@name='address2']")).sendKeys("Edificio BTS 3");
        driver.findElement(By.xpath("//input[@name='postcode']")).sendKeys("110111");
        driver.findElement(By.xpath("//input[@name='city']")).sendKeys("Bogota");
        driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("3504501504");
        driver.findElement(By.xpath("//button[@class='btn btn-primary float-xs-right']")).click();
        expectedResult = "Addresses";
        currentResult = driver.getTitle();
        Assert.assertEquals(currentResult, expectedResult, "The title is not the same");
    }

    @Test(priority = 4)
    public void myAccountOrderHistory() {
        driver.findElement(By.xpath("//section[@id='wrapper']//li[2]//a[1]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("history-link")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        expectedResult = "Order history";
        currentResult = driver.getTitle();
        Assert.assertEquals(currentResult, expectedResult, "The title is not the same");
    }

    @Test(priority = 5)
    public void myAccountCredit() {
        driver.findElement(By.xpath("//section[@id='wrapper']//li[2]//a[1]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("order-slips-link")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        expectedResult = "Credit slip";
        currentResult = driver.getTitle();
        Assert.assertEquals(currentResult, expectedResult, "The title is not the same");
    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }

}
