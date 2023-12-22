class Solution {
public:
    int maxScore(string s) {
        int zeros = 0, ones = 0, ans = INT_MIN;
        int n = s.size();
        /*
        ans 
        = max(lZero+rOne)
        = max(lZero+totalOne-lOne)
        = max(lZero-lOne) + totalOne
        */
        for(int i = 0; i < n; i++){
            if(s[i] == '0') zeros++;
            else ones++;
            /*
            there should be at least one char in the right part,
            so don't update ans in the last iteration
            */
            if(i != n-1) ans = max(ans, zeros-ones);
        }
        
        return ans + ones;
    }
};