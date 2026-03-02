package DSA.Stack._04_Advanced_Problems;
/*
Example 1:
        Input: positions = [5,4,3,2,1], healths = [2,17,9,15,10], directions = "RRRRR"
        Output: [2,17,9,15,10]
        Explanation: No collision occurs in this example, since all robots are moving in the same direction. So, the health of the robots in order from the first robot is returned, [2, 17, 9, 15, 10].

        Example 2:
        Input: positions = [3,5,2,6], healths = [10,10,15,12], directions = "RLRL"
        Output: [14]
        Explanation: There are 2 collisions in this example. Firstly, robot 1 and robot 2 will collide, and since both have the same health, they will be removed from the line. Next, robot 3 and robot 4 will collide and since robot 4's health is smaller, it gets removed, and robot 3's health becomes 15 - 1 = 14. Only robot 3 remains, so we return [14].

        Example 3:
        Input: positions = [1,2,5,6], healths = [10,10,11,11], directions = "RLRL"
        Output: []
        Explanation: Robot 1 and robot 2 will collide and since both have the same health, they are both removed. Robot 3 and 4 will collide and since both have the same health, they are both removed. So, we return an empty array, [].

        Constraints:
        1 <= positions.length == healths.length == directions.length == n <= 105
        1 <= positions[i], healths[i] <= 109
        directions[i] == 'L' or directions[i] == 'R'
        All values in positions are distinct

*/



import java.util.*;
public class RobotCollision {
    public static List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions){
        int n = positions.length;
        Integer[] indices = new Integer[n];
        List<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for (int index = 0; index < n; ++index) {
            indices[index] = index;
        }

        Arrays.sort(
                indices,
                (lhs, rhs) -> Integer.compare(positions[lhs], positions[rhs])
        );

        for (int currentIndex : indices) {
            // Add right-moving robots to the stack
            if (directions.charAt(currentIndex) == 'R') {
                stack.push(currentIndex);
            } else {
                while (!stack.isEmpty() && healths[currentIndex] > 0) {
                    // Pop the top robot from the stack for collision check
                    int topIndex = stack.pop();

                    // Top robot survives, current robot is destroyed
                    if (healths[topIndex] > healths[currentIndex]) {
                        healths[topIndex] -= 1;
                        healths[currentIndex] = 0;
                        stack.push(topIndex);
                    } else if (healths[topIndex] < healths[currentIndex]) {
                        // Current robot survives, top robot is destroyed
                        healths[currentIndex] -= 1;
                        healths[topIndex] = 0;
                    } else {
                        // Both robots are destroyed
                        healths[currentIndex] = 0;
                        healths[topIndex] = 0;
                    }
                }
            }
        }

        // Collect surviving robots
        for (int index = 0; index < n; ++index) {
            if (healths[index] > 0) {
                result.add(healths[index]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(survivedRobotsHealths( new int[]{3,5,2,6},new int[]{10,10,15,12},"RLRL"));
    }
}
