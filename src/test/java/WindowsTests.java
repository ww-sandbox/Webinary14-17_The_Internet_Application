import org.testng.annotations.Test;

public class WindowsTests extends BaseTest {
    @Test
    public void multipleWindowsTests(){
        //Przejdź do adresu http://the-internet.herokuapp.com/windows
        //Kliknij w link 'Click Here'
        //Sprawdź czy zawartość nagłówka h3 to 'New Window'
        //Popraw test - na początku pobierz WindowHandle
        //Kliknij w link 'Click Here'
        //Pobierz WindowHandles i znajdź uchwyt nowego okna
        //Przełącz się do nowego okna
        //Sprawdź czy zawartość nagłówka h3 to 'New Window'
        //Zamknij okno
        //Sprawdź czy możesz zlokalizować link 'Click Here'
        //Popraw test przełączający się na pierwotne okno
        //Sprawdź czy możesz zlokalizować link 'Click Here'
    }
}
