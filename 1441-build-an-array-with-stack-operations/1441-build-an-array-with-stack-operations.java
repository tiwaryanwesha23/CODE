
class Solution {

    private static final String PUSH = "Push";
    private static final String POP = "Pop";

    public List<String> buildArray(int[] target, int n) {
        List<String> l = new LinkedList<>();
        int preTarget = 0;

        for (int t : target) {
            l.add(PUSH);

            int diff = t - preTarget;
            if (diff != 1) {
                for (int i = 0; i < diff - 1; i++) {
                    l.add(POP);
                    l.add(PUSH);
                }
            }

            preTarget = t;
        }

        return l;
    }
}