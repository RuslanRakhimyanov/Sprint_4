package tests;

import Pages_Object.HomePageElements;
import Pages_Object.OrderPageFirstForm;
import Pages_Object.OrderPageSecondForm;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.CoreMatchers.containsString;

@RunWith(Parameterized.class)
public class TestOrderScooter {

    private final String orderButtonLocator;
    private final String firstName;
    private final String secondName;
    private final String streetName;
    private final String metroStation;
    private final String phoneNumber;
    private final String dataFields;
    private final String commentField;

    WebDriver driver;

    public TestOrderScooter(String orderButtonLocator, String firstName, String secondName, String streetName, String metroStation, String phoneNumber, String dataFields, String commentField) {
        this.orderButtonLocator = orderButtonLocator;
        this.firstName = firstName;
        this.secondName = secondName;
        this.streetName = streetName;
        this.metroStation = metroStation;
        this.phoneNumber = phoneNumber;
        this.dataFields = dataFields;
        this.commentField = commentField;
    }
    @Parameterized.Parameters
    public static Object[][] getCostumersData() {
        return new Object[][] {
                { "//div/button[@class='Button_Button__ra12g']","Александр", "Петров", "Победы 37", "Сокольники", "89634486811", "31.03.2023", "Тестовый комментарий"},
                { "//div/button[@class='Button_Button__ra12g Button_Middle__1CSJM']","Юлия", "Иванова", "Ленина 55/1", "Чистые пруды", "89001234567", "02.04.2023", ""},
        };
    }

    @Before
    public void startDriver () {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePageElements objHomePage = new HomePageElements(driver);
        objHomePage.clickSignInButton();
    }

    @Test
    public void testUpOrderButton ()  {
        driver.findElement(By.xpath(orderButtonLocator)).click();
        OrderPageFirstForm orderPageFirstForm = new OrderPageFirstForm(driver);
        orderPageFirstForm.fillFirstForm(firstName, secondName, streetName, metroStation,phoneNumber);
        orderPageFirstForm.setNextButton();
        OrderPageSecondForm orderPageSecondForm = new OrderPageSecondForm(driver);
        orderPageSecondForm.fillSecondForm(dataFields,commentField);
        orderPageSecondForm.clickOrderBook();
        orderPageSecondForm.setOrderConfirmation();
        String orderText = orderPageSecondForm.getOrderSuccessText();
        MatcherAssert.assertThat(orderText, containsString("Заказ оформлен"));
    }

    @After
    public void quit() {
        driver.quit();
    }


}
