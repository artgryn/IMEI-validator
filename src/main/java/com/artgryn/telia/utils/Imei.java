package com.artgryn.telia.utils;

import lombok.val;
import org.springframework.stereotype.Component;

import java.util.Random;
import static java.util.Locale.ENGLISH;

/**
 * Standard logic to create IMEI
 *
 */
@Component
public class Imei {
    private static final Random GENERATOR = new Random();

    private static final String[] REPORTING_BODY_IDS = {"01", "10", "30", "33", "35", "44", "45", "49", "50", "51", "52", "53", "54", "86", "91", "98", "99"};

    private static int sum(int number) {
        int a = 0;
        while (number > 0) {
            a = a + number % 10;
            number = number / 10;
        }
        return a;
    }

    public String getImei() {
        val mainDigitBlock = String.format("%s%.12s",
                REPORTING_BODY_IDS[GENERATOR.nextInt(REPORTING_BODY_IDS.length)],
                String.format(ENGLISH, "%012d", Math.abs(GENERATOR.nextLong())));

        int sum = 0;

        for (int i = 0; i < mainDigitBlock.length(); i++) {
            int c = Character.digit(mainDigitBlock.charAt(i), 10);
            sum += (i % 2 == 0 ? c : sum(c * 2));
        }

        int controlNumber = (10 - (sum % 10)) % 10;

        return mainDigitBlock + controlNumber;
    }
}
