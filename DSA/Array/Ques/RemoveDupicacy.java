package Array;

// Remove duplicates from unsorted array (no extra DS)

import java.util.*;

public class RemoveDupicacy {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int size = input.nextInt();
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = input.nextInt();
        }

        int x = 0;

        for (int i = 0; i < size; i++) {
            boolean isDuplicate = false;

            for (int j = 0; j < x; j++) {
                if (arr[i] == arr[j]) {
                    isDuplicate = true;
                    break;
                }
            }

            if (!isDuplicate) {
                arr[x] = arr[i];
                x++;
            }
        }

        // print unique elements
        for (int i = 0; i < x; i++) {
            System.out.print(arr[i] + " ");
        }

        input.close();
    }
}
