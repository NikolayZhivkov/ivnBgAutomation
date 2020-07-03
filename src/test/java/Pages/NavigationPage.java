package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationPage extends BasePage {

    private By beginPageLocator = By.id("tabs_home");
    private By newInvoiceLocator = By.id("tabs_invoices/new");
    private By listOfInvoicesLocator = By.id("tabs_invoices");
    private By clientsLocator = By.id("tabs_clients");
    private By objectsLocator = By.id("tabs_objects");
    private By documentsLocator = By.id("tabs_documents");
    private By cashboxLocator = By.id("tabs_cashbox");


    public void beginMenu(){
        click(beginPageLocator);
    }

    public void newInvoice(){
        click(newInvoiceLocator);
    }

    public void invoiceList(){
        click(listOfInvoicesLocator);
    }

    public void clients(){
        click(clientsLocator);
    }

    public void objects(){
        click(objectsLocator);
    }

    public void documents(){
        click(documentsLocator);
    }

    public void cash(){
        click(cashboxLocator);
    }



    public NavigationPage(WebDriver driver) {
        super(driver);
    }
}
