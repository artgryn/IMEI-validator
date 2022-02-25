package com.artgryn.telia.service.imei;

import com.artgryn.telia.data.entity.DuplicateImei;
import com.artgryn.telia.data.presentation.ImeiInput;
import com.artgryn.telia.data.presentation.ImeiValidationResult;
import com.artgryn.telia.repository.DuplicateImeiRepository;
import com.artgryn.telia.utils.Validator;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
@RequiredArgsConstructor
public class ImeiService {

    @NonNull
    private Validator validator;

    @NonNull
    private DuplicateImeiRepository duplicateImeiRepository;

    public ImeiValidationResult getImeiValidationResult(final ImeiInput data) {

        val invalid = new HashSet<String>();
        val duplicates = new HashSet<String>();
        val valid = new HashSet<String>();

        data.getInput().stream()
                .forEach(item -> {

                    final boolean isValid = validator.isValid(item);

                    // unique and valid
                    if (isValid && !valid.contains(item) && !duplicates.contains(item)) {
                        valid.add(item);
                    } else if (isValid)  {

                        // if valid but already not unique
                        duplicates.add(item);
                        valid.remove(item);
                        invalid.add(item);
                    } else {

                        // just invalid
                        invalid.add(item);
                    }
                });

        if (!duplicates.isEmpty()) {
            duplicateImeiRepository.save(DuplicateImei.builder()
                                                      .duplicatedImei(duplicates)
                                                      .build());
        }

        return ImeiValidationResult.builder()
                .valid(valid)
                .duplicates(duplicates)
                .invalid(invalid)
                .build();
    }
}
