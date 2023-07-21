package String;

import java.io.*;
import java.util.Scanner;

public class FindingWordFromFile {

    public static void findWordInFile() throws FileNotFoundException {
        File file = new File("src/abc.txt");
        Scanner sc2 = new Scanner(new FileInputStream(file));
        String word = "employee";
        boolean flag = false;
        int count = 0;
        while (sc2.hasNextLine()) {
            String line = sc2.nextLine();
            if (line.indexOf(word) != -1) {
                flag = true;
                count = count + 1;
            }
        }
        if (flag) {
            System.out.println("File contains the specified word");
            System.out.println("Number of occurrences is: " + count);
        } else {
            System.out.println("File does not contain the specified word");
        }
    }

    public static void findWord() throws IOException {
        File file = new File("src/abc.txt");
        FileReader fileReader = new FileReader(file);
        int i;
        while ((i = fileReader.read()) != -1) {
            System.out.print((char) i);
        }
        fileReader.close();
    }

    public static void main(String[] args) throws IOException {
        findWordInFile();
    }
}
