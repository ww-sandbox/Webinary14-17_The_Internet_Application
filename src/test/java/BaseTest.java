import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

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
    
    @AfterClass
    public void tearDown(){
        driver.quit();
        //Dodaj kod zapisujący screenshot w przypadku 'faila' testu
    }
}
