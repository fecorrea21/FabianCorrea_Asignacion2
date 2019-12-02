package maintest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class MyStore {


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

    @Test(priority = 6)
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

    @Test(priority = 7)
    public void portraitDoorPrintedTshirt() {
        driver.findElement(By.xpath("//body[@id='index']/main/section[@id='wrapper']/div[@class='container']/div[@id='content-wrapper']/section[@id='main']/section[@id='content']/section[@class='featured-products clearfix']/div[@class='products']/article[1]/div[1]/a[1]")).click();
        Select s = new Select(driver.findElement(By.xpath("//select[@id='group_1']")));
        s.selectByValue("1");
        s.selectByValue("2");
        s.selectByValue("3");
        s.selectByValue("4");
        driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@id='quantity_wanted']")).clear();
        driver.findElement(By.xpath("//input[@id='quantity_wanted']")).sendKeys("10");
        expectedResult = "Hummingbird printed t-shirt";
        currentResult = driver.getTitle();
        Assert.assertEquals(expectedResult, currentResult, "The title is not the same");
    }

    @Test(priority = 8)
    public void productsPrintedSweater() {
        driver.findElement(By.xpath("//body[@id='index']/main/section[@id='wrapper']/div[@class='container']/div[@id='content-wrapper']/section[@id='main']/section[@id='content']/section[@class='featured-products clearfix']/div[@class='products']/article[2]/div[1]/a[1]")).click();
        Select s = new Select(driver.findElement(By.xpath("//select[@id='group_1']")));
        s.selectByValue("4");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@id='quantity_wanted']")).clear();
        driver.findElement(By.xpath("//input[@id='quantity_wanted']")).sendKeys("10");
        expectedResult = "Hummingbird printed sweater";
        currentResult = driver.getTitle();
        Assert.assertEquals(currentResult, expectedResult, "The title is not the same");
    }

    @Test(priority = 9)
    public void productsTheBestToCome() {
        driver.findElement(By.xpath("//body[@id='index']/main/section[@id='wrapper']/div[@class='container']/div[@id='content-wrapper']/section[@id='main']/section[@id='content']/section[@class='featured-products clearfix']/div[@class='products']/article[3]/div[1]/a[1]")).click();
        Select s = new Select(driver.findElement(By.xpath("//select[@id='group_3']")));
        s.selectByValue("20");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@id='quantity_wanted']")).clear();
        driver.findElement(By.xpath("//input[@id='quantity_wanted']")).sendKeys("10");
        expectedResult = "The best is yet to come' Framed poster";
        currentResult = driver.getTitle();
        Assert.assertEquals(currentResult, expectedResult, "The title is not the same");
    }
    @Test(priority = 10)
    public void productsTheAdventureBegins(){
        driver.findElement(By.xpath("//body[@id='index']/main/section[@id='wrapper']/div[@class='container']/div[@id='content-wrapper']/section[@id='main']/section[@id='content']/section[@class='featured-products clearfix']/div[@class='products']/article[4]/div[1]/a[1]")).click();
        Select s = new Select(driver.findElement(By.xpath("//select[@id='group_3']")));
        s.selectByValue("19");
        s.selectByValue("20");
        s.selectByValue("21");
        driver.findElement(By.xpath("//input[@id='quantity_wanted']")).clear();
        driver.findElement(By.xpath("//input[@id='quantity_wanted']")).sendKeys("10");
        expectedResult = "The adventure begins Framed poster";
        currentResult = driver.getTitle();
        Assert.assertEquals(expectedResult,currentResult, "The title is not the same");
    }
    @Test(priority = 11)
    public void productsTodayIsaGood(){
        driver.findElement(By.xpath("//body[@id='index']/main/section[@id='wrapper']/div[@class='container']/div[@id='content-wrapper']/section[@id='main']/section[@id='content']/section[@class='featured-products clearfix']/div[@class='products']/article[5]/div[1]/a[1]")).click();
        Select s = new Select(driver.findElement(By.xpath("//select[@id='group_3']")));
        s.selectByValue("19");
        s.selectByValue("20");
        s.selectByValue("21");
        driver.findElement(By.xpath("//input[@id='quantity_wanted']")).clear();
        driver.findElement(By.xpath("//input[@id='quantity_wanted']")).sendKeys("10");
        expectedResult = "Today is a good day Framed poster";
        currentResult = driver.getTitle();
        Assert.assertEquals(expectedResult, currentResult, "The title is not the same");
    }
    @Test(priority = 12)
    public void productsCupTheBestCome(){
        driver.findElement(By.xpath("//body[@id='index']/main/section[@id='wrapper']/div[@class='container']/div[@id='content-wrapper']/section[@id='main']/section[@id='content']/section[@class='featured-products clearfix']/div[@class='products']/article[6]/div[1]/a[1]")).click();
        driver.findElement(By.xpath("//input[@id='quantity_wanted']")).clear();
        driver.findElement(By.xpath("//input[@id='quantity_wanted']")).sendKeys("20");
        expectedResult = "Mug The best is yet to come";
        currentResult = driver.getTitle();
        Assert.assertEquals(expectedResult, currentResult, "The title is not the same");
    }
    @Test(priority = 13)
    public void productsCupTheAdventureBegins(){
        driver.findElement(By.xpath("//body[@id='index']/main/section[@id='wrapper']/div[@class='container']/div[@id='content-wrapper']/section[@id='main']/section[@id='content']/section[@class='featured-products clearfix']/div[@class='products']/article[7]/div[1]/a[1]")).click();
        driver.findElement(By.xpath("//input[@id='quantity_wanted']")).clear();
        driver.findElement(By.xpath("//input[@id='quantity_wanted']")).sendKeys("20");
        expectedResult = "Mug The adventure begins";
        currentResult = driver.getTitle();
        Assert.assertEquals(expectedResult, currentResult, "The title is not the same");
    }
    @Test(priority = 14)
    public void productsCupTodayIsGoodDay(){
        driver.findElement(By.xpath("//body[@id='index']/main/section[@id='wrapper']/div[@class='container']/div[@id='content-wrapper']/section[@id='main']/section[@id='content']/section[@class='featured-products clearfix']/div[@class='products']/article[8]/div[1]/a[1]")).click();
        driver.findElement(By.xpath("//input[@id='quantity_wanted']")).clear();
        driver.findElement(By.xpath("//input[@id='quantity_wanted']")).sendKeys("20");
        expectedResult = "Mug Today is a good day";
        currentResult = driver.getTitle();
        Assert.assertEquals(expectedResult, currentResult, "The title is not the same");
    }


    @AfterMethod
    public void goBackToHomePage() {
        driver.findElement(By.xpath("//div[@id='_desktop_logo']//a")).click();
    }


    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }


}


