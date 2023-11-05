class Solution {
public:
    int getWinner(vector<int>& arr, int k) {
        int n = arr.size();
        
        if(k >= n) return *max_element(arr.begin(), arr.end());
        
        int winner = arr[0], win_count = 0;
        for(int i = 1; i < n && win_count < k; ++i){
            if(winner < arr[i]){
                winner = arr[i];
                win_count = 0;
            }
            /*
            either the winner remains the same or changes,
            we need to increase win_count!!
            */
            ++win_count;
        }
        
        return winner;
    }
};