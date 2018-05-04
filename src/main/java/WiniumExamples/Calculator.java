package WiniumExamples;

/**
 * Created by Maor on 19/03/2018.
 * Refer to https://github.com/2gis/Winium.Desktop
 */

import java.io.IOException;
import java.net.URL;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import static java.util.concurrent.TimeUnit.SECONDS;

public class Calculator {
    public DesktopOptions options = new DesktopOptions();

    @BeforeTest
     public void SetUp() throws InterruptedException, IOException {
        options.setApplicationPath("C:\\Windows\\System32\\calc.exe");
   }

   @Test
    public void CalcAddition() throws InterruptedException, IOException {
        WiniumDriver driver = new WiniumDriver(new URL("http://localhost:9999"), options);
        SECONDS.sleep(2);
        driver.findElementById("num8Button").click();
        driver.findElementById("plusButton").click();
        driver.findElementById("num8Button").click();
        driver.findElementById("equalButton").click();
        SECONDS.sleep(5);
        String output = driver.findElementById("CalculatorResults").getAttribute("Name");
        System.out.println("Result is: " + output);
        Assert.assertEquals(output, "התצוגה היא 16");
        driver.findElementByName("Close").click();
    }

    @Test
    public void CalcMultiply () throws InterruptedException, IOException {
        WiniumDriver driver = new WiniumDriver(new URL("http://localhost:9999"), options);
        SECONDS.sleep(2);
        driver.findElementById("num8Button").click();
        driver.findElementById("multiplyButton").click();
        driver.findElementById("num8Button").click();
        driver.findElementById("equalButton").click();
        SECONDS.sleep(5);
        String output = driver.findElementById("CalculatorResults").getAttribute("Name");
        System.out.println("Result is: " + output);
        Assert.assertEquals(output, "התצוגה היא 64");
        driver.findElementByName("Close").click();
    }

}

