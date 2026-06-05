package io.TimmLars.CrystalCalculator.domain;

import org.apache.commons.math3.ode.FirstOrderDifferentialEquations;

import lombok.Setter;

@Setter
public class DGL implements FirstOrderDifferentialEquations{

    private final int numberIons;
    private final double[] omega;
    private final double[] mass;
    private final double[] charge;
    private double damping = 0.0;


    //Constructor
    public DGL(int numberIons, double omega[], double[] mass, double[] charge) {
        this.numberIons = numberIons;
        this.omega = omega;
        this.mass = mass;
        this.charge = charge;
    }

    @Override
    public int getDimension() {
        return 6*numberIons;
    }

    private double[] calculateForce(double[] y, int i) {
        double[] f = new double[3]; 
        for(int j = 0; j<numberIons; j++) {
            if(j != i) {
                double dx = y[j] - y[i];
                double dy = y[j+numberIons] - y[i+numberIons];
                double dz = y[j+2*numberIons] - y[i+2*numberIons];
                double r3 = Math.pow(dx*dx + dy*dy + dz*dz, 1.5);
                f[0] += charge[j] * charge[i] * dx / r3;
                f[1] += charge[j] * charge[i] * dy / r3;
                f[2] += charge[j] * charge[i] * dz / r3;
            }
        }
        return f;

    }

    @Override
    public void computeDerivatives(double t, double[] y, double[] yDot) {
        double[] f = new double[3];
        for (int i = 0; i < numberIons; i++) {
            yDot[i] = y[i+3*numberIons];
            yDot[i+numberIons] = y[i+4*numberIons];
            yDot[i+2*numberIons] = y[i+5*numberIons];
            f = calculateForce(y, i);
            yDot[i+3*numberIons] = -omega[0]*omega[0]*y[i] + f[0]/mass[i] - damping*y[i+3*numberIons];
            yDot[i+4*numberIons] = -omega[1]*omega[1]*y[i+numberIons] + f[1]/mass[i] - damping*y[i+4*numberIons];
            yDot[i+5*numberIons] = -omega[2]*omega[2]*y[i+2*numberIons] + f[2]/mass[i] - damping*y[i+5*numberIons];
        }
    }

}
