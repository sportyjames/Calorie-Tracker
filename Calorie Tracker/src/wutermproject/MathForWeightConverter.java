//Jiayu Wu
//4/30/18
//This program is created to help users have an idea of BMI and calorie deficit
//This class calculates user's height in kilograms
package wutermproject;


public class MathForWeightConverter {
    
    //convertWeight method
    public double convertWeight(int integerPound, int decimalPound)
    {
        double result;
        double decimalConversion = (double)decimalPound/10;
        result = (integerPound + decimalConversion)/2.20462;
        return result;
    }
    
}
