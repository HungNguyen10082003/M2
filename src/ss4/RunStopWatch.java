package ss4;

import java.util.Random;


public class RunStopWatch {
    public static void main(String[] args) {
        int size = 100000;
        int [] arr = new int [size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(size);
        }
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

    for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
        stopWatch.stop();
        System.out.println("Time taken to sort the array: " + stopWatch.getElapsedTime() + " ms");
            
    }
    

}
