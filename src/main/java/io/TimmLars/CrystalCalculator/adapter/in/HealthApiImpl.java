package io.TimmLars.CrystalCalculator.adapter.in;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import io.TimmLars.CrystalCalculator.adapter.in.rest.api.HealthApi;

@RestController
public class HealthApiImpl implements HealthApi{

    @Override
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("Server ist erreichbar");
    }

}