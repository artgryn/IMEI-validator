package com.artgryn.telia.controller;

import com.artgryn.telia.data.presentation.ImeiInput;
import com.artgryn.telia.data.presentation.ImeiValidationResult;
import com.artgryn.telia.service.generator.ImeiGeneratorService;
import com.artgryn.telia.service.imei.ImeiService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.web.bind.annotation.*;

/**
 * Controller to process IMEI validation task.
 * POST - input is List of IMEI to validate
 * GET - Simulate random IMEI generation with 20% of valid duplicates and 20% of invalid
 */
@RestController
@RequestMapping("/imei")
@RequiredArgsConstructor
public class IndexController {

    @NonNull
    private ImeiService imeiService;

    @NonNull
    private ImeiGeneratorService imeiGeneratorService;

    @PostMapping
    public ImeiValidationResult validateImei(@RequestBody final ImeiInput data) {

        return imeiService.getImeiValidationResult(data);
    }

    @GetMapping
    public ImeiValidationResult generateAndValidateImei(@RequestParam final int amount) {

        val inputList = imeiGeneratorService.generateInputData(amount);

        return imeiService.getImeiValidationResult(ImeiInput.builder().input(inputList).build());
    }
}
