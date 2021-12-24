package ch15;

public class CallbackStyleExample {
    public static void main(String[] args) {

        int result = SampleMethod.f(10, (x) -> {
            System.out.println("original : " + x);
            x++;
            return x;
        });
        System.out.println("result : " + result);

        //callback으로 정의해서 던지거나. 혹은 .. future로 받거나?
    }
}
