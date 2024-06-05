class Solution {
  public List<String> commonChars(String[] A) {
    int[] base = new int[26];
    for (char c: A[0].toCharArray()) {
      base[c - 'a']++;
    }
    for (int i = 1; i < A.length; i++) {
      int[] temp = new int[26];
      for (char c: A[i].toCharArray()) {
        temp[c - 'a']++;
      }
      for (int j = 0; j < 26; j++) {
        base[j] = Math.min(temp[j], base[j]);
      }
    }
    List<String> ans = new ArrayList<>();
    for (int i = 0; i < 26; i++) {
      if (base[i] > 0) {
        for (int j = 0; j < base[i]; j++) {
          ans.add(Character.toString((char) ('a' + i)));
        }
      }
    }
    return ans;
  }
}