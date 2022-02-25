package com.artgryn.telia.controller;

import com.artgryn.telia.service.generator.ImeiGeneratorService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *  GET - Generate defined amount of random IMEIs with 20% of valid duplicates and 20% of invalid
 */
@RestController
@RequestMapping("/generate")
@RequiredArgsConstructor
public class GeneratorController {

    @NonNull
    private ImeiGeneratorService imeiGeneratorService;

    @GetMapping
    public List<String> generateInputData(@RequestParam final Integer amount) {

        return imeiGeneratorService.generateInputData(amount);
    }
}
