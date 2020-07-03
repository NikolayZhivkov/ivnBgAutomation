import Pages.LoginPage;
import Pages.NavigationPage;
import Pages.ObjectsPage;
import Pages.SearchObjectsPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class ItemPageTest extends BaseTest {

    @Test
    @Tag("item")
    @DisplayName("Can create new item via UI")
    public void canCreateNewItemViaUI() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("nizhivkov@gmail.com", "123456");
        NavigationPage navigationPage = new NavigationPage(driver);
        navigationPage.objects();
        ObjectsPage objectsPage = new ObjectsPage(driver);
        objectsPage.createNewItem();
        /**
         * @param User enter new item information
         */
        objectsPage.itemNameBulgarian("Паралел");
        objectsPage.itemNameEnglish("Paralel");
        /**
         * User can choose from different currency unit
         * @param : "лв.", "EUR", "USD", "GBP", "RON", "DKK", "CAD", "PLN", "CZK", "CHF", "HUF", "SGD", "AUD", "HRK", "JPY", "INR"
         */
        objectsPage.price("10", "USD");
        /**
         * User can choose from different quantity units
         * @param : бр., дни, кг, месец, 123, kg., кг, kg, бр., кг., литър, pound, бр, ÐºÐ³., kr., ??., 4, num, ---, Нова...
         *
         */
        objectsPage.priceForQuantityUnit("2", "бр.");
        objectsPage.account("111");
        objectsPage.accountingBatch("22222");
        /**
         * User create item, click on add item button
         */
        objectsPage.addObject();


    }

    @Test
    @Tag("item")
    @DisplayName("Can search and delete item via UI")
    public void canSearchAndDeleteItemViaUI() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("nizhivkov@gmail.com", "123456");
        NavigationPage navigationPage = new NavigationPage(driver);
        navigationPage.objects();
        SearchObjectsPage searchObjectsPage = new SearchObjectsPage(driver);
        searchObjectsPage.clickSearch();
        /**
         * Methods that can search specific item, by name,price , type of currency etc.
         */
        searchObjectsPage.searchByName("Паралел");
        /**
         * User can choose from different currency unit
         * @param : "лв.", "EUR", "USD", "GBP", "RON", "DKK", "CAD", "PLN", "CZK", "CHF", "HUF", "SGD", "AUD", "HRK", "JPY", "INR"
         */
        searchObjectsPage.enterPriceFromTo("","","USD");
        searchObjectsPage.enterCatNum("");
        searchObjectsPage.enterQuantityFromTo("","");
        searchObjectsPage.enterAvailableFromTo("","");
        searchObjectsPage.clickSearchButton();

        searchObjectsPage.clickCheckBox();
        /**
         * Method that delete search item
         */
        searchObjectsPage.deleteItem();







    }
}
