package view;

import controller.KinematicsController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/*
 * KinematicsGUI class
 *
 * provides a gui for the Kinematics Calculator
 *
 * @author Spencer Fleming
 * */
public class KinematicsGUI extends Frame{

    private TextField x0Field, xField, v0Field, vField, aField, tField;

    public KinematicsGUI(){
        add(new Label("Initial Distance x0="));
        x0Field = new TextField("");
        add(x0Field);

        add(new Label("Final Distance x="));
        xField = new TextField("");
        add(xField);

        add(new Label("Initial Velocity v0="));
        v0Field = new TextField("");
        add( v0Field);

        add( new Label("Final Velocity v="));
        vField = new TextField("");
        add(vField);

        add(new Label("Acceleration a="));
        aField = new TextField("");
        add(aField);

        add(new Label("Time t="));
        tField = new TextField("");
        add(tField);

        Label message = new Label("");
        add(message);
        Button solveButton = new Button("solve");
        solveButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                solve();
            }
        });
        add(solveButton);

        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e) { System.exit(0); }
        });

        setLayout(new GridLayout(7,2));
        setTitle("Kinematics Calculator");
        setSize(500, 500);
        setVisible(true);
    }

    public void solve(){
        KinematicsController controller = new KinematicsController();
        try {
            controller.setInitialDisplacement(Double.valueOf(x0Field.getText()));
        }catch (NumberFormatException e){}
        try {
            controller.setDisplacement(Double.valueOf(xField.getText()));
        }catch (NumberFormatException e){}
        try {
            controller.setInitialVelocity(Double.valueOf(v0Field.getText()));
        }catch (NumberFormatException e){}
        try {
            controller.setVelocity(Double.valueOf(vField.getText()));
        }catch (NumberFormatException e){}
        try {
            controller.setAcceleration(Double.valueOf(aField.getText()));
        }catch (NumberFormatException e){}
        try {
            controller.setTime(Double.valueOf(tField.getText()));
        }catch (NumberFormatException e){}

        controller.solve();

        x0Field.setText(String.valueOf(controller.getVariable("x0")));
        xField.setText(String.valueOf(controller.getVariable("x")));
        v0Field.setText(String.valueOf(controller.getVariable("v0")));
        vField.setText(String.valueOf(controller.getVariable("v")));
        aField.setText(String.valueOf(controller.getVariable("a")));
        tField.setText(String.valueOf(controller.getVariable("t")));
    }

    public static void main(String[] args) {
        KinematicsGUI gui = new KinematicsGUI();
    }

}
