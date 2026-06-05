package io.TimmLars.CrystalCalculator.domain;

import org.apache.commons.math3.ode.nonstiff.ClassicalRungeKuttaIntegrator;

public class CrystalCalculator {


    public double[] calculateCrystal(int numberIons, double[] omega, double[] mass, double[] charge){
        DGL dgl = new DGL(numberIons, omega, mass, charge);
        double[] y0 = CrystalInitializer.initializeCrystal(numberIons, omega);

        ClassicalRungeKuttaIntegrator integrator = new ClassicalRungeKuttaIntegrator(0.05*2*Math.PI);
        dgl.setDamping(0.05); // set damping factor
        return DynamicsDamper.dampDynamics(y0, integrator, dgl, numberIons);
    }

}
