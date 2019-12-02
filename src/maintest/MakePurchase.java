package maintest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class MakePurchase {

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

    /*
    @Test(priority = 6)
    public void methodOfLogIn() {
        LogIn logIn = new LogIn();
        logIn.methodLogIn();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

     */

    @Test(priority = 15)
    public void methodLogIn() {
        driver.findElement(By.xpath("//div[@class='user-info']//a")).click();
        driver.findElement(By.xpath("//div[@class='col-md-6']//input[@name='email']")).sendKeys(CreateUser.user);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(CreateUser.password);
        driver.findElement(By.xpath("//button[@id='submit-login']")).click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        expectedResult = "My account";
        currentResult = driver.getTitle();
        Assert.assertEquals(currentResult, expectedResult, "The title is not the same");
    }
    // happy path
    @Test(priority = 16)
    public void purchaseTshirt(){
        driver.findElement(By.xpath("//div[@id='_desktop_logo']//a")).click();
        driver.findElement(By.xpath("//body[@id='index']/main/section[@id='wrapper']/div[@class='container']/div[@id='content-wrapper']/section[@id='main']/section[@id='content']/section[@class='featured-products clearfix']/div[@class='products']/article[1]/div[1]/a[1]")).click();
        Select s = new Select(driver.findElement(By.xpath("//select[@id='group_1']")));
        s.selectByValue("4");
        driver.findElement(By.xpath("//li[2]//label[1]//input[1]")).click();
        driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//button[@class='btn btn-primary add-to-cart']")).click();
        expectedResult = "Hummingbird printed t-shirt";
        currentResult = driver.getTitle();
        Assert.assertEquals(expectedResult,currentResult,"The title is not the same");
    }
    @Test(priority = 17)
    public void proceedToCheckout(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();
        driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//li[1]//div[1]//div[3]//div[1]//div[2]//div[1]//div[1]//div[1]//input[1]")).clear();
        driver.findElement(By.xpath("//li[1]//div[1]//div[3]//div[1]//div[2]//div[1]//div[1]//div[1]//input[1]")).sendKeys("50");
        driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();
        expectedResult = "Ecommerse";
        currentResult = driver.getTitle();
        Assert.assertEquals(currentResult,expectedResult,"The title is not the same");
    }
    @Test(priority = 18)
    public void AddNewAddresses(){
        driver.findElement(By.xpath("//a[contains(text(),'add new address')]")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@name='company']")).sendKeys("Prodigious Calle 93");
        driver.findElement(By.xpath("//input[@name='vat_number']")).sendKeys("653-001115");
        driver.findElement(By.xpath("//input[@name='address1']")).sendKeys("CL 93B No 13-44 P3");
        driver.findElement(By.xpath("//input[@name='postcode']")).sendKeys("21630");
        driver.findElement(By.xpath("//input[@name='city']")).sendKeys("Bogota");
        driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("233541552");
        driver.findElement(By.xpath("//button[@name='confirm-addresses']")).click();
        expectedResult = "Ecommerse";
        currentResult = driver.getTitle();
        Assert.assertEquals(expectedResult,currentResult, "The title is not the same");
    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }


}

