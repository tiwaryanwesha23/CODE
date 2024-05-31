class Solution {
    public int[] singleNumber(int[] nums) {
        HashSet<Integer> visited = new HashSet();
        for(int n : nums){
            if(!visited.add(n)){
                visited.remove(n);
            }
        }
        int[] ans = new int[visited.size()];
        int idx = 0;
        for(int n : visited){
            ans[idx++] = n;
        }
        return ans;
    }
}