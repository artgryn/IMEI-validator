package com.artgryn.telia.utils;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ImeiTest {

    @Autowired
    private Imei imei;

    @Autowired
    private Validator validator;

    @Test
    void getImei() {

        String newImei = imei.getImei();
        assertTrue(validator.isValid(newImei));
    }
}