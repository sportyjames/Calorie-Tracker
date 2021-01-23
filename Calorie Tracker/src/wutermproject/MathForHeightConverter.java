//Jiayu Wu
//4/30/18
//This program is created to help users have an idea of BMI and calorie deficit
//This class calculates user's height in meters
package wutermproject;


public class MathForHeightConverter {
    
     //convertHeight method
    public double convertHeight(int feet, int inch)
    {
        double result;
        result = (feet*12 + inch)/39.3701;
        return result;
    }
    
}
