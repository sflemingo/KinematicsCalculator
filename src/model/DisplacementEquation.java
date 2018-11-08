package model;

import java.util.Map;

/*
 * DisplacementEquation class
 * solves x = x0 + (1/2)(v0 + v)t
 *
 * @author Spencer Fleming
 * */
public class DisplacementEquation implements Equation {

    private Double x0, x, v0, v, a, t;

    /*
     * constructor for DisplacementEquation class
     * @param variables the known/unknown variables
     * */
    public DisplacementEquation(Map<String, Double> variables){
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
        if (this.x == null && this.x0 != null && this.v0 != null && this.v != null && this.t != null)
            solveForX();
        else if (this.x != null && this.x0 == null && this.v0 != null && this.v != null && this.t != null)
            solveForX0();
        else if (this.x != null && this.x0 != null && this.v0 == null && this.v != null && this.t != null)
            solveForV0();
        else if (this.x != null && this.x0 != null && this.v0 != null && this.v == null && this.t != null)
            solveForV();
        else if (this.x != null && this.x0 != null && this.v0 != null && this.v != null && this.t == null)
            solveForT();
        else return -1;
        return 0;
    }

    /*
     * solves equation to find the distance
     * */
    private void solveForX(){
        this.x = this.x0 + (0.5 * this.t * (this.v0 + this.v));
    }

    /*
     * solves equation to find the initial distance
     * */
    private void solveForX0(){
        this.x0 = this.x - (0.5 * this.t * (this.v0 + this.v));
    }

    /*
     * solves equation to find the initial velocity
     * */
    private void solveForV0() {
        this.v0 = (((this.x - this.x0) / this.t) * 2.0) - this.v;
    }
    /*
     * solves equation to find the velocity
     * */
    private void solveForV(){
        this.v = (((this.x - this.x0) / this.t ) * 2.0) - this.v0;
    }

    /*
     * solves equation to find the time
     * */
    private void solveForT(){
        this.t = ((this.x - this.x0) * 2.0) / (this.v0 + this.v);
    }
}