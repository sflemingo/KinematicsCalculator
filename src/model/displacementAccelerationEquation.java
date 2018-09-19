/*
 * displacementAccelerationEquation class
 * solves x = x0 + v0(t) + (1/2)(a)t^2
 * */

package model;

import java.util.Map;

public class displacementAccelerationEquation extends Equation {

    /*
     * constructor for displacementAccelerationEquation class
     * @param variables the known/unknown variables
     * */
    public displacementAccelerationEquation(Map<String, Double> variables){
        super(variables);
    }

    @Override
    public int solve() {
        if (this.x == null && this.x0 != null && this.v0 != null && this.t != null && this.a != null)
            solveForX();
        else if (this.x != null && this.x0 == null && this.v0 != null && this.t != null && this.a != null)
            solveForX0();
        else if (this.x != null && this.x0 != null && this.v0 == null && this.t != null && this.a != null)
            solveForV0();
        else if (this.x != null && this.x0 != null && this.v0 != null && this.t == null && this.a != null)
            solveForT();
        else if (this.x != null && this.x0 != null && this.v0 != null && this.t != null && this.a == null)
            solveForA();
        else return -1;
        return 0;
    }

    /*
     * solves equation to find the distance
     * */
    private void solveForX(){
        this.x = this.x0 + (this.v0 * this.t) + (.5 * (this.a * (this.t * this.t)));
    }

    /*
     * solves equation to find the initial distance
     * */
    private void solveForX0(){
        this.x0 = this.x - (.5 * (this.a * (this.t * this.t))) - (this.v0 * this.t);
    }

    /*
     * solves equation to find the initial velocity
     * */
    private void solveForV0(){
        this.v0 = (this.x - this.x0 - (.5 * (this.a * (this.t * this.t))) / this.t);
    }

    /*
     * solves equation to find the time
     * uses quadratic formula
     * */
    private void solveForT(){
        double a = this.a * .5;
        double b = this.v0;
        double c = this.x0 - this.x;
        //quadratic formula
        this.t = ((0.0 - b) + Math.sqrt((b * b) - (4.0 * a * c))) / (2.0 * a);
    }

    /*
     * solves equation to find the acceleration
     * */
    private void solveForA(){
        this.a = ((this.x - this.x0 - (this.v0 * this.t)) * 2.0) / (this.t * this.t);
    }
}
