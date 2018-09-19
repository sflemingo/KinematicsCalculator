/*
 * kinematicsController class
 * */
package controller;

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
     * */
    public void solve(){
        ;
    }

}
