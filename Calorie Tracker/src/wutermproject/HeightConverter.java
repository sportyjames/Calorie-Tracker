//Jiayu Wu
//4/30/18
//This program is created to help users have an idea of BMI and calorie deficit
//This class displays user's height
package wutermproject;

import java.awt.BorderLayout;
import java.awt.Color;
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
public class HeightConverter extends JFrame implements ActionListener {

    private JLabel convertionLabel;
    private JLabel meterLabel;
    private JLabel feetUnitLabel;
    private JLabel executionResultLabel;
    private JLabel errorMessageLabel;
    private JLabel outputHeightResultLabel;
    private JPanel usaUnitInputPanel;
    private JPanel executionPanel;
    private JButton executeButton;
    private JButton exitButton;
    private JTextField feetInput;
    private JTextField inchInput;

    private final Font WU_FONT = new Font("Times New Roman", Font.BOLD, 20);
    private final Font JAMES_FONT = new Font("Times New Roman", Font.PLAIN, 20);

    //construct HeightConverter by using constructor
    public HeightConverter() {
        super("HeightConverter");
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

        executionResultLabel = new JLabel();
        executionResultLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        errorMessageLabel = new JLabel();

        convertionLabel = new JLabel();
        convertionLabel.setText("Enter your height in ft ");
        convertionLabel.setFont(WU_FONT);

        feetUnitLabel = new JLabel();
        feetUnitLabel.setText("' ");

        feetInput = new JTextField(2);

        inchInput = new JTextField(2);

        usaUnitInputPanel.add(convertionLabel);
        usaUnitInputPanel.add(feetInput);
        usaUnitInputPanel.add(feetUnitLabel);
        usaUnitInputPanel.add(inchInput);

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
        int feetNumber;
        int inchNumber;
        double heightResult;

        if (Command.equals("convert")) {
             // try to execute the following command
            try {
                String feetString = feetInput.getText();
                feetNumber = Integer.parseInt(feetString);
                String inchString = inchInput.getText();
                inchNumber = Integer.parseInt(inchString);

                MathForHeightConverter heightObj = new MathForHeightConverter();
                heightResult = heightObj.convertHeight(feetNumber, inchNumber);
                heightResult = (double) Math.round(heightResult * 100) / 100;
                String heightresultAsString = Double.toString(heightResult);
                executionResultLabel.setText("Your height is " + heightresultAsString + " m");
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
