package DSA.Algorithm.SlidingWindow;

import java.util.ArrayList;
import java.util.List;

/* Substring with Concatenation of All Words
Solved
        Hard
Topics
        Companies
You are given a string s and an array of strings words. All the strings of words are of the same length.

A concatenated string is a string that exactly contains all the strings of any permutation of words concatenated.

For example, if words = ["ab","cd","ef"], then "abcdef", "abefcd", "cdabef", "cdefab", "efabcd", and "efcdab" are all concatenated strings. "acdbef" is not a concatenated string because it is not the concatenation of any permutation of words.
Return an array of the starting indices of all the concatenated substrings in s. You can return the answer in any order.



        Example 1:

Input: s = "barfoothefoobarman", words = ["foo","bar"]

Output: [0,9]

Explanation:

The substring starting at 0 is "barfoo". It is the concatenation of ["bar","foo"] which is a permutation of words.
The substring starting at 9 is "foobar". It is the concatenation of ["foo","bar"] which is a permutation of words.

Example 2:

Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]

Output: []

Explanation:

There is no concatenated substring.

        Example 3:

Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]

Output: [6,9,12]

Explanation:

The substring starting at 6 is "foobarthe". It is the concatenation of ["foo","bar","the"].
The substring starting at 9 is "barthefoo". It is the concatenation of ["bar","the","foo"].
The substring starting at 12 is "thefoobar". It is the concatenation of ["the","foo","bar"].



Constraints:

        1 <= s.length <= 104
        1 <= words.length <= 5000
        1 <= words[i].length <= 30
s and words[i] consist of lowercase English letters. */
import java.util.*;
public class SubstringConcante {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ics = new ArrayList<>();

        Map<String, Integer> wc = new HashMap<>();
        for (String word : words)
            wc.merge(word, 1, Integer::sum);

        var wl = words[0].length();
        var numOfWords = words.length;
        for (int i = 0; i < wl; i++) {
            var wli = new HashMap<String, LinkedList<Integer>>();
            for (
                    int left = i, right = i;
                    right <= s.length() - wl
                            && left <= s.length() - wl * numOfWords;
                    right += wl
            ) {
                var word = s.substring(right, right + wl);
                if (wc.containsKey(word)) {
                    List<Integer> pi = wli.putIfAbsent(word, new LinkedList<Integer>());
                    if (pi != null && pi.size() >= wc.get(word)) {
                        left = Math.max(left, pi.get(0) + wl);
                        pi.removeFirst();
                    }
                    wli.get(word).add(right);
                } else {
                    left = right + wl;
                }
                if ((right - left + wl) / wl == numOfWords)
                    ics.add(left);
            }
        }

        return ics;
    }

    public static void main(String[] args) {

    }
}
