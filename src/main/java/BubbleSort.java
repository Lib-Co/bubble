import java.io.*;
import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        //Read in names from file and store in an array as one string
        File names = new File("names.txt");
        String[] arr = new String[0];
        //Remove speech marks and split the imported string into names as separated by commas
        try {
            BufferedReader in = new BufferedReader(new FileReader(names));
            String line = in.readLine();
            line = line.replace("\"", "");
            arr = line.split(",");

            System.out.println("Names to sort: " + Arrays.toString(arr));
        } catch (IOException e) {
            System.out.println(e);
        }

        //Bubble sort functionality
        String temp;
        int n = arr.length;
        //Iterate over array until no further swaps are required
        for (int j = 0; j < n; j++) {
            //Compare adjacent values until the end of the array is reached
            for (int i = 0; i < (n - j - 1); i++) {
                if (compareValues(arr[i], arr[i + 1]) > 0) {
                    temp = arr[i + 1];
                    arr[i + 1] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        System.out.println("Sorted names: " + Arrays.toString(arr));
    }

    //Reimplemented String.compareTo method
    public static int compareValues(String first, String second) {
        byte[] v1 = first.getBytes();
        byte[] v2 = second.getBytes();
        int len1 = first.length();
        int len2 = second.length();
        int lim = Math.min(len1, len2);
        for (int k = 0; k < lim; k++) {
            if (v1[k] != v2[k]) {
                return getChar(v1, k) - getChar(v2, k);
            }
        }
        return len1 - len2;
    }

    public static char getChar(byte[] val, int index) {
        return (char) (val[index] & 0xff);
    }
}

