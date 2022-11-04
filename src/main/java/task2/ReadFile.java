package task2;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadFile {

    public static List<User> read(String file){
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
        for (String s : result) {
            String[] tempArray;
            tempArray = s.split(" ");
            if(tempArray.length == 2) {
                newArray[count] = tempArray[0];
                newArray[count + 1] = tempArray[1];
            }
            count += 2;
        }
        return newArray;
    }

    private static ArrayList<User> convertIntoList(String[] array){
        ArrayList<User> userList = new ArrayList<>();
        for(int i = 2; i < array.length; i+=2){
            if(array[i] != null || array[i + 1] != null) {
                try {
                    int h = Integer.parseInt(array[i + 1]);
                    userList.add(new User(array[i], h));
                } catch (NumberFormatException ignored) {
                }
            }
        }
        for (User u: userList) {
            System.out.println(u);
        }
        return userList;
    }
}
