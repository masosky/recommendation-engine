package com.buttons;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        FileParser fileParser = ApplicationInjector.getInjector().getInstance(FileParser.class);
        fileParser.parseFile();

        System.out.println("Question 1:");
        Cache cache = ApplicationInjector.getInjector().getInstance(Cache.class);
        LinkedHashMap<String, Integer> userTimes = cache.getUserTimesMap("ff0d3fb21c00bc33f71187a2beec389e9eff5332");
        System.out.println(userTimes);
        System.out.println("Tags: ");
        Set<String> strings = userTimes.keySet();
        for(String userId: strings) {
            LinkedHashSet<String> tags = cache.visitedTags(userId);
            System.out.println(tags.toArray()[0]);
        }

    }
}
