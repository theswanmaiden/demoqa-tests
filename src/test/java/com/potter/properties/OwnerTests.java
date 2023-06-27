package com.potter.properties;

import com.potter.config.CredentialsConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;

public class OwnerTests {
    public CredentialsConfig credentials =
            ConfigFactory.create(CredentialsConfig.class);

    @Test
    void readCredentialsTest(){
        String login = credentials.login();
        String password = credentials.password();

        System.out.println(login + " - это логин, а это" + " " + password + " - пароль");
    }
}
