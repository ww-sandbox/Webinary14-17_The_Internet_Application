import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ScreenshotUtil;

import java.io.IOException;
import java.util.List;

public class RadioButtonTests extends BaseTest{
    @Test
    public void thereAreThreeRadioButtonsInForm(){
        //Przejdź do adresu https://ultimateqa.com/simple-html-elements-for-automation/
        //Zlokalizuj formularz z radio buttonami
        //Pobierz listę radio buttonów
        //Upewnij się że są dostępne 3 radio buttony
        driver.get("https://ultimateqa.com/simple-html-elements-for-automation/");
        List<WebElement> radioButtons = driver.findElements(By.cssSelector("input[type='radio']"));

        Assert.assertEquals(radioButtons.size(), 3);
    }

    @Test(dependsOnMethods = {"thereAreThreeRadioButtonsInForm"})
    public void selectFemaleAndAssertOthersAreNotSelected() throws IOException {
        //Zaznacz radio button 'Female'
        //Wykorzystując Assert sprawdź, że zaznaczony jest tylko jeden radio button
        WebElement femaleRadioButton = driver.findElement(By.cssSelector("input[type='radio'][value='female']"));
        femaleRadioButton.click();
        List<WebElement> selectedRadioButtons = driver.findElements(By.cssSelector("input[type='radio']:checked"));

        Assert.assertEquals(selectedRadioButtons.size(), 1);
    }
}
