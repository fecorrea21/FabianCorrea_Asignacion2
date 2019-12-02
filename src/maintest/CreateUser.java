package maintest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;


public class CreateUser<user, password> {

    //Change the email number to run the class Login and the test is ok
    public static CharSequence user = "test20@qa.com";
    public static CharSequence password = "Aa123*";

    String baseUrl = "http://serenitybddpractice.com/login?create_account=1 ";
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


    @Test(priority = 0)
    public void formnewUser() {
        driver.findElement(By.name("id_gender")).click();
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("PRUEBA");
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("PRUEBAQA");
        driver.findElement(By.xpath("//div[@class='col-md-6']//input[@name='email']")).sendKeys(user);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@placeholder='MM/DD/YYYY']")).sendKeys("17/01/1992");
        driver.findElement(By.xpath("//input[@name='optin']")).click();
        driver.findElement(By.xpath("//input[@name='newsletter']")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-primary form-control-submit float-xs-right']")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        expectedResult = "Ecommerse";
        currentResult = driver.getTitle();
        Assert.assertEquals(currentResult, expectedResult, " The title is not the same");

    }

    @AfterMethod
    public void goBackToHomePage() {
        driver.findElement(By.xpath("//div[@id='_desktop_logo']//h1//a")).click();
    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }

}
