package ch17;

import java.util.Random;

public class TempInfo {

    private String town;
    private int temp;
    private static Random random = new Random();

    private TempInfo(String town , int temp){
        this.town=town;
        this.temp = temp;
    }
    public static TempInfo fetch(String town){
        if(random.nextInt(10)==0){
            throw new RuntimeException("에러 발생!!");
        }
        return new TempInfo(town, random.nextInt(100));
    }

    public String getTown() {
        return town;
    }


    public int getTemp() {
        return temp;
    }

    @Override
    public String toString() {
        return "TempInfo { " +
                " town = '" + town + '\'' +
                ", temp = " + temp  + " }";
    }
}
