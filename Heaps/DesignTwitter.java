/*
Pattern: HashMap + PriorityQueue + HashSet

Time: O(T log T) for getNewsFeed
Space: O(T)

Idea:
Store each user's tweets in a max-heap ordered by timestamp.
Store follow relationships using a HashSet.
For getNewsFeed, merge tweets from the user and all followees into
a temporary max-heap and extract the 10 most recent tweets.
*/

class Node{
    int tweetId;
    int timestamp;
    Node(int tweetId, int timestamp){
        this.tweetId=tweetId;
        this.timestamp=timestamp;
    }
}

class Twitter {
    HashMap<Integer, PriorityQueue<Node>> map1;
    HashMap<Integer, HashSet<Integer>> map2;
    PriorityQueue<Node> pq;
    HashSet<Integer> set;
    int timestamp;
    public Twitter() {
        map1=new HashMap<>();
        map2=new HashMap<>();
        timestamp=0;
    }
    
    public void postTweet(int userId, int tweetId) {
        timestamp++;
        if(map1.containsKey(userId)){
            Node node=new Node(tweetId, timestamp);
            map1.get(userId).offer(node);
        }
        else{
            pq=new PriorityQueue<>(
                (a,b) -> b.timestamp-a.timestamp
            );
            Node node=new Node(tweetId, timestamp);
            pq.offer(node);
            map1.put(userId, pq);
        }
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> list=new ArrayList<>();
        PriorityQueue<Node> temp=new PriorityQueue<>(
            (a,b) -> b.timestamp-a.timestamp
        );
        if(map1.containsKey(userId)){
            temp.addAll(map1.get(userId));
        }
        if(map2.containsKey(userId)){
            for(int x:map2.get(userId)){
                if(map1.containsKey(x)){
                    temp.addAll(map1.get(x));
                }
            }
        }
        for(int i=0; i<10; i++){
            if(temp.isEmpty()){
                break;
            }
            list.add(temp.poll().tweetId);
        }
        return list;
    }
    
    public void follow(int followerId, int followeeId) {
        if(map2.containsKey(followerId)){
            map2.get(followerId).add(followeeId);
        }
        else{
            set=new HashSet();
            set.add(followeeId);
            map2.put(followerId, set);
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(map2.containsKey(followerId)){
            if(map2.get(followerId).contains(followeeId)){
                map2.get(followerId).remove(followeeId);
            }  
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */