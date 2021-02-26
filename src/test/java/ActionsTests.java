import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ActionsTests extends BaseTest{
    @Test
    public void openHoversPage(){
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
        - sprawdź czy adres strony jest poprawny - zawiera '/users/2'
         */
    }

}
