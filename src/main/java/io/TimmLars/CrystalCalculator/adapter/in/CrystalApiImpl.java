package io.TimmLars.CrystalCalculator.adapter.in;

import org.springframework.web.bind.annotation.RestController;
import io.TimmLars.CrystalCalculator.adapter.in.rest.api.CrystalApi;
import io.TimmLars.CrystalCalculator.adapter.in.rest.api.model.TrapConfigDTO;
import io.swagger.v3.oas.annotations.Parameter;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import org.springframework.web.context.request.NativeWebRequest;

@RestController
public class CrystalApiImpl implements CrystalApi {

    @Override
    public ResponseEntity<List<List<Double>>> calculateCrystal(
         @Valid TrapConfigDTO trapConfigDTO
    ) {
        // Implement the logic to calculate crystal properties based on the provided configuration
        // For now, returning an empty list as a placeholder
        return new ResponseEntity<>(List.of(List.of(1.0,2.0,3.0),List.of(4.0,5.0,6.0)), HttpStatus.OK);
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

}
