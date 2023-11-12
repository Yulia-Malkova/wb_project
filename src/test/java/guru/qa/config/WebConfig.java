package guru.qa.config;

import org.aeonbits.owner.Config;

    @Config.Sources({
            "classpath:${env}.properties",
    })

    public interface WebConfig extends Config {

        @Key("browser")
        @DefaultValue("CHROME")
        Browser getBrowser();

        @Key("browserVersion")
        @DefaultValue("116.0")
        String getBrowserVersion();

        @Config.Key("browserSize")
        @DefaultValue("1920x1080")
        String getBrowserSize();

        @Key("baseUrl")
        @DefaultValue("https://www.wildberries.ru/")
        String getBaseUrl();

        @Key("isRemote")
        @DefaultValue("true")
        Boolean isRemote();

        @Key("remoteUrl")
        String getRemoteUrl();
}
