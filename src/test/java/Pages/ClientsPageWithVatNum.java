package Pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ClientsPageWithVatNum extends BasePage {

    protected WebDriver driver;

    private By createNewClientButtonLocator = By.cssSelector("a.newbtn.selenium-add-client-button");
    private By getHeadLineTextLocator = By.cssSelector("div#headline2");
    private By typePersonRadioButtonLocator = By.id("type_person");
    private By typeFirmRadioButtonLOcator = By.id("type_firm");
    private By firmNameBGLocator = By.xpath("//input[@name=\"firm_name\"]");
    private By firmNameENLocator = By.xpath("//input[@name=\"firm_name_en\"]");
    private By eikBulstatLocator = By.xpath("//input[@name=\"firm_bulstat\"]");
    private By checkVatNumberLocator = By.id("show_vat_number");
    private By firmVatNumberLocator = By.xpath("//input[@name=\"firm_vat_number\"]");
    private By firmAdressLocator = By.xpath("//td//textarea[@name=\"firm_addr\"]");
    private By firmAddressENLocator = By.xpath("//td//textarea[@name=\"firm_addr_en\"]");
    private By postalCodeLocator = By.xpath("//input[@name=\"client_postcode\"]");

    private By firmTownLocator = By.xpath("//input[@name=\"firm_town\"]");
    private By firmTownENLocator = By.xpath("//input[@name=\"firm_town_en\"]");
    private By firmMolLocator = By.xpath("//input[@name=\"firm_mol\"]");
    private By firmMolENLocator = By.xpath("//input[@name=\"firm_mol_en\"]");
    private By clientCodeLocator = By.xpath("//input[@name=\"firm_mol\"]");
    private By phoneNumberLocator = By.xpath("//input[@name=\"phone_numbers[0][number]\"]");
    private By addClientButton = By.xpath("//input[@name=\"do_submit\"]");
    private By verificationMessageCreateClient = By.cssSelector("div#okmsg");
    private By searchClientsLocator = By.id("searchbtn");
    private By searchFirmNameLocator = By.xpath("//input[@name=\"fnm\"]");
    private By searchFirmAddressLocator = By.xpath("//input[@name=\"adr\"]");
    private By searchFirmCorespondentLocator = By.xpath("//input[@name=\"unm\"]");
    private By searchFirmBulstatLocator = By.xpath("//input[@name=\"bst\"]");
    private By searchFirmMolLocator = By.xpath("//input[@name=\"mol\"]");
    private By searchFirmEmailLocator = By.xpath("//input[@name=\"eml\"]");
    private By searchButtonLocator = By.xpath("//input[@name=\"s\"]");
    private By markAllCheckboxLocator = By.xpath("//*[@id=\"handle_all\"]");
    private By deleteButtonLocator = By.id("cl_delbtn");

    private By errorMessageLocator = By.id("error");
    private By linkCanSeeItHereLocator = By.xpath("//a[@target=\"_blank\"]");
    private By editButtonLocator = By.xpath("//div[@id=\"faktura_controls\"]//a[@class=\"slenium-client-button-edit\"]");
    private By saveEditChangesLocator = By.xpath("//input[@type=\"submit\"]");
    private By verificationMessage = By.id("okmsg");



    public ClientsPageWithVatNum(WebDriver driver) {
        super(driver);
    }

    protected String getHeaderText() {

        return getText(getHeadLineTextLocator);

    }


    public void createClientButton() {
        click(createNewClientButtonLocator);
        Assertions.assertEquals("Нов клиент", getHeaderText().trim());

    }

    public void personType() {
        click(typePersonRadioButtonLocator);
    }

    public void firmType() {
        click(typeFirmRadioButtonLOcator);
    }

    protected void firmNameBg(String firmName) {
        typeText(firmNameBGLocator, firmName);

    }

    protected void bulstat(String bulstat) {
        typeText(eikBulstatLocator, bulstat);
    }

    public void enterFirmNameAndBulstat(String name, String bulstat) {
        firmNameBg(name);
        bulstat(bulstat);
    }

    public void checkVatDDS(String vatNum, String firmAddress, String postalCode, String town, String mol, String code) {
        click(checkVatNumberLocator);
        vatNumber(vatNum);
        firmAddress(firmAddress);
        postalCode(postalCode);
        firmTown(town);
        firmMol(mol);
        clientCode(code);

    }


    protected void clientCode(String code) {
        typeText(clientCodeLocator, code);
    }

    protected void firmMol(String mol) {
        typeText(firmMolLocator, mol);
    }

    protected void firmTown(String town) {
        typeText(firmTownLocator, town);
    }

    protected void postalCode(String postalCode) {
        typeText(postalCodeLocator, postalCode);
    }

    protected void firmAddress(String firmAddress) {
        typeText(firmAdressLocator, firmAddress);
    }

    protected void vatNumber(String vatNum) {
        typeText(firmVatNumberLocator, vatNum);
    }

    public void enterFirmInEnglish(String name, String address, String town, String molEn) {
        firmNameEN(name);


        firmAddressEN(address);

        firmTownEN(town);
        firmMOlEN(molEn);


    }

    protected void firmNameEN(String name) {
        typeText(firmNameENLocator, name);

    }

    protected void firmAddressEN(String address) {
        typeText(firmAddressENLocator, address);
    }


    protected void firmTownEN(String town) {
        typeText(firmTownENLocator, town);
    }

    protected void firmMOlEN(String molEn) {
        typeText(firmMolENLocator, molEn);
    }

    public void enterPhoneNumber(String phoneNumber, String phoneType) {
        typeText(phoneNumberLocator, phoneNumber);
        selectNumber(phoneType);
    }

    protected String getVerificationCreateClient() {

        return getText(verificationMessageCreateClient);
    }

    public void addClient() {
        click(addClientButton);

        Assertions.assertEquals("Клиентът е добавен успешно.", getVerificationCreateClient().trim());


    }

    public void addingClient() {
        click(addClientButton);
    }

    public void clickSearchClients() {
        click(searchClientsLocator);
    }

    public void searchClient(String firmName, String address, String corespondent, String bulstat, String mol, String email) {
        searchFirm(firmName);
        searchAddress(address);
        searchCorespondent(corespondent);
        searchBulstat(bulstat);
        searchMol(mol);
        searchEmail(email);
        click(searchButtonLocator);


    }

    public void deleteSearchClient() {
        checkBox();
        deleteButton();
        acceptAlert();
        Assertions.assertEquals("Избраните клиенти бяха изтрити успешно.", verifyDeleteClient().trim());

    }

    protected void searchFirm(String firmName) {
        typeText(searchFirmNameLocator, firmName);
    }

    protected void searchAddress(String address) {
        typeText(searchFirmAddressLocator, address);
    }

    protected void searchCorespondent(String corespondent) {
        typeText(searchFirmCorespondentLocator, corespondent);
    }

    protected void searchBulstat(String bulstat) {
        typeText(searchFirmBulstatLocator, bulstat);
    }

    protected void searchMol(String mol) {
        typeText(searchFirmMolLocator, mol);
    }

    protected void searchEmail(String email) {
        typeText(searchFirmEmailLocator, email);
    }

    protected void checkBox() {
        click(markAllCheckboxLocator);
    }

    protected void deleteButton() {
        click(deleteButtonLocator);
    }

    protected String verifyDeleteClient() {
        return getText(verificationMessage);
    }

    protected String getErrorMessageCantCreateClientWhitSameDDSNum() {
        return getText(errorMessageLocator);

    }

    public void verifyEnableCreateClientWhitSameDDS() {
        Assertions.assertEquals("Вече съществува фирма Andale с този булстат", getErrorMessageCantCreateClientWhitSameDDSNum().trim());
    }

    public void seeDoubleMatchClient() {
        click(linkCanSeeItHereLocator);
    }

    public void editClientMatch(String changeBulstat) {
//
//        String parentWindow = driver.getWindowHandle();
//        Set<String> handles =  driver.getWindowHandles();
//        for(String windowHandle  : handles)
//        {
//            if(!windowHandle.equals(parentWindow))
//            {
//                driver.switchTo().window(windowHandle);
//         //<!--Perform your operation here for new window-->
//                click(editButtonLocator);
//                bulstat(changeBulstat);
//                click(saveEditChangesLocator);
//                Assertions.assertEquals("Информацията е редактирана успешно.",verifyEditMassageChanges().trim());
//                    driver.close(); //closing child window
//                driver.switchTo().window(parentWindow); //cntrl to parent window
//            }
//        }


        click(editButtonLocator);


        bulstat(changeBulstat);
        click(saveEditChangesLocator);
        Assertions.assertEquals("Информацията е редактирана успешно.", verifyEditMassageChanges().trim());


    }

    protected String verifyEditMassageChanges() {
        return getText(verificationMessage);
    }







}
