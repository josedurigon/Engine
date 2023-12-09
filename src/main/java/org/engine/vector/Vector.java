package org.engine.vector;

import java.util.Objects;

/**
 * Vector class
 * add, subtract, dot product, normalize and magnitude
 */
public class Vector {
    private  Double x;
    private  Double y;

    public Vector(Double x, Double y){
        this.x=x;;
        this.y=y;
    }

    public Vector add(Vector other){
        return new Vector(this.x+other.x, this.y+ other.y);
    }

    public Vector subtract(Vector other){
        return new Vector(this.x-other.x, this.y- other.y);
    }
    public Vector scale(double scalar){
        return new Vector(this.x* scalar, this.y*scalar);
    }

    public double dotProduct(Vector other){
        return this.x*other.x+this.y* other.y;
    }
    public double magnitude(){
        return Math.sqrt(x*x+y*y);
    }
    public Vector normalise(){
        double magnitude = magnitude();
        if(magnitude!= 0 ){
            return new Vector(x/magnitude, y/magnitude);
        }else{
            return new Vector(0D,0D);
        }
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        if(x instanceof Double)
            this.x = x;
        else
            throw new IllegalArgumentException("Invalid argument");
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        if(y instanceof Double)
            this.y = y;
        else
            throw  new IllegalArgumentException("Invalid argument");
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || this.getClass() != o.getClass()) return false;
        Vector vector = (Vector) o;
        return Objects.equals(x, vector.x) && Objects.equals(y, vector.y);
    }

    public int hashCode(){
        return Objects.hash(x,y);
    }
}
