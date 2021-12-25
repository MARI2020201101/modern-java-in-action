package ch03;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ProcessFiler {
    static String fileName = "\\study\\modern-java-in-action\\src\\ch03\\test.txt";
    public static void main(String[] args) throws IOException {
        String s = processFile(fileName, (br) -> {
            try {
                return br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        });

        System.out.println(s);
        //근데좀...별루다.....익셉션덕지덕지넹..
    }

    public static String processFile(String fileName , ProcessFileFunction p) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
            return p.processFile(br);
        }
    }
}
