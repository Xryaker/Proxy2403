package conf;

import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.core.har.HarEntry;
import net.lightbody.bmp.proxy.CaptureType;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import util.WorkWithLogs;

import java.io.File;
import java.io.IOException;

public class BaseClass {

    public static WebDriver driver;

    @BeforeClass
    public static void BeforParent() {
        driver = ConfiguretionWebDriver.createDriver(WebDrivers.PROXYCHROME);
        ConfiguretionWebDriver.server.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT,CaptureType.RESPONSE_CONTENT);
        ConfiguretionWebDriver.server.newHar("hh");
        AgentFActory.create(Agents.UkraineLang);
    }

    @AfterClass
    public static void afterParent() throws InterruptedException, IOException {
        WorkWithLogs.writeLogs(driver,"logs");
        Har har=ConfiguretionWebDriver.server.getHar();
        for(HarEntry l:har.getLog().getEntries()){
            System.out.println(l.getRequest().getUrl());
        }
        har.writeTo(new File("Google.har"));
        Thread.sleep(3000);
        driver.quit();
    }

}
