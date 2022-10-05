package task2;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class ReadFile {
    public static ArrayList<User> read(String file){
        try (FileReader fileReader = new FileReader(file)) {
            char[] buffer = new char[1256];
            int c;
            while ((c = fileReader.read(buffer)) > 0) {
                if (c < 1256) {
                    buffer = Arrays.copyOf(buffer, c);
                }
            }
            return convertIntoList(convertToStringArray(buffer));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String[] convertToStringArray(char[] array){
        String temp = new String(array);
        String[] result = temp.split("\\n");
        String[] newArray = new String[result.length * 2];
        int count = 0;
        for(int i = 0 ; i < result.length ; i++){
            String[] tempArray = new String[2];
            tempArray = result[i].split(" ");
            newArray[count] = tempArray[0];
            newArray[count+1] = tempArray[1];
            count += 2;
        }
        return newArray;
    }

    private static ArrayList<User> convertIntoList(String[] array){
        ArrayList<User> userList = new ArrayList<>();
        for(int i = 2; i < array.length; i+=2){
            userList.add(new User(array[i], Integer.parseInt(array[i+1])));
        }
        for (User u: userList) {
            System.out.println(u);
        }
        return userList;
    }
}
