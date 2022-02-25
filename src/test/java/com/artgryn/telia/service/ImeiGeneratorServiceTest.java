package com.artgryn.telia.service;

import com.artgryn.telia.service.generator.ImeiGeneratorService;
import com.artgryn.telia.utils.Imei;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ImeiGeneratorServiceTest {

    @MockBean
    private Imei imei;

    @Autowired
    private ImeiGeneratorService imeiGeneratorService;

    @Test
    void testGenerateInputData_ok() {

        when(imei.getImei()).thenReturn("508779747405898");

        List<String> values = imeiGeneratorService.generateInputData(10);
        assertEquals(values.size(), 10);
    }

    @Test
    void testGenerateInputData_error() {

        assertThrows(ResponseStatusException.class, () -> {
            imeiGeneratorService.generateInputData(null);
        });
    }

}
