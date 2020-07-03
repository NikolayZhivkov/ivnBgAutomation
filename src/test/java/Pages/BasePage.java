package Pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BasePage {
    private WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver=driver;
    }

    protected void typeText(By by, String text){
        System.out.println("Entering text: "+text);
        WebElement element = driver.findElement(by);
        element.clear();
        element.sendKeys(text);
    }

    protected void click(By by){
        WebElement element = driver.findElement(by);
        System.out.println("Clicking" );
        element.click();
    }

    protected String getText(By by){
        System.out.println("Extracting text from the web element");
        WebElement element = driver.findElement(by);
        return element.getText().trim();
    }

    protected void select(String unit) {

        Select dropMenu = new Select(driver.findElement(By.xpath("//select[@name=\"obj_0_price_quantity_unit\"]")));
        Assertions.assertFalse(dropMenu.isMultiple());

        List<Object> exp_options = Arrays.asList(new Object[]{"бр.", "дни", "кг", "месец","---", "Нова..."});
        List<Object> act_options = new ArrayList<>();
        List<WebElement> all_options = dropMenu.getOptions();

        for (WebElement option : all_options) {

            act_options.add(option.getText().trim());

        }

        System.out.println("Choosing unit : " + unit);
        Assertions.assertArrayEquals(exp_options.toArray(), act_options.toArray());
        dropMenu.selectByVisibleText(unit);

    }

    protected void selectMoneyCurrency(String currency) {

        Select dropMenu = new Select(driver.findElement(By.xpath("//select[@id=\"money_currency\"]")));
        Assertions.assertFalse(dropMenu.isMultiple());

        List<Object> exp_currency = Arrays.asList(new Object[]{"лв.", "EUR", "USD", "GBP", "RON", "DKK", "CAD", "PLN", "CZK", "CHF", "HUF", "SGD", "AUD", "HRK", "JPY", "INR"});
        List<Object> act_currency = new ArrayList<>();
        List<WebElement> all_currency = dropMenu.getOptions();

        for (WebElement currencyUnit : all_currency) {

            act_currency.add(currencyUnit.getText().trim());

        }

        System.out.println("Choosing unit : " + currency);
        Assertions.assertArrayEquals(exp_currency.toArray(), act_currency.toArray());
        dropMenu.selectByVisibleText(currency);

    }

    protected void selectPaymentType(String payment) {

        Select dropMenu = new Select(driver.findElement(By.id("payment_type")));
        Assertions.assertFalse(dropMenu.isMultiple());

        List<Object> exp_payment = Arrays.asList(new Object[]{"В брой", "Банков път", "Наложен платеж", "С карта", "Платежно нареждане", "Чек/Ваучер", "С насрещно прихващане", "Паричен превод", "E-Pay", "PayPal", "EasyPay", "Друг"});
        List<Object> act_payment = new ArrayList<>();
        List<WebElement> allpayment = dropMenu.getOptions();

        for (WebElement paymentType : allpayment) {

            act_payment.add(paymentType.getText().trim());

        }

        System.out.println("Choosing unit : " + payment);
        Assertions.assertArrayEquals(exp_payment.toArray(), act_payment.toArray());
        dropMenu.selectByVisibleText(payment);

    }

    protected void selectNumber(String typeNumber){
        WebElement phoneType = driver.findElement(By.xpath("//select[@name=\"phone_numbers[0][type]\"]"));
        Select phone = new Select(phoneType);

        Assertions.assertFalse(phone.isMultiple());

        List<Object> exp_options = Arrays.asList(new Object[]{"Служебен","Домашен","Мобилен","Факс"});
        List<Object> act_options = new ArrayList<>();
        List<WebElement> all_options = phone.getOptions();

        for (WebElement option : all_options) {

            act_options.add(option.getText().trim());

        }

        System.out.println("Choosing number type : " + typeNumber);
        Assertions.assertArrayEquals(exp_options.toArray(), act_options.toArray());
        phone.selectByVisibleText(typeNumber);
    }


    protected void acceptAlert() {

        Alert alert = driver.switchTo().alert();
        alert.accept();
        driver.switchTo().defaultContent();

    }

    protected void selectUnitCurrency(String currency){

        Select selectUnit = new Select(driver.findElement(By.xpath("//select[@name=\"price_currency\"]")));
        Assertions.assertFalse(selectUnit.isMultiple());

        List<Object> exp_options = Arrays.asList(new Object[]{"лв.", "EUR", "USD", "GBP", "RON", "DKK", "CAD", "PLN", "CZK", "CHF", "HUF", "SGD", "AUD", "HRK", "JPY", "INR"});

        List<Object> act_options = new ArrayList<Object>();
        List<WebElement> allOptions = selectUnit.getOptions();
        for (WebElement option : allOptions) {
            act_options.add(option.getText());
        }

        selectUnit.selectByVisibleText(currency);


    }

    protected void selectPriceQuantityUnit(String priceQuantityUnit){
        Select quantityUnit = new Select(driver.findElement(By.xpath("//select[@name=\"price_quantity_unit\"]")));
        Assertions.assertFalse(quantityUnit.isMultiple());

        List<String> exp_quantity = Arrays.asList(new String[]{"бр.","дни","кг","месец","123","kg.","кг","kg","бр.","кг.","литър","pound","бр","ÐºÐ³.","kr.","??.","4","num","---","Нова..."});
        List<String> act_quantity = new ArrayList<String>();
        List<WebElement> allQuantity = quantityUnit.getOptions();

        for (WebElement quantity: allQuantity) {
            act_quantity.add(quantity.getText());

        }

        quantityUnit.selectByVisibleText(priceQuantityUnit);
    }

    protected void searchUnitCurrency(String currency){

        Select selectUnit = new Select(driver.findElement(By.xpath("//select[@name=\"prc\"]")));
        Assertions.assertFalse(selectUnit.isMultiple());

        List<Object> exp_options = Arrays.asList(new Object[]{"лв.", "EUR", "USD", "GBP", "RON", "DKK", "CAD", "PLN", "CZK", "CHF", "HUF", "SGD", "AUD", "HRK", "JPY", "INR"});

        List<Object> act_options = new ArrayList<Object>();
        List<WebElement> allOptions = selectUnit.getOptions();
        for (WebElement option : allOptions) {
            act_options.add(option.getText());
        }

        selectUnit.selectByVisibleText(currency);


    }

    protected void bankAccountDropDown(String bankName){

        Select selectUnit = new Select(driver.findElement(By.id("bankName")));
        Assertions.assertFalse(selectUnit.isMultiple());

        List<Object> exp_options = Arrays.asList(new Object[]{"УниКредит Булбанк АД","Банка ДСК EАД","Обединена българска банка АД","Юробанк България АД","Райфайзенбанк (България) ЕАД","Експресбанк АД","Алианц Банк България АД","Банка Пиреос България АД","Ти Би Ай Банк EАД","Първа инвестиционна банка АД","Българо - американска кредитна банка АД","ПроКредит Банк (България) EАД","Търговска Банка Д АД","Токуда Банк АД","Инвестбанк АД","Централна кооперативна банка АД","Общинска банка АД","Българска банка за развитие АД","Интернешънъл Асет Банк АД","Тексим Банк АД","Ситибанк Европа АД"});

        List<Object> act_options = new ArrayList<Object>();
        List<WebElement> allOptions = selectUnit.getOptions();
        for (WebElement option : allOptions) {
            act_options.add(option.getText());
        }

        selectUnit.selectByVisibleText(bankName);


    }


    protected void selectBankCurrency(String currency){

        Select selectUnit = new Select(driver.findElement(By.id("currency")));
        Assertions.assertFalse(selectUnit.isMultiple());

        List<Object> exp_options = Arrays.asList(new Object[]{"BGN","EUR","USD","CHF","CZK","DKK","GBP","HUF","ISK","NOK","PLN","RON","SEK","AED","AFN","AMD","ANG","AOA","ARS","AUD","AWG","AZN","BAM","BBD","BDT","BHD","BIF","BMD","BND","BOB","BRL","BSD","BTN","BWP","BYR","BZD","CAD","CDF","CLP","CNY","COP","CRC","CUC","CUP","CVE","DJF","DOP","DZD","EGP","ERN","ETB","FJD","FKP","GEL","GGP","GHS","GIP","GMD","GNF","GTQ","GYD","HKD","HNL","HRK","HTG","IDR","ILS","IMP","INR","IQD","IRR","JEP","JMD","JOD","JPY","KES","KGS","KHR","KMF","KPW","KRW","KWD","KYD","KZT","LAK","LBP","LKR","LRD","LSL","LYD","MAD","MDL","MGA","MKD","MMK","MNT","MOP","MRO","MUR","MVR","MWK","MXN","MYR","MZN","NAD","NGN","NIO","NPR","NZD","OMR","PAB","PEN","PGK","PHP","PKR","PYG","QAR","RSD","RUB","RWF","SAR","SBD","SCR","SDG","SGD","SHP","SLL","SOS","SPL","SRD","STD","SVC","SYP","SZL","THB","TJS","TMT","TND","TOP","TRY","TTD","TVD","TWD","TZS","UAH","UGX","UYU","UZS","VEF","VND","VUV","WST","XAF","XAG","XAU","XBT","XCD","XDR","XOF","XPD","XPF","XPT","YER","ZAR","ZMW","ZWD"});

        List<Object> act_options = new ArrayList<Object>();
        List<WebElement> allOptions = selectUnit.getOptions();
        for (WebElement option : allOptions) {
            act_options.add(option.getText());
        }

        selectUnit.selectByVisibleText(currency);


    }
}
