package task2;

import java.util.List;

public class Tester {

    private static final String FILE = "file2.txt";

    public static void main(String[] args){
        List<User> listUsers = ReadFile.read(FILE);
        ConvertToJson.convert(listUsers);
    }
}
