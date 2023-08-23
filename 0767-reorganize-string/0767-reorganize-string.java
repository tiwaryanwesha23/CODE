class Solution {
    public String reorganizeString(String S) {
        if (S == null || S.length() == 0) return "";

        Map<Character, Letter> map = new HashMap<>();
        for (char c : S.toCharArray()) {
            map.putIfAbsent(c, new Letter(c, 0));
            map.get(c).count += 1;
            if (map.get(c).count > (S.length() + 1) / 2) return "";
        }

        PriorityQueue<Letter> pq = new PriorityQueue<>((a, b) -> (b.count - a.count));
        pq.addAll(map.values());

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            int k = 2; // two slots to fill
            Queue<Letter> buffer = new LinkedList<>();
            while (k > 0 && !pq.isEmpty()) {
                Letter letter = pq.poll();
                sb.append(letter.c);
                letter.count -= 1;
                if (letter.count > 0) buffer.offer(letter);
                k--;
            }
            
            pq.addAll(buffer);
        }
        return sb.length() == S.length() ? sb.toString() : "";
    }
    
    class Letter {
        char c;
        int count;
        public Letter(char c, int count) {
            this.c = c;
            this.count = count;
        }
    }
}

