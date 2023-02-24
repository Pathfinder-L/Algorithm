package 算法第四版.排序;

import java.util.Arrays;

/*
 * TODO
 *  @version 1.0
 *  @author Administrator
 *  @date   2023/2/22 22:10
 *
 * */
// 基数排序
public class RadixSort
{
    public void  sort(int[] arr){
        //最大值，用来计算需要找多少次。
        int max = Integer.MIN_VALUE;
        //用来判断是否是负数
        int min = Integer.MAX_VALUE;
        //从该数组中找到最大，最小值
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        //如果最小值小于0，那么把每个数都减去最小值，这样可以保证最小的数是0
        if (min<0) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] -= min;
            }
            //max也要处理！
            max -= min;
        }

        int maxLength = (max+"").length();
        int[][] bucket = new int[10][arr.length];
        int[] bucketElementCount = new int[10];
        for (int i = 0 ,n = 1 ; i < maxLength ; i++,n*=10) {
            for (int j = 0; j < arr.length ; j++) {
                int value = arr[j]/n % 10;
                bucket[value][bucketElementCount[value]] = arr[j];
                bucketElementCount[value]++;
            }
            int index = 0;
            for (int j = 0; j < bucketElementCount.length ; j++) {
                if (bucketElementCount[j]!=0){
                    for (int k = 0; k < bucketElementCount[j]; k++) {
                        arr[index] = bucket[j][k];
                        index++;
                    }
                }
                bucketElementCount[j] = 0;
            }
        }
        if (min<0){
            for (int i = 0; i < arr.length ; i++) {
                arr[i] += min;
            }
        }
    }
}
