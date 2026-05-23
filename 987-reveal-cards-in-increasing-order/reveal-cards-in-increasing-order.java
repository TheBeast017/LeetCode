class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        Queue<Integer> q = new LinkedList<>();
        int n = deck.length;
        for (int i = 0; i < n; i++) q.offer(i);

        int[] res = new int[n];

        for (int card : deck) {
            res[q.poll()] = card;
            if (!q.isEmpty()) q.offer(q.poll());
        }

        return res;
    }
}