package configurations;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeSuite;

import static com.codeborne.selenide.Selenide.open;

public class BaseConfig {
    @BeforeSuite
    public static void init() {
        Configuration.browser = "chrome";
        Configuration.baseUrl = "";
        Configuration.browserSize = "1280x1024";
        open("https://github.com/login");
    }
}