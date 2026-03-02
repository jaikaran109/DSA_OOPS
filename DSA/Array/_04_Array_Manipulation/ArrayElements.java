package DSA.Array._04_Array_Manipulation;

public class ArrayElements {



    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int sum = 0;
        for(int i = 0; i < rolls.length; i++){
            sum += rolls[i];
        }
        int arr = ((n + m) * mean) -  sum;
        if(arr > n*6 || arr < n) return new int[]{};
        return findArrayWithSum(n,arr);

    }
    // Function to find one possible array of length n that sums to target
    public static int[] findArrayWithSum(int n, int target) {
        int[] array = new int[n];

        // Fill the array with a default value
        int defaultValue = target / n;
        int remainder = target % n;

        for (int i = 0; i < n; i++) {
            array[i] = defaultValue;
        }

        // Distribute the remainder across the array elements
        for (int i = 0; i < remainder; i++) {
            array[i]++;
        }

        return array;
    }

    public static void main(String[] args) {
        int length = 5; // Example length of the array
        int targetSum = 12;

        int[] array = findArrayWithSum(length, targetSum);
        System.out.print("One possible array of length " + length + " with sum " + targetSum + ": [");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}

