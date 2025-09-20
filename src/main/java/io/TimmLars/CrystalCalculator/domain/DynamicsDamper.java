package io.TimmLars.CrystalCalculator.domain;

import org.apache.commons.math3.ode.nonstiff.ClassicalRungeKuttaIntegrator;

public class DynamicsDamper {

    public static double[] dampDynamics(double[] y0, ClassicalRungeKuttaIntegrator integrator, DGL dgl, int numberIons){
        double[] y = new double[6*numberIons];
        integrator.integrate(dgl, 0.0, y0, 0.1*2*Math.PI, y);
        return y;
    }

    
}
