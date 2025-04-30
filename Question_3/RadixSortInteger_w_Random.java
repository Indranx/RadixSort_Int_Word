package Question_3;

import java.util.Random; // Import Random
import java.util.Scanner;

/*
 * ================================================================================
 * Why Operation Counting Is Not Included Here:
 * -------------------------------------------------------------------------------
 * This file only handles:
 *   - Generating random integers.
 *   - Displaying the original array.
 *   - Calling the actual radix sort algorithm.
 *   - Random Number Generating is always O(n)
 *
 * Since this part only performs input generation and not the sorting logic itself,
 * we do not need to count operations here.
 * 
 * All meaningful operation counting (digit processing, comparisons, insertions, etc.)
 * is already handled inside the RadixSortInteger_w_Counter.java file.
 *
 * Therefore, no additional operation counter is needed in this test file.
 * ================================================================================
 */

public class RadixSortInteger_w_Random {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            Random random = new Random();
    
            System.out.print("Enter number of random integers to sort: ");
            int size = scanner.nextInt();
    
            int[] array = new int[size];
            for (int i = 0; i < size; i++) {
                array[i] = random.nextInt(10000); // Values from 0 to 9999
            }
    
            System.out.println("\nGenerated Array:");
            for (int num : array) {
                System.out.print(num + " ");
            }
            System.out.println();
    
            System.out.println("\nCalling Radix Sort with Operation Counter (Question_3)...");
            
            // Reset counter before sorting
            RadixSortInteger_w_Counter.operationCount = 0;
    
            // Call radix sort with counter
            RadixSortInteger_w_Counter.radixSort(array);
    
            // Show operation count
            System.out.println("\nTotal Operations: " + RadixSortInteger_w_Counter.operationCount);
    
            scanner.close();
        }
    }
    

