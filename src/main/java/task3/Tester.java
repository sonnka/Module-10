package task3;

import java.util.List;

public class Tester {

    private static final String FILE = "words.txt";

    public static void main(String[] args){
        List<String> list;
        list = ReadFile.read(FILE);
        GetFrequency.print(list);
    }
}
