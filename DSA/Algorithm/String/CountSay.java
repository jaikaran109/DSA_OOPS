package DSA.Algorithm.String;

public class CountSay {

        public static String countAndSay(int n) {
            if(n == 1) return "1";
            int i = 1;
            String ans = "";
            String str = "1";
            while (i < n) {
                ans = RLE(str);
                str = ans;
                i++;
            }
            return ans;
        }

        public static String RLE(String str) {
            if (str.length() == 1) {
                return "11";
            }
            StringBuilder ans = new StringBuilder(); // Use StringBuilder for efficiency
            for (int i = 0; i < str.length(); i++) {
                int count = 1;
                while (i + 1 < str.length() && str.charAt(i) == str.charAt(i + 1)) {
                    count++;
                    i++;
                }
                ans.append(count).append(str.charAt(i));
            }
            return ans.toString();
        }


    public static void main(String str[]){
        System.out.println(countAndSay(2));
    }
}
