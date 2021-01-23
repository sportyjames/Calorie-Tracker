//Jiayu Wu
//4/30/18
//This program is created to help users have an idea of BMI and calorie deficit
//This class output gain weight plan
package wutermproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;

//I am using inheritance to inherit the attributes from JFrame and also implements ActionListener interface to accept event messages
public class gainWeightCalorieIntake extends JFrame  implements ActionListener{
    
    //declare instance variables here
    private JLabel outputCalorie;
    private JButton finishMyPhysical;
    
    //construct gainWeightCalorieIntake by using constructor
    public gainWeightCalorieIntake(double calorie) {
        super("gainWeightCalorieIntake");
        this.setBounds(250, 80, 1000, 900);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.ORANGE);
        this.setLayout(new BorderLayout());  
    
        finishMyPhysical = new JButton("Finish My Physical");
        finishMyPhysical.addActionListener(this);
        
        String calorieResultAsString = Double.toString(calorie);
        outputCalorie = new JLabel("You will need " + calorieResultAsString+ " extra calorie per week to reach your ideal weight");
        outputCalorie.setFont(new Font("Bree Serif", Font.BOLD, 18));
        
        this.setVisible(true);
        this.add(outputCalorie,BorderLayout.CENTER);
        this.add(finishMyPhysical,BorderLayout.SOUTH);
        
}   //Tell class how to respond to events by writing necessary action statements in a method
    public void actionPerformed(ActionEvent e) {

        String command = e.getActionCommand();
        if(command.equals("Finish My Physical"))
        {
            this.dispose();     
        }
    }

}
