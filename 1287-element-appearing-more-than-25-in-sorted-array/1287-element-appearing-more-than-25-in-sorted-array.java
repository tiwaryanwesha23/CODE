class Solution {
    public int findSpecialInteger(int[] arr) {
        int result = arr[0];
        int i = 0;
        int cnt = 0;
        while (i < arr.length){
            cnt = 0;
            while (arr[i] == result){
                cnt ++;
                if(cnt >= arr.length / 4 + 1){
                    return result;
                }
                i++;
            }
            result = arr[i];
        }
        return result;
    }
}