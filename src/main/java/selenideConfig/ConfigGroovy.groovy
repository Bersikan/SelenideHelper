package selenideConfig

import com.codeborne.selenide.Configuration
import com.codeborne.selenide.logevents.SelenideLogger
import io.qameta.allure.selenide.AllureSelenide
import org.testng.annotations.BeforeSuite

class ConfigGroovy {
    private static final String browser = System.getenv("browser");

    @BeforeSuite
    static void init() {
        SelenideLogger.addListener("allure", new AllureSelenide()
                .screenshots(true)
                .savePageSource(false)
                .includeSelenideSteps(true))
        print(browser)
        Configuration.browser = "firefox" ?: browser
        print(Configuration.browser)
        Configuration.baseUrl = ""
        Configuration.browserSize = "1280x1024";
    }
}