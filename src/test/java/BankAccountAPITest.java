import API.BankAccountAPI;
import org.junit.jupiter.api.*;
import Pages.BankAccountPage;
import Pages.LoginPage;
import Pages.SettingsPage;
import pojo.BankAccount;

public class BankAccountAPITest extends BaseTest{

//    @BeforeEach
//    public void beforeEach(){
//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.login("nizhivkov@gmail.com","123456");
//    }

    @Test
    @Tag("bank-account-via-API")
    @DisplayName("Can create bank account via API")
    public void canCreateBankAccountViaAPI(){
        /**
         * Unauthorized operation , account is not authorised
         */

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("nizhivkov@gmail.com","123456");
        BankAccountPage bankAccountPage = new BankAccountPage(driver);
        bankAccountPage.clickSettings();
        BankAccountAPI bankAccountAPI = new BankAccountAPI();
        BankAccount bankAccount = new BankAccount();
        bankAccount.setBank_name("Niko");
        bankAccount.setBank_name_en("Niko eng");
        bankAccount.setBank_iban("NL68RABO6038321969");
        bankAccount.setBank_bic("1212");
        bankAccountAPI.createBankAccount(bankAccount);
        SettingsPage settingsPage = new SettingsPage(driver);
        settingsPage.clickBankAccount();
        Assertions.assertEquals("Банкови сметки на фирмата",bankAccountPage.getBankAccountHeader());

    }




}
