package guru.qa.tests;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import guru.qa.helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;;import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static java.lang.String.format;
import static org.asynchttpclient.util.HttpConstants.Methods.OPTIONS;


public class TestBase {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://www.wildberries.ru/";
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";

        String webDriver = System.getProperty("webDriver","https://user1:1234@selenoid.autotests.cloud/");
        Configuration.remote = format("%swd/hub",webDriver);

        DesiredCapabilities capabilities = new DesiredCapabilities();
        ChromeOptions options = new ChromeOptions();
        options.addArguments(OPTIONS);
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        Map<String, Object> selenoidOptions = new HashMap<>();
        selenoidOptions.put("enableVNC", true);
        selenoidOptions.put("enableVideo", true);
        capabilities.setCapability("selenoid:options", selenoidOptions);
        Configuration.browserCapabilities = capabilities;}

        @BeforeEach
        void addListener() {
            SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
            open(baseUrl);
        }

        @AfterEach
        void addVideo() {
            Attach.screenshotAs("Last screenshot");
            Attach.pageSource();
            Attach.browserConsoleLogs();
            Attach.addVideo();
            closeWebDriver();
        }
    }
