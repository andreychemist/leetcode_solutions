class Solution {
    public int minScore(int n, int[][] roads) {
        int min = Integer.MAX_VALUE;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] r : roads) {
            List<Integer> l1 = map.computeIfAbsent(r[0], k -> new ArrayList<>());
            l1.add(r[1]);
            l1.add(r[2]);
            List<Integer> l2 = map.computeIfAbsent(r[1], k -> new ArrayList<>());
            l2.add(r[0]);
            l2.add(r[2]);
        }
        boolean[] seen = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        seen[1] = true;
        while (!q.isEmpty()) {
            int k = q.poll();
            List<Integer> list = map.get(k);
                for (int j = 0; j < list.size() - 1; j += 2) {
                    min = Math.min(min, list.get(j + 1));
                    int t = list.get(j);
                    if (!seen[t]) {
                        System.out.println("k = " + k + "; t = " + t);
                        q.offer(t);
                        seen[t] = true;
                    }
                }
        }
        return min;
    }
}