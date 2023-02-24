package practise;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

import java.time.Duration;

public class AllTest {
    WebDriver driver;
    PageObjModel pom;

    public AllTest() {
        driver = new ChromeDriver();
        pom = new PageObjModel(driver);
    }

    @Test
    public void test() {
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElements(By.xpath("//input[@name='radioButton']")).stream()
                .filter(x -> x.findElement(By.xpath("parent::label")).getText().trim().equalsIgnoreCase("radio3"))
                .findFirst().ifPresent(WebElement::click);
        driver.findElement(By.cssSelector("input#autocomplete")).sendKeys(Keys.SHIFT, "india");
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//li[@class='ui-menu-item']")));
        Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);
        wait.until(driver -> {
            if(driver.findElement(By.xpath("//li[@class='ui-menu-item']")).isDisplayed()){
                return driver.findElement(By.xpath("//li[@class='ui-menu-item']"));
            }else{
                return null;
            }
        });
//        pom.getCountriesDropdown().stream().filter(x -> x.findElement(By.xpath("div")).getText().equalsIgnoreCase("india"))
//                .findFirst().ifPresent(WebElement::click);
        driver.manage().logs().get(LogType.DRIVER).getAll().stream().map(LogEntry::getMessage).forEach(System.out::println);
        driver.quit();

    }
}
