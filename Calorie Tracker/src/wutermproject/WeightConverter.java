//Jiayu Wu
//4/30/18
//This program is created to help users have an idea of BMI and calorie deficit
//This class displays user's weight
package wutermproject;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

//I am using inheritance to inherit the attributes from JFrame and also implements ActionListener interface to accept event messages
public class WeightConverter extends JFrame implements ActionListener {
    
    private JLabel convertionLabel;
    private JLabel decimalLabel;
    private JLabel executionResultLabel;
    private JLabel errorMessageLabel;
    private JPanel usaUnitInputPanel;
    private JPanel executionPanel;
    private JButton executeButton;
    private JButton exitButton;
    private JTextField poundInput;
    private JTextField poundDecimalInput;

    
    private final Font WU_FONT = new Font("Times New Roman", Font.BOLD, 20);
    private final Font JAMES_FONT = new Font("Times New Roman", Font.PLAIN, 20);

    //construct WeightConverter by using constructor
    public WeightConverter()
    {
        super("WeightConverter");
        this.setBounds(0, 0, 400, 300);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        usaUnitInputPanel = new JPanel(new FlowLayout());

        executionPanel = new JPanel();
        executionPanel.setLayout(new BoxLayout(executionPanel, BoxLayout.Y_AXIS));

        executeButton = new JButton();
        executeButton.setText("convert");
        executeButton.setFont(JAMES_FONT);
        executeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        executeButton.addActionListener(this);

        exitButton = new JButton("Got it");
        exitButton.addActionListener(this);
        
        decimalLabel = new JLabel();
        decimalLabel.setText(".");

        executionResultLabel = new JLabel();
        executionResultLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        errorMessageLabel = new JLabel();

        convertionLabel = new JLabel();
        convertionLabel.setText("Enter your weight in ibs ");
        convertionLabel.setFont(WU_FONT);



        poundInput = new JTextField(3);
        
        poundDecimalInput= new JTextField(1);

       

        usaUnitInputPanel.add(convertionLabel);
        usaUnitInputPanel.add(poundInput);
        usaUnitInputPanel.add(decimalLabel);
        usaUnitInputPanel.add(poundDecimalInput);


        executionPanel.add(executeButton);
        executionPanel.add(executionResultLabel);

        this.add(usaUnitInputPanel, BorderLayout.NORTH);
        this.add(executionPanel, BorderLayout.CENTER);
        this.add(exitButton, BorderLayout.SOUTH);

        this.setVisible(true);
    }
    //Tell class how to respond to events by writing necessary action statements in a method
    public void actionPerformed(ActionEvent e) {
        String Command = e.getActionCommand();

        //declare local variables
        int poundNumber;
        int decimalPoundNumber;
        double weightResult;

        if (Command.equals("convert")) {
            // try to execute the following command
            try {
                String poundString = poundInput.getText();
                poundNumber = Integer.parseInt(poundString);
                String poundDecimalString = poundDecimalInput.getText();
                decimalPoundNumber = Integer.parseInt(poundDecimalString);

                MathForWeightConverter WeightObj = new MathForWeightConverter();
                weightResult = WeightObj.convertWeight(poundNumber,decimalPoundNumber);
                weightResult = (double) Math.round(weightResult * 10) / 10;
                String weightresultAsString = Double.toString(weightResult);
                executionResultLabel.setText("Your weight is " + weightresultAsString + " kg");
                executionResultLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
            } 
            //catch the numberException. If it is invalid, Exception class generates a new object and output the errorMessage 
            catch (NumberFormatException numberException) {

                errorMessageLabel.setText("ERROR!PLEASE ENTER A NUMBER");
                Exception ExceptionObj = new Exception(errorMessageLabel);

            }
        } 
        //if user clicks got it, the frame will be disposed
        else if (Command.equals("Got it")) {
            this.dispose();
        }
    }
}


