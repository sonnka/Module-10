package task2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ConvertToJson {
    public static void convert(List<User> list){
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(list);
            System.out.println(json);
            write(json);
    }
    private static void write(String json){
        try(FileWriter fileWriter = new FileWriter("user.json")){
            fileWriter.write(json);
            fileWriter.flush();
        }catch(IOException e){
            throw new RuntimeException();
        }
    }
}
