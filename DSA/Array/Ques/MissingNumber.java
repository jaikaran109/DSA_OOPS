package Array;


//Find the missing number from 1 to n


import java.util.*;
public class MissingNumber {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int size = input.nextInt();
		int[] arr = new int[size];
		for(int i = 0 ; i < size ; i++) {
			arr[i] = input.nextInt();
		}
		long expectedSum = size * (size + 1) / 2;
		long actualSum = 0;
		for(int i = 0 ; i < size ; i++) {
			actualSum += arr[i];
		}
		System.out.print(expectedSum - actualSum);
		
	}
}
fcghgvbjhnkm,
