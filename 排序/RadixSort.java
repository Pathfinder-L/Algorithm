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
        //计算最大值有几位数
        int maxLength = (max+"").length();
        //用来存放临时排序的数组
        int[][] bucket = new int[10][arr.length];
        //用来存放排序数组在某个值下面的位置
        int[] bucketElementCount = new int[10];
        //根据最大长度数，决定比较次数
        for (int i = 0 ,n = 1 ; i < maxLength ; i++,n*=10) {
            //把每一个数字分别计算余数
            for (int j = 0; j < arr.length ; j++) {
                int value = arr[j]/n % 10;
                //把当前遍历的数组，放到指定的位置
                bucket[value][bucketElementCount[value]] = arr[j];
                //该位置加一，为下一个值进来做准备
                bucketElementCount[value]++;
            }
            //记录arr的位置
            int index = 0;
            //遍历取出第n次排序的值，等于0的不需要取
            for (int j = 0; j < bucketElementCount.length ; j++) {
                if (bucketElementCount[j]!=0){
                    //遍历取出数据并放到用来的arr中
                    for (int k = 0; k < bucketElementCount[j]; k++) {
                        arr[index] = bucket[j][k];
                        index++;
                    }
                }
                //把数量置为零，因为还有n轮
                bucketElementCount[j] = 0;
            }
        }
        //把排序好的arr重新加上减去的值
        if (min<0){
            for (int i = 0; i < arr.length ; i++) {
                arr[i] += min;
            }
        }
    }
}
