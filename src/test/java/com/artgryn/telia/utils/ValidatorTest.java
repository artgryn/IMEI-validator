package com.artgryn.telia.utils;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class ValidatorTest {

    @Autowired
    private Validator validator;

    @Test
    void testImeiValidation() {

        // valid
        assertTrue(validator.isValid("490726530251468"));

        // valid
        assertTrue(validator.isValid("508779747405898"));

        // invalid - base valid but check digit wrong -> should be 8 but now 7
        assertFalse(validator.isValid("490726530251467"));

        // full invalid input
        assertFalse(validator.isValid("banana"));

        // empty string
        assertFalse(validator.isValid(""));

        // null input
        assertFalse(validator.isValid(null));
    }
}
