package guru.qa.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import guru.qa.config.ConfigReader;
import guru.qa.config.WebConfig;
import guru.qa.config.WebConfigProject;
import guru.qa.helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class TestBase {

    private static final WebConfig config = ConfigReader.Instance.read();

    @BeforeAll
    public static void beforeAll(){
    WebConfigProject webConfigProject = new WebConfigProject(config);
        webConfigProject.webConfig();}

        @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open(baseUrl);
    }

    @AfterEach
    void addAttachments() {

        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        closeWebDriver();
    }
    }
