package com.bliznichenka.heappriorityqueue.designtwitter_355;

import javafx.util.Pair;

import java.util.*;

class Twitter {
    private final Map<Integer, Set<Integer>> userToFollowees = new HashMap<>();
    private final Map<Integer, List<Pair<Integer, Integer>>> userToTweets = new HashMap<>();
    private int time = 0;

    public void postTweet(int userId, int tweetId) {
        if (!userToTweets.containsKey(userId)) {
            userToTweets.put(userId, new ArrayList<>());
        }
        userToTweets.get(userId).add(new Pair<>(time, tweetId));
        time++;
    }

    public List<Integer> getNewsFeed(int userId) {
        // [time, tweetId, userId, index]
        Queue<List<Integer>> maxHeap = new PriorityQueue<>((l1, l2) -> l2.get(0) - l1.get(0));

        Set<Integer> userIds = new HashSet<>();
        userIds.add(userId);
        userIds.addAll(userToFollowees.getOrDefault(userId, Set.of()));
        for (int followeeId : userIds) {
            List<Pair<Integer, Integer>> tweets = userToTweets.getOrDefault(followeeId, List.of());
            if (!tweets.isEmpty()) {
                int index = tweets.size() - 1;
                Pair<Integer, Integer> tweetInfo = tweets.get(index);
                maxHeap.add(List.of(
                        tweetInfo.getKey(),
                        tweetInfo.getValue(),
                        followeeId,
                        index - 1
                ));
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!maxHeap.isEmpty() && result.size() < 10) {
            List<Integer> polled = maxHeap.poll();
            int tweetId = polled.get(1);
            int followeeId = polled.get(2);
            int nextIndex = polled.get(3);
            result.add(tweetId);
            if (nextIndex >= 0) {
                Pair<Integer, Integer> nextTweetInfo = userToTweets.get(followeeId).get(nextIndex);
                maxHeap.add(List.of(
                        nextTweetInfo.getKey(),
                        nextTweetInfo.getValue(),
                        followeeId,
                        nextIndex - 1
                ));
            }
        }
        return result;
    }

    public void follow(int followerId, int followeeId) {
        if (!userToFollowees.containsKey(followerId)) {
            userToFollowees.put(followerId, new HashSet<>());
        }
        userToFollowees.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        userToFollowees.getOrDefault(followerId, new HashSet<>()).remove(followeeId);
    }
}
