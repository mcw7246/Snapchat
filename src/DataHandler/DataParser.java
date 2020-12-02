package DataHandler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class DataParser
{
  //static Map<String, Map<String, Map<String, Integer>>>mainMap =  new HashMap<>();
  //        name        date    number
  public static Map<String, Map<String, Integer>> mainMap = new HashMap<>();
  public static Map<String, Map<String, Integer>> sentMap = new HashMap<>();
  public static Map<String, Map<String, Integer>> fromMap = new HashMap<>();

  public static void parseData()
  {
    File file = new File("src/Data/data.txt");
    List<String> lines = new ArrayList<>();
    Scanner scanner;
    try
    {
      scanner = new Scanner(file);
      while (scanner.hasNextLine())
      {
        lines.add(scanner.nextLine());
      }
    }
    catch (FileNotFoundException e)
    {
      System.out.println(e.getStackTrace());
    }

    for (String line : lines)
    {
      String[] splitLine = line.split(",");
      String name = "";
      String date = splitLine[2].substring(13, 23);
      boolean sent = false;

      if (splitLine[0].substring(2, 3).equals("F"))
      {
        name = splitLine[0].substring(10, splitLine[0].length() - 1);


      }
      else
      {
        name = splitLine[0].substring(8, splitLine[0].length() - 1);
        sent = true;
      }
      if(sent){
        sentMap = separateTypes(sentMap, name, date);
      }
      else{
        fromMap = separateTypes(fromMap, name, date);
      }
      if (mainMap.keySet().contains(name))
      {
        Map<String, Integer> currentMap = mainMap.get(name);
        if (currentMap.keySet().contains(date))
        {
          currentMap.replace(date, currentMap.get(date) + 1);
        }
        else
        {
          currentMap.put(date, 1);
        }
        mainMap.replace(name, currentMap);
      }
      else
      {
        Map<String, Integer> currentMap = new HashMap<>();
        currentMap.put(date, 1);
        mainMap.put(name, currentMap);
      }
    }
  }

  public static Map<String, Map<String, Integer>> separateTypes(Map<String, Map<String, Integer>> map, String name, String date){
    Map<String, Map<String, Integer>> currentMap = map;

    if(currentMap.containsKey(name)){
      Map<String, Integer> currentDates = currentMap.get(name);
      if(currentDates.containsKey(date)){
        currentDates.replace(date, currentDates.get(date) + 1);
      }
      else{
        currentDates.put(date, 1);
      }
      currentMap.replace(name, currentDates);
    }else{
      Map<String, Integer> currentDates = new HashMap<>();
      currentDates.put(date, 1);
      currentMap.put(name, currentDates);
    }
    return currentMap;
  }
}
