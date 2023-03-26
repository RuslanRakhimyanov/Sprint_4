package Pages_Object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPageSecondForm {
    private final WebDriver driver;

    public OrderPageSecondForm(WebDriver driver) {
        this.driver = driver;
    }

    public By dateField = By.xpath("//div/input[@placeholder='* Когда привезти самокат']");
    public By orderDropdownField = By.xpath("//div/span[@class='Dropdown-arrow']");
    public By orderDropdownFieldDay = By.xpath("//div[contains(text(),'сутки')]");

    //public By orderDropTimeFieldTwoDay = By.xpath("//div[contains(text(),'двое суток')]");
    //public By orderDropTimeFieldThreeDay = By.xpath("//div[contains(text(),'трое суток')]");

    public By colorScooterCheck = By.xpath("//label[contains(text(),'чёрный жемчуг')]");
    //public By colorScooterCheck2 = By.xpath("//label[contains(text(),'серая безысходность')]");

    public By orderComment = By.xpath("//div/input[@placeholder='Комментарий для курьера']");
    public By orderBook = By.xpath("//div[@class='Order_Buttons__1xGrp']/button[contains(text(),'Заказать')]");
    public By orderConfirmation = By.xpath("//div[@class='Order_Buttons__1xGrp']/button[contains(text(), 'Да')]");
    public By orderSuccessText = By.xpath("//div[@class='Order_ModalHeader__3FDaJ']");

    public void setDateOrder(String dataFields){
        driver.findElement(dateField).sendKeys(dataFields);}

    public  void setOrderArrowTimeField(){
        driver.findElement(orderDropdownField).click();}

    public  void setOrderDropTimeField(){
        driver.findElement(orderDropdownFieldDay).click();}

    public  void setColorScooterCheck(){
        driver.findElement(colorScooterCheck).click();}

    public  void setOrderComments(String commentField){
        driver.findElement(orderComment).sendKeys(commentField);}

    public void clickOrderBook() {
        driver.findElement(orderBook).click();}

    public  void setOrderConfirmation() {
        driver.findElement(orderConfirmation).click();
    }

    public String getOrderSuccessText() {
        String orderText = driver.findElement(orderSuccessText).getText();
        return orderText;
    }

    public void fillSecondForm(String dataFields, String commentField) {
        setDateOrder(dataFields);
        setOrderArrowTimeField();
        setOrderDropTimeField();
        setColorScooterCheck();
        setOrderComments(commentField);
    }
}
