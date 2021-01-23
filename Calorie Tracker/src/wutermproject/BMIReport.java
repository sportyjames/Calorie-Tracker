//Jiayu Wu
//4/30/18
//This program is created to help users have an idea of BMI and calorie deficit
//This class shows users their BMI Report
package wutermproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

//I am using inheritance to inherit the attributes from JFrame and also implements ActionListener interface to accept event messages
public class BMIReport extends JFrame implements ActionListener{
   
    
    private final Color TABLE_COLOR = new Color(51,123,54);
    private final Font HEADER_FONT = new Font("Arial",Font.BOLD|Font.ITALIC,20);
    private final Font TABLE_FONT = new Font("Arial",Font.BOLD,15);
    private final Font TIERLEVEL_FONT = new Font("Times New Roman",Font.BOLD,20); 
    
    private final String[] DATA_TITLES = {"" , "My Data" , "Ideal Data"};
    private Object[][] userData;
    private JTable report;
    private JScrollPane myScrollPanel;
    private JPanel reportPanel;
    private JPanel guidePanel;
    private JButton myBMIScale; 
    private JButton checkButton;
    private JButton newPhysicalButton;
    private JButton treatmentButton;
    private JLabel BMILabel;
    private JLabel tierLevelLabel;
    private FitnessExamination gframe;
    
    double idealWeightResult1;
    double idealWeightResult2;
    double weightNumber1;
    //construct BMIReport by using constructor
    public BMIReport(String heightOutput, String weightOutput, String BMIOutput, double idealHeight,double BMINumber,double weightNumber, FitnessExamination pframe)
    {
        super("BMIReport");
        this.setBounds(250, 80, 800, 700);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.YELLOW);
        this.setLayout(new BorderLayout());
        
        weightNumber1 = weightNumber;
        
        gframe = pframe;
        
        IdealWeightCalculation  idealWeightObj = new IdealWeightCalculation();
        idealWeightResult1 = idealWeightObj.IdealWeightMath1(idealHeight);
        idealWeightResult1 = (double) Math.round(idealWeightResult1 * 10) / 10;
        String BMIresultAsString1 = Double.toString(idealWeightResult1);
        
        idealWeightResult2 = idealWeightObj.IdealWeightMath2(idealHeight);
        idealWeightResult2 = (double) Math.round(idealWeightResult2 * 10) / 10;
        String BMIresultAsString2 = Double.toString(idealWeightResult2);
        
        
        
        //fill objects in JTable with values.
        userData = new Object[3][3];
        userData[0][0] = "Height(m)"; 
        userData[0][1] = heightOutput;
        userData[0][2] = heightOutput;
        userData[1][0] = "Weight(kg)";
        userData[1][1] = weightOutput;
        userData[1][2] = BMIresultAsString1 + "~" +BMIresultAsString2;
        userData[2][0] = "BMI"; 
        userData[2][1] = BMIOutput; 
        userData[2][2] = "18.5~24.9";
        
        report = new JTable(userData,DATA_TITLES);
        
        myScrollPanel = new JScrollPane();
        myScrollPanel.getViewport().add(report);
        report.setFillsViewportHeight(true);
        
        // line color
        report.setGridColor(Color.ORANGE); 
        // table background color
        report.setBackground(TABLE_COLOR); 
        // cell font
        report.setFont(TABLE_FONT); 
        
        //TO CHANGE THE COLOR AND FONT AND GRID LINE OF HEADER
        JTableHeader header = report.getTableHeader();
        header.setBackground(Color.RED);
        header.setForeground(Color.WHITE);
        header.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        header.setFont(HEADER_FONT);
        
        TableColumn column = null;
        //column 0
        column = report.getColumnModel().getColumn(0); 
        column.setPreferredWidth(15);
        //column 1
        column = report.getColumnModel().getColumn(1);
        column.setPreferredWidth(50);
        
        report.setRowHeight(35);
         
        reportPanel = new JPanel(new FlowLayout());
        
        guidePanel = new JPanel(new FlowLayout()); 
        
        checkButton = new JButton("Check My BMI");
        checkButton.addActionListener(this);
        
        newPhysicalButton = new JButton("Redo Physical");
        newPhysicalButton.addActionListener(this);
        
        treatmentButton = new JButton("Calorie Deficit Treatment");
        treatmentButton.addActionListener(this);
                 
        tierLevelLabel = new JLabel();
        
        if(BMINumber < 18.5){
            tierLevelLabel.setText("YOU ARE UNDERWEIGHT");
        }
        else if(BMINumber > 24.9){
            tierLevelLabel.setText("YOU ARE OVERWEIGHT");
        }
        else{
            tierLevelLabel.setText("YOU HAVE NORMAL WEIGHT");
        }
            

        
        reportPanel.add(myScrollPanel);
        guidePanel.add(checkButton);
        guidePanel.add(newPhysicalButton);
        guidePanel.add(treatmentButton);
        
        
        
        this.add(reportPanel,BorderLayout.NORTH);
        this.add(guidePanel,BorderLayout.CENTER);
                
        this.setVisible(true);
    }
    //Tell class how to respond to events by writing necessary action statements in a method
    public void actionPerformed(ActionEvent e)
    {
        String command = e.getActionCommand();
        if(command.equals("Redo Physical"))
        {
            this.setVisible(false);
            gframe.setVisible(true);         
        }
        else if(command.equals("Check My BMI"))
        {
            tierLevelLabel.setFont(TIERLEVEL_FONT);
            tierLevelLabel.setForeground(Color.RED);
            this.add(tierLevelLabel,BorderLayout.SOUTH);
            this.validate();
            this.repaint(); 
        }
        else if(command.equals("Calorie Deficit Treatment"))
        {
          this.dispose();
          CalorieDeficitTreatment CalorieDeficitTreatmentObj = new CalorieDeficitTreatment(weightNumber1);
        }
        
    }
    
}
