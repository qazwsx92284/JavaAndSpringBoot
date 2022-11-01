

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementInArr {
        public int findKthLargest__fastest(int[] nums, int k) {
            // --k to go from the range [1, nums.length] to the range [0, nums.length - 1]
            return select(nums, 0, nums.length - 1, --k);
        }
        
        private static int select(int[] nums, int left, int right, int k) {
            while(left != right) {
                int pivotIndex = partition(nums, left, right, left + (right - left) / 2);
                if(k == pivotIndex) {
                    return nums[k];
                } else if(k < pivotIndex) {
                    right = pivotIndex - 1;
                } else {
                    left = pivotIndex + 1;
                }
            }
            
            return nums[left];
        }
        
        private static int partition(int[] nums, int left, int right, int pivotIndex) {
            int pivot = nums[pivotIndex];
            swap(nums, pivotIndex, right);
            int storeIndex = left;
            for(int i = left; i < right; ++i) {
                // Swap only if greater instead of lower (kth largest vs kth smallest)
                if(nums[i] > pivot) {
                    swap(nums, storeIndex, i);
                    ++storeIndex;
                }
            }
            swap(nums, right, storeIndex);
            return storeIndex;
        }
        
        private static void swap(int[] arr, int i, int j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }

        public int findKthLargest__easyToUnderstanc(int[] nums, int k) {
            Queue<Integer> pq = new PriorityQueue<>();
            for(int num : nums) {
                pq.offer(num);
                if(pq.size()>k) pq.poll();
            }
            return pq.peek();
        }
    }

