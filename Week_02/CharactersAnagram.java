package com.carol.practice.geekbang.week2;

import java.util.HashMap;
import java.util.Map;

public class CharactersAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] characters = new int[26];
        for (int i = 0; i < s.length(); i++) {
            characters[s.charAt(i) - 'a']++;
            characters[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (characters[i] != 0) {
                return false;
            }
        }

        return true;
    }


    //处理字符串中带有Unicode字符的情况
    public static boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Integer, Integer> charactersMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Integer svalues = charactersMap.get((int)s.charAt(i));
            int svalue = svalues != null ? svalues : 0;
            svalue++;
            charactersMap.put((int)s.charAt(i), svalue);

            Integer tvalues = charactersMap.get((int)t.charAt(i));
            int tvalue = tvalues != null ? tvalues : 0;
            tvalue--;
            charactersMap.put((int)t.charAt(i), tvalue);
        }

        for (Integer i:
                charactersMap.values()
        ) {
            if(i != 0) {
                return false;
            }
        }

        return true;
    }

    public static boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> charactersMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Integer svalues = charactersMap.get(s.charAt(i));
            int svalue = svalues != null ? svalues : 0;
            svalue++;
            charactersMap.put(s.charAt(i), svalue);

            Integer tvalues = charactersMap.get(t.charAt(i));
            int tvalue = tvalues != null ? tvalues : 0;
            tvalue--;
            charactersMap.put(t.charAt(i), tvalue);
        }

        for (Integer i:
                charactersMap.values()
        ) {
            if(i != 0) {
                return false;
            }
        }

        return true;
    }
}
