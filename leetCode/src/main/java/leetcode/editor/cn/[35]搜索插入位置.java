package leetcode.editor.cn;
//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
//
// 请必须使用时间复杂度为 O(log n) 的算法。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,3,5,6], target = 5
//输出: 2
// 
//
// 示例 2: 
//
// 
//输入: nums = [1,3,5,6], target = 2
//输出: 1
// 
//
// 示例 3: 
//
// 
//输入: nums = [1,3,5,6], target = 7
//输出: 4
// 
//
// 示例 4: 
//
// 
//输入: nums = [1,3,5,6], target = 0
//输出: 0
// 
//
// 示例 5: 
//
// 
//输入: nums = [1], target = 0
//输出: 0
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 104 
// -104 <= nums[i] <= 104 
// nums 为无重复元素的升序排列数组 
// -104 <= target <= 104 
// 
// Related Topics 数组 二分查找 
// 👍 1408 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
// https://mp.weixin.qq.com/s/fCf5QbPDtE6SSlZ1yh_q8Q
/**
 * 有序数组
 * 1. 目标在所有元素之前
 * 2. 目标等于元素
 * 3. 目标插入元素之间
 * 4. 目标在所有元素之后
 */

// 暴力解法
//class Solution {
//    public int searchInsert(int[] nums, int target) {
//        for (int i = 0; i < nums.length; i++) {
//           // 1，2，3
//            if (nums[i] >= target) {
//                return i;
//            }
//        }
//        //4
//        return  nums.length;
//    }
//}


class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        // 左闭右闭区间
        int right = nums.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] < target) {
                left = middle + 1;
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else if (nums[middle] == target) {
                return middle;
            }
        }
        return right + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
