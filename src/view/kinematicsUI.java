/*
 * kinematicsUI class
 * view of the KinematicsCalculator
 *
 * very simple user interface for solving kinematics problems,
 * will probably implement javafx later.
 *
 * */
package view;

import controller.kinematicsController;

public class kinematicsUI {

    /*
     * main method for the kinematicsUI
     * */
    public static void main(String args[]){
        kinematicsController kC = new kinematicsController();

        kC.setAcceleration(null);
        kC.setInitialVelocity(null);
        kC.setVelocity(null);
        kC.setInitialDisplacement(null);
        kC.setDisplacement(null);
        kC.setTime(null);

        for (String s: args){
            if (s.startsWith("a:"))
                kC.setAcceleration(Double.valueOf(s.substring(2)));
            if (s.startsWith("v:"))
                kC.setVelocity(Double.valueOf(s.substring(2)));
            if (s.startsWith("v0:"))
                kC.setInitialVelocity(Double.valueOf(s.substring(3)));
            if (s.startsWith("x:"))
                kC.setDisplacement(Double.valueOf(s.substring(2)));
            if (s.startsWith("x0:"))
                kC.setInitialDisplacement(Double.valueOf(s.substring(3)));
            if (s.startsWith("t:"))
                kC.setTime(Double.valueOf(s.substring(2)));
        }

        kC.solve();

        System.out.println("a:\t" + kC.getVariable("a"));
        System.out.println("v0:\t" + kC.getVariable("v0"));
        System.out.println("v:\t" + kC.getVariable("v"));
        System.out.println("x0:\t" + kC.getVariable("x0"));
        System.out.println("x:\t" + kC.getVariable("x"));
        System.out.println("t:\t" + kC.getVariable("t"));

        printStatement(kC);
    }

    /*
     * prints a short statement describing the one dimensional motion of the particle
     * @param kC the kinematicsController with all the solved variables
     * */
    public static void printStatement(kinematicsController kC){
        System.out.println();
        boolean useAnd = false;
        if(kC.getVariable("x0") != null || kC.getVariable("v0") != null || kC.getVariable("a") != null)
            System.out.print("The particle");
        if (kC.getVariable("x0") != null) {
            System.out.print(" starts at " + String.valueOf(kC.getVariable("x0")) + " meters");
            useAnd = true;
        }
        if (kC.getVariable("v0") != null) {
            if (useAnd)
                System.out.print(",");
            else
                System.out.print(" is");
            System.out.print(" moving at " + String.valueOf(kC.getVariable("v0")) + " meters per second");
            useAnd = true;
        }
        if (kC.getVariable("a") != null) {
            if (useAnd)
                System.out.print(",");
            else
                System.out.print(" is");
            System.out.print(" accelerating at a rate of " + String.valueOf(kC.getVariable("a")) + " meters per second squared");
        }
        if(kC.getVariable("x0") != null || kC.getVariable("v0") != null || kC.getVariable("a") != null)
            System.out.print(".\n");

        if(kC.getVariable("t") != null && (kC.getVariable("x") == null && kC.getVariable("v") == null))
            System.out.print(String.valueOf(kC.getVariable("t")) + " seconds pass by");
        else if (kC.getVariable("t") != null && (kC.getVariable("x") != null || kC.getVariable("v") != null)){
            System.out.print("After " + String.valueOf(kC.getVariable("t")) + " seconds,");
        }

        if (kC.getVariable("t") == null && (kC.getVariable("x") != null || kC.getVariable("v") != null)){
            System.out.print("After some time,");
        }

        useAnd = false;
        if(kC.getVariable("x") != null){
            System.out.print(" the particle is at " + String.valueOf(kC.getVariable("x")) + " meters");
            useAnd = true;
        }

        if(kC.getVariable("v") != null){
            if(useAnd)
                System.out.print(", moving at " + String.valueOf(kC.getVariable("v")) + " meters per second");
            else
                System.out.print(" the particle is moving at " + String.valueOf(kC.getVariable("v")) + " meters per second");
        }

        if(kC.getVariable("x") != null || kC.getVariable("v") != null || kC.getVariable("t") != null)
            System.out.print(".\n");
    }
}
