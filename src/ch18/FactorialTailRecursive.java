package ch18;

public class FactorialTailRecursive {

    public static void main(String[] args) {
        int i = factorialTail(4);
        System.out.println(i);
    }
    public static int factorialTail(int n){
        return recur(1, n);
    }

    private static int recur(int i, int n) {
        return n==1? i : recur(n*i,n-1);
    }
}
