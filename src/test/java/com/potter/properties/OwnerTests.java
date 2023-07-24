package com.potter.properties;

import com.potter.config.CredentialsConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static java.lang.String.format;

@Tag("owner")
@Tag("simple_tests")
public class OwnerTests {
    public CredentialsConfig credentials =
            ConfigFactory.create(CredentialsConfig.class);

    @Test
    void readCredentialsTest(){
        String login = credentials.login();
        String password = credentials.password();

        String message = format("Это логин %s , а это пароль %s", login, password);
        System.out.println(message);
    }
}
