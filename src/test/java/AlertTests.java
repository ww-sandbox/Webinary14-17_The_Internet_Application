import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AlertTests extends BaseTest{
    @BeforeClass
    public void setUp(){
        super.setUp();
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
    }

    @Test
    public void jsAlertTest(){
        //Zlokalizuj i kliknij na przycisk 'Click for JS Alert'
        //przełącz się na alert wykorzystując metodę switchTo
        //pobierz tekst alertu i sprawdź czy jest poprawny 'I am a JS Alert'
        //Zamknij alert
        //Sprawdź tekst 'Result' czy ma wartość 'You successfully clicked an alert'
    }

    @Test
    public void jsConfirmOkTest(){
        //Zlokalizuj i kliknij na przycisk 'Click for JS Confirm'
        //przełącz się na alert wykorzystując metodę switchTo
        //pobierz tekst alertu i sprawdź czy jest poprawny 'I am a JS Confirm'
        //Zamknij używając 'OK'
        //Sprawdź tekst 'Result' czy ma wartość 'You clicked: OK'

    }

    @Test
    public void jsConfirmCancelTest(){
        //Zlokalizuj i kliknij na przycisk 'Click for JS Confirm'
        //przełącz się na alert wykorzystując metodę switchTo
        //pobierz tekst alertu i sprawdź czy jest poprawny 'I am a JS Confirm'
        //Zamknij używając 'Cancel'
        //Sprawdź tekst 'Result' czy ma wartość 'You clicked: Cancel'

    }
}
