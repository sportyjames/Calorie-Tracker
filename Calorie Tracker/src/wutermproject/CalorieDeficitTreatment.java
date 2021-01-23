//Jiayu Wu
//4/30/18
//This program is created to help users have an idea of BMI and calorie deficit
//This class prompts users to input their idealweight and their daily calorie Intake
package wutermproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

//I am using inheritance to inherit the attributes from JFrame and also implements ActionListener interface to accept event messages
public class CalorieDeficitTreatment extends JFrame implements ActionListener {

    //declare instance variables here
    private final Color GENERAL_PRODUCT_COLOR = new Color(255, 255, 255);
    private final java.net.URL CALORIE_IMAGE = getClass().getResource("calorieIntake.jpg");
    private final ImageIcon CALORIE_ICON = new ImageIcon(new ImageIcon(
            CALORIE_IMAGE).getImage().getScaledInstance(
            600, 400, Image.SCALE_DEFAULT));
    private JLabel calorieComsumptionLabel;
    private JLabel calorieChart;
    private JLabel calorieLabel;
    private JLabel weightLabel;
    private JLabel errorMessageLabel;
    private JTextField weightTextField;
    private JTextField calorieTextField;
    private JPanel caloriePanel;
    private JPanel inputPanel;
    private JPanel changePanel;
    private JButton gainButton;
    private JButton loseButton;

    double userWeight;

    //construct CalorieDeficitTreatment by using constructor
    public CalorieDeficitTreatment(double weightNumber1) {
        super("CalorieDeficitTreatment");
        this.setBounds(250, 80, 1000, 900);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.ORANGE);
        this.setLayout(new BorderLayout());

        userWeight = weightNumber1;

        gainButton = new JButton("Gain Weight Plan");
        gainButton.setFont(new Font("Bree Serif", Font.BOLD, 18));
        gainButton.addActionListener(this);

        loseButton = new JButton("Lose Weight Plan");
        loseButton.setFont(new Font("Bree Serif", Font.BOLD, 18));
        loseButton.addActionListener(this);

        errorMessageLabel = new JLabel();

        calorieComsumptionLabel = new JLabel();
        calorieComsumptionLabel.setText("Daily Calorie Consumption");
        calorieComsumptionLabel.setFont(new Font("Impact", Font.BOLD, 28));
        calorieComsumptionLabel.setForeground(GENERAL_PRODUCT_COLOR);
        calorieComsumptionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        calorieLabel = new JLabel();
        calorieLabel.setText("My Calorie Intake(kcal)");
        calorieLabel.setFont(new Font("Bree Serif", Font.BOLD, 18));
        calorieLabel.setForeground(GENERAL_PRODUCT_COLOR);

        errorMessageLabel = new JLabel();

        calorieTextField = new JTextField(4);

        weightLabel = new JLabel();
        weightLabel.setText("My Ideal Weight(kg)");
        weightLabel.setFont(new Font("Bree Serif", Font.BOLD, 18));
        weightLabel.setForeground(GENERAL_PRODUCT_COLOR);

        weightTextField = new JTextField(4);

        calorieChart = new JLabel(CALORIE_ICON, SwingConstants.CENTER);
        calorieChart.setAlignmentX(Component.CENTER_ALIGNMENT);

        caloriePanel = new JPanel();
        caloriePanel.setLayout(new BoxLayout(caloriePanel, BoxLayout.Y_AXIS));
        caloriePanel.setBackground(Color.GREEN);

        inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2, 2));
        inputPanel.setBackground(Color.GREEN);

        changePanel = new JPanel(new FlowLayout());
        changePanel.setBackground(Color.GREEN);

        caloriePanel.add(calorieComsumptionLabel);
        caloriePanel.add(calorieChart);

        inputPanel.add(calorieLabel);
        inputPanel.add(calorieTextField);
        inputPanel.add(weightLabel);
        inputPanel.add(weightTextField);

        changePanel.add(gainButton);
        changePanel.add(loseButton);

        this.add(caloriePanel, BorderLayout.NORTH);
        this.add(inputPanel, BorderLayout.CENTER);
        this.add(changePanel, BorderLayout.SOUTH);

        this.setVisible(true);

    }

    //Tell class how to respond to events by writing necessary action statements in a method
    public void actionPerformed(ActionEvent e) {
        String Command = e.getActionCommand();
        if (Command.equals("Lose Weight Plan")) {
            //create local variables here
            double calorieIntakeNumber;
            double idealWeightNumber;
            double weeks;
            String ArrayList;

            //ArrayList<String> class here construct an object
            ArrayList<String> weeksInArrayList = new ArrayList<>();

            //lossWeightCalculation class here construct an object
            lossWeightCalculation lossWeightCalculationObj = new lossWeightCalculation();

            try {
                //convert the values in textfield from string to double
                String calorieString = calorieTextField.getText();
                calorieIntakeNumber = Double.parseDouble(calorieString);
                String weightString = weightTextField.getText();
                idealWeightNumber = Double.parseDouble(weightString);

                //use the calculation method from BMIcalculation class and assign the values in the textfield as arguments
                weeks = lossWeightCalculationObj.calculateWeekNumber(calorieIntakeNumber, idealWeightNumber, userWeight);
                weeks = (double) Math.round(weeks * 10) / 10;
                //use the calculation method from BMIcalculation class and assign the values in the textfield as arguments
                weeksInArrayList = lossWeightCalculationObj.calculatetime(weeks);
                ArrayList = lossWeightCalculationObj.convertArrayList(weeksInArrayList);

              
                //pass String as argument to BMIReport
                loseWeightPlan objLoseWeightPlan = new loseWeightPlan(ArrayList, weeks);

                this.dispose();
                //catch the numberException. If it is invalid, Exception class generates a new object and output the errorMessage    
            } catch (NumberFormatException numberException) {
                errorMessageLabel.setText("ERROR!PLEASE ENTER A NUMBER");
                Exception objException = new Exception(errorMessageLabel);
            }
        } else if (Command.equals("Gain Weight Plan")) {
            try {
                double idealWeightNumber2;
                String weightString = weightTextField.getText();
                idealWeightNumber2 = Double.parseDouble(weightString);

                gainWeightPlan objGainWeightPlan = new gainWeightPlan(idealWeightNumber2, userWeight);

                this.dispose();
            }
            //catch the numberException. If it is invalid, Exception class generates a new object and output the errorMessage    
            catch (NumberFormatException numberException) {
                errorMessageLabel.setText("ERROR!PLEASE ENTER A NUMBER");
                Exception objException = new Exception(errorMessageLabel);

            }
        }
    }

}
