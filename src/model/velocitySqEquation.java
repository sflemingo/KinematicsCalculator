/*
 * velocitySqEquation class
 * solves v^2 = (v0)^2 + 2(a)(x - x0)
 * */

package model;

import java.util.Map;

public class velocitySqEquation extends Equation {

    /*
     * constructor for velocitySqEquation class
     * @param variables the known/unknown variables
     * */
    public velocitySqEquation(Map<String, Double> variables){
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