import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ActionsTests extends BaseTest{
    @Test
    public void openHoversPage(){
        driver.get("http://the-internet.herokuapp.com/");
        WebElement hoversLink = driver.findElement(By.linkText("Hovers"));
        //driver.findElement(By.xpath("//a[text()='Hovers']"));
        hoversLink.click();
        String headerText = driver.findElement(By.tagName("h3")).getText();

        Assert.assertEquals(headerText, "Hovers");
    }

    @Test(dependsOnMethods = {"openHoversPage"})
    public void openUserProfile(){
        /*
        Z wykorzystaniem Actions:
        - stwórz akcję 'openUserProfileAction'
        - odnajdź obrazek profilu drugiego użytkownika
        - najedź na obrazek
        - zlokalizuj link 'View profile' i kliknij w niego
        Znajdź element 'h1' z tekstem 'Not Found'
        Sprawdź czy aktualny url zawiera '/users/2'
         */
        Actions openUserProfileAction = new Actions(driver);
        WebElement secondUserAvatar = driver.findElement(By.cssSelector(".figure:nth-of-type(2)"));
        openUserProfileAction.moveToElement(secondUserAvatar).pause(1000).moveToElement(secondUserAvatar.findElement(By.tagName("a"))).click().build().perform();

        driver.findElement(By.xpath("//h1[text()='Not Found']"));
        String currentUrl = driver.getCurrentUrl();

        Assert.assertTrue(currentUrl.contains("/users/2"));
    }

}
