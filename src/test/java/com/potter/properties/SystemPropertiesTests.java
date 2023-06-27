package com.potter.properties;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class SystemPropertiesTests {

    @Test
    @Tag("properties")
    void tryOnSomeProperties() {
        String browser = System.getProperty("browser", "chrome");
        String version = System.getProperty("version", "92");
        String browserSize = System.getProperty("browserSize", "1920x1080");

        System.out.println(browser);
        System.out.println(version);
        System.out.println(browserSize);

    }

}

