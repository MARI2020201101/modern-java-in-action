package ch08;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RemoveIfEx {
    public static void main(String[] args) {
        List<String> list = string();

//        for (String s : list) {
//            if(s.charAt(0)=='a'){
//                list.remove(s);
//            }
//        }//ConcurrentModificationException 이 발생한다. collection의 상태와 iterator의 상태가 일치하지 않기 때문이다.


        for(Iterator<String> iterator = list.iterator(); iterator.hasNext();){
            String s = iterator.next();
            if(s.charAt(0)=='a'){
                iterator.remove();
            }//iterator를 명시적으로 불러서 이러한 문제를 해결할 수 있다.
        }
        System.out.println(list);


        List<String> strings = string();
        strings.removeIf(s->s.charAt(0)=='a');
        System.out.println(strings);
        //java 8부터는 removeIf로 해결한다!

    }

    public static List<String> string(){
        List<String> strings = new ArrayList<>();
        strings.add("abc");
        strings.add("bbc");
        strings.add("cbc");
        strings.add("aac");
        strings.add("adc");
        return strings;
    }
}
