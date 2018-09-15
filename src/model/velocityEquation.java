/*
* velocityEquation class
* solves v = v0 + a(t)
* */

package model;

import java.util.HashMap;

public class velocityEquation extends Equation {

    /*
     * constructor for velocityEquation class
     * @param variables the known/unknown variables
     * */
    public velocityEquation(HashMap<String, Double> variables){
        super(variables);
    }

    @Override
    public int solve() {
        if (this.v == null && this.v0 != null && this.a != null && this.t != null)
            solveForV();
        else if (this.v != null && this.v0 == null && this.a != null && this.t != null)
            solveForV0();
        else if (this.v != null && this.v0 != null && this.a == null && this.t != null)
            solveForA();
        else if (this.v != null && this.v0 != null && this.a != null && this.t == null)
            solveForT();
        else return -1;
        return 0;
    }

    /*
    * solves equation to find the velocity
    * */
    private void solveForV(){
        this.v = this.v0 + (this.a * this.t);
    }

    /*
     * solves equation to find the initial velocity
     * */
    private void solveForV0(){
        this.v0 = this.v - (this.a * this.t);
    }

    /*
     * solves equation to find the acceleration
     * */
    private void solveForA(){
        this.a = (this.v - this.v0) / this.t;
    }

    /*
     * solves equation to find the time
     * */
    private void solveForT(){
        this.t = (this.v - this.v0) / this.a;
    }
}
