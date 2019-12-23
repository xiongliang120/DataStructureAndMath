package com.xiongliang.pratice.Sort;

/**
 * 堆排序 -- 利用堆这种数据结构的特性(最大堆或最小堆), 即是完全二叉树 并且 某个节点总是大于(或者小于)其左右子节点
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
     * 将数组保持最大堆特性
     */
    public void heapSort(int arr[] ){

    }
}
