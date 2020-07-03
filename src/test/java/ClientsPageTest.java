import Pages.ClientsPageWithVatNum;
import Pages.ClientsPageWithoutVatNum;
import Pages.LoginPage;
import Pages.NavigationPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class ClientsPageTest extends BaseTest {

    @Test
    @Tag("Can create client via UI whit vat number")
    @DisplayName("Can create client via UI whit vat number")
    public void canCreateClientViaUIWhitVatNumber() {
        /**
         * Method that login in web site
         */
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("nizhivkov@gmail.com", "123456");
        /**
         * navigation bar
         */
        NavigationPage navigationPage = new NavigationPage(driver);
        navigationPage.clients();
        ClientsPageWithVatNum clientsPageWithVatNum = new ClientsPageWithVatNum(driver);
        clientsPageWithVatNum.createClientButton();
        /**
         * Method that create client from type firm
         */
        clientsPageWithVatNum.firmType();
        /**
         * Method that create client , user can fill only the obligatory fields
         * which are firm name "name", address "firmAddress" and city "town"
         */
        clientsPageWithVatNum.enterFirmNameAndBulstat("Mandalee", "354257");
        clientsPageWithVatNum.checkVatDDS("314142", "Pirin St", "2450", "Plovdiv", "354253", "");
        clientsPageWithVatNum.enterFirmInEnglish("Andalee", "kiril i kiril", "sofia", "352526");
        /**
         * Method enter phone number user can choose phoneType"Служебен","Домашен","Мобилен","Факс"
         */
        clientsPageWithVatNum.enterPhoneNumber("058785524", "Факс");
        clientsPageWithVatNum.addClient();
        /**
         * Method that verify that the client is created
         */
        wait(5);

    }

    @Test
    @Tag("Can search and delete created client via UI")
    @DisplayName("Can search and delete created client via UI")
    public void canSearchAndDeleteCreatedClientViaUI() {
        /**
         * Method that login in to the web site
         */
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("nizhivkov@gmail.com", "123456");
        /**
         * Method that navigate to menu clients
         */
        NavigationPage navigationPage = new NavigationPage(driver);
        navigationPage.clients();
        ClientsPageWithVatNum clientsPageWithVatNum = new ClientsPageWithVatNum(driver);
        /**
         * Method that click on search button
         */
        clientsPageWithVatNum.clickSearchClients();
        /**
         * Method searchClient can search a client By FirmName, Address, Corespondent, Bulstat,Mol, Email
         *
         */
        clientsPageWithVatNum.searchClient("Mandalee", "", "", "354257", "", "");
        /**
         * Method that delete searched client
         */
        clientsPageWithVatNum.deleteSearchClient();



    }

    @Test
    @Tag("Can't create client whit same EIK/Bulstat number")
    @DisplayName("Can't create client whit same EIK/Bulstat number ")
    public void CantCreateClientWhitSameEIKBulstatNumber() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("nizhivkov@gmail.com", "123456");
        NavigationPage navigationPage = new NavigationPage(driver);
        navigationPage.clients();
        ClientsPageWithVatNum clientsPageWithVatNum = new ClientsPageWithVatNum(driver);
        clientsPageWithVatNum.createClientButton();
        clientsPageWithVatNum.firmType();
        /**
         * Method that enter client info
         */
        clientsPageWithVatNum.enterFirmNameAndBulstat("Andale", "254254");
        clientsPageWithVatNum.checkVatDDS("213213", "kiril i kiril", "2100", "SofiaCity", "252525", "1");
        clientsPageWithVatNum.enterFirmInEnglish("Andale", "kiril i kiril", "sofia", "252525");
        clientsPageWithVatNum.enterPhoneNumber("32132131", "Факс");
        /**
         * method that add client
         */
        clientsPageWithVatNum.addingClient();
        /**
         * Method that verify that client with same DDS number can't be created
         */
        clientsPageWithVatNum.verifyEnableCreateClientWhitSameDDS();




    }

    @Test
    @Tag("Can edit created client whit same EIK/Bulstat number")
    @DisplayName("Can edit created client whit same EIK/Bulstat number ")
    public void CanEditCreatedClientWhitSameEIKBulstatNumber() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("nizhivkov@gmail.com", "123456");
        NavigationPage navigationPage = new NavigationPage(driver);
        navigationPage.clients();
        ClientsPageWithVatNum clientsPageWithVatNum = new ClientsPageWithVatNum(driver);
        clientsPageWithVatNum.createClientButton();
        clientsPageWithVatNum.firmType();
        clientsPageWithVatNum.enterFirmNameAndBulstat("Andale", "254254");
        clientsPageWithVatNum.checkVatDDS("213213", "kiril i kiril", "2100", "SofiaCity", "252525", "1");
        clientsPageWithVatNum.enterFirmInEnglish("Andale", "kiril i kiril", "sofia", "252525");
        clientsPageWithVatNum.enterPhoneNumber("32132131", "Факс");
        clientsPageWithVatNum.addingClient();
        clientsPageWithVatNum.verifyEnableCreateClientWhitSameDDS();
        clientsPageWithVatNum.seeDoubleMatchClient();
        /**
         * трябва да оправа метода за редактиране на клиента че нещо не ми локира edit button
         */
        wait(10);
        //clientsPage.editClientMatch("254257");


    }


    @Test
    @Tag("Can create client via UI without vat number")
    @DisplayName("Can create client via UI without vat number")
    public void canCreateClientViaUIWithoutVatNumber() {
        /**
         * Method that login in web site
         */
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("nizhivkov@gmail.com", "123456");
        /**
         * navigation bar
         */
        NavigationPage navigationPage = new NavigationPage(driver);
        navigationPage.clients();
        ClientsPageWithVatNum clientsPageWithVatNum = new ClientsPageWithVatNum(driver);
        clientsPageWithVatNum.createClientButton();

        /**
         * Method that create client from type firm
         */
        clientsPageWithVatNum.enterFirmNameAndBulstat("Karamanoleva", "2654574");
        ClientsPageWithoutVatNum clientsPageWithoutVatNum = new ClientsPageWithoutVatNum(driver);
        /**
         * Method that enter firm info in bulgarian and english languages
         */
        clientsPageWithoutVatNum.enterFirmAddressBg("Ризово улица", "2453", "Бистрица", "3255", "202");
        clientsPageWithoutVatNum.enterFirmAddressEn("karamanoleva", "rizovo street", "Bistrica", "3255");
        clientsPageWithVatNum.enterPhoneNumber("23658971", "Факс");
        /**
         * Method that create and verify that the client is created
         */

        clientsPageWithoutVatNum.addClientButton();

    }

    @Test
    @Tag("Can create client via UI without vat number and edit it")
    @DisplayName("Can create client via UI without vat number and edit it")
    public void canCreateClientViaUIWithoutVatNumberAndEditIt() {
        /**
         * Method that login in web site
         */
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("nizhivkov@gmail.com", "123456");
        /**
         * navigation bar
         */
        NavigationPage navigationPage = new NavigationPage(driver);
        navigationPage.clients();
        ClientsPageWithVatNum clientsPageWithVatNum = new ClientsPageWithVatNum(driver);
        clientsPageWithVatNum.createClientButton();
        /**
         * Method that create client from type firm
         */
        clientsPageWithVatNum.enterFirmNameAndBulstat("Стар", "");
        ClientsPageWithoutVatNum clientsPageWithoutVatNum = new ClientsPageWithoutVatNum(driver);
        /**
         * Method tha enter firm info in bulgarian and english languages
         */
        clientsPageWithoutVatNum.enterFirmAddressBg("Писта", "", "Бистрица", "", "");
        clientsPageWithoutVatNum.enterFirmAddressEn("Star", "Pista", "Bistrica", "");
        clientsPageWithVatNum.enterPhoneNumber("00359585858", "Факс");
        /**
         * Method that create and verify that the client is created
         */
        clientsPageWithoutVatNum.addClientButton();
        /**
         * Method that edit client info
         * Editing only required fields
         */
        clientsPageWithoutVatNum.editClient("Стар Листа","Писта иста","Калояново");
        wait(10);


    }
}
