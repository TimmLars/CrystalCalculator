package io.TimmLars.CrystalCalculator.application;

public class UnitsHandler {

    private static final double elementaryCharge = 1.60217662e-19; // Coulomb
    private static final double amu = 1.66053906660e-27; // kg
    private static final double epsilon0 = 8.8541878128e-12; // As/(Vm)
    private static final double lengthUnit = Math.pow(elementaryCharge*elementaryCharge/(4*Math.PI*epsilon0*amu),1.0/3.0);
    
    public static double convertChargeToSI(double charge){
        return charge * elementaryCharge;
    }
    public static double convertMassToSI(double mass){
        return mass * amu;
    }

    public static double convertLengthToSI(double length, double omegaZ){
        return length * lengthUnit * Math.pow(omegaZ*omegaZ,-1.0/3.0) ;
    }

}
