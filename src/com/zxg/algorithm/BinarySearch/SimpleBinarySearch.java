package com.zxg.algorithm.BinarySearch;

/**
 * 折半查找(二分查找)，要求数据源必须有序，这里简单做一个int数组的折半查找
 * https://www.cnblogs.com/wxd0108/p/5465926.html
 */
public class SimpleBinarySearch {

    /**
     * 递归折半查找 切记return binarySearch(data, index + 1, end, target);
     * 不要忘了return
     *
     * @param data
     * @param start
     * @param end
     * @param target
     * @return
     */
    public int binarySearch(int[] data, int start, int end, int target) {
        int index = ((end - start) / 2) + start;
        if (data[index] == target) {
            return index;
        }
        if (target > data[index]) {
            return binarySearch(data, index + 1, end, target);
        } else if (target < data[index]) {
            return binarySearch(data, start, index - 1, target);
        }
        return -1;
    }


    /**
     * 循环折半查找
     *
     * @param data
     * @param target
     * @return
     */
    public int binarySearch(int[] data, int target) {
        int mid = data.length / 2;
        if (data[mid] == target) {
            return target;
        }
        int start = 0;
        int end = data.length - 1;
        while (start <= end) {
            mid = (end - start) / 2 + start;
            if (target < data[mid]) {
                end = mid - 1;
            } else if (target > data[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        SimpleBinarySearch search = new SimpleBinarySearch();
        int[] data = new int[]{32, 50, 64, 78, 81, 95, 101};
//        int result = search.binarySearch(data, 0, data.length - 1, 81);
        int result = search.binarySearch(data, 81);
        System.out.println(result);
    }

}
