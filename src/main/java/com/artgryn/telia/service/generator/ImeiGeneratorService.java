package com.artgryn.telia.service.generator;

import com.artgryn.telia.utils.Imei;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
public class ImeiGeneratorService {

    final static double RATE_INCORRECT_VALUES = 20;

    @NonNull
    private Imei imei;

    public List<String> generateInputData(final Integer amount) {

        if (amount == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid input params");
        }

        val amountOfIncorrectOrInvalid = getNumberOfItemsToGenerate(amount);


        val listOfItemsToReturn = new ArrayList<String>();

        IntStream.range(0, amountOfIncorrectOrInvalid).forEach(i -> {

            // Incorrect imei can be any string or number
            listOfItemsToReturn.add(UUID.randomUUID().toString());
        });

        IntStream.range(0, amountOfIncorrectOrInvalid / 2 + 1).forEach(i -> {

            val imeiDuplicate = imei.getImei();

            // add imei 2 times
            listOfItemsToReturn.add(imeiDuplicate);
            listOfItemsToReturn.add(imeiDuplicate);
        });


        val amountOfCorrectItems = amount - listOfItemsToReturn.size();
        IntStream.range(0, amountOfCorrectItems).forEach(i -> listOfItemsToReturn.add(imei.getImei()));


        return listOfItemsToReturn;
    }

    private int getNumberOfItemsToGenerate(final int amount) {
        return (int) (amount * (RATE_INCORRECT_VALUES / 100.0f) );
    }
}
