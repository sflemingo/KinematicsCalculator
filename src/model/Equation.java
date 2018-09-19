/*
* abstract Equation class
* */

package model;

import java.util.Map;

public abstract class Equation {

    public Double x0, x, v0, v, a, t;

    /*
    * constructor for Equation class
    * @param variables the known/unknown variables
    * */
    public Equation(Map<String, Double> variables){
        this.x0 = variables.get("x0");
        this.x = variables.get("x");
        this.v0 = variables.get("v0");
        this.v = variables.get("v");
        this.a = variables.get("a");
        this.t = variables.get("t");
    }

    /*
     * abstract method to solve the equation
     * finds unknown variable and solves for it
     * */
    public abstract int solve();

}
