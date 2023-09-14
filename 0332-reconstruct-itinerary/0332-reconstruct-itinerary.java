class Solution {
    int n = 0;
    public List<String> findItinerary(List<List<String>> tickets) {
        
        List<String> rst = new LinkedList<>();
        Set<String> citySet = new HashSet<>();
        Map<String, List<String>> map = buildMap(tickets);
        n = tickets.size();
        rst.add("JFK");
        dfs(rst, map, "JFK");
        return rst;
    }
    
    private boolean dfs(List<String> list, Map<String, List<String>> map, String curr) {
        if (list.size() == n + 1) return true;
        if (!map.containsKey(curr)) return false;
        List<String> destinations = map.get(curr);
        for (int i = 0; i < destinations.size(); i++) {
            String next = destinations.get(i);
            destinations.remove(i);
            list.add(next);

            if (dfs(list, map, next)) return true;

            // backtrack
            destinations.add(i, next);
            list.remove(list.size() - 1);
        }
        return false;
    }
    
    private Map<String, List<String>> buildMap(List<List<String>> tickets) {
        Map<String, List<String>> map = new HashMap<>();
        for (List<String> ticket : tickets) {
            map.putIfAbsent(ticket.get(0), new LinkedList<>());
            map.get(ticket.get(0)).add(ticket.get(1));
        }
        for (String key : map.keySet()) Collections.sort(map.get(key));
        return map;
    }
}
