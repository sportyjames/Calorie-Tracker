//Jiayu Wu
//4/30/18
//This program is created to help users have an idea of BMI and calorie deficit
//This class output lose weight plan
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
public class loseWeightPlan extends JFrame implements ActionListener {

    //declare instance variables here
    private JLabel weekLabel;
    private JLabel numberOfWeeks;
    private JButton finishMyPhysical;

    double WeekNumber;

    //construct loseWeightPlan by using constructor
    public loseWeightPlan(String week, double weeks) {
        super("loseWeightPlan");
        this.setBounds(250, 80, 1000, 900);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.ORANGE);
        this.setLayout(new BorderLayout());

        WeekNumber = weeks;

        weekLabel = new JLabel("Estimating time(in weeks): " + week);
        weekLabel.setFont(new Font("Bree Serif", Font.BOLD, 18));

        numberOfWeeks = new JLabel("If you consume 1800 calories per day, you will need " + WeekNumber + " weeks to lose weight ");
        numberOfWeeks.setFont(new Font("Bree Serif", Font.BOLD, 18));

        finishMyPhysical = new JButton("Finish My Physical");
        finishMyPhysical.addActionListener(this);

        this.setVisible(true);

        this.add(weekLabel, BorderLayout.NORTH);
        this.add(numberOfWeeks, BorderLayout.CENTER);
        this.add(finishMyPhysical,BorderLayout.SOUTH);
    }
    //Tell class how to respond to events by writing necessary action statements in a method
    public void actionPerformed(ActionEvent e) {

        String command = e.getActionCommand();
        if(command.equals("Finish My Physical"))
        {
            this.dispose();     
        }
    }

}
