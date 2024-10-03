package leetcode.patterns.top.k.elements;

//You are given an array of meeting time intervals, where each interval is represented as [start, end].
// You need to determine the minimum number of conference rooms required to host all the meetings.
//Example:
//Input: [[0, 30], [5, 10], [15, 20]]
//Output: 2

//understanding.. problem solution
//Meeting1 : [0,30]
//Meeting2 : [5,10]
//Meeting3 : [15,20]

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

//so Meeting 1 will overlap with meeting 2 & 3 - definetly needs MR1 room
// as Meeting 2 and 3 do not overlap - can be use same meeting room i.e MR2 room
// total 2 rooms
public class MeetingRoom {
    //approach - a. sort the meeting times with start time.
    //b. then use minheap to track the end-time of current meeting
    //c  if the start time is greater than or equal to the earliest end time , remove the meeting from heap
    //d. The size of the heap will give the number of rooms required.

    public static int getMeetingRoomCount(int[][] meetingTimes) {
        if(meetingTimes == null) {
            return 0;
        }
        Arrays.sort(meetingTimes, Comparator.comparingInt(a-> a[0]));
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int i = 0; i<meetingTimes.length; i++){
            heap.add(meetingTimes[i][1]);
            if(meetingTimes[i][0] >= heap.peek()){
                heap.poll();
            }
        }
        return heap.size();
    }

    public static void main(String[] args) {
        int[][] in1 = new int[][]{
                {0, 30},
                {15, 20},
                {5, 10}};
        int result = getMeetingRoomCount(in1);
        System.out.println("No. of Rooms - " + result);

        int[][] in2 = new int[][]{
                {5, 30},
                {5, 10},
                {15, 20},
                {25, 30}};
        int result2 = getMeetingRoomCount(in2);
        System.out.println("No. of Rooms - " + result2);
    }

}
