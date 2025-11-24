package Strings;

import java.util.HashMap;
import java.util.Map;

public class Charfreq {
    Map<Character, Integer> charFrequency(String str) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : str.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        return frequencyMap;
    }
    public static void main(String[] args) {
        Charfreq cf = new Charfreq();
        String str = "hello world";
        Map<Character, Integer> frequencyMap = cf.charFrequency(str);
        System.out.println("Character frequencies: " + frequencyMap);
    }
}
