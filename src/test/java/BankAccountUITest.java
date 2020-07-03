import Pages.BankAccountPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.SettingsPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class BankAccountUITest extends BaseTest {

    @Test
    @Tag("bank-account-UI")
    @DisplayName("Can create bank account via UI")
    public void canCreateBankAccountViaUI(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("nizhivkov@gmail.com","123456");
        HomePage homePage = new HomePage(driver);
        homePage.clickSettingsMenu();
        Assertions.assertEquals("Настройки",homePage.getSettingsHeader());
        SettingsPage settingsPage = new SettingsPage(driver);
        settingsPage.clickBankAccount();
        BankAccountPage bankAccountPage = new BankAccountPage(driver);
        Assertions.assertEquals("Банкови сметки на фирмата",bankAccountPage.getBankAccountHeader());
        bankAccountPage.addNewBankAccount();
        wait(2);
        bankAccountPage.bankAccountName("Prosta");
        /**
         * User can choose from different banks
         * @param "УниКредит Булбанк АД","Банка ДСК EАД","Обединена българска банка АД","Юробанк България АД",
         * "Райфайзенбанк (България) ЕАД","Експресбанк АД","Алианц Банк България АД","Банка Пиреос България АД",
         * "Ти Би Ай Банк EАД","Първа инвестиционна банка АД","Българо - американска кредитна банка АД",
         * "ПроКредит Банк (България) EАД","Търговска Банка Д АД","Токуда Банк АД","Инвестбанк АД",
         * "Централна кооперативна банка АД","Общинска банка АД","Българска банка за развитие АД",
         * "Интернешънъл Асет Банк АД","Тексим Банк АД","Ситибанк Европа АД"
         */
        bankAccountPage.chooseBank("Българска банка за развитие АД");
        /**
         * chooseNewBank method , user can enter new bank name that is not in the list of banks
         */
        //bankAccountPage.chooseNewBank("Сотирис банк");
        bankAccountPage.enterIban("NL47RABO4734538751");
        /**
         * @param : User can select different currency
         *        "BGN","EUR","USD","--Валути в ЕС--","CHF","CZK","DKK","GBP","HUF","ISK","NOK","PLN","RON","SEK","--Всички валути--"
         *        ,"AED","AFN","AMD","ANG","AOA","ARS","AUD","AWG","AZN","BAM","BBD","BDT","BHD","BIF","BMD","BND","BOB","BRL","BSD",
         *        "BTN","BWP","BYR","BZD","CAD","CDF","CLP","CNY","COP","CRC","CUC","CUP","CVE","DJF","DOP","DZD","EGP","ERN","ETB",
         *        "FJD","FKP","GEL","GGP","GHS","GIP","GMD","GNF","GTQ","GYD","HKD","HNL","HRK","HTG","IDR","ILS","IMP","INR","IQD",
         *        "IRR","JEP","JMD","JOD","JPY","KES","KGS","KHR","KMF","KPW","KRW","KWD","KYD","KZT","LAK","LBP","LKR","LRD","LSL",
         *        "LYD","MAD","MDL","MGA","MKD","MMK","MNT","MOP","MRO","MUR","MVR","MWK","MXN","MYR","MZN","NAD","NGN","NIO","NPR",
         *        "NZD","OMR","PAB","PEN","PGK","PHP","PKR","PYG","QAR","RSD","RUB","RWF","SAR","SBD","SCR","SDG","SGD","SHP","SLL",
         *        "SOS","SPL","SRD","STD","SVC","SYP","SZL","THB","TJS","TMT","TND","TOP","TRY","TTD","TVD","TWD","TZS","UAH","UGX",
         *        "UYU","UZS","VEF","VND","VUV","WST","XAF","XAG","XAU","XBT","XCD","XDR","XOF","XPD","XPF","XPT","YER","ZAR","ZMW",
         *        "ZWD"
         */
        bankAccountPage.selectCurrency("VEF");
        bankAccountPage.clickSaveButton();

        wait(3);




    }

    @Test
    @Tag("bank-account-UI")
    @DisplayName("Can't create bank account via UI with the same iban number")
    public void cantCreateBankAccountViaUIWithTheSameIbanNumber(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("nizhivkov@gmail.com","123456");
        HomePage homePage = new HomePage(driver);
        homePage.clickSettingsMenu();
        Assertions.assertEquals("Настройки",homePage.getSettingsHeader());
        SettingsPage settingsPage = new SettingsPage(driver);
        settingsPage.clickBankAccount();
        BankAccountPage bankAccountPage = new BankAccountPage(driver);
        Assertions.assertEquals("Банкови сметки на фирмата",bankAccountPage.getBankAccountHeader());
        bankAccountPage.addNewBankAccount();
        wait(2);
        bankAccountPage.bankAccountName("kokos");
        /**
         * User can choose from different banks
         * @param "УниКредит Булбанк АД","Банка ДСК EАД","Обединена българска банка АД","Юробанк България АД",
         * "Райфайзенбанк (България) ЕАД","Експресбанк АД","Алианц Банк България АД","Банка Пиреос България АД",
         * "Ти Би Ай Банк EАД","Първа инвестиционна банка АД","Българо - американска кредитна банка АД",
         * "ПроКредит Банк (България) EАД","Търговска Банка Д АД","Токуда Банк АД","Инвестбанк АД",
         * "Централна кооперативна банка АД","Общинска банка АД","Българска банка за развитие АД",
         * "Интернешънъл Асет Банк АД","Тексим Банк АД","Ситибанк Европа АД"
         */
        bankAccountPage.chooseBank("Българска банка за развитие АД");
        /**
         * chooseNewBank method , user can enter new bank name that is not in the list of banks
         */
        //bankAccountPage.chooseNewBank("Сотирис банк");
        bankAccountPage.enterIban("NL47RABO4734538751");
        /**
         * @param : User can select different currency
         *        "BGN","EUR","USD","--Валути в ЕС--","CHF","CZK","DKK","GBP","HUF","ISK","NOK","PLN","RON","SEK","--Всички валути--"
         *        ,"AED","AFN","AMD","ANG","AOA","ARS","AUD","AWG","AZN","BAM","BBD","BDT","BHD","BIF","BMD","BND","BOB","BRL","BSD",
         *        "BTN","BWP","BYR","BZD","CAD","CDF","CLP","CNY","COP","CRC","CUC","CUP","CVE","DJF","DOP","DZD","EGP","ERN","ETB",
         *        "FJD","FKP","GEL","GGP","GHS","GIP","GMD","GNF","GTQ","GYD","HKD","HNL","HRK","HTG","IDR","ILS","IMP","INR","IQD",
         *        "IRR","JEP","JMD","JOD","JPY","KES","KGS","KHR","KMF","KPW","KRW","KWD","KYD","KZT","LAK","LBP","LKR","LRD","LSL",
         *        "LYD","MAD","MDL","MGA","MKD","MMK","MNT","MOP","MRO","MUR","MVR","MWK","MXN","MYR","MZN","NAD","NGN","NIO","NPR",
         *        "NZD","OMR","PAB","PEN","PGK","PHP","PKR","PYG","QAR","RSD","RUB","RWF","SAR","SBD","SCR","SDG","SGD","SHP","SLL",
         *        "SOS","SPL","SRD","STD","SVC","SYP","SZL","THB","TJS","TMT","TND","TOP","TRY","TTD","TVD","TWD","TZS","UAH","UGX",
         *        "UYU","UZS","VEF","VND","VUV","WST","XAF","XAG","XAU","XBT","XCD","XDR","XOF","XPD","XPF","XPT","YER","ZAR","ZMW",
         *        "ZWD"
         */
        wait(3);
        bankAccountPage.selectCurrency("BGN");
        bankAccountPage.clickSaveButton();
        Assertions.assertEquals("Вече съществува сметка с такъв IBAN",bankAccountPage.getErrorMessage());

    }

    @Test
    @Tag("bank-account-UI-delete")
    @DisplayName("Can delete bank account via UI")
    public void canDeleteBankAccountVisUI(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("nizhivkov@gmail.com","123456");
        HomePage homePage = new HomePage(driver);
        homePage.clickSettingsMenu();
        Assertions.assertEquals("Настройки",homePage.getSettingsHeader());
        SettingsPage settingsPage = new SettingsPage(driver);
        settingsPage.clickBankAccount();
        BankAccountPage bankAccountPage = new BankAccountPage(driver);
        Assertions.assertEquals("Банкови сметки на фирмата",bankAccountPage.getBankAccountHeader());
        bankAccountPage.deleteBankAccount();
        Assertions.assertEquals("Банковата сметка е изтрита успешно.", bankAccountPage.getSuccessMessage());


    }

    @Test
    @Tag("bank-account-UI-delete")
    @DisplayName("Can edit bank account via UI")
    public void canEditBankAccountVisUI(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("nizhivkov@gmail.com","123456");
        HomePage homePage = new HomePage(driver);
        homePage.clickSettingsMenu();
        Assertions.assertEquals("Настройки",homePage.getSettingsHeader());
        SettingsPage settingsPage = new SettingsPage(driver);
        settingsPage.clickBankAccount();
        BankAccountPage bankAccountPage = new BankAccountPage(driver);
        Assertions.assertEquals("Банкови сметки на фирмата",bankAccountPage.getBankAccountHeader());
       bankAccountPage.editBankAccount();
       wait(3);
        bankAccountPage.bankAccountName("karakas");
        /**
         * User can choose from different banks
         * @param "УниКредит Булбанк АД","Банка ДСК EАД","Обединена българска банка АД","Юробанк България АД",
         * "Райфайзенбанк (България) ЕАД","Експресбанк АД","Алианц Банк България АД","Банка Пиреос България АД",
         * "Ти Би Ай Банк EАД","Първа инвестиционна банка АД","Българо - американска кредитна банка АД",
         * "ПроКредит Банк (България) EАД","Търговска Банка Д АД","Токуда Банк АД","Инвестбанк АД",
         * "Централна кооперативна банка АД","Общинска банка АД","Българска банка за развитие АД",
         * "Интернешънъл Асет Банк АД","Тексим Банк АД","Ситибанк Европа АД"
         */
       bankAccountPage.chooseBank("Общинска банка АД");
       bankAccountPage.enterIban("NL41INGB9082037890");
        /**
         * @param : User can select different currency
         *        "BGN","EUR","USD","--Валути в ЕС--","CHF","CZK","DKK","GBP","HUF","ISK","NOK","PLN","RON","SEK","--Всички валути--"
         *        ,"AED","AFN","AMD","ANG","AOA","ARS","AUD","AWG","AZN","BAM","BBD","BDT","BHD","BIF","BMD","BND","BOB","BRL","BSD",
         *        "BTN","BWP","BYR","BZD","CAD","CDF","CLP","CNY","COP","CRC","CUC","CUP","CVE","DJF","DOP","DZD","EGP","ERN","ETB",
         *        "FJD","FKP","GEL","GGP","GHS","GIP","GMD","GNF","GTQ","GYD","HKD","HNL","HRK","HTG","IDR","ILS","IMP","INR","IQD",
         *        "IRR","JEP","JMD","JOD","JPY","KES","KGS","KHR","KMF","KPW","KRW","KWD","KYD","KZT","LAK","LBP","LKR","LRD","LSL",
         *        "LYD","MAD","MDL","MGA","MKD","MMK","MNT","MOP","MRO","MUR","MVR","MWK","MXN","MYR","MZN","NAD","NGN","NIO","NPR",
         *        "NZD","OMR","PAB","PEN","PGK","PHP","PKR","PYG","QAR","RSD","RUB","RWF","SAR","SBD","SCR","SDG","SGD","SHP","SLL",
         *        "SOS","SPL","SRD","STD","SVC","SYP","SZL","THB","TJS","TMT","TND","TOP","TRY","TTD","TVD","TWD","TZS","UAH","UGX",
         *        "UYU","UZS","VEF","VND","VUV","WST","XAF","XAG","XAU","XBT","XCD","XDR","XOF","XPD","XPF","XPT","YER","ZAR","ZMW",
         *        "ZWD"
         */
       bankAccountPage.selectCurrency("GMD");
       bankAccountPage.clickSaveButton();



    }

}
