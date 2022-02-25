package com.artgryn.telia.data.presentation;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
public class ImeiInput {

    private List<String> input;
}
