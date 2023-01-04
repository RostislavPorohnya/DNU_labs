public class Main {
    public static void main(String[] args) {
        int n = 4;

        factorial fact = new factorial();
        int res1 = fact.recursionExecute(n);
        System.out.println("Factorial recursive n: " + n);
        System.out.println("Factorial recursive execute: " + res1);

        int res2 = fact.cycleExecute(n);
        System.out.println("Factorial cycle n: " + n);
        System.out.println("Factorial cycle execute: " + res2);
        assert res1 == res2 : "different values";


        fibonacci fib = new fibonacci();

        res1 = fib.recursionExecute(n);
        System.out.println("Fibonacci recursive n: " + n);
        System.out.println("Fibonacci recursive execute: " + res1);

        res2 = fib.cycleExecute(n);
        System.out.println("Fibonacci cycle n: " + n);
        System.out.println("Fibonacci cycle execute: " + res2);
        assert res1 == res2 : "different values";


        int number = 233151;
        digitsSum digitSum = new digitsSum();
        res1 = digitSum.execute(number);
        System.out.println("Digits sum number: " + number);
        System.out.println("Digits sum recursive execute: " + res1);

        int x = 5;
        int y = 2;
        sum sum = new sum();
        res1 = sum.execute(x,y);
        System.out.println("Sum without arithmetic operations x: " + x + ", y: " + y);
        System.out.println("Sum without arithmetic operations execute: " + res1);

    }
}