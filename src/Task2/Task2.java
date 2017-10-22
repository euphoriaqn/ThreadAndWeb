package Task2;
import java.util.Scanner;
import java.util.concurrent.*;


/**
 * Created by Илья on 16.10.2017.
 */
public class Task2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int numProcessors = Runtime.getRuntime().availableProcessors();
        ExecutorService threadPool = Executors.newFixedThreadPool(numProcessors);
        ///////////////////////////////////////////
        System.out.println("Create array");
        int size = 80000000;
        int[] intArray = createIntArray(size);

        System.out.println("Enter number of calculation");
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());

        UtilsCalculation utils = new UtilsCalculation(intArray);
        ///////////////////////////////////////////////////////////////////
        System.out.println("Calculate sum by one thread");
        double sum = 0.0;
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < number; i++) {
            sum+=utils.sumOfElements(0, intArray.length);
        }
        System.out.println("Time="+(System.currentTimeMillis()-startTime));
        System.out.println("sum="+sum);


        ///////////////////////////////////////////////////////////////////
        System.out.println("Calculate sum by threads");
        startTime = System.currentTimeMillis();
        sum = 0.0;
        for (int j = 0; j < number; j++) {
            sum+=utils.calculateSumByTreads(numProcessors);
        }
        System.out.println("Time="+(System.currentTimeMillis()-startTime));
        System.out.println("sum="+sum);

        //////////////////////////////////////////////////////////////////////
        System.out.println("Calculate sum by threadPool");
        startTime = System.currentTimeMillis();
        sum = 0.0;
        for (int j = 0; j < number; j++) {
            sum+=utils.calculateSumByTreadPool(numProcessors, threadPool);
        }
        threadPool.shutdown();
        System.out.println("Time="+(System.currentTimeMillis()-startTime));
        System.out.println("sum="+sum);
    }

    private static int[] createIntArray(int size) {
        int[] intArray = new int[size];
        for (int i = 0; i < size; i++) {
            intArray[i] = i+1;
        }
        return intArray;
    }

}
