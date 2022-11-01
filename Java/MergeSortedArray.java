
public class MergeSortedArray {
    public void merge_wrong(int[] nums1, int m, int[] nums2, int n) {
        
        int index = m+n-1;
     
            while(n-1>=0) {
                if(n-1 >=0 && nums1[m-1] < nums2[n-1]) {
                    nums1[index] = nums2[n-1];
                }
                else {
                    nums1[index] = nums1[m-1];
                }
                n--;
                index--;
                m--;
            }
    }

    public void merge_correct(int[] nums1, int m, int[] nums2, int n) {
        int index = m+n-1;
            while(n-1>=0) {
                if(m-1 >=0 && nums1[m-1] > nums2[n-1]) {
                    nums1[index] = nums1[m-1];
                    index--;
                    m--;
                }
                else {
                    nums1[index] = nums2[n-1];
                    index--;
                    n--;
                }
            }
    }

    public void merge_clean_up(int[] nums1, int m, int[] nums2, int n) {
        int index = m+n-1;
        int nums1_idx = m-1;
        int nums2_idx = n-1;
            while(nums2_idx>=0) {
                if(nums1_idx >=0 && nums1[nums1_idx] > nums2[nums2_idx]) {
                    nums1[index--] = nums1[nums1_idx--];
                }
                else {
                    nums1[index--] = nums2[nums2_idx--];
                }
            }
    }
}


