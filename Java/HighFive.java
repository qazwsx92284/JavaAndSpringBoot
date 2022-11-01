

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

public class HighFive {
    private int K;

    public int[][] highFive_usingSorting(int[][] items) {
        this.K = 5;
        Arrays.sort(
                items,
                new Comparator<int[]>() {
                    @Override
                    public int compare(int[] a, int[] b) {
                        if (a[0] != b[0])
                            // item with lower id goes first
                            return a[0] - b[0];
                        // in case of tie for ids, item with higher score goes first
                        return b[1] - a[1];
                    }
                });
        List<int[]> solution = new ArrayList<>();
        int n = items.length;
        int i = 0;
        while (i < n) {
            int id = items[i][0];
            int sum = 0;
            // obtain total using the top 5 scores
            for (int k = i; k < i + this.K; ++k)
                sum += items[k][1];
            // ignore all the other scores for the same id
            while (i < n && items[i][0] == id)
                i++;
            solution.add(new int[] {id, sum / this.K});
        }
        int[][] solutionArray = new int[solution.size()][];
        return solution.toArray(solutionArray);
    }
    /*Time Complexity: Assuming NN is the total number of items, 
    sorting the items takes O(N \log N)O(NlogN) time and traversing the sorted array takes O(N)O(N) time. 
    Hence the overall time complexity of this approach is O(N \log N)O(NlogN).
    Space Complexity: O(N)O(N), the space used by solution. */


    class Solution {
        private int K;
    
        public int[][] highFive(int[][] items) {
            this.K = 5;
            TreeMap<Integer, Queue<Integer>> allScores = new TreeMap<>();
            for (int[] item : items) {
                int id = item[0];
                int score = item[1];
                if (!allScores.containsKey(id))
                    // max heap
                    allScores.put(id, new PriorityQueue<>((a,b) -> b - a));
                // Add score to the max heap
                allScores.get(id).add(score);
            }
    
            List<int[]> solution = new ArrayList<>();
    
            for (int id : allScores.keySet()) {
                int sum = 0;
                // obtain the top k scores (k = 5)
                for (int i = 0; i < this.K; ++i)
                    sum += allScores.get(id).poll();
                solution.add(new int[] {id, sum / this.K});
            }
            int[][] solutionArray = new int[solution.size()][];
            return solution.toArray(solutionArray);
        }
    }

    class Solution3 {
        private int K;
    
        public int[][] highFive(int[][] items) {
            this.K = 5;
            TreeMap<Integer, Queue<Integer>> allScores = new TreeMap<>();
            for (int[] item : items) {
                int id = item[0];
                int score = item[1];
                if (!allScores.containsKey(id))
                    allScores.put(id, new PriorityQueue<>());
                // insert the score in the min heap
                allScores.get(id).add(score);
                // remove the minimum element from the min heap in case the size of the min heap exceeds 5 
                if (allScores.get(id).size() > this.K)
                    allScores.get(id).poll();
            }
    
            List<int[]> solution = new ArrayList<>();
    
            for (int id : allScores.keySet()) {
                int sum = 0;
                // min heap contains the top 5 scores
                for (int i = 0; i < this.K; ++i)
                    sum += allScores.get(id).poll();
                solution.add(new int[] {id, sum / this.K});
            }
            int[][] solutionArray = new int[solution.size()][];
            return solution.toArray(solutionArray);
        }
    }
}

