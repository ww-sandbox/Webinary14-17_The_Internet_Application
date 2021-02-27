import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class CssAtributesTests extends BaseTest{
    private static WebElement modalAd;
    private static WebElement modalAdTitleBar;
    @Test
    public void modalAdIsDisplayed(){
        driver.get("http://the-internet.herokuapp.com/entry_ad");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        modalAd = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("modal")));
        modalAdTitleBar = modalAd.findElement(By.className("modal-title"));

        Assert.assertTrue(modalAd.isDisplayed());
    }

    @Test(dependsOnMethods = {"modalAdIsDisplayed"})
    public void modalAdHasBlacBackgroundHeader(){
        String backgroundColor = modalAdTitleBar.getCssValue("background-color");
        System.out.println(backgroundColor);
        //bezpośrednio pobrany kolor w formacie RGB rgb(XX, XX, XX)
        String backgroundColorHex = Color.fromString(backgroundColor).asHex();
        //konwersja do formatu szesnastkowego z wykorzystaniem biblioteki Color
        System.out.println(backgroundColorHex);
        //kolor zapisany w formacie szesnastkowym #XXXXXX

        Assert.assertEquals(backgroundColorHex, "#252525");
    }

    @Test(dependsOnMethods = {"modalAdIsDisplayed"})
    public void modalAdHeaderFontFaceIsOpenSans(){
        String fontFamily = modalAdTitleBar.getCssValue("font-family");
        String mainFont = fontFamily.split(",")[0];

        Assert.assertTrue(mainFont.contains("Open Sans"));
    }

    @Test(dependsOnMethods = {"modalAdIsDisplayed"})
    public void modalAdHeaderFontColorIsWhite(){
        String fontColor = modalAdTitleBar.getCssValue("color");
        String fontColorHex = Color.fromString(fontColor).asHex();

        System.out.println(fontColor);

        Assert.assertEquals(fontColorHex, "#ffffff");
    }
}
