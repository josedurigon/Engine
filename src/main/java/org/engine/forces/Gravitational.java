package org.engine.forces;

import org.engine.vector.Vector;

/**
 * Gravity force class
 */
public class Gravitational {
    private static final double GRAVITATIONAL_CONSTANT = 6.674E-11;
    private Vector gravitationalForce;
    private double massObjectOne;
    private double massObjectTwo;

    public Gravitational(double massObjectOne, double massObjectTwo) {
        this.massObjectOne = massObjectOne;
        this.massObjectTwo = massObjectTwo;
    }

    public double gravityForce(double mass1, double mass2, double distanceBetweenCenter){
        //F=G x ((m1*m2)/r²)

        double masses = mass1 * mass2;
        double division = masses/ distanceBetweenCenter;
        double force = this.GRAVITATIONAL_CONSTANT * division;
        return  force;
    }

}
