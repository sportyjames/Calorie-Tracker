//Jiayu Wu
//4/30/18
//This program is created to help users have an idea of BMI and calorie deficit
//This class calculates user's ideal weight
package wutermproject;


public class IdealWeightCalculation {
    
    //IdealWeightMath1 method
    public double IdealWeightMath1(double height)
    {
      double weightResult1;
      weightResult1 = 18.5*height*height;
      
          
      return weightResult1;
      
    }
    //IdealWeightMath2 method
    public double IdealWeightMath2(double height)
    {
        double weightResult2;
        weightResult2 = 24.9*height*height;
        
        
        return weightResult2;
    }
    
}
