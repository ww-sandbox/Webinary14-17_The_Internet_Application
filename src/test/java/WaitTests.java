import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WaitTests extends BaseTest{
    @Test
    public void progressBarTest(){
        //Przejdź do adresu http://the-internet.herokuapp.com/dynamic_loading/1
        //Kliknij w przyisk 'Start'
        //poczekaj na pojawienie się elementu o id 'finish'
        //Upewnij się, że tekst tego elementu to 'Hello World'

        driver.get("http://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(By.cssSelector("#start button")).click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("finish")));

        String finishText = driver.findElement(By.id("finish")).getText();
        Assert.assertEquals(finishText, "Hello World!");
    }
}
