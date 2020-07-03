package Pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ObjectsPage extends BasePage {

    public ObjectsPage(WebDriver driver) {
        super(driver);
    }

    private By newItemButtonLocator = By.cssSelector("a.newbtn.selenium-add-item");
    private By headLineTextLocator = By.cssSelector("div#headline2");
    private By itemNameBgLocator = By.xpath("//input[@name=\"name\"]");
    private By itemNameEnLocator = By.xpath("//input[@name=\"name_en\"]");
    private By priceItemLocator = By.xpath("//input[@name=\"price\"]");
    private By priceForQuantityUnitLocator = By.xpath("//input[@name=\"price_quantity\"]");
    private By accountFieldLocator = By.xpath("//input[@name=\"account\"]");
    private By accountingBatchLocator = By.xpath("//input[@name=\"accounting_batch\"]");
    private By submitButtonLocator = By.xpath("//input[@name=\"do_submit\"]");
    private By verificationMessageLocator = By.id("okmsg");

    public void createNewItem() {
        click(newItemButtonLocator);
        Assertions.assertEquals("Нов артикул", getHeadLineText());
    }

    protected String getHeadLineText() {
        return getText(headLineTextLocator).trim();
    }

    public void itemNameBulgarian(String name) {
        typeText(itemNameBgLocator, name);
    }

    public void itemNameEnglish(String name) {
        typeText(itemNameEnLocator, name);
    }

    public void price(String price, String currency) {
        typeText(priceItemLocator, price);
        selectUnitCurrency(currency);
    }

    public void priceForQuantityUnit(String unit, String quantityUnit) {
        typeText(priceForQuantityUnitLocator, unit);
        selectPriceQuantityUnit(quantityUnit);
    }

    public void account(String account) {
        typeText(accountFieldLocator, account);
    }

    public void accountingBatch(String accBatch) {
        typeText(accountingBatchLocator, accBatch);
    }

    public void addObject() {
        click(submitButtonLocator);
        Assertions.assertEquals("Артикулът е добавен успешно.", getVerificationMessage());
    }

    protected String getVerificationMessage() {
        return getText(verificationMessageLocator).trim();
    }

}
