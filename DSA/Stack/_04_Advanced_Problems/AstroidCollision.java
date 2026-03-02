package DSA.Stack._04_Advanced_Problems;
import java.util.*;
/*
Example 1:

Input: asteroids = [5,10,-5]
Output: [5,10]
Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.
Example 2:

Input: asteroids = [8,-8]
Output: []
Explanation: The 8 and -8 collide exploding each other.
Example 3:

Input: asteroids = [10,2,-5]
Output: [10]
Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.


Constraints:

2 <= asteroids.length <= 104
-1000 <= asteroids[i] <= 1000
asteroids[i] != 0
 */
public class AstroidCollision {
    public static int[] asteroidCollision(int[] arr) {
        Stack<Integer> st = new Stack<>();
        for(int i = 0 ; i < arr.length; i++){
            if(arr[i] > 0){
                st.push(arr[i]);
            }else{
                while(!st.isEmpty() && st.peek() > 0 &&  Math.abs(st.peek()) < Math.abs(arr[i])){
                    st.pop();
                }
                if(!st.isEmpty() &&  (-st.peek() == arr[i] || st.peek() == -arr[i])) {
                    st.pop();
                }
                else if(st.isEmpty() || (!st.isEmpty() && st.peek() < 0 && arr[i] < 0))
                    st.push(arr[i]);
            }
        }
        int n = st.size();
        int ans[] = new int[n];
        int i = 0;
        while(!st.isEmpty()){
            ans[n - i++ - 1] = st.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(asteroidCollision(new int[]{5,10,-5})));
    }
}
