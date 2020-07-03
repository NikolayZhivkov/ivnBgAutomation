import Pages.InvoicePage;
import Pages.LoginPage;
import Pages.NavigationPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class InvoiceTest extends BaseTest {

    @Test
    @Tag("Navigation-New Invoice")
    @DisplayName("Can create invoice whit all fields")
    public void canCreateInvoiceWhitAllFields() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("nizhivkov@gmail.com", "123456");
        NavigationPage navigationPage = new NavigationPage(driver);
        navigationPage.newInvoice();
        InvoicePage invoicePage = new InvoicePage(driver);
        Assertions.assertEquals("Нова фактура", invoicePage.verifyHeadline());
        invoicePage.enterClient("David");
        /**
         * Method whit checkbox
         */
        //invoicePage.checkIsPerson("25452545","skjskjs","skjskjskjsk");
        invoicePage.checkVat("231325648");
        invoicePage.enterBulstat("21326558");
        invoicePage.enterMolNumber("654658");
        invoicePage.enterCity("Blagoevgrad");
        invoicePage.enterAddress("Prosvet");
        invoicePage.enterRecipient("Musala");
        /**
         * @param for unit: "бр.", "дни", "кг", "месец", "123", "kg.", "кг", "kg", "бр.", "кг.", "литър", "pound", "бр", "ÐºÐ³.", "kr.", "??.", "4", "num", "---", "Нова..."
         * @param for currency: "лв.", "EUR", "USD", "GBP", "RON", "DKK", "CAD", "PLN", "CZK", "CHF", "HUF", "SGD", "AUD", "HRK", "JPY", "INR"
         * @param for paymentType : "В брой","Банков път","Наложен платеж","С карта","Платежно нареждане","Чек/Ваучер","С насрещно прихващане","Паричен превод","E-Pay","PayPal","EasyPay","Друг
         */
        invoicePage.createItem("Kuka", "5", "бр.", "2", "EUR", "E-Pay");
        invoicePage.createItemButton();
        Assertions.assertEquals("създаде",invoicePage.verifyCreateItem());
    }
}
