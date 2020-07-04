package com.carol.practice.geekbang.week2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * 核心思想：字母异位字符串转唯一字符串和HashMap
 */
public class GroupCharacterAnagram {
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            boolean ok = false;
            for ( int j = 0; j < result.size(); j++) {
                if(isAnagram(strs[i], result.get(j).get(0))) {
                    result.get(j).add(strs[i]);
                    ok = true;
                    break;
                }
            }

            if(ok == false) {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                result.add(list);
            }

        }

        return result;
    }

    public static List<List<String>> groupAnagrams1(String[] strs){
        if (strs.length == 0) {
            return new ArrayList<>();
        }
        //利用字符串，找到一个唯一值作为HashMap的key
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0;i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String str = String.valueOf(chars);
            if(!map.containsKey(str)){
                map.put(str, new ArrayList<String>());
            }
            map.get(str).add(strs[i]);
        }

        return new ArrayList<>(map.values());
    }


    public static List<List<String>> groupAnagrams2(String[] strs){
        if (strs.length == 0) {
            return new ArrayList<>();
        }
        //利用字符串，找到一个唯一值作为HashMap的key
       Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String key = createKey(strs[i]);
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<String>());
            }

            map.get(key).add(strs[i]);
        }

        return new ArrayList(map.values());
    }


    /**
     * @param s 不能包含Unicode字符
     * @return
     */
    private static String createKey(String s){
        int[] count = new int[26];
        Arrays.fill(count, 0);
        for (int i = 0; i < s.length(); i++){
            count[s.charAt(i) - 'a']++;
        }

        StringBuffer sb = new StringBuffer();
        sb.append("#");
        for (int i = 0; i < count.length; i++){
            sb.append(count[i]);
            sb.append("#");
        }

        return sb.toString();
    }

    private static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Integer sValueObj = map.get(s.charAt(i));
            int sValue = sValueObj == null ? 0 : sValueObj;
            sValue++;
            map.put(s.charAt(i), sValue);

            Integer tValueObj = map.get(t.charAt(i));
            int tValue = tValueObj == null ? 0 : tValueObj;
            tValue--;
            map.put(t.charAt(i), tValue);
        }

        for(Integer i : map.values()) {
            if ( i != 0) {
                return false;
            }
        }

        return true;
    }
}
