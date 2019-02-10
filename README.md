# recommendation-engine

Simple program that reads a csv and caches the information.

## Cache
Contains
   
Map<TagId, LinkedHashMap<User, Times>>
```
Map<String, LinkedHashMap<String, Integer>> tagMap
```
Map<UserId, Set<TagId>
```
Map<String, LinkedHashSet<String>> userMap
```

The problem is that this cache has a duplication of information but give access O(1) for a lot of queries

## Tests
No tests added
