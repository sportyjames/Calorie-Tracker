//Jiayu Wu
//4/30/18
//This program is created to help users have an idea of BMI and calorie deficit
//This class prompts user to enter the number of weeks for their gain weight plan
package wutermproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

//I am using inheritance to inherit the attributes from JFrame and also implements ActionListener interface to accept event messages
public class gainWeightPlan extends JFrame implements ActionListener {
    
    //declare instance variables here
    private JLabel planLabel;
    private JLabel errorMessageLabel;
    private JLabel caloriePerWeek;
    private JTextField planTextField;
    private JPanel planPanel;
    private JButton makePlanButton;
    
    double userIdealWeight;
    double userCurrentWeight;
    
    //construct gainWeightPlan by using constructor
    public gainWeightPlan(double idealWeight, double currentWeight) {
        super("gainWeightPlan");
        this.setBounds(250, 80, 1000, 900);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.ORANGE);
        this.setLayout(new BorderLayout());  
        
        userIdealWeight = idealWeight;
        userCurrentWeight =currentWeight;
        
        planLabel = new JLabel("How long do you want to set your plan in weeks?");
        planLabel.setFont(new Font("Bree Serif", Font.BOLD, 18));
        
        caloriePerWeek = new JLabel();
        
        errorMessageLabel = new JLabel();
        
        planTextField = new JTextField(3);
        
        makePlanButton = new JButton("Make Plan");
        makePlanButton.addActionListener(this);
        
        
        planPanel = new JPanel(new FlowLayout());
        
        planPanel.add(planLabel);
        planPanel.add(planTextField);
        
        this.add(planPanel,BorderLayout.CENTER);
        this.add(makePlanButton,BorderLayout.SOUTH);
        
        this.setVisible(true);
    }
    //Tell class how to respond to events by writing necessary action statements in a method
    public void actionPerformed(ActionEvent e)
    {
        String Command = e.getActionCommand();
        if (Command.equals("Make Plan")) {
            //create local variables here
            double weekNumber;
            double calorieNumber;
            
            //gainWeightCalculation class here construct an object
            gainWeightCalculation ObjgainWeightCalculation = new gainWeightCalculation();
            
            try{
                //convert the values in textfield from string to double
                String weekString = planTextField.getText();
                weekNumber = Double.parseDouble(weekString);
                //use the calculation method from gainWeightCalculation class and assign the values in the textfield as arguments)
                calorieNumber = ObjgainWeightCalculation.calculateWeekNumber(userIdealWeight,userCurrentWeight,weekNumber);
                gainWeightCalorieIntake ObjGainWeightCalorieIntake = new gainWeightCalorieIntake(calorieNumber);
                this.dispose();
            }
            //catch the numberException. If it is invalid, Exception class generates a new object and output the errorMessage    
            catch(NumberFormatException numberException){
                errorMessageLabel.setText("ERROR!PLEASE ENTER A NUMBER");
                Exception objException = new Exception(errorMessageLabel);
            }
            
        }
    }
    
}

    

