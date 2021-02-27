import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CheckBoxesTests extends BaseTest {
    @Test
    public void thereAreTwoCheckboxes(){
        driver.get("https://ultimateqa.com/simple-html-elements-for-automation/");
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));

        Assert.assertEquals(checkboxes.size(), 2);
    }

    @Test(dependsOnMethods = {"thereAreTwoCheckboxes"})
    public void noCheckboxIsSelected(){
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']:checked"));

        Assert.assertEquals(checkboxes.size(), 0);
    }

    @Test(dependsOnMethods = {"noCheckboxIsSelected"})
    public void selectCarCheckboxAndCheckSelectedCount(){
        driver.findElement(By.cssSelector("input[type='checkbox'][value='Car']")).click();
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']:checked"));

        Assert.assertEquals(checkboxes.size(), 1);
    }

    @Test(dependsOnMethods = {"selectCarCheckboxAndCheckSelectedCount"})
    public void selectBikeCheckboxAndCheckSelectedCount(){
        driver.findElement(By.cssSelector("input[type='checkbox'][value='Bike']")).click();
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']:checked"));

        Assert.assertEquals(checkboxes.size(), 2);
    }

    @Test(dependsOnMethods = {"selectBikeCheckboxAndCheckSelectedCount"})
    public void unselectCarCheckboxAndCheckSelectedCount(){
        driver.findElement(By.cssSelector("input[type='checkbox'][value='Car']")).click();
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']:checked"));

        Assert.assertEquals(checkboxes.size(), 1);
    }

    @Test(dependsOnMethods = {"unselectCarCheckboxAndCheckSelectedCount"})
    public void unselectBikeCheckboxAndCheckSelectedCount(){
        driver.findElement(By.cssSelector("input[type='checkbox'][value='Bike']")).click();
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']:checked"));

        Assert.assertEquals(checkboxes.size(), 0);
    }
}
