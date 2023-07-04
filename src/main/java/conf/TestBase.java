package conf;

import org.junit.AfterClass;
import org.junit.BeforeClass;

public class TestBase {
    @BeforeClass
    public static void bb(){
        System.out.println("Before class from parent class");
    }
    @AfterClass
    public static void aa(){
        System.out.println("After class from parent class");
    }
}
