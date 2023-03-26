package tests;

import Pages_Object.HomePageElements;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


@RunWith(Parameterized.class)
public class TestQuestionsSection {
    WebDriver driver;
    private final String result;
    private final String accordionLocator;



    public TestQuestionsSection(String result, String accordionLocator) {
        this.result = result;
        this.accordionLocator = accordionLocator;
    }

    @Parameterized.Parameters// добавили аннотацию
    public static Object[][] data() {
        return new Object[][]{
                {"Сутки — 400 рублей. Оплата курьеру — наличными или картой.", "//div[@id='accordion__heading-0']" },
                {"Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.", "//div[@id='accordion__heading-1']"},
                {"Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.", "//div[@id='accordion__heading-2']"},
                {"Только начиная с завтрашнего дня. Но скоро станем расторопнее.", "//div[@id='accordion__heading-3']", },
                {"Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.", "//div[@id='accordion__heading-4']"},
                {"Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.", "//div[@id='accordion__heading-5']"},
                {"Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.", "//div[@id='accordion__heading-6']"},
                {"Да, обязательно. Всем самокатов! И Москве, и Московской области.", "//div[@id='accordion__heading-7']"},
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
    public void testQuestionsSection()  throws InterruptedException {
        HomePageElements objHomePage = new HomePageElements(driver);
        objHomePage.scrollToMainQuestion();

        driver.findElement(By.xpath(accordionLocator)).click();
        Thread.sleep(500);
        String answerText = objHomePage.getOpenAnswerText();
        Assert.assertEquals(result, answerText);
    }
    @After
    public void quit() {
        driver.quit();
    }
}
