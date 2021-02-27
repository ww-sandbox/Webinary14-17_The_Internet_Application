import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import utils.ScreenshotUtil;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected static WebDriver driver;

    @BeforeClass
    public void setUp(){
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        System.setProperty("webdriver.gecko.driver", "C:/webdrivers/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    //Dodaj metodę 'methodTearDown' z adnotacją '@AfterMethod' pobierającą jako argument 'ITestResult result'
    //Zapisującą zrzut ekranu w przypadku testu zakończonego failem
    @AfterMethod
    public void methodTearDown(ITestResult result) throws IOException {
        if(result.getStatus() != ITestResult.SUCCESS){
            String screenshotName = "screenshots/" + result.getName() + result.getEndMillis() + ".png";
            ScreenshotUtil.takeScreenshot(driver, screenshotName);
        }
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
