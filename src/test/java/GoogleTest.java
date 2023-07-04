import conf.BaseClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import util.ScreenShoT;
import util.WorkWithFile;

import java.security.Key;
import java.util.ArrayList;
import java.util.List;

public class GoogleTest extends BaseClass {
  static final String url="https://www.youtube.com/";
    @BeforeClass
    public static void st(){
        driver.get(url);
    }
    @Test
    public void test1(){
//        driver.findElement(By.name("q")).sendKeys("Ukraine");
//        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        List<String> list=new ArrayList<>();
        list.add("Vasiliy");
        list.add("Nikolay");
        WorkWithFile.writeStrings(list,"list");
        for (String s : WorkWithFile.readFile("06_30_19-59-54_logs.txt")) {
            System.out.println(s);
        }
        ScreenShoT.getScreenShot(driver,"test1");
    }
}
