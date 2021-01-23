//Jiayu Wu
//4/30/18
//This program is created to help users have an idea of BMI and calorie deficit
//This class prompts users to input their height and weight
package wutermproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

//I am using inheritance to inherit the attributes from JFrame and also implements ActionListener interface to accept event messages
public class FitnessExamination extends JFrame implements ActionListener {

    //declare instance variables here
    private final Color BACKGROUND_COLOR = new Color(0, 0, 255);

    private Intro gFrame;
    private JLabel physicalInstructionLabel;
    private JLabel heightLabel;
    private JLabel weightLabel;
    private JLabel errorMessageLabel;
    private JButton examButton;
    private JButton homeButton;
    private JButton exitButton;
    private JTextField heightTextField;
    private JTextField weightTextField;
    private JPanel inputPanel;
    private JPanel examPanel;
    private JMenuBar helpMenuBar;
    private JMenu inputHelp;
    private JMenuItem heightConvertion;
    private JMenuItem weightConvertion;

    //construct FitnessExamination by using constructor
    //In here, I use pFrame to hold the address of the IntroFrame
    public FitnessExamination(Intro pFrame) {
        super("FitnessExamination");
        this.setBounds(300, 100, 700, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setBackground(BACKGROUND_COLOR);

        //In here, I use gFrame to convert the address to be accessible outside of the constructor
        gFrame = pFrame;
        
        //initialize inputPanel by setting background color and layout to it
        inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2, 2));
        inputPanel.setBackground(Color.CYAN);

        //initialize examPanel by setting background color to it
        examPanel = new JPanel();
        examPanel.setBackground(Color.YELLOW);

        //initialize physicalInstructionLabel by setting text,font.
        physicalInstructionLabel = new JLabel();
        physicalInstructionLabel.setText("<html>PLEASE BE HONEST WHILE YOU ARE ENTERING YOUR ACTUAL HEIGHT AND WEIGHT AND PLEASE BE CAREFUL WITH THE UNIT<html>");
        physicalInstructionLabel.setFont(new Font("Bree Serif", Font.BOLD | Font.ITALIC, 22));

        //initialize heightLabel by setting text.
        heightLabel = new JLabel();
        heightLabel.setText("Height(m): ");

        //initialize weightLabel by setting text.
        weightLabel = new JLabel();
        weightLabel.setText("Weight(kg): ");
        
        //initialize errorMessageLabel.
        errorMessageLabel = new JLabel();

        //initialize examButton by setting text and add ActionListner.
        examButton = new JButton();
        examButton.setText("I accept to be examined");
        examButton.addActionListener(this);
        
        exitButton = new JButton("exit");
        exitButton.addActionListener(this);
        
        //initialize homeButton by setting text and add ActionListner.
        homeButton = new JButton("Home");
        homeButton.addActionListener(this);

        //initialize heightTextField by setting textfield to it.
        heightTextField = new JTextField(3);

        //initialize weightTextField by setting textfield to it.
        weightTextField = new JTextField(3);

        //initialize helpMenuBar.
        helpMenuBar = new JMenuBar();

        ////initialize inputHelp.
        inputHelp = new JMenu("Learn more about Free Unit Conversion Service ");

        //initialize heightConvertion by setting text and adding ActionListener to it.
        heightConvertion = new JMenuItem("Height Converter");
        heightConvertion.addActionListener(this);

        //initialize weightConvertion by setting text and adding ActionListener to it.
        weightConvertion = new JMenuItem("Weight Converter");
        weightConvertion.addActionListener(this);
        
        //add Label and TextField to inputPanel.
        inputPanel.add(heightLabel);
        inputPanel.add(heightTextField);
        inputPanel.add(weightLabel);
        inputPanel.add(weightTextField);

        //add buttons to examPanel.
        examPanel.add(examButton);
        examPanel.add(homeButton);
        examPanel.add(exitButton);

        //add JMenu to JMenuBar
        helpMenuBar.add(inputHelp);
        //add JMenuItem to JMenu
        inputHelp.add(heightConvertion);
        inputHelp.add(weightConvertion);

        //add Label and Panel the frame    
        this.add(physicalInstructionLabel, BorderLayout.NORTH);
        this.add(inputPanel, BorderLayout.CENTER);
        this.add(examPanel, BorderLayout.SOUTH);

        //set JMenuBar
        this.setJMenuBar(helpMenuBar);

        //set them visible
        this.setVisible(true);

    }

    //Tell class how to respond to events by writing necessary action statements in a method
    public void actionPerformed(ActionEvent e) {
        String Command = e.getActionCommand();
        if (Command.equals("Height Converter")) {
            HeightConverter myHeightConverter = new HeightConverter();
        }
        else if(Command.equals("Weight Converter"))
        {
            WeightConverter myWeightConverter = new WeightConverter();
        }
        else if(Command.equals("Home"))
        {
            this.setVisible(false);
            gFrame.setVisible(true);
            
        }
        else if(Command.equals("exit"))
        {
            this.dispose();
            gFrame.dispose();
        }
        else if(Command.equals("I accept to be examined"))
        {
            //create local variables here
            double heightNumber;
            double weightNumber;
            double BMIResult;
            
            try
            {
                //convert the values in textfield from string to double
                String heightString = heightTextField.getText();
                heightNumber = Double.parseDouble(heightString);
                String weightString = weightTextField.getText();
                weightNumber = Double.parseDouble(weightString);
                
                //BMICalculation class here construct an object
                BMICalculation BMIObj = new BMICalculation();
                //use the calculation method from BMIcalculation class and assign the values in the textfield as arguments)
                BMIResult = BMIObj.BMIEquation(weightNumber,heightNumber);
                BMIResult = (double) Math.round(BMIResult * 10) / 10;
                String BMIresultAsString = Double.toString(BMIResult);
                
                //pass String as argument to BMIReport
                BMIReport objBMIReport = new BMIReport(heightString,weightString,BMIresultAsString,heightNumber,BMIResult,weightNumber,this);
                

             //catch the numberException. If it is invalid, Exception class generates a new object and output the errorMessage    
            }catch(NumberFormatException numberException){
                errorMessageLabel.setText("ERROR!PLEASE ENTER A NUMBER");
                Exception objException = new Exception(errorMessageLabel);
            }
        }

    }

}
