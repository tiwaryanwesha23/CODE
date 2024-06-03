class Solution {

    public int appendCharacters(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();

        int tIdx = 0;
        for (int i = 0; i < sLen; i++) {
            if (s.charAt(i) == t.charAt(tIdx)) {
                tIdx += 1;
                if (tIdx >= tLen) {
                    return 0;
                }
            }
        }

        return tLen - tIdx;
    }

}