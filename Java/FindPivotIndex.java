public class FindPivotIndex {
    public int pivotIndex_my_solution(int[] nums) {
        int totalSum = 0;
        for(int i=0; i<nums.length; i++) {
            totalSum += nums[i];
        }
        
        int leftSum = 0;
        int rightSum = totalSum-nums[0];
        if(leftSum == rightSum){
            return 0;
        }
        for(int i=1; i<nums.length; i++) {
            leftSum  += nums[i-1];
            rightSum  = totalSum - nums[i] - leftSum;
            if(leftSum == rightSum) {
                return i;
            }
        }
        return -1;
    }

    public int pivotIndex_cleanupmycodeabit(int[] nums) {
        int totalSum = 0;
        for(int i=0; i<nums.length; i++) {
            totalSum += nums[i];
        }
        
        int leftSum = 0;
        int rightSum;
        
        for(int i=0; i<nums.length; ++i) {
            rightSum  = totalSum - nums[i] - leftSum;
            if(leftSum == rightSum) {
                return i;
            }
            leftSum  += nums[i];
        }
        return -1;
    }

    public int pivotIndex(int[] nums) {
        int sum = 0, leftsum = 0;
        for (int x: nums) sum += x;
        for (int i = 0; i < nums.length; ++i) {
            if (leftsum == sum - leftsum - nums[i]) return i;
            leftsum += nums[i];
        }
        return -1;
    }
}
