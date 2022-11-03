package leetcode.hot100;

import java.util.*;

public class LetterCombinations {
    public static Map<Character, String> map = new HashMap<>();

    static {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }


    public static void main(String[] args) {
        char a = 'a';  // 97 98 99 ----> 2
        char d = 'd';  // 100 101 102 ----> 3
        System.out.println((char) (a + 1));
        String digits = "234";
        List<String> list = new LetterCombinations().letterCombinations(digits);
        System.out.println(Arrays.toString(list.toArray()));

    }

    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            char num = digits.charAt(i);
            String s = map.get(num);
            if (list.isEmpty()) {
                for (int j = 0; j < s.length(); j++) {
                    list.add("" + s.charAt(j));
                }
//                System.out.println(list.size());
            } else {
                List<String> listNew = new ArrayList<>();
                for (int j = 0; j < s.length(); j++) {
                    for (String temp : list) {
                        listNew.add(temp + s.charAt(j));
                    }
                }
                list = listNew;
            }
//            System.out.println(s + ", " + Arrays.toString(list.toArray()));
        }
        return list;
    }


}