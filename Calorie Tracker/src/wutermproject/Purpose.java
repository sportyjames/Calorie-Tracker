//Jiayu Wu
//4/30/18
//This program is created to help users have an idea of BMI and calorie deficit
//This is the purpose Frame which tells user the purpose of taking the physical
package wutermproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

//I am using inheritance to inherit the attributes from JFrame and also implements ActionListener interface to accept event messages
public class Purpose extends JFrame implements ActionListener {
    
    //declare instance variables here
    private JButton doneButton;
    private JLabel purposeLabel;
    
    //construct purpose by using constructor
    public Purpose()
    {
        super("Purpose");
        this.setBounds(800,50,500,400);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.getContentPane().setBackground(Color.DARK_GRAY);
        this.setLayout(new BorderLayout());
        
        doneButton = new JButton("Done");
        doneButton.addActionListener(this);
        
        purposeLabel = new JLabel();
        purposeLabel.setText("<html>Nowadays,people dream of having ideal body types but they don't actually know how to make that happen. As people don't eat healthy food, they have a hard time maintaining their weight, which may lead to physical and mental health risks. This program aims at providing treatments such as offering an advanced physical and a healthy prescription<html>");
        purposeLabel.setFont(new Font("Times new Roman",Font.BOLD,22));
        purposeLabel.setForeground(Color.ORANGE);
        
        this.add(purposeLabel,BorderLayout.CENTER);
        this.add(doneButton,BorderLayout.SOUTH);
        
        this.setVisible(true);
        
    }
    
    //Tell class how to respond to events by writing necessary action statements in a method
    public void actionPerformed(ActionEvent e)
    {
       String command = e.getActionCommand();
       if(command.equals("Done"))
       {
         this.dispose();
       }
        
    }
    
    
    
}
