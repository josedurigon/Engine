package org.engine;
import org.engine.vector.Vector;

import java.util.Objects;

/**
 * Particle class
 */
public class Particle {


    private double mass;
    private Vector position;
    private Vector velocity;
    private Vector force;

    public Particle(double mass, Vector position, Vector velocity, Vector force) {
        this.mass = mass;
        this.position = position;
        this.velocity = velocity;
        this.force = force;
    }

    public void applyForce(Vector externalForce){
        //R = m x a
        force = force.add(externalForce);
    }

    public void update(double deltaTime){
        //R = m x a => A = F/M
        Vector acceleration = force.scale(1/mass);
        velocity = velocity.add(acceleration.scale(deltaTime));
        position = position.add(velocity.scale(deltaTime));

        force = new Vector(0.0, 0.0);
    }


    public double getMass() {
        return mass;
    }

    public Vector getPosition() {
        return position;
    }

    public Vector getVelocity() {
        return velocity;
    }

    public Vector getForce() {
        return force;
    }

    public void setPosition(Vector position) {
        this.position = position;
    }

    public void setVelocity(Vector velocity) {
        this.velocity = velocity;
    }

    public void setForce(Vector force) {
        this.force = force;
    }

    public void setMass(Double mass){
        if(!mass.isNaN() && mass>0){
            this.mass= mass;
        }
        else{
            throw new IllegalArgumentException("Invalid mass");
        }
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Particle particle = (Particle) object;
        return Double.compare(mass, particle.mass) == 0 && Objects.equals(position, particle.position) && Objects.equals(velocity, particle.velocity) && Objects.equals(force, particle.force);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mass, position, velocity, force);
    }
}
