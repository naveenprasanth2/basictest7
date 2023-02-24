package practise;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class BasicTest {

    public static final String reportPath = "C:\\Users\\navee\\IdeaProjects\\basictest7\\src\\main\\java\\reports";
    public static final String screenPath = "C:\\Users\\navee\\IdeaProjects\\basictest7\\src\\main\\java\\screenshots";

    @Test
    public void test() throws IOException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);

        ChromeOptions co = new ChromeOptions();
        co.addArguments("--headless");
        co.addArguments("--screen-size=1920,1080");
        co.merge(dc);
        WebDriver driver = new ChromeDriver(co);

        ExtentSparkReporter spark = new ExtentSparkReporter(reportPath + "\\newTest.html");
        spark.config().setReportName("regression");
        spark.config().setDocumentTitle("myFirstTest");

        ExtentReports report = new ExtentReports();
        report.attachReporter(spark);
        report.setSystemInfo("tester", "naveen");
        report.setSystemInfo("testname", "summaTest");

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElements(By.xpath("//input[@name='radioButton']"))
                .stream().filter(x -> x.getText().trim().equalsIgnoreCase("radio 3"))
                .findFirst().ifPresent(WebElement::click);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scroll(0,500)");

        TakesScreenshot sc = (TakesScreenshot) driver;
        File src = sc.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File(screenPath + "\\firstTest.png"));

        ExtentTest test = report.createTest("firstTest");
        test.addScreenCaptureFromPath(screenPath + "\\firstTest.png");
        report.flush();
    }
}
