//Jiayu Wu
//4/30/18
//This program is created to help users have an idea of BMI and calorie deficit
//This class calculates user's BMI
package wutermproject;


public class BMICalculation {
    
    //BMIEquation method
    public double BMIEquation(double userweight, double userheight )
    {
       double result;
       result = userweight/userheight/userheight;
       return result;
    }
    
    
}
