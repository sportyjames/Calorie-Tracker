//Jiayu Wu
//4/30/18
//This program is created to help users have an idea of BMI and calorie deficit
//This class calculates the number of weeks for restricting calorie 
package wutermproject;

import java.util.ArrayList;


public class lossWeightCalculation {
    

     //calculateWeekNumber method
    public double calculateWeekNumber(double calorieNumber,double idealweight,double weightNumber)
    {
        double calorieDeficit;
        double weeks;
        calorieDeficit = calorieNumber - 1800;
        weeks = 7700*(weightNumber-idealweight)/calorieDeficit/7;
        return weeks;
        
    }
    //calculatetime method
    public ArrayList<String> calculatetime(double weekNumber)
    {
        //construct arraylist
        ArrayList<String>list = new ArrayList<>(5);
        //Using for loop to add string to the object of arraylist
        for(int i=0;i<weekNumber-1;i++)
        {
        list.add(Double.toString(i+2));
        }
        return list;
    }
    //initialize the first output number as 1.0 and also initialize temporary String by using the members in arraylist in order to output the following numbers
    public String convertArrayList(ArrayList<String> ArrayList)
    {
        String Wu = "1.0";
        for(int j=0; j<ArrayList.size();j++)
        {
          String temporary;
          temporary = ArrayList.get(j);
          Wu = Wu + "," + temporary;
        }
        return Wu;
    }
    
}
