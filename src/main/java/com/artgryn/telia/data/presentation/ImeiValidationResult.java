package com.artgryn.telia.data.presentation;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
public class ImeiValidationResult {

    private Set<String> valid;
    private Set<String> invalid;
    private Set<String> duplicates;
}
