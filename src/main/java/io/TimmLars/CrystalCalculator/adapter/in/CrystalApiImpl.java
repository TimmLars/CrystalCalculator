package io.TimmLars.CrystalCalculator.adapter.in;

import org.springframework.web.bind.annotation.RestController;
import io.TimmLars.CrystalCalculator.adapter.in.rest.api.CrystalApi;
import io.TimmLars.CrystalCalculator.adapter.in.rest.api.model.TrapConfigDTO;
import io.TimmLars.CrystalCalculator.port.in.CalculateCrystalPort;
import java.util.ArrayList;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import org.springframework.web.context.request.NativeWebRequest;

@RestController
public class CrystalApiImpl implements CrystalApi {

    @Autowired
    private CalculateCrystalPort calculateCrystalPort;

    @Override
    public ResponseEntity<List<List<Double>>> calculateCrystal(
         @Valid TrapConfigDTO trapConfigDTO
    ) {
        // Implement the logic to calculate crystal properties based on the provided configuration
        // For now, returning an empty list as a placeholder
        //Here maybe work with a mapper?
        double[] y = 
        calculateCrystalPort.calculateCrystal(
            trapConfigDTO.getIonNumber(), 
            trapConfigDTO.getOmegaX(), 
            trapConfigDTO.getOmegaY(), 
            trapConfigDTO.getOmegaZ());
        List<List<Double>> response = new ArrayList<>();
        for(int i = 0; i<trapConfigDTO.getIonNumber(); i++){
            List<Double> ion = new ArrayList<>();
            ion.add(y[i]);
            ion.add(y[i+trapConfigDTO.getIonNumber()]);
            ion.add(y[i+2*trapConfigDTO.getIonNumber()]);
            response.add(ion);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

}
