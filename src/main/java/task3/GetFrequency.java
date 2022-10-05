package task3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        map.forEach((k,v) -> System.out.println(k + " " + v));
    }

    private GetFrequency(){

    }
}
