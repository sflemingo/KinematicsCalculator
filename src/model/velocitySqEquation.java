/*
 * velocitySqEquation class
 * solves v^2 = (v0)^2 + 2(a)(x - x0)
 * */

package model;

import java.util.HashMap;

public class velocitySqEquation extends Equation {

    /*
     * constructor for velocitySqEquation class
     * @param variables the known/unknown variables
     * */
    public velocitySqEquation(HashMap<String, Double> variables){
        super(variables);
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

    }

    /*
     * solves equation to find the initial velocity
     * */
    private void solveForV0(){

    }

    /*
     * solves equation to find the acceleration
     * */
    private void solveForA(){

    }

    /*
     * solves equation to find the distance
     * */
    private void solveForX(){

    }

    /*
     * solves equation to find the initial distance
     * */
    private void solveForX0(){

    }
}