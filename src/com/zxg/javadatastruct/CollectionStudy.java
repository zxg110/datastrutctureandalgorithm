package com.zxg.javadatastruct;

import java.util.*;

/**
 * Java Collection Study
 */
public class CollectionStudy {


    public static void main(String[] args) {
        CollectionStudy study = new CollectionStudy();
        study.studyArrayDeque();
    }

    /**
     * Stack 后进先出
     * push() 向栈中推入元素
     * peek() 获取栈顶元素，但不弹出
     * pop() 弹出栈顶元素
     */
    public void studyStack() {
        Stack<String> stack = new Stack<>();
        stack.push("first");
        System.out.println("stack push first");
        stack.push("second");
        System.out.println("stack push second");
        stack.push("third");
        System.out.println("stack push third");
        System.out.println("stack peek" + stack.peek());
    }

    /**
     * Set:不能存储重复元素，重复判断由CompareTo()判断
     * 所以存入Set內的元素必须实现Comparable接口
     */
    /**
     * HashSet:
     * 不保证有序，输出时有序也是允许的,但是不应该依赖这一点。
     * 实验证实，这里的有序指偏序关系（Comparable接口等定义）输出。
     */
    public void studyHashSet() {
        Set<Integer> hashSet = new HashSet<>();
        hashSet.add(1);
        hashSet.add(8);
        hashSet.add(5);
        hashSet.add(3);
        for (Integer value : hashSet) {
            System.out.println("HashSet element:" + value);
        }

    }

    /**
     * 排序Set：TreeSet
     * add() 添加一個元素
     * remove() 刪除某个元素
     * first() 获取第一个元素
     * last() 获取最后一个元素
     * 自带排序功能，无论输入顺序，输出时按照偏序关系（Comparable接口等定义）输出。
     * 而非按照输入顺序
     */
    public void studyTreeSet() {
        Set<Integer> treeSet = new TreeSet<>();
        treeSet.add(5);
        treeSet.add(1);
        treeSet.add(8);
        System.out.println("set first element" + ((TreeSet<Integer>) treeSet).first());
        for (Integer value : treeSet) {
            System.out.println("TreeSet element:" + value);
        }

        //初始化时传入自定义比较器
        Set<String> customSortRuleSet = new TreeSet<>(new CompareByLength());
        customSortRuleSet.add("aaa");
        customSortRuleSet.add("ss");
        customSortRuleSet.add("t");
        customSortRuleSet.add("a");
        for (String str : customSortRuleSet) {
            System.out.println("sort by length:" + str);
        }

        //自定义model实现Comparable接口
        Set<Person> personSet = new TreeSet<>();
        personSet.add(new Person(4, "tom"));
        personSet.add(new Person(2, "jerry"));
        personSet.add(new Person(6, "max"));
        for (Person person : personSet) {
            System.out.println("person:" + person.toString());
        }
    }

    class Person implements Comparable<Person> {
        int id;
        String name;

        public Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        /**
         * 返回0 认为是同一元素
         * 返回1 认为新插入的元素大(this)，this存在根的右侧
         * 返回-1 认为上一个插入的元素大(o)，this存在根的左侧
         * 这里我们确立逻辑：id大的排列在后边
         *
         * @param o
         * @return
         */
        @Override
        public int compareTo(Person o) {
            return this.id - o.id;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    /**
     * 自定义比较规则：按照字符串长度比较
     */
    class CompareByLength implements Comparator<String> {
        @Override
        public int compare(String s1, String s2) {
            int num = s1.length() - s2.length();        //长度为主要条件
            return num == 0 ? s1.compareTo(s2) : num;    //内容为次要条件
        }
    }

    /**
     * Queue 队列
     */

    /**
     * 优先队列，每次出队元素为队列中最小元素
     * 小顶堆(任何一个非叶子节点，其值都不大于左右子节点的权值)实现
     * offer()/add() 向队列中插入元素，offer()插入失败返回false，add()插入失败抛出异常
     * 原理解析博客
     * https://www.cnblogs.com/CarpenterLee/p/5488070.html
     * https://www.jianshu.com/p/4c7ad59a0489
     */
    public void studyPriorityQueue() {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(3);
        priorityQueue.offer(8);
        priorityQueue.offer(11);
        priorityQueue.offer(9);

//        priorityQueue.remove(1);
        System.out.println("priorityQueue poll:" + priorityQueue.poll());
        System.out.println("priorityQueue peek:" + priorityQueue.peek());
    }

    /**
     * 双端队列，可从队列首尾两端操作
     * 采用循环数组实现,精妙之处在于使用与运算
     * 参考资料：https://www.jianshu.com/p/132733115f95
     */
    public void studyArrayDeque() {
        //当做双端队列使用
        ArrayDeque<String> arrayDeque = new ArrayDeque<>();
        arrayDeque.add("a");
        arrayDeque.add("b");
        arrayDeque.add("c");
        arrayDeque.addFirst("f");
        arrayDeque.addLast("x");
        arrayDeque.offer("a");

        System.out.println("arrayDeque:" + arrayDeque.poll());
        //当做栈使用，比Stack快
        ArrayDeque<String> stack = new ArrayDeque<>();
        stack.push("a");
        stack.push("b");
        stack.pop();
    }

}
