package task3;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class GetFrequency {

    private static final Map<String,Integer> map = new HashMap<>();

    public static void print(List<String> list){
        for(int i = 0; i < list.size(); i++){
            int count = 1;
            String temp = list.get(i);
            for(int j = i+1; j < list.size(); j++){
                if(temp.equals(list.get(j))){

                    count++;
                }

            }
            if(!map.containsKey(temp)){
                map.put(temp,count);
            }
        }
        Map<String,Integer> sortedMap = map.entrySet().stream()
            .sorted(Collections.reverseOrder(Entry.comparingByValue()))
            .collect(Collectors
                .toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        sortedMap.forEach((k,v) -> System.out.println(k + " " + v));
    }
}
