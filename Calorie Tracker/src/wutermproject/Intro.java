//Jiayu Wu
//4/30/18
//This program is created to help users have an idea of BMI and calorie deficit
//This is the introduction Frame 
package wutermproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

//I am using inheritance to inherit the attributes from JFrame and also implements ActionListener interface to accept event messages
public class Intro extends JFrame implements ActionListener{
    
    //declare instance variables here
    private final java.net.URL SUPERMAN_LOGO = getClass().getResource("superman.jpg");
    private final ImageIcon SUPERMAN_ICON= new ImageIcon(new ImageIcon(
            SUPERMAN_LOGO).getImage().getScaledInstance(
                    400,300,Image.SCALE_DEFAULT));
    private final Color GENERAL_PRODUCT_COLOR = new Color(255,255,255);
    private final Color PANEL_BACKGROUND_COLOR = new Color(0,255,37);
    
    private JButton physicalButton;
    private JButton purposeButton;
    private JButton exitButton;
    private JLabel productNameLabel;
    private JLabel productDescriptionLabel;
    private JLabel supermanLabel;
    private JLabel physicalLabel;
    private JLabel purposeLabel;
    private JPanel applicationPanel;
    private JPanel guidePanel;
    
    
    //construct Intro by using constructor
    public Intro()
    {
        super("MAGICAL Weight Scale");
        this.setBounds(300,100,700,600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setBackground(PANEL_BACKGROUND_COLOR);
        this.setLayout(new BorderLayout());
        
        //initialize applicationPanel by setting BoxLayout to it.
        applicationPanel = new JPanel();
        applicationPanel.setLayout(new BoxLayout(applicationPanel,BoxLayout.Y_AXIS));
        applicationPanel.setBackground(PANEL_BACKGROUND_COLOR);
        
        //initialize guidePanel by setting background color to it
        guidePanel = new JPanel(new FlowLayout());
        guidePanel.setBackground(PANEL_BACKGROUND_COLOR);
        
        //initialize physicalButton and add ActionListener to it
        physicalButton = new JButton("take physical now");
        physicalButton.addActionListener(this);
        
        //initialize purposeButton and add ActionListener to it.
        purposeButton = new JButton("purpose");
        purposeButton.addActionListener(this);
        
        //initialize exitButton and add ActionListener to it.
        exitButton = new JButton("exit");
        exitButton.addActionListener(this);
        
        
        //initialize productNameLabel by setting text,font, foreground color and alignment
        productNameLabel = new JLabel();
        productNameLabel.setText("MAGICAL WEIGHT SCALE");
        productNameLabel.setFont(new Font("Impact",Font.BOLD,28));
        productNameLabel.setForeground(GENERAL_PRODUCT_COLOR);
        productNameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        
        //initialize productDescriptionLabel by setting text,font, foreground color and alignment
        productDescriptionLabel = new JLabel();
        productDescriptionLabel.setText("Powerful Weight Management Program");
        productDescriptionLabel.setFont(new Font("Bree Serif",Font.BOLD,18));
        productDescriptionLabel.setForeground(GENERAL_PRODUCT_COLOR);
        productDescriptionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        //initialize physicalLabel by setting text,font, foreground color and alignment
        physicalLabel = new JLabel();
        physicalLabel.setText("<html>In order to get started, you are required to take a physical for the program to examine your current body condition. If you are not ready to proceed, click purpose to learn why you need to take a physical or click exit to exit the program.<html>");
        physicalLabel.setFont(new Font("Bree Serif",Font.BOLD,22));
        physicalLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        //initialize supermanLabel by setting alignment
        supermanLabel = new JLabel(SUPERMAN_ICON,SwingConstants.CENTER);
        supermanLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        
        
        //add Labels to Panel
        applicationPanel.add(productNameLabel);
        applicationPanel.add(productDescriptionLabel);
        applicationPanel.add(supermanLabel);
        applicationPanel.add(physicalLabel);
        
        //add Buttons to Panel
        guidePanel.add(physicalButton);
        guidePanel.add(purposeButton);
        guidePanel.add(exitButton);
        
        
        
        //add Panels to Frame
        this.add(applicationPanel,BorderLayout.NORTH);
        this.add(guidePanel,BorderLayout.SOUTH);
        
        //set them visible
        this.setVisible(true);
        
        
        
    }
    
    //Tell class how to respond to events by writing necessary action statements in a method
    public void actionPerformed(ActionEvent e)
    {
        //if the user clicks it, it will set the current frame invisible and FitnessExaminationFrame will generate an object and hold the address of Intro
        String command = e.getActionCommand();
        if(command.equals("take physical now"))
        {
          this.setVisible(false);
          FitnessExamination myFitnessExamination= new FitnessExamination(this);
        }
        //if the user clicks it, purposeFrame will generate an object
        if(command.equals("purpose"))
        {
          
          Purpose PurposeOfTheProgram= new Purpose();
        }
        //if the user clicks it, the current frame will be disposed.
        if(command.equals("exit"))
        {          
          this.dispose();
        }
    }
    
    

    
    //main method
    public static void main(String[] args) {
        // construct newIntroFrame
        Intro newIntro = new Intro();
    }
    
}
