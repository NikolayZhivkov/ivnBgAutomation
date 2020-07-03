package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InvoicePage extends BasePage {


    private By headlineInvoice = By.id("headline2");
    private By clientFieldLocator = By.id("client_firmname");
    private By checkIsPersonLocator = By.id("is_person");
    private By bulstatLocator = By.id("clbulstat");
    private By showVatNumLocator = By.id("show_vat_number");
    private By molLocator = By.id("client-firm-mol");
    private By cityLocator = By.id("firm_city");
    private By firmAddressLocator = By.id("firm_addr");
    private By recipientLocator = By.id("client-recipient");
    private By personalEgnLocator = By.id("person_egn");
    private By personCityLocator = By.id("person_city");
    private By personAddressLocator = By.id("person_address");
    private By clientVatNumberLocator = By.id("client-vat-number");
    private By itemFieldFirstLocator = By.xpath("//input[@name=\"obj_0_name\"]");
    private By itemQuantityFirstLocator = By.xpath("//input[@name=\"obj_0_quantity\"]");
    private By selectQuantityUnitLocator = By.xpath("//select[@name=\"obj_0_price_quantity_unit\"]");
    private By selectObjectPriceLocator = By.xpath("//input[@name=\"obj_0_price\"]");
    private By selectCurrencyLocator = By.xpath("//select[@id=\"money_currency\"]");
    private By discountLocator = By.xpath("//input[@class=\"selenium-money-reduction-amount\"]");
    private By createItemButton = By.id("act_create");
    private By verifyCreateItemHeader = By.cssSelector("span.action");


    public String verifyHeadline() {
        return getText(headlineInvoice);

    }

    public void enterClient(String clientName) {
        typeText(clientFieldLocator, clientName);
    }

    public void checkIsPerson(String egn, String city, String address) {
        click(checkIsPersonLocator);
        typeText(personalEgnLocator, egn);
        typeText(personCityLocator, city);
        typeText(personAddressLocator, address);
    }

    public void enterBulstat(String bulstat) {
        typeText(bulstatLocator, bulstat);
    }

    public void checkVat(String DDSNumber) {
        click(showVatNumLocator);
        typeText(clientVatNumberLocator, DDSNumber);

    }

    public void enterMolNumber(String molNumber) {
        typeText(molLocator, molNumber);
    }

    public void enterCity(String city) {
        typeText(cityLocator, city);
    }

    public void enterAddress(String address) {
        typeText(firmAddressLocator, address);
    }

    public void enterRecipient(String recipient) {
        typeText(recipientLocator, recipient);
    }

    public void createItem(String itemName, String quantity, String unit, String price,String currency,String paymentType) {
        typeText(itemFieldFirstLocator, itemName);
        typeText(itemQuantityFirstLocator, quantity);
        selectUnit(unit);
        typeText(selectObjectPriceLocator, price);
        selectCurrency(currency);
        paymentType(paymentType);
    }

    protected void selectUnit(String unit) {
        click(selectQuantityUnitLocator);
        select(unit);
    }
    protected void selectCurrency(String currency){
        click(selectCurrencyLocator);
        selectMoneyCurrency(currency);
    }

    protected void paymentType(String payment){
        selectPaymentType(payment);
    }

    public void createItemButton(){
        click(createItemButton);

    }

   public String verifyCreateItem() {
       return getText(verifyCreateItemHeader).trim();

   }



    public InvoicePage(WebDriver driver) {
        super(driver);
    }
}
