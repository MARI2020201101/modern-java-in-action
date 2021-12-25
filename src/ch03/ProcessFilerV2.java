package ch03;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ProcessFilerV2 {
    static String fileName = "\\study\\modern-java-in-action\\src\\ch03\\test.txt";
    public static void main(String[] args){
        String s = processFile(fileName, BufferedReader::readLine);
//        String s2 = processFile(fileName, (br) -> br.readLine());
        System.out.println(s);

//깔끔하게 해결되었당 헤헤.
    }

    public static String processFile(String fileName , ProcessFileFunction p){
        String s = "";
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
            s = p.processFile(br);
        } catch (Exception e) {
            e.printStackTrace(); //try - catch -resources 로 깔끄미~~!!
        }
        return s;
    }
}
