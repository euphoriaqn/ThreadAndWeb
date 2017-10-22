package Task1; /**
 * Created by Илья on 16.10.2017.
 */
import java.util.Scanner;
import java.util.concurrent.*;
public class Task1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        ExecutorService threadPool = Executors.newFixedThreadPool(1);
        int a, b;
        System.out.println("Введите число A");
        a = scanner.nextInt();
        System.out.println("Введите число B");
        b = scanner.nextInt();
        System.out.println("Выбирите действие над числами (+\n" +
                "-\n" +
                "*\n" +
                "/\n" +
                "%\n" +
                "==\n" +
                ">\n" +
                "<\n");
        String c = scanner.next();
        int result;
        switch(c) {
            case "+":
                Callable<Integer> callable1 = new Callable<Integer>() {
                    @Override
                    public Integer call() throws Exception {
                        int summ = a+b;
                        return summ;
                    }
                };
                Future<Integer> future1 = threadPool.submit(callable1);
                System.out.println("Result a + b = " + future1.get());
                break;
            case "-":
                Callable<Integer> callable2 = new Callable<Integer>() {
                    @Override
                    public Integer call() throws Exception {
                        int minus = a-b;
                        return minus;
                    }
                };
                Future<Integer> future2 = threadPool.submit(callable2);
                System.out.println("Result a - b = " + future2.get());
                break;
            case "*":
                Callable<Integer> callable3 = new Callable<Integer>() {
                    @Override
                    public Integer call() throws Exception {
                        int multi = a*b;
                        return multi;
                    }
                };
                Future<Integer> future3 = threadPool.submit(callable3);
                System.out.println("Result a * b = " + future3.get());
                break;
            case "/":
                Callable<Integer> callable4 = new Callable<Integer>() {
                    @Override
                    public Integer call() throws Exception {
                        int division = a/b;
                        return division;
                    }
                };
                Future<Integer> future4 = threadPool.submit(callable4);
                System.out.println("Result a / b = " + future4.get());
                break;
            case "%":
                Callable<Integer> callable5 = new Callable<Integer>() {
                    @Override
                    public Integer call() throws Exception {
                        int modulus = a%b;
                        return modulus;
                    }
                };
                Future<Integer> future5 = threadPool.submit(callable5);
                System.out.println("Result a % b = " + future5.get());
                break;
            case "==":
                Callable<Boolean> callable6 = new Callable<Boolean>() {
                    @Override
                    public Boolean call() throws Exception {
                        return (a==b);
                    }
                };
                Future<Boolean> future6 = threadPool.submit(callable6);
                System.out.println("Result a == b = " + future6.get());
                break;
            case ">":
                Callable<Boolean> callable7 = new Callable<Boolean>() {
                    @Override
                    public Boolean call() throws Exception {
                        return (a>b);
                    }
                };
                Future<Boolean> future7 = threadPool.submit(callable7);
                System.out.println("Result a > b = " + future7.get());
                break;
            case "<":
                Callable<Boolean> callable8 = new Callable<Boolean>() {
                    @Override
                    public Boolean call() throws Exception {
                        return (a<b);
                    }
                };
                Future<Boolean> future8 = threadPool.submit(callable8);
                System.out.println("Result a < b = " + future8.get());
                break;
            default:
                System.out.println("Введено не верное значение");
                break;
        }
        threadPool.shutdown();
    }
}
