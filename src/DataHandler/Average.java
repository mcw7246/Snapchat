package DataHandler;

import java.util.HashMap;
import java.util.Map;

public class Average
{
  static Map<String, Double> avg;
  public static Map<String, Double> getAverageAll(){
    avg = new HashMap<>();
    for(String name : DataParser.mainMap.keySet()){
      Map<String, Integer> dates = DataParser.mainMap.get(name);
      int total = 0;
      int totalDays = 0;
      for(Integer ints : dates.values()){
        total+= ints;
        totalDays++;
      }

      double aver = (double) total/totalDays;
      avg.put(name, aver);
    }
    System.out.println(avg);
    return avg;
  }

  public static Double getAverageName(String name){
    if(avg.keySet().contains(name)){
      return avg.get(name);
    }
    else{
      return 0.0;
    }
  }
}
