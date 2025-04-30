package Question_3;

import java.util.Arrays;


public class RadixSortInteger_w_Counter {

    public static long operationCount = 0; //counter initialization
    
    public static void radixSort(int[] initialNumArray) {
        int size = initialNumArray.length;
        operationCount++; // Operation for getting the size of the array.
    
        int[][] Array_1 = new int[10][size];
        int[][] Array_2 = new int[10][size];
        operationCount += 2; // Operation for creating 2D arrays.
    
        initializeWithNegativeOne(Array_1);
        initializeWithNegativeOne(Array_2);
        operationCount += 2; // Operation for initializing arrays with -1.
    
        int max = findMaxValue(initialNumArray);
        operationCount++; // Operation for calling findMaxValue
        operationCount++; // Operation for assigning the returned max value

        int maxDigits = countDigits(max);
        operationCount++; // Operation for calling countDigits
        operationCount++; // Operation for assigning the returned maxDigits value

        int multiplier = 1;
        operationCount++; // Operation for setting multiplier.
        
        for (int iteration = 0; iteration < maxDigits; iteration++) {
            operationCount += 2; // Operation for entering the main loop.
            
            if (iteration % 2 == 0) {
                for (int i = 0; i < size; i++) {
                    operationCount += 2; // Operation for entering inner loop.
                    int num = (iteration == 0) ? initialNumArray[i] : getValue(Array_2, i); 
                    operationCount += 3; // Operation for accessing num.
                    int digit = (num / multiplier) % 10;
                    operationCount += 3; // Operations for the digit extraction.
                    insertNumber(Array_1, num, digit);
                    operationCount++; // Operation for inserting into Array_1.
                }
                //printArray(Array_1, "After Iteration " + (iteration + 1) + " (Digit " + (iteration + 1) + ") - Array 1");
                operationCount++; // Operation for printing Array_1.
    
            
                Array_2 = new int[10][size];
                initializeWithNegativeOne(Array_2);
                operationCount += 2; // Operation for resetting Array_2.
            } else {
                for (int i = 0; i < 10; i++) {
                    operationCount += 2; // Operation for entering outer loop of Array_2 processing.
                    for (int j = 0; j < size; j++) {
                        operationCount += 2; // Operation for entering inner loop of Array_2.
                        int num = Array_1[i][j];
                        operationCount += 2; // Operation for accessing num.
                        if (num != -1) {
                            operationCount++;
                            int digit = (num / multiplier) % 10;
                            operationCount += 3; // Operations for the digit extraction.
                            insertNumber(Array_2, num, digit);
                            operationCount++; // Operation for inserting into Array_2.
                        }
                    }
                }
                //printArray(Array_2, "After Iteration " + (iteration + 1) + " (Digit " + (iteration + 1) + ") - Array 2");
                operationCount++; // Operation for printing Array_2.
    
                // Reset and prepare Array_1 for next iteration.
                Array_1 = new int[10][size];
                initializeWithNegativeOne(Array_1);
                operationCount += 2; // Operation for resetting Array_1.
            }
    
            multiplier *= 10; // Increase multiplier by 10 for next digit.
            operationCount++; // Operation for increasing multiplier.
        }
    
        System.out.println("\nSorted List:");
        int[][] tempArray = (maxDigits % 2 == 0) ? Array_2 : Array_1; // use last filled array, if even then Array_2 else Array_1.
        int[] sorted = new int[size];
        int index = 0; 
        operationCount += 3; // Operation for initializing index.
    
        for (int i = 0; i < 10; i++) {
            operationCount += 2; // Operation for entering outer loop of final sorting.
            for (int j = 0; j < size; j++) {
                operationCount += 2; // Operation for entering inner loop of final sorting.
                if (tempArray[i][j] != -1) {
                    sorted[index++] = tempArray[i][j];
                    operationCount += 3; //Operation for adding number to sorted array.
                }
            }
        }
    
        for (int num : sorted) {
            System.out.print(num + " ");
            operationCount++; // Operation for printing each number.
        }
        operationCount++; // Final operation for printing newline.
    }
    
    private static void initializeWithNegativeOne(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            operationCount += 2;
            Arrays.fill(arr[i], -1);
            operationCount++; // fill call
        }
    }

    // Finds max value in array
    public static int findMaxValue(int[] arr) {
        int max = arr[0];
        operationCount++;
        for (int i = 1; i < arr.length; i++) {
            operationCount += 2;
            if (arr[i] > max) {
                max = arr[i];
                operationCount += 2;
            }
        }
        return max;
    }

    // Counts digits in a number
    public static int countDigits(int number) {
        int count = 0;
        operationCount++;
        while (number != 0) {
            count++;
            number /= 10;
            operationCount += 3; // add ops count
        }
        return count;
    }
    

    // Inserts number into the correct bucket
    public static void insertNumber(int[][] arr, int num, int digit) {
        for (int k = 0; k < arr[0].length; k++) {
            operationCount += 2;
            if (arr[digit][k] == -1) {
                arr[digit][k] = num;
                operationCount += 3; //add ops count
                break;
            }
        }
    }
    
    private static void printArray(int[][] array, String label) {
        System.out.println("\n" + label);
        operationCount++; // print
        for (int i = 0; i < 10; i++) {
            System.out.print("Index [" + i + "]: ");
            operationCount++;
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] != -1) {
                    System.out.print(array[i][j] + " ");
                    operationCount += 3;
                }
                operationCount += 2;
            }
            System.out.println();
            operationCount++;
        }
    }

    // Gets the valid number from a 2D Array based on the index.
    public static int getValue(int[][] arr, int index) {
        int count = 0;
        operationCount++;
        for (int i = 0; i < 10; i++) {
            operationCount += 2;
            for (int j = 0; j < arr[0].length; j++) {
                operationCount += 2;
                if (arr[i][j] != -1) {
                    operationCount++;
                    if (count == index) {
                        operationCount++;
                        return arr[i][j];
                    }
                    count++;
                    operationCount++; // add ops count
                }
            }
        }
        return -1;
    }
    
    // main method not needed here
    /*public static void main(String[] args) {

        // Step 1: Initialize input array.
        int initialNumArray[] = {275, 87, 426, 61, 409, 170, 677, 503}; // Array of numbers to be sorted initialized.
        radixSort(initialNumArray); // Call radix sort function.
    }*/
}