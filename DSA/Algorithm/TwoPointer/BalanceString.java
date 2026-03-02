package DSA.Algorithm.TwoPointer;

public class BalanceString {
    public static int minimumDeletions(String s) {
        int a_right_count[] = new int[s.length()];
        for(int i = s.length()-2; i >= 0; i--){
            a_right_count[i] = a_right_count[i+1];
            if(s.charAt(i+1) == 'a')
                a_right_count[i] += 1;
        }

        int b_left_count = 0;
        int result = s.length();
        for(int i = 0;  i < s.length(); i++){
            result = Math.min(result, b_left_count + a_right_count[i]);
            if(s.charAt(i) == 'b')
                b_left_count += 1;
        }

        return result;
    }

    public static int minimumDeletion(String s) {
        int a_right_count = 0;
        for(int i = s.length()-1; i >= 0; i--){
            if(s.charAt(i) == 'a')
                a_right_count += 1;
        }

        int b_left_count = 0;
        int result = s.length();
        for(int i = 0;  i < s.length(); i++){
            if(s.charAt(i) == 'a'){
                a_right_count--;
            }
            result = Math.min(result, b_left_count + a_right_count);
            if(s.charAt(i) == 'b')
                b_left_count += 1;
        }

        return result;
    }

    public static void main(String[] args) {
        String s = "aababbab";
        System.out.println(minimumDeletions(s));
    }
}
