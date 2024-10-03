package leetcode.patterns.overlapping.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//57. Insert Interval
//You are given an array of non-overlapping intervals
// where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti.
// You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
//
//Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals
// still does not have any overlapping intervals (merge overlapping intervals if necessary).
//
//Return intervals after the insertion.
//Note that you don't need to modify intervals in-place. You can make a new array and return it.
//Example 1:
//
//Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
//Output: [[1,5],[6,9]]
//Example 2:
//
//Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
//Output: [[1,2],[3,10],[12,16]]
//Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
public class InsertNewInterval {
    //a. add the new interval to the existing intervals array
    //b. sort the intervals start time in asc order.
    //c. create a new empty merged list
    //d. now evaluate the newInterval - if the previous interval endTime is less than current interval startTime then add the new interval to the merged list
    //e. if not, merge the new interval with the previous interval - update the endTime of the previous interval.


    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> intervalsList = new ArrayList<>(Arrays.asList(intervals));
        intervalsList.add(newInterval);

        intervalsList.sort(Comparator.comparingInt(value -> value[0]));
        List<int[]> mergedIntervals = new ArrayList<>();

        for (int i = 0; i< intervalsList.size(); i++) {
            if(mergedIntervals.size()==0 || mergedIntervals.get(mergedIntervals.size()-1)[1]< intervalsList.get(i)[0]) {
                mergedIntervals.add(intervalsList.get(i));
            } else {
                int endTime = Math.max(mergedIntervals.get(mergedIntervals.size()-1)[1],intervalsList.get(i)[1] );
                mergedIntervals.get(mergedIntervals.size()-1)[1] = endTime;
            }
        }
        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }

    public static void main(String[] args) {
        int[][] inputIntervals = new int[][] {
                {1,3}
                ,{6,9}
        };
        int[] newInterval = new int[]{2,5};
        int[][] result = insert(inputIntervals,newInterval );
        System.out.println("Consolidated intervals "+ result.length);
    }
}
