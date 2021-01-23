//Jiayu Wu
//4/30/18
//This program is created to help users have an idea of BMI and calorie deficit
//This is the exception Frame 
package wutermproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

//I am using inheritance to inherit the attributes from JFrame and also implements ActionListener interface to accept event messages
public class Exception extends JFrame implements ActionListener{
    
    //declare instance variables here
    private JButton OKButton;
    
   
    
    //construct ExceptionFrame by using constructor
    public Exception(JLabel Message)
    {
        super("Exception");
        this.setBounds(200,200,300,200);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.getContentPane().setBackground(Color.MAGENTA);
        
        //initialize OKButton by setting text and ActionListener to it.
        OKButton = new JButton("OK");
        OKButton.addActionListener(this);
        
        
        //add message and OKButton to the frame and set them visible
        this.add(Message,BorderLayout.CENTER);
        this.add(OKButton,BorderLayout.SOUTH);
        this.setVisible(true);
        
        
        
         
    }
    //Tell class how to respond to events by writing necessary action statements in a method
    public void actionPerformed(ActionEvent e){
        String command = e.getActionCommand();
        
        //if the user click it, it will be disposed
        if(command.equals("OK"))
        {
            this.dispose();
        }
    }
    
    
}

