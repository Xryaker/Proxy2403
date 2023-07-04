package util;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ScreenShoT {
    public static void getScreenShot(WebDriver driver,String fileName){
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dest=new File(new SimpleDateFormat("MM_dd_HH-mm-ss").format(Calendar.getInstance().getTime())+fileName+".png");
        try {
            FileUtils.copyFile(file,dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
