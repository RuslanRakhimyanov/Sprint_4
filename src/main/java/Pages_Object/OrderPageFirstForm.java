package Pages_Object;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class OrderPageFirstForm {
    private final WebDriver driver;

    public OrderPageFirstForm(WebDriver driver) {
        this.driver = driver;
    }

    public By firstNameField = By.xpath("//div/input[@placeholder='* Имя']");
    public By secondNameField = By.xpath("//div/input[@placeholder='* Фамилия']");
    public By streetField = By.xpath("//div/input[@placeholder='* Адрес: куда привезти заказ']");
    public By metroStationField = By.xpath("//div/input[@placeholder='* Станция метро']");
    public By phoneNumberField = By.xpath("//div/input[@placeholder='* Телефон: на него позвонит курьер']");
    public By nextButton = By.xpath("//div/button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    public void setFirstNameField(String firstName) {
        driver.findElement(firstNameField).sendKeys(firstName);
    }
    public void setSecondNameField(String secondName) {
        driver.findElement(secondNameField).sendKeys(secondName);
    }
    public void setStreetField(String streetName) {
        driver.findElement(streetField).sendKeys(streetName);
    }
    public void setMetroStationField(String metroStantion) {
        driver.findElement(metroStationField).sendKeys(metroStantion, Keys.ARROW_DOWN, Keys.ENTER);
    }
    public void setPhoneNumberField(String phoneNumber) {
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
    }
    public void setNextButton() {
        driver.findElement(nextButton).click();}

    public void fillFirstForm (String firstName, String secondName, String streetName, String metroStantion, String phoneNumber) {
        setFirstNameField(firstName);
        setSecondNameField(secondName);
        setStreetField(streetName);
        setMetroStationField(metroStantion);
        setPhoneNumberField(phoneNumber);
    }

}
