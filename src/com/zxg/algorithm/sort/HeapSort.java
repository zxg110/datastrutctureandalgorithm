package com.zxg.algorithm.sort;

/**
 * https://www.cnblogs.com/chengxiao/p/6129630.html
 */
public class HeapSort extends Sort {
    @Override
    public int[] sort(int[] originalData) {
        //构造大顶堆
        for (int i = originalData.length / 2 - 1; i >= 0; i--) {
            //i初始值是最后一个非叶结点
            //从最后非叶子结点从下至上，从右至左调整结构
            adjustHeap(originalData, i, originalData.length);
        }
        //2.调整堆结构+交换堆顶元素与末尾元素
        for (int j = originalData.length - 1; j > 0; j--) {
            swap(originalData, 0, j);//将堆顶元素与末尾元素进行交换
            adjustHeap(originalData, 0, j);//重新对堆进行调整
        }
        return originalData;
    }

    /**
     * @param arr:数据源
     * @param i：需要调整的非叶子节点下标
     * @param length：调整范围，不一定数组内全部都需要调整
     */
    private void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];
        //k的递增原因是处理完一个父节点，要接着处理相邻的父节点
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            //k为i结点的左结点 k+1为右结点
            //找出两个子节点中较大的用k记录
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;
            }
            //与父节点比较
            if (arr[k] > temp) {
                //若k结点数值（左右孩子中的一个）比父节点大，则将父节点直接赋值，不用交换
                arr[i] = arr[k];
                //将i赋值成k，与5处相对应
                i = k;
            } else {
                break;
            }
        }
        //5处 赋值
        arr[i] = temp;
    }

    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        HeapSort sort = new HeapSort();
        int[] data = {1, 5, 3, 18, 2, 7, 9, 11, 13};
        result = sort.sort(data);
        printResult();
    }
}
