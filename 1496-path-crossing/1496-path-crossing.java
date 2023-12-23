class Solution {
    public boolean isPathCrossing(String path) {
        int x = 0;
        int y = 0;
        Set<String> set = new HashSet();
        String key = x + "$" + y;
        set.add(key);
        
        for(char c : path.toCharArray()) {
            if(c == 'N') y++;
            else if(c == 'S') y--;
            else if(c == 'E') x++;
            else x--;
            key = x  + "$" + y;
            if(set.contains(key))
                return true;
            set.add(key);
        }
        
        return false;
    }
}