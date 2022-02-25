package com.artgryn.telia.utils;

import lombok.val;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Component;

@Component
public class Validator {

    private static final int IMEI_LENGTH = 15;

    //Luhn algorithm
    public boolean isValid(final String imei) {

        // Check that basics length/number
        if (imei == null || imei.length() != IMEI_LENGTH || !NumberUtils.isCreatable(imei)) {
            return false;
        }

        val sb = new StringBuilder(imei);
        sb.reverse();

        final String stringToProcess = sb.toString();

        int checkSum = 0;

        // used FOR loop instead of streams because of in the stream we can not use non-final value
        for (int i = 0; i < stringToProcess.length(); i++) {
            final int value = Character.getNumericValue(stringToProcess.charAt(i));

            if ((i+1) % 2 == 0) {
                int multipliedValue = value * 2;

                if (multipliedValue > 9) {
                    final String numberStr = String.valueOf(multipliedValue);
                    checkSum = checkSum + (Character.getNumericValue(numberStr.charAt(0)) + Character.getNumericValue(numberStr.charAt(1)));

                } else {
                    checkSum = checkSum + multipliedValue;
                }

            } else {
                checkSum = checkSum + value;
            }

        }

        return checkSum % 10 == 0;
    }
}
