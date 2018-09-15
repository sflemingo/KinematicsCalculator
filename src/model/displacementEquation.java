/*
 * displacementEquation class
 * solves x = x0 + (1/2)(v0 + v)t
 * */

package model;

import java.util.HashMap;

public class displacementEquation extends Equation {

    /*
     * constructor for Equation class
     * @param variables the known/unknown variables
     * */
    public displacementEquation(HashMap<String, Double> variables){
        super(variables);
    }

    @Override
    public int solve() {
        if (this.x == null && this.x0 != null && this.v0 != null && this.v != null && this.t != null)
            solveForX();
        else if (this.x != null && this.x0 == null && this.v0 != null && this.v != null && this.t != null)
            solveForX0();
        else if (this.x != null && this.x0 != null && this.v0 == null && this.v != null && this.t != null)
            solveForV0();
        else if (this.x != null && this.x0 != null && this.v0 != null && this.v == null && this.t != null)
            solveForV();
        else if (this.x != null && this.x0 != null && this.v0 != null && this.v != null && this.t == null)
            solveForT();
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
     * solves equation to find the velocity
     * */
    private void solveForV(){

    }

    /*
     * solves equation to find the time
     * */
    private void solveForT(){

    }
}