package com.xiongliang.pratice.Sort;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 堆排序 -- 利用堆这种数据结构的特性(最大堆或最小堆), 即是完全二叉树 并且 某个节点总是大于(或者小于)其左右子节点,时间复杂度O(nLog2^N)
 * 1) 将整个数组构建为最大堆，此时arr[0]是数组中最大元素
 * 2) 将arr[0] 和 arr[length -1] 进行交换
 * 3) 将0到length-2 之间元素构建最大堆，此时arr[0]即第一步找出最大值外的最大值, 将arr[0]与arr[length -2]进行交换
 * 4) 递归执行,直至用来构建堆的元素仅剩arr[0],整个数组排序完毕
 *
 * (下标从0开始算)下标为n 的节点 其左子树小标为2n +1 , 右子树是2n+2, 最底层最右边的叶子节点为end,最小的非叶子节点为(end-1)/2
 *
 *  时间复杂度：
 *  完全二叉树高度h,总数为n, n = 1+2+2*2+2*2*2 ... = 2^h -1； --> h = log2^N
 *
 *  对n个元素建堆一次,需要log2 N次计算, 总共需要建堆n次, 所以时间复杂度为O(nlog2 N)
 *
 *   方式二:
 *   PriorityQueue 优先队列,底层是二叉最小堆实现
 *   add() 插入元素
 *   element() 获取队首元素,但不删除元素
 *   remove() 获取队首元素,并删除元素
 *
 *  https://www.cnblogs.com/niuyourou/p/11995132.html
 *
 */
public class HeapSort {
    /**
     * 将数组保持最大堆特性, 保证每个父节点大于其左右子节点
     */
    public void heapSort(int arr[],int end){
         for(int i= (end-1)/2; i>=0;i--){  //最右边叶子节点为end, 最小非叶子节点为(end-1)/2,排序是从最小的非叶子节点(2*i+1 是左)开始向上构建堆
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


    /**
     * 方式2: 使用PriorityQueue 优先队列, 直接将所有元素全部放入优先队列中
     * @param arr
     */
    public void sort2(int arr[]){
        int length = arr.length;
        int index = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(length, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        for (int i=0;i<length;i++){
            priorityQueue.add(arr[i]);
        }

        while (priorityQueue.size() > 0){
            int max = priorityQueue.remove();
            arr[index] = max;
            index ++;
        }
    }
}
