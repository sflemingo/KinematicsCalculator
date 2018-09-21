/*
 * kinematicsController class
 * connects the model package to the view package
 * */
package controller;

import model.*;

import java.util.HashMap;
import java.util.Map;

public class kinematicsController {

    //map of known variables
    private Map<String, Double> variables;

    /*
     * constructor for kinematicsController class
     * */
    public kinematicsController(){
        variables = new HashMap<>();
    }

    /*
     * getVariable method
     * @param variable the type of variable ex: "a" for acceleration
     * @return the value of the variable
     * */
    public Double getVariable(String variable){
        return variables.get(variable);
    }

    public void setAcceleration(Double a){
        variables.put("a", a);
    }

    public void setInitialDisplacement(Double x0){
        variables.put("x0", x0);
    }

    public void setDisplacement(Double x){
        variables.put("x", x);
    }

    public void setInitialVelocity(Double v0){
        variables.put("v0", v0);
    }

    public void setVelocity(Double v){
        variables.put("v", v);
    }

    public void setTime(Double t){
        variables.put("t", t);
    }

    /*
     * Utilizes model and solves for unknowns
     *
     * recursive function that stops when no other variables were set
     * */
    public void solve(){
        boolean equSolved = true;
        Equation eq = new velocityEquation(variables);

        if (eq.solve() == 0){
            setVelocity(eq.getVariable("v"));
            setInitialVelocity(eq.getVariable("v0"));
            setAcceleration(eq.getVariable("a"));
            setTime(eq.getVariable("t"));
            equSolved = false;
        }

        eq = new velocitySqEquation(variables);
        if (eq.solve() == 0){
            setVelocity(eq.getVariable("v"));
            setInitialVelocity(eq.getVariable("v0"));
            setAcceleration(eq.getVariable("a"));
            setDisplacement(eq.getVariable("x"));
            setInitialDisplacement(eq.getVariable("x0"));
            equSolved = false;
        }

        eq = new displacementEquation(variables);
        if (eq.solve() == 0){
            setVelocity(eq.getVariable("v"));
            setInitialVelocity(eq.getVariable("v0"));
            setTime(eq.getVariable("t"));
            setDisplacement(eq.getVariable("x"));
            setInitialDisplacement(eq.getVariable("x0"));
            equSolved = false;
        }

        eq = new displacementAccelerationEquation(variables);
        if (eq.solve() == 0){
            setTime(eq.getVariable("t"));
            setInitialVelocity(eq.getVariable("v0"));
            setAcceleration(eq.getVariable("a"));
            setDisplacement(eq.getVariable("x"));
            setInitialDisplacement(eq.getVariable("x0"));
            equSolved = false;
        }

        if (!equSolved)
            solve();
    }

}
