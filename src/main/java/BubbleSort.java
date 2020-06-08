import java.io.*;
import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) throws Exception {
        File names = new File("/home/libby/Dev/AP/resources/Names/names.txt");
//        String[] arr = {"test", "hello", "bye", "matt", "libby"};
        String[] arr = new String[0];
        try {
            BufferedReader in = new BufferedReader(new FileReader(names));
            String line = in.readLine();
            line = line.replace("\"", "");
            arr = line.split("," );

            System.out.println("Names to sort: " + Arrays.toString(arr));
        } catch (IOException e) {
            System.out.println(e);
        }

        boolean swapped;
        String temp;
        int n = arr.length;
        //set range of loop to be cover all values in array list
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < (n - j - 1); i++) {
                if (arr[i].compareTo(arr[i + 1]) > 0) {
                    temp = arr[i + 1];
                    arr[i + 1] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        System.out.println("Sorted names: " + Arrays.toString(arr));
    }
}
