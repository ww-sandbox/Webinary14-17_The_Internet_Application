import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LocatorsTests extends BaseTest{
    @Test
    public void properCredentialsLoginTest(){
        //Przejdź do adresu http://the-internet.herokuapp.com/login
        //Wypełnij pola formularza (skorzystaj z By.id)
        //Kliknij na przycisk (skorzystaj z By.tagName)
        //Sprawdź czy wyświetlony został porpawny komunikat o zalogowaniu (By.cssSelector)
        driver.get("http://the-internet.herokuapp.com/login");
        WebElement usernameInput = driver.findElement(By.id("username"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.tagName("button"));

        usernameInput.sendKeys("tomsmith");
        passwordInput.sendKeys("SuperSecretPassword!");
        loginButton.click();

        WebElement successAlert = driver.findElement(By.cssSelector(".flash.success"));
        String successText = successAlert.getText();

        Assert.assertTrue(successText.contains("You logged into a secure area!"));
    }

    @Test
    public void logoutTest(){
        //Wyloguj się korzystając z By.className
        //Sprawdź czy wyświetlony został porpawny komunikat o wylogowaniu (By.xpath)
        WebElement logoutButton = driver.findElement(By.className("icon-signout"));
        logoutButton.click();

        WebElement successAlert = driver.findElement(By.cssSelector(".flash.success"));
        String successText = successAlert.getText();

        Assert.assertTrue(successText.contains("You logged out of the a secure area!"));
    }
}
