package task3;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadFile {
    public static List<String> read(String file) {
        try (FileReader fileReader = new FileReader(file)) {
            char[] buffer = new char[1256];
            int c;
            while ((c = fileReader.read(buffer)) > 0) {
                if (c < 1256) {
                    buffer = Arrays.copyOf(buffer, c);
                }
            }
            return convertToStringArray(buffer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<String> convertToStringArray(char[] array){
        String temp = new String(array);
        String[] result = temp.split("\\n");
        List<String> newArray = new ArrayList<>();
        for (String s : result) {
            String[] tempArray = s.replaceAll("\\s+", " ").split(" ");
            newArray.addAll(Arrays.asList(tempArray));
        }
        return newArray;
    }

    private ReadFile(){

    }
}
