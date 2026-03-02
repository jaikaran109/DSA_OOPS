package DSA.Array._06_Matrix_Operations;

import java.util.ArrayList;
import java.util.List;

public class ContestProb1 {
    public static void main(String[] args) {
        List<Integer> lis = zigzagTraversal(new int[][]{{1,2},{3,4}});
        System.out.println(lis);
    }
    public static List<Integer> zigzagTraversal(int[][] grid) {
        List<Integer> list = new ArrayList<>();
        int temp;
        for(int i = 0; i < grid.length; i++){
            if(i % 2 == 0){
                temp = 0;
                for(int j = 0;  j < grid[0].length; j++){
                    if(Math.abs(j-temp) % 2 == 0){
                        list.add(grid[Math.abs(i-temp)][Math.abs(j-temp)]);
                    }
                }
            }else{
                temp = grid[i].length-1;
                for(int j = 0;  j < grid[0].length; j++){
                    if(Math.abs(j-temp) % 2  != 0){
                        list.add(grid[Math.abs(i-temp)][Math.abs(j-temp)]);
                    }
                }
            }

        }
        return list;
    }

}
