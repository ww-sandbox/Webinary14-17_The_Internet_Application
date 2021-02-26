import org.testng.annotations.Test;

public class LocatorsTests extends BaseTest{
    @Test
    public void properCredentialsLoginTest(){
        //Przejdź do adresu http://the-internet.herokuapp.com/login
        //Wypełnij pola formularza (skorzystaj z By.id)
        //Kliknij na przycisk (skorzystaj z By.tagName)
        //Sprawdź czy wyświetlony został porpawny komunikat o zalogowaniu (By.cssSelector)
    }

    @Test
    public void logoutTest(){
        //Wyloguj się korzystając z By.className
        //Sprawdź czy wyświetlony został porpawny komunikat o wylogowaniu (By.xpath)
    }
}
