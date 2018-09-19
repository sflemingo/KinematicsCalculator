/*
 * displacementEquation class
 * solves x = x0 + (1/2)(v0 + v)t
 * */

package model;

import java.util.Map;

public class displacementEquation extends Equation {

    /*
     * constructor for Equation class
     * @param variables the known/unknown variables
     * */
    public displacementEquation(Map<String, Double> variables){
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
        this.x = this.x0 + (0.5 * this.t * (this.v0 + this.v));
    }

    /*
     * solves equation to find the initial distance
     * */
    private void solveForX0(){
        this.x0 = this.x - (0.5 * this.t * (this.v0 + this.v));
    }

    /*
     * solves equation to find the initial velocity
     * */
    private void solveForV0() {
        this.v0 = (((this.x - this.x0) / this.t) * 2.0) - this.v;
    }
    /*
     * solves equation to find the velocity
     * */
    private void solveForV(){
        this.v = (((this.x - this.x0) / this.t ) * 2.0) - this.v0;
    }

    /*
     * solves equation to find the time
     * */
    private void solveForT(){
        this.t = ((this.x - this.x0) * 2.0) / (this.v0 + this.v);
    }
}