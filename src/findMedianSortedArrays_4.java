//Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
//
//The overall run time complexity should be O(log (m+n)).
//
//
//
//Example 1:
//
//Input: nums1 = [1,3], nums2 = [2]
//Output: 2.00000
//Explanation: merged array = [1,2,3] and median is 2.
//Example 2:
//
//Input: nums1 = [1,2], nums2 = [3,4]
//Output: 2.50000
//Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.

public class findMedianSortedArrays_4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Variables
        int[] mArr = new int[nums1.length + nums2.length]; // array that will hold the merged values

        // external iterators initially to make things easier to understand
        int itr = 0; //counter for mArr
        int iItr = 0; //counter for nums1
        int jItr = 0; //counter for nums2
        boolean notFullyCounted = true;

        // merge both arrays
        // loop will end when all numbers have been added to new array
        while (notFullyCounted) {
            //if either iterators are less than their lengths
            if (nums1.length > iItr || nums2.length > jItr) {
                // null check
                // Checking if either list is at end of iterator
                if (nums1.length-1 < iItr) { // if nums1 is at end of list
                    mArr[itr] = nums2[jItr];
                    // advance the iterator in the array we added the lower number from
                    itr++;
                    jItr++;
                } else if (nums2.length-1 < jItr) { // if nums 2 is at end of list
                    mArr[itr] = nums1[iItr];
                    // advance the iterator in the array we added the lower number from
                    itr++;
                    iItr++;
                } else {
                    // interleave the arrays by checking whats the lower number between arrays
                    // add the lower number
                    if (nums1[iItr] < nums2[jItr]) { //if they are equal it doesn't matter which one we pick first
                        mArr[itr] = nums1[iItr];
                        // advance the iterator in the array we added the lower number from
                        itr++;
                        iItr++;
                    } else {
                        mArr[itr] = nums2[jItr];
                        // advance the iterator in the array we added the lower number from
                        itr++;
                        jItr++;
                    }
                }
            } else {
                notFullyCounted = false;
                //End loop here
            }
        }
        // find median of the merged array
        // take array length and divide by two
        // check if array is odd or even
        if ((mArr.length) % 2 == 0){ // if even
            // take two most middle numbers and average them
            return (((double)mArr[(mArr.length / 2)] + (double)mArr[(mArr.length / 2) - 1]) / 2 );
        } else { // odd
            // take the middle number which would be array/2
            return mArr[(mArr.length/2)];
        }
    }
}
