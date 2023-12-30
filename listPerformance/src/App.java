import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class App {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        int[] array = new int[10000];
        String fileName = "performance_data.csv";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("Test,Duration\n");

            // Test LinkedList add
            long startTime = System.nanoTime();
            for (int i = 0; i < 10000; i++) {
                list.add(i);
            }
            long endTime = System.nanoTime();
            writer.write("LinkedList Add," + (endTime - startTime) + "\n");

            // Test Array add
            startTime = System.nanoTime();
            for (int i = 0; i < 10000; i++) {
                array[i] = i;
            }
            endTime = System.nanoTime();
            writer.write("Array Add," + (endTime - startTime) + "\n");

            // Test LinkedList addAtIndex
            int middleIndex;
            startTime = System.nanoTime();
            for (int i = 0; i < 100; i++) {
                middleIndex = i / 2; // Approximating middle index after each insertion
                list.addAtIndex(middleIndex, -1); // Adding a constant value at the middle index
            }
            endTime = System.nanoTime();
            writer.write("LinkedList AddAtIndex," + (endTime - startTime) + "\n");

            // Test LinkedList remove
            startTime = System.nanoTime();
            for (int i = 0; i < 100; i++) {
                list.remove(i);
            }
            endTime = System.nanoTime();
            writer.write("LinkedList Remove," + (endTime - startTime) + "\n");

            // Test Array removal
            startTime = System.nanoTime();
            for (int i = 0; i < 100; i++) {
                // Simulate removal by shifting elements
                for (int j = i; j < array.length - 1; j++) {
                    array[j] = array[j + 1];
                }
                // Optional: set the last element to a default value (like 0) after shifting
                array[array.length - 1] = 0;
            }
            endTime = System.nanoTime();
            writer.write("Array Remove," + (endTime - startTime) + "\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
