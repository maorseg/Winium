package WiniumExamples;

/**
 * Created by Maor on 19/03/2018.
 * Refer to https://github.com/2gis/Winium.Desktop
 */

import java.io.IOException;
import java.net.URL;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static java.util.concurrent.TimeUnit.SECONDS;

public class Explorer {
    public DesktopOptions options = new DesktopOptions();

    @BeforeTest
     public void SetUp() throws InterruptedException, IOException {
        options.setApplicationPath("C:\\Windows\\explorer.exe");
    }

    @Test
    public void CalcAddExample() throws InterruptedException, IOException {
        WiniumDriver driver = new WiniumDriver(new URL("http://localhost:9999"), options);
        SECONDS.sleep(5);
        driver.findElementById("SearchEditBox").sendKeys("Winium");
        SECONDS.sleep(5);
        driver.findElementByName("Close search").click();
        driver.findElementByName("Close").click();
        }
    }

