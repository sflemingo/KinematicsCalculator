/*
 * kinematicsController class
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
        variables.replace("a", a);
    }

    public void setInitialDisplacement(Double x0){
        variables.replace("x0", x0);
    }

    public void setDisplacement(Double x){
        variables.replace("x", x);
    }

    public void setInitialVelocity(Double v0){
        variables.replace("v0", v0);
    }

    public void setVelocity(Double v){
        variables.replace("v", v);
    }

    public void setTime(Double t){
        variables.replace("t", t);
    }

    /*
     * Utilizes model and solves for unknowns
     * */
    public void solve(){
        Equation eq = new velocityEquation(variables);
        int i = eq.solve();
        if (i == 0){
            setVelocity(eq.getVariable("v"));
            setInitialVelocity(eq.getVariable("v0"));
            setAcceleration(eq.getVariable("a"));
            setTime(eq.getVariable("t"));
        }

        eq = new velocitySqEquation(variables);
        i = eq.solve();
        if (i == 0){
            setVelocity(eq.getVariable("v"));
            setInitialVelocity(eq.getVariable("v0"));
            setAcceleration(eq.getVariable("a"));
            setDisplacement(eq.getVariable("x"));
            setInitialDisplacement(eq.getVariable("x0"));
        }

        eq = new displacementEquation(variables);
        i = eq.solve();
        if (i == 0){
            setVelocity(eq.getVariable("v"));
            setInitialVelocity(eq.getVariable("v0"));
            setTime(eq.getVariable("t"));
            setDisplacement(eq.getVariable("x"));
            setInitialDisplacement(eq.getVariable("x0"));
        }

        eq = new displacementAccelerationEquation(variables);
        i = eq.solve();
        if (i == 0){
            setTime(eq.getVariable("t"));
            setInitialVelocity(eq.getVariable("v0"));
            setAcceleration(eq.getVariable("a"));
            setDisplacement(eq.getVariable("x"));
            setInitialDisplacement(eq.getVariable("x0"));
        }
    }

}
