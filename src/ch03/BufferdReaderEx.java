package ch03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferdReaderEx {

    public static void main(String[] args) throws IOException {
        String s = processFile("\\study\\modern-java-in-action\\src\\ch03\\test.txt");
        System.out.println(s);
    }

    public static String processFile(String fileName) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
            String s;
            StringBuffer sb = new StringBuffer();
            while((s = br.readLine())!=null){
                sb.append(s);
                sb.append("\n");
            }
            return sb.toString();
        }
    }
}
