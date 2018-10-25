package model;

/*
 * Equation interface
 *
 * @author Spencer Fleming
 * */
public interface Equation {



    /*
     * getVariable method
     * @param variable the type of variable ex: "a" for acceleration
     * @return the value of the variable
     * */
    public abstract Double getVariable(String variable);

    /*
     * abstract method to solve the equation
     * finds unknown variable and solves for it
     * */
    public abstract int solve();

}
