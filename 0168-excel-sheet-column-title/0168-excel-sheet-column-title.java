class Solution {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            int tmp = (n - 1) % 26;
            sb.append((char) ('A' + tmp));

            n = (n - 1) / 26;
        }

        return sb.reverse().toString();
    }
}