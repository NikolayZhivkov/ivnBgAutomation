package Pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ClientsPageWithoutVatNum extends BasePage {

    private By firmAddressBgLocator = By.xpath("//td//textarea[@name=\"firm_addr\"]");
    private By clientPostCodeBgLocator = By.xpath("//input[@name=\"client_postcode\"]");
    private By townBgLocator = By.xpath("//input[@name=\"firm_town\"]");
    private By molBgLocator = By.xpath("//input[@name=\"firm_mol\"]");
    private By clientCodeLocator = By.xpath("//input[@name=\"clcode\"]");
    private By firmAddressEnLocator = By.xpath("//td//textarea[@name=\"firm_addr_en\"]");
    private By townEnLocator = By.xpath("//input[@name=\"firm_town_en\"]");
    private By molEnLocator = By.xpath("//input[@name=\"firm_mol_en\"]");
    private By firmNameEnLocator = By.xpath("//input[@name=\"firm_name_en\"]");
    private By addClientButtonLocator = By.xpath("//input[@name=\"do_submit\"]");
    private By verificationMessageLocator = By.id("okmsg");
    private By editButtonLocator = By.cssSelector("a.slenium-client-button-edit");
    private By headLineTextLocator = By.cssSelector("div#headline2");
    private By firmNameLocator = By.xpath("//input[@name=\"firm_name\"]");
    private By saveEditInfoButtonLocator = By.xpath("//input[@name=\"do_submit\"]");

    protected void firmNameBg(String name){
        typeText(firmNameLocator,name);
    }

    protected void firmAddressBg(String address){
        typeText(firmAddressBgLocator,address);
    }
    protected void postCode(String postCode){
        typeText(clientPostCodeBgLocator,postCode);
    }
    protected void townBg(String town){
        typeText(townBgLocator,town);
    }
    protected void molBg(String mol){
        typeText(molBgLocator,mol);
    }
    protected void clientCode(String code){
        typeText(clientCodeLocator,code);
    }
    protected void firmAddressEn(String addressEn){
        typeText(firmAddressEnLocator,addressEn);
    }
    protected void townEn(String town){
        typeText(townEnLocator,town);
    }
    protected void molEn(String molEn){
        typeText(molEnLocator,molEn);
    }

    public void enterFirmAddressBg(String address,String postCode, String town, String mol, String code){
        firmAddressBg(address);
        postCode(postCode);
        townBg(town);
        molBg(mol);
        clientCode(code);
    }

    protected void firmNameEn(String name){
        typeText(firmNameEnLocator,name);
    }

    public void enterFirmAddressEn(String name, String address, String town, String mol){
        firmNameEn(name);
        firmAddressEn(address);
        townEn(town);
        molEn(mol);
    }

    protected String getVerificationMessage(){
        return getText(verificationMessageLocator).trim();
    }

    public void addClientButton(){
        click(addClientButtonLocator);
        Assertions.assertEquals("Клиентът е добавен успешно.",getVerificationMessage());
    }

    protected String getHeadLineText(){
        return getText(headLineTextLocator).trim();
    }
    protected void saveButton(){
        click(saveEditInfoButtonLocator);
        Assertions.assertEquals("Информацията е редактирана успешно.",verificationMessageLocator);
    }

    public void editClient(String name,String address,String town){
        click(editButtonLocator);
        Assertions.assertEquals("Редакция на клиент",getHeadLineText());
        firmNameBg(name);
        firmAddressBg(address);
        townBg(town);
        saveButton();

    }





    public ClientsPageWithoutVatNum(WebDriver driver) {
        super(driver);
    }
}
