package nativewinapps;

/**
 * Created by Maor on 5/5/2018.
 */
import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import static java.util.concurrent.TimeUnit.SECONDS;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.annotations.*;

public class Calculator {

    private static WindowsDriver driverSession = null;

    @BeforeTest
    public static void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("app", "Microsoft.WindowsCalculator_8wekyb3d8bbwe!App");
        driverSession = new WindowsDriver(new URL(" http://127.0.0.1:4723"), capabilities);
        driverSession.manage().timeouts().implicitlyWait(10, SECONDS);
    }

    @Test
    public void CalcAddition() throws InterruptedException {
        driverSession.findElementByAccessibilityId("num1Button").click();
        driverSession.findElementByAccessibilityId("plusButton").click();
        driverSession.findElementByAccessibilityId("num7Button").click();
        driverSession.findElementByAccessibilityId("equalButton").click();
        String result = driverSession.findElementByAccessibilityId("CalculatorResults").getAttribute("Name");
        System.out.println("Result is: " + result);
        Assert.assertEquals(result, "התצוגה היא 8");
        SECONDS.sleep(2);
    }

    @Test
    public void CalcMultiply () throws InterruptedException {
        driverSession.findElementByAccessibilityId("num9Button").click();
        driverSession.findElementByAccessibilityId("multiplyButton").click();
        driverSession.findElementByAccessibilityId("num9Button").click();
        driverSession.findElementByAccessibilityId("equalButton").click();
        String result = driverSession.findElementByAccessibilityId("CalculatorResults").getAttribute("Name");
        System.out.println("Result is: " + result);
        Assert.assertEquals(result, "התצוגה היא 81");
        SECONDS.sleep(2);
    }

    @Test
    public void CalcDivide() throws InterruptedException {
        driverSession.findElementByAccessibilityId("num8Button").click();
        driverSession.findElementByAccessibilityId("divideButton").click();
        driverSession.findElementByAccessibilityId("num4Button").click();
        driverSession.findElementByAccessibilityId("equalButton").click();
        String result = driverSession.findElementByAccessibilityId("CalculatorResults").getAttribute("Name");
        System.out.println("Result is: " + result);
        Assert.assertEquals(result, "התצוגה היא 2");
        SECONDS.sleep(2);    }

    @Test
    public void CalcSubtraction() throws InterruptedException {
        driverSession.findElementByAccessibilityId("num9Button").click();
        driverSession.findElementByAccessibilityId("minusButton").click();
        driverSession.findElementByAccessibilityId("num2Button").click();
        driverSession.findElementByAccessibilityId("equalButton").click();
        String result = driverSession.findElementByAccessibilityId("CalculatorResults").getAttribute("Name");
        System.out.println("Result is: " + result);
        Assert.assertEquals(result, "התצוגה היא 7");
        SECONDS.sleep(2);
    }

    @AfterTest
    public static void tearDown() {
        if (driverSession != null) {
            driverSession.quit();
        }
    }
}