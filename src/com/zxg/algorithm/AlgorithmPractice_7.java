package com.zxg.algorithm;

import com.zxg.datastructure.linklist.SingleLink;

/**
 * 合并两个已知排序的单链表，合并后保持有序
 */
public class AlgorithmPractice_7 {
    public SingleLink<Integer> mergeSingleLink(SingleLink<Integer> link_1, SingleLink<Integer> link_2) {
        //最终输出的单链表
        SingleLink<Integer> resultLink = new SingleLink<>();
        //link_1指针
        SingleLink.Node link_1_pointer = link_1.head;
        //link_2指针
        SingleLink.Node link_2_pointer = link_2.head;
        //循环条件任意一个链表没遍历完就接着遍历
        while (link_1_pointer.next != null || link_2_pointer.next != null) {
            //比较两个指针取到的值，true代表data1<=data2(因为是升序)
            if (compareData((Integer) link_1_pointer.data, (Integer) link_2_pointer.data)) {
                //判断条件：link_1没有遍历结束
                if (link_1_pointer.next != null) {
                    //把较小的值添加到新链表并将较小值所在链表指针向前移动
                    resultLink.addNode((Integer) link_1_pointer.data);
                    link_1_pointer = link_1_pointer.next != null ? link_1_pointer.next : link_1_pointer;
                } else {
                    /**
                     * 若link_1遍历结束，且link_1最后一个值仍小于link_2.pointer值，则直接将link_2添加
                     * 到resultLink(因为两个输入链表都是有序的)并结束循环
                     */
                    resultLink.addNode(link_2_pointer);
                    break;
                }
            //同理不赘述
            } else {
                if (link_2_pointer.next != null) {
                    resultLink.addNode((Integer) link_2_pointer.data);
                    link_2_pointer = link_2_pointer.next != null ? link_2_pointer.next : link_2_pointer;
                } else {
                    resultLink.addNode(link_1_pointer);
                    break;
                }

            }
        }
        return resultLink;
    }

    private boolean compareData(Integer data_1, Integer data_2) {
        return data_1 <= data_2;
    }

    public static void main(String[] args) {
        AlgorithmPractice_7 algorithm = new AlgorithmPractice_7();
        Integer[] array_2 = {1, 3, 5, 7, 9};
        Integer[] array_1 = {2, 4, 66, 90, 220};

        SingleLink<Integer> link_1 = new SingleLink<Integer>(array_1);
        SingleLink<Integer> link_2 = new SingleLink<>(array_2);

        SingleLink<Integer> result = algorithm.mergeSingleLink(link_1, link_2);
        result.printLink();
    }
}
