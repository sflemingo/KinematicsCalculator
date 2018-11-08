package model;

import java.util.Map;

/*
 * VelocitySqEquation class
 * solves v^2 = (v0)^2 + 2(a)(x - x0)
 *
 * @author Spencer Fleming
 * */
public class VelocitySqEquation implements Equation {

    private Double x0, x, v0, v, a, t;

    /*
     * constructor for VelocitySqEquation class
     * @param variables the known/unknown variables
     * */
    public VelocitySqEquation(Map<String, Double> variables){
        this.x0 = variables.get("x0");
        this.x = variables.get("x");
        this.v0 = variables.get("v0");
        this.v = variables.get("v");
        this.a = variables.get("a");
        this.t = variables.get("t");
    }

    @Override
    public Double getVariable(String variable){
        if (variable.equals("x0")) return x0;
        if (variable.equals("x")) return x;
        if (variable.equals("v0")) return v0;
        if (variable.equals("v")) return v;
        if (variable.equals("a")) return a;
        if (variable.equals("t")) return t;
        return null;
    }

    @Override
    public int solve() {
        if (this.v == null && this.v0 != null && this.a != null && this.x != null && this.x0 != null)
            solveForV();
        else if (this.v != null && this.v0 == null && this.a != null && this.x != null && this.x0 != null)
            solveForV0();
        else if (this.v != null && this.v0 != null && this.a == null && this.x != null && this.x0 != null)
            solveForA();
        else if (this.v != null && this.v0 != null && this.a != null && this.x == null && this.x0 != null)
            solveForX();
        else if (this.v != null && this.v0 != null && this.a != null && this.x != null && this.x0 == null)
            solveForX0();
        else return -1;
        return 0;
    }

    /*
     * solves equation to find the velocity
     * */
    private void solveForV(){
        this.v = Math.sqrt((this.v0 * this.v0) + (2.0 * this.a * (this.x - this.x0)));
    }

    /*
     * solves equation to find the initial velocity
     * */
    private void solveForV0(){
        this.v0 = Math.sqrt((this.v * this.v) - (2.0 * this.a * (this.x - this.x0)));
    }

    /*
     * solves equation to find the acceleration
     * */
    private void solveForA(){
        this.a = (((this.v * this.v) - (this.v0 * this.v0))/ (this.x - this.x0)) / 2.0;
    }

    /*
     * solves equation to find the distance
     * */
    private void solveForX(){
        this.x = ((((this.v * this.v) - (this.v0 * this.v0))/2.0)/this.a) + this.x0;
    }

    /*
     * solves equation to find the initial distance
     * */
    private void solveForX0(){
        this.x0 = this.x - ((((this.v * this.v) - (this.v0 * this.v0))/2.0)/this.a);
    }
}