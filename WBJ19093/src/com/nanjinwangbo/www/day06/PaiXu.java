package com.nanjinwangbo.www.day06;

public class PaiXu {
    public static void main(String[] args) {
        int[] nums = {5, 3, 1, 4, 2};
        //???????
        for (int i = 0; i < nums.length - 1; i++) {//????????
            for (int j = 0; j < nums.length - i - 1; j++) {//?????????б??????
                if (nums[j] < nums[j + 1]) {//????????????? < ??С????  >???С??j???j+1???
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;//??λ????
                }
            }
        }
        for (int i : nums) {
            System.out.print(i + ",");
        }
        //????????   ???2.0
        //??????????а???????????
        //????????
    }
}
