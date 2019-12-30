package com.xiongliang.pratice.Sort;

/**
 * 归并排序原理:  采用分治法, 将已有序列的子序列合并,得到完全有序的序列,即先使每个序列有序,再使子序列段间有序。
 * 递归实现
 * 1) 先对数组进行拆分，一分为二
 * 2）然后对拆分的数组进行合并，合并时,左右数组同起点index 对比，较小的放入tmp数组对应的位置;
 *    依次对比完之后，将剩余的元素移到tmp数组对应位置, 最后将tmp数组元素复制到array数组相应的位置
 * 3) 递归实现上诉步骤
 *
 *
 * https://blog.csdn.net/qq_36442947/article/details/81612870
 * https://blog.csdn.net/weixin_39651041/article/details/80010906
 */
public class MergeSort {
    public void sort(int arr[]){
       mergeSort(arr,0,arr.length-1);
    }

    /***
     * 拆数组
     * @param arr
     * @param left
     * @param right
     */
    public void mergeSort(int arr[],int left,int right){
           if(left < right){
               int middle = (left+right) /2;
               mergeSort(arr,left,middle);  //拆左边
               mergeSort(arr,middle+1,right);  //拆右边
               unionArray(arr,left,middle,right); //合数组
           }
    }

    /**
     * 合并数组
     * 按从小到大排列
     */
    public void unionArray(int array[],int left, int middle, int right){
        int tmp[] = new int[array.length];
        int leftIndex= left;
        int rightIndex = middle + 1;
        int tmpIndex = left;

        while(leftIndex <= middle && rightIndex <= right){
            if(array[leftIndex] < array[rightIndex]){
                   tmp[tmpIndex] = array[leftIndex];
                   tmpIndex++;
                   leftIndex++;
            }else{
                   tmp[tmpIndex] = array[rightIndex];
                   tmpIndex++;
                   rightIndex++;
            }
        }


        while(leftIndex <= middle){
            tmp[tmpIndex] = array[leftIndex];
            tmpIndex++;
            leftIndex++;
        }

        while (rightIndex <= right){
            tmp[tmpIndex] = array[rightIndex];
            tmpIndex++;
            rightIndex++;
        }

        //将tmp相应数据拷贝到array
        while(left <= right){
            array[left] = tmp[left];
            left++;
        }



    }



    public void printArray(int[] sort){
        if(sort != null){
            for (int i=0;i<sort.length;i++){
                System.out.print(sort[i]+".");
            }
        }
    }
}
