package DSA.Stack._04_Advanced_Problems;
import java.util.*;
/*
Example 1:

Input: formula = "H2O"
Output: "H2O"
Explanation: The count of elements are {'H': 2, 'O': 1}.
Example 2:

Input: formula = "Mg(OH)2"
Output: "H2MgO2"
Explanation: The count of elements are {'H': 2, 'Mg': 1, 'O': 2}.
Example 3:

Input: formula = "K4(ON(SO3)2)2"
Output: "K4N2O14S4"
Explanation: The count of elements are {'K': 4, 'N': 2, 'O': 14, 'S': 4}.

*/

public class NoOfAtom {
    public static String countOfAtoms(String formula) {
        int n = formula.length();

        Stack<Map<String, Integer>> stack = new Stack<>();

        stack.push(new HashMap<>());

        int i = 0;
        while (i < n) {
            if (formula.charAt(i) == '(') {
                stack.push(new HashMap<>());
                i++;
            } else if (formula.charAt(i) == ')') {
                Map<String, Integer> top = stack.pop();
                i++;
                StringBuilder sb = new StringBuilder();
                while (i < n && Character.isDigit(formula.charAt(i))) {
                    sb.append(formula.charAt(i));
                    i++;
                }
                int multiplier = sb.length() > 0 ? Integer.parseInt(sb.toString()) : 1;
                for (String key : top.keySet()) {
                    int value = top.get(key);
                    top.put(key, value * multiplier);
                }
                for (String key : top.keySet()) {
                    stack.peek().put(key, stack.peek().getOrDefault(key, 0) + top.get(key));
                }
            } else {
                StringBuilder element = new StringBuilder();
                element.append(formula.charAt(i++));
                while (i < n && Character.isLowerCase(formula.charAt(i))) {
                    element.append(formula.charAt(i++));
                }
                StringBuilder sb = new StringBuilder();
                while (i < n && Character.isDigit(formula.charAt(i))) {
                    sb.append(formula.charAt(i++));
                }
                int count = sb.length() > 0 ? Integer.parseInt(sb.toString()) : 1;
                stack.peek().put(element.toString(), stack.peek().getOrDefault(element.toString(), 0) + count);
            }
        }

        Map<String, Integer> result = stack.pop();
        List<String> elements = new ArrayList<>(result.keySet());
        Collections.sort(elements);
        StringBuilder sb = new StringBuilder();
        for (String element : elements) {
            sb.append(element);
            int count = result.get(element);
            if (count > 1) sb.append(count);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(countOfAtoms("K4(ON(SO3)2)2"));
    }
}
