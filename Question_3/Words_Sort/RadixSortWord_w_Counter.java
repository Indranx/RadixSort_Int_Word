package Question_3.Words_Sort;
import java.util.Arrays;
public class RadixSortWord_w_Counter {

    public static long operationCount = 0; //counter initialization

    public static void radixSortWord(String[] initialWordArray){
        
        int size = initialWordArray.length;
        operationCount++;

        // Step 2: Find the longest word length (for padding)
        int maxLength = findMaxLength(initialWordArray);
        operationCount++;

        // Step 3: Pad words with space (' ') to equal length - RIGHT PADDING
        String[] paddedWords = padWords(initialWordArray, maxLength);
        operationCount += 2;

        // Step 4: Create two 2D arrays for sorting passes
        String[][] Array_1 = new String[27][size]; // 26 letters + 1 for padding/space
        String[][] Array_2 = new String[27][size];
        initializeArray(Array_1);
        initializeArray(Array_2);
        operationCount += 4;

        // Step 5: Perform radix sort from rightmost character to leftmost
        for (int pos = maxLength - 1; pos >= 0; pos--) {
            operationCount += 2;

            if ((maxLength - pos) % 2 != 0) {
                // Odd pass → fill Array_1
                for (int i = 0; i < size; i++) {
                    operationCount += 2;
                    String word = (maxLength - pos == 1) ? paddedWords[i] : getWordFrom2D(Array_2, i);
                    operationCount += 3;
                    char ch = word.charAt(pos);
                    operationCount++;
                    int row = getCharIndex(ch);
                    operationCount++;
                    insertWord(Array_1, word, row);
                    operationCount++;
                }
                printArray(Array_1, "After Pass (char at position " + (pos + 1) + ") - Array 1");
                Array_2 = new String[27][size];
                initializeArray(Array_2);
                operationCount += 3;
            } else {
                // Even pass → fill Array_2
                for (int i = 0; i < 27; i++) {
                    operationCount += 2;

                    for (int j = 0; j < size; j++) {
                        operationCount += 2;
                        String word = Array_1[i][j];
                        operationCount++;

                        if (word != "-1") {  // Replaced .equals() with '!='
                            char ch = word.charAt(pos);
                            operationCount++;
                            int row = getCharIndex(ch);
                            operationCount++;
                            insertWord(Array_2, word, row);
                            operationCount++;
                        }
                    }
                }
                printArray(Array_2, "After Pass (char at position " + (pos + 1) + ") - Array 2");
                Array_1 = new String[27][size];
                initializeArray(Array_1);
                operationCount += 3;
            }
        }
        
        // Step 6: Collect and print final sorted list
        String[][] finalArray = (maxLength % 2 == 0) ? Array_2 : Array_1;
        operationCount += 2;
        String[] sortedWords = new String[size];
        operationCount++;
        int index = 0;
        operationCount++;
        for (int i = 0; i < 27; i++) {
            operationCount += 2;
            for (int j = 0; j < size; j++) {
                operationCount += 2;
                if (finalArray[i][j]!= "-1") {
                    sortedWords[index++] = finalArray[i][j].trim(); // remove padding
                    operationCount += 3;
                }
            }
        }

        System.out.println("\nSorted List:");
        operationCount++;
        for (int i = 0; i < sortedWords.length; i++) {
            operationCount += 2;
            System.out.print(sortedWords[i] + " ");
            operationCount++;
        }

    } 

    // Initialize all slots to "-1"
    private static void initializeArray(String[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            operationCount += 2;
            Arrays.fill(arr[i], "-1");
        }
    }

    // Find longest word for padding length
    private static int findMaxLength(String[] words) {
        int max = words[0].length();
        operationCount++;
        for (int i = 0; i < words.length; i++) {
            operationCount += 2;
            if (words[i].length() > max) {
                max = words[i].length();
                operationCount += 2;
            }
        }
        return max;
    }

    // Pad all words with space so they are equal in length (RIGHT padding for alphabetical order)
    private static String[] padWords(String[] words, int length) {
        String[] padded = new String[words.length];
        operationCount++;
        for (int i = 0; i < words.length; i++) {
            operationCount += 2;
            StringBuilder sb = new StringBuilder(words[i]);
            operationCount++;
            while (sb.length() < length) {
                sb.append(" "); // pad on the RIGHT
                operationCount++;
            }
            padded[i] = sb.toString();
        }
        return padded;
    }

    // Insert word into correct row and first empty column
    private static void insertWord(String[][] arr, String word, int row) {
        for (int k = 0; k < arr[0].length; k++) {
            operationCount += 2;
            if (arr[row][k] =="-1") {
                arr[row][k] = word;
                operationCount += 2;
                break;
            }
        }
    }

    // Convert character to row index (space → 0, 'a' → 1, ..., 'z' → 26)
    private static int getCharIndex(char ch) {
        if (ch == ' ') return 0;
        return (ch - 'a') + 1;
    }

    // Print the 2D array matrix with labels
    private static void printArray(String[][] arr, String label) {
        System.out.println("\n" + label);
        operationCount++;
        for (int i = 0; i < 27; i++) {
            operationCount += 2;
            char labelChar = (i == 0) ? ' ' : (char) ('a' + i - 1);
            operationCount += 4;
            System.out.print("Index [" + labelChar + "]: ");
            operationCount++;

            for (int j = 0; j < arr[0].length; j++) {
                operationCount += 2;
                if (arr[i][j] != "-1") {
                    operationCount++;
                    // Manually remove leading and trailing spaces
                    String word = arr[i][j];
                    operationCount++;
                    int start = 0;
                    operationCount++;
                    while (start < word.length() && word.charAt(start) == ' ') {
                        start++;
                        operationCount += 2;
                    }
                    int end = word.length() - 1;
                    operationCount++;
                    while (end >= 0 && word.charAt(end) == ' ') {
                        end--;
                        operationCount += 2;
                    }
                    if (start <= end) {
                        word = word.substring(start, end + 1);
                        System.out.print(word + " ");
                        operationCount += 3;
                    }
                }
            }
            System.out.println();
            operationCount++;
        }
        
    }

    // Retrieve the Nth word from a 2D array (non "-1" only)
    private static String getWordFrom2D(String[][] arr, int index) {
        int count = 0;
        operationCount++;
        for (int i = 0; i < 27; i++) {
            operationCount += 2;
            for (int j = 0; j < arr[0].length; j++) {
                operationCount += 2;
                if (arr[i][j] != "-1") {
                    operationCount++;
                    if (count == index) {
                        operationCount++;
                        return arr[i][j];
                    }
                    count++;
                }
            }
        }
        return "-1";
    }

}