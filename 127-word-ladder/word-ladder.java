class Solution {
    static class Pair {
        String word;
        int steps;

        Pair(String word, int steps) {
            this.word = word;
            this.steps = steps;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);

        if(!set.contains(endWord)) return 0;
        
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(beginWord, 1));

        while(!queue.isEmpty()) {
            Pair current = queue.poll();
            String word = current.word;
            int steps = current.steps;

            if(word.equals(endWord)) {
                return steps;
            }

            char[] chars = word.toCharArray();

            for(int i=0; i<chars.length; i++) {
                char original = chars[i];

                for(char ch='a'; ch<='z'; ch++) {
                    chars[i] = ch;
                    String nextWord = new String(chars);

                    if(set.contains(nextWord)) {
                        queue.offer(new Pair(nextWord, steps+1));
                        set.remove(nextWord);
                    }
                }
                chars[i] = original;
            }
        }
        return 0;
    }
}