package com.xiongliang.pratice.Sort;

/**
 * 堆排序 -- 利用堆这种数据结构的特性(最大堆或最小堆), 即是完全二叉树 并且 某个节点总是大于(或者小于)其左右子节点,时间复杂度O(nLog2 N)
 * 1) 将整个数组构建为最大堆，此时arr[0]是数组中最大元素
 * 2) 将arr[0] 和 arr[length -1] 进行交换
 * 3) 将0到length-2 之间元素构建最大堆，将arr[0]与arr[length -2]进行交换 递归执行
 *
 *   下标为n 的节点 其左子树小标为2n +1 , 右子树是2n+2, 最底层最右边的叶子节点为end,最小的非叶子节点为(end-1)/2
 *
 *  https://www.cnblogs.com/niuyourou/p/11995132.html
 *
 */
public class HeapSort {
    /**
     * 将数组保持最大堆特性, 保证每个父节点大于其左右子节点
     */
    public void heapSort(int arr[],int end){
         for(int i= (end-1)/2; i>=0;i--){
             int leftIndex = 2*i +1;
             int rightIndex =2*i +2;

             if(leftIndex <= end){
                 if(arr[leftIndex] > arr[i]){ //左子节点与父节点交换
                     int tmp = arr[i];
                     arr[i] = arr[leftIndex];
                     arr[leftIndex] = tmp;
                 }
             }

             if(rightIndex <= end){
                 if(arr[rightIndex] > arr[i]){  //右子节点与父节点交换
                     int tmp = arr[i];
                     arr[i] = arr[rightIndex];
                     arr[rightIndex] = tmp;
                 }
             }

         }
    }

    //递归去做
    public void sortRecure(int arr[],int end){
        heapSort(arr,end);
        if(end < 0){
            return;
        }
        int tmp = arr[0];
        arr[0] = arr[end];
        arr[end] = tmp;
        sortRecure(arr,end-1);
    }

    public void sort(int arr[]){
        sortRecure(arr,arr.length -1);
    }

    public void printArray(int[] sort){
        if(sort != null){
            for (int i=0;i<sort.length;i++){
                System.out.print(sort[i]+".");
            }
        }
    }


}
