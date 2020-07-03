package Pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchObjectsPage extends BasePage {

    private By searchButtonLocator = By.id("searchbtn");
    private By nameFieldLocator = By.xpath("//input[@name=\"nm\"]");
    private By itemPriceFromLocator = By.xpath("//input[@name=\"pr1\"]");
    private By itemPriceToLocator = By.xpath("//input[@name=\"pr2\"]");
    private By catNumberLocator = By.xpath("//input[@name=\"catnum\"]");
    private By quantityFromLocator = By.xpath("//input[@name=\"qu1\"]");
    private By quantityToLocator = By.xpath("//input[@name=\"qu2\"]");
    private By availableFromLocator = By.xpath("//input[@name=\"av1\"]");
    private By availableToLocator = By.xpath("//input[@name=\"av2\"]");
    private By sButtonLocator = By.xpath("//input[@name=\"s\"]");
    private By checkAllLocator = By.id("handle_all");
    private By deleteSearchButtonLocator = By.id("delbtn");
    private By verifyDeleteItemMessage = By.id("okmsg");

    public void clickSearch(){
        click(searchButtonLocator);
    }
    public SearchObjectsPage(WebDriver driver) {
        super(driver);
    }
    public void searchByName(String name){
        typeText(nameFieldLocator,name);
    }
    public void enterPriceFromTo(String from,String to,String currency){
        typeText(itemPriceFromLocator,from);
        typeText(itemPriceToLocator,to);
        searchUnitCurrency(currency);
    }
    public void enterCatNum(String catNum){
        typeText(catNumberLocator,catNum);
    }
    public void enterQuantityFromTo(String from,String to){
        typeText(quantityFromLocator,from);
        typeText(quantityToLocator,to);
    }
    public void enterAvailableFromTo(String from,String to){
        typeText(availableFromLocator,from);
        typeText(availableToLocator,to);
    }
    public void clickSearchButton(){
        click(sButtonLocator);
    }
    public void clickCheckBox(){
        click(checkAllLocator);
    }
    public void deleteItem(){
        click(deleteSearchButtonLocator);
        acceptAlert();
        Assertions.assertEquals("Избраните артикули бяха изтрити успешно.",getVerificationDeleteMessage());

    }
    protected String getVerificationDeleteMessage(){
        return getText(verifyDeleteItemMessage).trim();
    }
}
