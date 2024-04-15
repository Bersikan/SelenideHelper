package selenideConfig;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.BeforeSuite;

public class BaseConfig {
    private static final String browser = System.getenv("browser");

    @BeforeSuite
    public static void init() {
        SelenideLogger.addListener("allure", new AllureSelenide()
                .screenshots(true)
                .savePageSource(false)
                .includeSelenideSteps(true));
        Configuration.browser = (browser == null) ? "asdasdasd" : browser;
        assert Configuration.browser.equals("firefox");
        Configuration.baseUrl = "";
        Configuration.browserSize = "1280x1024";
    }
}