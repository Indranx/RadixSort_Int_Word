package Question_3.Words_Sort;
import java.util.Random;
import java.util.Scanner;

public class RadixSortWord_w_Random {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of random words to generate: ");
        int n = scanner.nextInt();

        // Predefined list of meaningful words
        String[] dictionary = {
            "apple", "banana", "zebra", "dog", "cat", "orange", "grape", "book", "notebook", "pencil",
            "cloud", "rain", "sun", "moon", "star", "river", "mountain", "forest", "ocean", "island",
            "table", "chair", "house", "car", "truck", "train", "plane", "school", "teacher", "student",
            "computer", "phone", "keyboard", "mouse", "screen", "window", "door", "floor", "ceiling", "wall",
            "garden", "flower", "tree", "grass", "bush", "breeze", "storm", "thunder", "lightning", "snow",
            "ice", "fire", "heat", "cold", "spring", "summer", "autumn", "winter", "morning", "night",
            "evening", "afternoon", "breakfast", "lunch", "dinner", "meal", "drink", "coffee", "tea", "juice",
            "bread", "cheese", "meat", "fish", "chicken", "beef", "pork", "salt", "sugar", "butter", "oil",
            "water", "milk", "egg", "fruit", "vegetable", "potato", "tomato", "onion", "carrot", "cabbage",
            "lettuce", "spinach", "pepper", "chili", "corn", "bean", "pea", "rice", "noodle", "cake", "pie",
            "cookie", "candy", "chocolate", "icecream", "yogurt", "soup", "sandwich", "burger", "pizza", "pasta"
        };

        Random random = new Random();
        String[] initialWordArray = new String[n];
        for (int i = 0; i < n; i++) {
            initialWordArray[i] = dictionary[random.nextInt(dictionary.length)];
        }

        // Reset counter before sorting
        RadixSortWord_w_Counter.operationCount = 0;

        // Call radix sort with counter
        RadixSortWord_w_Counter.radixSortWord(initialWordArray);

        // Show operation count
        System.out.println("\nTotal Operations: " + RadixSortWord_w_Counter.operationCount);
    }
}
