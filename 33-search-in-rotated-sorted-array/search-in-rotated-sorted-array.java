class Solution {
    int search(int[] nums, int target) {  
        int pivot = pivotsearch(nums);  
        if (pivot == -1) {  
            return BinarySearch(nums, 0, nums.length - 1, target);  
        }  
        
        if (nums[pivot] == target) {  
            return pivot;  
        }   
        
        if (target >= nums[0]) {  
            return BinarySearch(nums, 0, pivot - 1, target);  
        }  
        
        return BinarySearch(nums, pivot + 1, nums.length - 1, target);  
    }  

    int BinarySearch(int[] arr, int start, int end, int target) {  
        while (start <= end) {  
            int mid = start + (end - start) / 2;  
            if (arr[mid] == target) {  
                return mid;  
            }  
            if (arr[mid] > target) {  
                end = mid - 1;  
            } else {  
                start = mid + 1;  
            }  
        }  
        return -1; // Target not found  
    }  

    int pivotsearch(int[] arr) {  
        int start = 0;  
        int end = arr.length - 1;  

        while (start <= end) {  
            int mid = start + (end - start) / 2;  
            if (mid < end && arr[mid] > arr[mid + 1]) {  
                return mid; // Pivot found  
            }  
            if (mid > start && arr[mid] < arr[mid - 1]) {  
                return mid - 1; // Pivot found  
            }  
            if (arr[mid] >= arr[start]) {  
                start = mid + 1; // Move right  
            } else {  
                end = mid - 1; // Move left  
            }  
        }  
        return -1; // No pivot found, array is not rotated  
    }  
}