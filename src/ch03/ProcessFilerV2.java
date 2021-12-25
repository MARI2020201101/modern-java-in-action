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


        //클라이언트로서 사용하는 경우 - 에는 내가 인터페이스를 수정할수없으므로. 이럴때에는 wrapper메서드를 하나더
        //정의해서 사용하도록 한다
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
