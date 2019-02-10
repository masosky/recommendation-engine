package com.buttons;

import com.google.inject.Singleton;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;

@Singleton
public final class Cache {

    private static Map<String, LinkedHashMap<String, Integer>> tagMap = new HashMap<>();
    //Map<TagId, LinkedHashMap<User, Times>>

    private static Map<String, LinkedHashSet<String>> userMap = new HashMap<>();
    //Map<UserId, Set<TagId>

    public void addVisit(String tag, String userId) {
        addTag(tag, userId);
        addUser(userId, tag);
    }

    public LinkedHashMap<String, Integer> getUserTimesMap(String tagId) {
        return tagMap.get(tagId);
    }

    public LinkedHashSet<String> visitedTags(String userId) {
        return userMap.get(userId);
    }

    private void addTag(String tagId, String userId) {
        if (tagMap.containsKey(tagId)) {
            LinkedHashMap<String, Integer> userTimes = tagMap.get(tagId);
            if (userTimes.containsKey(userId)) {
                userTimes.compute(userId, (k, v) -> v + 1);
            } else {
                userTimes.put(userId, 1);
            }

        } else {
            LinkedHashMap<String, Integer> userTimes = new LinkedHashMap<>();
            userTimes.put(userId, 1);
            tagMap.put(tagId, userTimes);
        }
    }

    private void addUser(String userId, String tag) {
        if (userMap.containsKey(userId)) {
            userMap.compute(userId, (k, v) -> {
                v.add(tag);
                return v;
            });
        } else {
            LinkedHashSet<String> tags = new LinkedHashSet<>();
            tags.add(tag);
            userMap.put(userId, tags);
        }
    }

}
