package model;

import java.util.Map;

/*
 * velocityEquation class
 * solves v = v0 + a(t)
 *
 * @author Spencer Fleming
 * */
public class velocityEquation implements Equation {

    private Double x0, x, v0, v, a, t;

    /*
     * constructor for velocityEquation class
     * @param variables the known/unknown variables
     * */
    public velocityEquation(Map<String, Double> variables){
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
        if (this.v == null && this.v0 != null && this.a != null && this.t != null)
            solveForV();
        else if (this.v != null && this.v0 == null && this.a != null && this.t != null)
            solveForV0();
        else if (this.v != null && this.v0 != null && this.a == null && this.t != null)
            solveForA();
        else if (this.v != null && this.v0 != null && this.a != null && this.t == null)
            solveForT();
        else return -1;
        return 0;
    }

    /*
    * solves equation to find the velocity
    * */
    private void solveForV(){
        this.v = this.v0 + (this.a * this.t);
    }

    /*
     * solves equation to find the initial velocity
     * */
    private void solveForV0(){
        this.v0 = this.v - (this.a * this.t);
    }

    /*
     * solves equation to find the acceleration
     * */
    private void solveForA(){
        this.a = (this.v - this.v0) / this.t;
    }

    /*
     * solves equation to find the time
     * */
    private void solveForT(){
        this.t = (this.v - this.v0) / this.a;
    }
}
