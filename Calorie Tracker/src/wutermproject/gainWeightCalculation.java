//Jiayu Wu
//4/30/18
//This program is created to help users have an idea of BMI and calorie deficit
//This class calculates the number of weeks for taking extra calorie 
package wutermproject;


public class gainWeightCalculation {
    
    //calculateWeekNumber method
    public double calculateWeekNumber(double idealweight,double weightNumber,double numberWeek)
    {
        double caloriePerWeek;    
        caloriePerWeek=7700*(idealweight-weightNumber)/numberWeek;
        return caloriePerWeek;
        
    }
    
}
