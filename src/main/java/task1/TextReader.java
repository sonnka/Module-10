package task1;

import java.io.*;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextReader {
    private final static String REGEX_1 = "(\\d{3}\\-\\d{3}\\-\\d{4})";
    private final static String REGEX_2 = "^([(]\\d{3}[)]\\s\\d{3}\\-\\d{4})";

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
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void convertToString(char[] array){
        String temp = new String(array);
        String[] result = temp.split("\\n");
        for(int i = 0 ; i < result.length ; i++){
            checkPhone(result[i],REGEX_1);
            checkPhone(result[i],REGEX_2);
        }
    }

    private static void checkPhone(String str , String regex){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        if(matcher.find()){
            System.out.println(str);
        }
    }

}
