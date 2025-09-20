package io.TimmLars.CrystalCalculator.application;

import io.TimmLars.CrystalCalculator.domain.CrystalInitializer;
import io.TimmLars.CrystalCalculator.domain.DGL;
import io.TimmLars.CrystalCalculator.port.in.CalculateCrystalPort;
import lombok.NoArgsConstructor;

import org.apache.commons.math3.ode.nonstiff.ClassicalRungeKuttaIntegrator;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class CalculateCrystalService implements CalculateCrystalPort {

    @Override
    public double[] calculateCrystal(int numberIons, double omegaX, double omegaY, double omegaZ){
        double[] omega = new double[]{1.0, omegaX/omegaZ, omegaY/omegaZ};
        double[] mass = new double[numberIons];
        double[] charge = new double[numberIons];
        for(int i = 0; i<numberIons; i++){
            mass[i] = 172; // mass of Yb in amu
            charge[i] = 1.0; // singly charged
        }
        DGL dgl = new DGL(numberIons, omega, mass, charge);
        dgl.setDamping(0.05); // set damping factor
        double[] y0 = CrystalInitializer.initializeCrystal(numberIons, omega);

        ClassicalRungeKuttaIntegrator integrator = new ClassicalRungeKuttaIntegrator(1.0e-6);
        double[] y = new double[6*numberIons];
        integrator.integrate(dgl, 0.0, y0, 0.5, y);
        return y;
    }

}
