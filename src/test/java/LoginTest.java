import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import Pages.HomePage;
import Pages.LoginPage;

public class LoginTest extends BaseTest{


    @Test
    @Tag("login")
    @DisplayName("Can't login with invalid credentials")
    public void cantLoginWithInvalidCredentials() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("nizhivkov@gmail.com");
        loginPage.enterPassword("123456789");
        loginPage.clickLoginButton();
        Assertions.assertEquals("Грешно потребителско име или парола. Моля, опитайте отново.", loginPage.getErrorMessage());

    }


    @Test
    @Tag("login")
    @DisplayName("Can login with valid credentials")
    public void canLoginWithValidCredentials() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("nizhivkov@gmail.com");
        loginPage.enterPassword("123456");
        loginPage.clickLoginButton();
        HomePage homePage = new HomePage(driver);
        Assertions.assertEquals("nizhivkov@gmail.com", homePage.getHeaderPanelText());

    }

    @Test
    @Tag("login")
    @DisplayName("Can login and logout with valid credentials")
    public void canLoginAndLogoutWithValidCredentials() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("nizhivkov@gmail.com");
        loginPage.enterPassword("123456");
        loginPage.clickLoginButton();
        HomePage homePage = new HomePage(driver);
        Assertions.assertEquals("nizhivkov@gmail.com", homePage.getHeaderPanelText());

        homePage.logout();

    }

    @Test
    @Tag("login")
    @DisplayName("Can't login with blank field and click button Login")
    public void CantLoginWithBlankFieldAndClickButtonLogin() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("");
        loginPage.enterPassword("");
        loginPage.clickLoginButton();
        Assertions.assertEquals("Моля, попълнете вашия email", loginPage.getErrorMessage());

    }
}
