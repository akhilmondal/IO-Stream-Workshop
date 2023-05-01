package com.workshop;

public class Solution {
    static int[] index = new int[2];
    static int[] match = new int[3];

    public static void indexSolution(int[] array, int target) {

        for (int i = 0; i< array.length; i ++) {
            for (int j = i+1; j< array.length; j++ ){
                int value = array[i] + array[j];
                if (value == target){
                    index[0]=i;
                    index[1]=j;
                }
            }
        }
    }
    public static boolean isPresent(String toCheck,String target) {
        int count = 0;
        String[] toCheckArray= toCheck.split("");
        String[] targetArray = target.split("");
        System.out.println("length"+toCheckArray.length);

        for (int i = 0; i< toCheckArray.length; i++) {
            for (int j = 0; j< targetArray.length; j++) {
                System.out.println(toCheckArray[i]+" "+targetArray[j]);
                if (toCheckArray[i].equals(targetArray[j])) {
                    match[i] = 1;
                    count++;
                    break;
                }
            }
        }
        System.out.println("count"+count);
        int checker = toCheckArray.length;
        System.out.println(checker);
        System.out.println(match[0]+"+"+match[1]+match[2]);
        int addition=0;
        for (int a = 0;a< match.length; a++) {
            addition = addition + match[a];
        }
        System.out.println(addition);
        if (addition == 3) {
            return true;
        }
        return false;
    }
    public static void main(String[] args) {

//        int[] arr= {1,2,3,4,5,6};
//        int target = 6;
//        indexSolution(arr,target);
//        System.out.print("The index of the two numbers are: ");
//        System.out.println("[ "+index[0] +","+index[1] +" ]");
        boolean result = isPresent("abc","abhsdc");
        if (result) {
            System.out.println("Is Present:" +result);
        } else {
            System.out.println("Not Present: " +result);
        }
    }
}
//Input: toCheck = "abc", target = "ahbgdc"
//        Output: true
//        Example 2:
//
//        Input: toCheck = "axc", target = "ahbgdc"
//        Output: false
//
//class Solution {
//    public boolean isPresent(String s, String t) {
//
//    }
//
//}

//Input: nums = [2,7,11,15], target = 9
//        Output: [0,1]
//
//        Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
//
//class Solution {
//    public int[] twoSum(int[] nums, int target) {
//
//    }
//}