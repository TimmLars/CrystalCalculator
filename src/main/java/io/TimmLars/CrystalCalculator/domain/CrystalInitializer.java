package io.TimmLars.CrystalCalculator.domain;

import org.springframework.stereotype.Component;

@Component
public class CrystalInitializer {

    public static double[] initializeCrystal(int numberIons, double[] omega){
        double[] y0 = new double[6*numberIons];
        for(int i = 0; i<numberIons; i++){
            y0[i] = (i - (numberIons-1)/2.0) * 5.0; // x position
            y0[i+numberIons] = Math.pow(-1.0,i); // y position
            y0[i+2*numberIons] = 0.0; // z position
            y0[i+3*numberIons] = 0.0; // x velocity
            y0[i+4*numberIons] = 0.0; // y velocity
            y0[i+5*numberIons] = 0.0; // z velocity
        }
        return y0;
    }

}
