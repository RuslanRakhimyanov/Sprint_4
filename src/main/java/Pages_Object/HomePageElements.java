package Pages_Object;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageElements {
    private final WebDriver driver;
    private final By cookiesButton = By.xpath(".//button[@class='App_CookieButton__3cvqF']");
    private final By mainQuestionText = By.xpath("//div[text()='Вопросы о важном']");

    // Все локаторы с вопросами перенесены в TestQuestionsSection @Parameterized
    //public By firstAccordionBlock = By.xpath("//div[@id='accordion__heading-0']");
    //public By secondAccordionBlock = By.xpath("//div[@id='accordion__heading-1']");
    //public By thirdAccordionBlock = By.xpath("//div[@id='accordion__heading-2']");
    //public By fourthAccordionBlock = By.xpath("//div[@id='accordion__heading-3']");
    //public By fifthAccordionBlock = By.xpath("//div[@id='accordion__heading-4']");
    //public By sixthAccordionBlock = By.xpath("//div[@id='accordion__heading-5']");
    //public By seventhAccordionBlock = By.xpath("//div[@id='accordion__heading-6']");
    //public By eighthAccordionBlock = By.xpath("//div[@id='accordion__heading-7']");

    public By openAnswerText = By.xpath("//div[@aria-expanded='true']/parent :: div/parent::div/div[@class='accordion__panel']/p");

    public HomePageElements(WebDriver driver) {
        this.driver = driver;
    }
    public void clickSignInButton() {
        driver.findElement(cookiesButton).click();
    }

    public void scrollToMainQuestion() {
        WebElement element = driver.findElement(mainQuestionText);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public String getOpenAnswerText() {
        String textElement = driver.findElement(openAnswerText).getText();
        return textElement;
    }
}
