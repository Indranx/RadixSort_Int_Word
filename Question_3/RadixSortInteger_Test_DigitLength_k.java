package Question_3;

import java.util.Random;
import java.util.Scanner;

/* Experiment 1: Varying  Digit Length (k) - input size fixed at 100
 *
 * ===================================================================================
 * Operation Counting Not Included Here:
 * -----------------------------------------------------------------------------------
 * This file only handles:
 *   - Accepting user input for k (digit length).
 *   - Generating random integers with exactly k digits.
 *   - Displaying the original array.
 *   - Calling the radix sort method from RadixSortInteger_w_Counter.
 *
 * Since sorting logic (including digit processing, comparisons, insertions, etc.)
 * is encapsulated in RadixSortInteger_w_Counter.java, this file does not count operations.
 *
 * All meaningful operation counting is already handled where radix sort is implemented.
 * ===================================================================================
 */

public class RadixSortInteger_Test_DigitLength_k {

    public static void main(String[] args) {
        int fixedArray = 100;
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Ask for digit length
        System.out.print("Enter number of digits per number (k): ");
        int k = scanner.nextInt();

        // Calculate min and max values for k-digit numbers
        int minValue = (int) Math.pow(10, k - 1);
        int maxValue = (int) Math.pow(10, k) - 1;

        int[] array = new int[100];
        for (int i = 0; i < fixedArray; i++) {
            array[i] = random.nextInt(maxValue - minValue + 1) + minValue;
        }

        System.out.println("\nGenerated Array (" + k + "-digit numbers):");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();

        System.out.println("\nCalling Radix Sort with Operation Counter (Question_3)...");

        // Reset operation counter before sorting
        RadixSortInteger_w_OP_Counter.operationCount = 0;

        // Call radix sort
        RadixSortInteger_w_OP_Counter.radixSort(array);

        // Display total operation count
        System.out.println("\nTotal Operations: " + RadixSortInteger_w_OP_Counter.operationCount);

        scanner.close();
    }
}
