package homeworks.VKS_04;

import com.sun.source.tree.LiteralTree;

import java.util.*;

public class Main {


    public static int countOccurance(List<String> strList, String duplicate) {
        int counter = 0;
        for (String s : strList) {
            if(s.equals(duplicate)){
                counter++;
            }
        }
        return counter;
    }

    public static List<Integer> toList(int[] intArr){
        List<Integer> intList = new ArrayList<>();
        for (int i : intArr) {
            intList.add(i);
        }
        return intList;
    }

    public static List<Integer> findUnique(List<Integer> parseList){
        HashSet<Integer> uniqueValue = new HashSet<>(parseList);
        return new ArrayList<>(uniqueValue);
    }

    public static HashMap<String, Integer> calcOccurance(List<String> array){
        HashMap<String, Integer> uniqueMap = new HashMap<>();
        for (String s : array) {
            if(!uniqueMap.containsKey(s)){
                uniqueMap.put(s,1);
            }else {
                uniqueMap.put(s, uniqueMap.get(s)+1);
            }
        }
        for (Map.Entry<String, Integer> stringIntegerEntry : uniqueMap.entrySet()) {
            System.out.println(stringIntegerEntry.getKey() + ": " + stringIntegerEntry.getValue());
        }
        return uniqueMap;
    }

    public static List<UniqueCounter> findOccurance(List<String> array){
        HashMap<String, Integer> uniqueMap = calcOccurance(array);
        List<UniqueCounter> uniqueCounters = new ArrayList<>();
        for (Map.Entry<String, Integer> stringIntegerEntry : uniqueMap.entrySet()) {
            uniqueCounters.add(new UniqueCounter(stringIntegerEntry.getKey(), stringIntegerEntry.getValue()));
        }
        return uniqueCounters;
    }
}


