package WiniumExamples;

/**
 * Created by Maor on 24/03/2018.
 * Refer to https://github.com/2gis/Winium.Desktop
 */

import java.io.IOException;
import java.net.URL;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.testng.annotations.*;
import static java.util.concurrent.TimeUnit.SECONDS;

// Automate example on Notepad++
public class NotepadPlus {

    public DesktopOptions options = new DesktopOptions();

    @BeforeTest
     public void SetUp() throws InterruptedException, IOException {
         options.setApplicationPath("C:\\Program Files\\Notepad++\\notepad++.exe");
     }

    @Test
    public void WriteToFile() throws InterruptedException, IOException {
        WiniumDriver driver = new WiniumDriver(new URL("http://localhost:9999"), options);
        SECONDS.sleep(2);
        driver.findElementByName("File").click();
        driver.findElementByName("New").sendKeys("Winium is fun");
        driver.findElementByName("File").click();
        driver.findElementByName("Save As...").click();
        driver.findElementByName("File name:").sendKeys("Winium is fun.txt");
        driver.findElementByName("Save").click();
        driver.quit();
    }
}
