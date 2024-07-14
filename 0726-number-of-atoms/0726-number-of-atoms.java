class Solution {
    public String countOfAtoms(String formula) {
        Stack<Map<String, Integer>> s = new Stack<Map<String, Integer>>();
        s.push(new HashMap<String, Integer>());
        int p = 0;
        while (p < formula.length()) {
            if (formula.charAt(p) == '(') {
                s.push(new HashMap<String, Integer>());
                p += 1;
            } else if (formula.charAt(p) == ')') {
                p += 1;
                int cur_cnt;
                if (p < formula.length() && Character.isDigit(formula.charAt(p))) {
                    cur_cnt = 0;
                    while (p < formula.length() && Character.isDigit(formula.charAt(p))) {
                        cur_cnt = cur_cnt * 10 + (formula.charAt(p) - '0');
                        p += 1;
                    }
                } else {
                    cur_cnt = 1;
                }
                Map<String, Integer> cur_ans = s.pop();
                for (Map.Entry<String, Integer> cur_ans_item : cur_ans.entrySet()) {
                    s.peek().put(cur_ans_item.getKey(), s.peek().getOrDefault(cur_ans_item.getKey(), 0) + cur_ans_item.getValue() * cur_cnt);
                }
            } else {
                String cur_element = "";
                cur_element += formula.charAt(p);
                p += 1;
                while (p < formula.length() && Character.isLowerCase(formula.charAt(p))) {
                    cur_element += formula.charAt(p);
                    p += 1;
                }
                int cur_cnt;
                if (p < formula.length() && Character.isDigit(formula.charAt(p))) {
                    cur_cnt = 0;
                    while (p < formula.length() && Character.isDigit(formula.charAt(p))) {
                        cur_cnt = cur_cnt * 10 + (formula.charAt(p) - '0');
                        p += 1;
                    }
                } else {
                    cur_cnt = 1;
                }
                s.peek().put(cur_element, s.peek().getOrDefault(cur_element, 0) + cur_cnt);
            }
        }
        List<String> info = new ArrayList<String>();
        for (String cur_info : s.peek().keySet()) {
            info.add(cur_info);
        }
        Collections.sort(info);
        String ans = "";
        for (String cur_info : info) {
            ans += cur_info;
            int cur_cnt = s.peek().get(cur_info);
            if (cur_cnt != 1) {
                ans += String.valueOf(cur_cnt);
            }
        }
        return ans;
    }
}