package selenideConfig;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.BeforeSuite;

import static com.codeborne.selenide.Selenide.open;

public class BaseConfig {

    @BeforeSuite
    public static void init() {
        SelenideLogger.addListener("allure", new AllureSelenide()
                .screenshots(true)
                .savePageSource(false)
                .includeSelenideSteps(true));
        Configuration.browser = "chrome";
        Configuration.baseUrl = "";
        Configuration.browserSize = "1280x1024";
    }
}