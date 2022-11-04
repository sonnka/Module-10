package task1;

import java.io.*;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextReader {

    private  static final Pattern pattern1 = Pattern.compile("^\\(\\d{3}\\)\\s\\d{3}-\\d{4}");
    private  static final Pattern pattern2 = Pattern.compile("^\\d{3}\\-\\d{3}\\-\\d{4}$");

    public static void reader(String file) {
        try (FileReader fileReader = new FileReader(file)) {
            char[] buffer = new char[256];
            int c;
            while ((c = fileReader.read(buffer)) > 0) {
                if (c < 256) {
                    buffer = Arrays.copyOf(buffer, c);
                }
            }
            convertToString(buffer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void convertToString(char[] array){
        String temp = new String(array);
        String[] result = temp.split("\\n");
        for (String s : result) {
            checkPhone(s, pattern1);
            checkPhone(s, pattern2);
        }
    }

    private static void checkPhone(String str , Pattern pattern){
        Matcher matcher = pattern.matcher(str);
        if(matcher.find()){
            System.out.println(str);
        }
    }

}
