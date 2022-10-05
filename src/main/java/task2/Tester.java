package task2;

import java.util.ArrayList;

public class Tester {
    private final static String FILE = "file2.txt";
    public static void main(String[] args){
        ArrayList<User> listUsers = ReadFile.read(FILE);
        ConvertToJson.convert(listUsers);
    }
}
