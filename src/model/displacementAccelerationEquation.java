/*
 * displacementAccelerationEquation class
 * solves x = x0 + v0(t) + (1/2)(a)t^2
 * */

package model;

import java.util.HashMap;

public class displacementAccelerationEquation extends Equation {

    /*
     * constructor for displacementAccelerationEquation class
     * @param variables the known/unknown variables
     * */
    public displacementAccelerationEquation(HashMap<String, Double> variables){
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

    }

    /*
     * solves equation to find the initial distance
     * */
    private void solveForX0(){

    }

    /*
     * solves equation to find the initial velocity
     * */
    private void solveForV0(){

    }

    /*
     * solves equation to find the time
     * */
    private void solveForT(){

    }

    /*
     * solves equation to find the acceleration
     * */
    private void solveForA(){

    }
}
