package com.zxg.datastructure.Tree.RBTree;

import sun.jvm.hotspot.utilities.RBNode;

public class RBTree<T extends Comparable<T>> {
    private RBTNode<T> mRoot;    // 根结点

    private static final boolean RED   = false;
    private static final boolean BLACK = true;

    /**
     * 节点数据结构
     * @param <T>
     */
    public class RBTNode<T extends Comparable<T>>{
        boolean color; //颜色
        T key; //节点值
        RBTNode<T> left; //左节点
        RBTNode<T> right; //右节点
        RBTNode<T> parent;    // 父结点

        public RBTNode(T key, boolean color, RBTNode<T> parent, RBTNode<T> left, RBTNode<T> right) {
            this.key = key;
            this.color = color;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 对红黑树节点x进行左旋
     * 示意图
     *    px              px
     *   /               /
     *  x       ->      y
     * / \             / \
     *lx  y           x  ry
     *   / \         / \
     *  ly ry       lx  ly
     *
     * @param x
     */
    /**
     * 感悟：
     * 先记录哪个值，下一句就覆盖哪个值，因为已经记录下它了，可以覆盖他了
     * 一定记住双向设置，a的左孩子是b，一定记得设置b的父亲是a
     * @param x
     */
    private void leftRotate(RBTNode<T> x){
        //设x的右孩子为y
        RBTNode<T> y  = x.right;
        //覆盖设置x的右节点为y的左节点
        x.right = y.left;
        //注意红黑树节点中有Parent节点，所以要双向设置
        //针对x右节点，既要设置x.right = y.left，也要对y.left设置parent
        if(y.left != null){
            y.left.parent = x;
        }
        //将y的父亲设置为x的父亲
        y.parent = x.parent;
        //如果x的父亲是空，则旋转前x是根节点，旋转后，y被提上去了，则y设置为根节点
        if(x.parent == null){
            this.mRoot = y;
        }else{
            if(x.parent.left == x){
                // 如果x是它父节点的左孩子，则将y设为“x的父节点的左孩子”
                x.parent.left = y;
            }else{
                // 如果 x是它父节点的右孩子，则将y设为“x的父节点的右孩子”
                x.parent.right =y;
            }
        }
        // 将 “x” 设为 “y的左孩子”
        y.left = x;
        // 将x的父节点设置为y
        x.parent = y;
    }

    /**
     * 右旋示意图(对节点y进行左旋)：
     *              py                               py
     *             /                                /
     *            y                                x
     *           /  \      --(右旋)-.             /  \
     *          x   ry                          lx   y
     *         / \                                  /  \
     *        lx  rx                              rx   ry
     * @param y
     */
    private void rightRotate(RBTNode<T> y){
        RBTNode<T> x = y.left;
        y.left = x.right;
        if(x.right != null){
            x.right.parent = y.left;
        }
        x.parent = y.parent;
        if(y.parent == null){
            this.mRoot = x;
        }else{
            if(y.parent.left == y){
                y.parent.left = x;
            }else{
                y.parent.right = x;
            }
        }
        x.right =y;
        y.parent=x;
    }

    private void insert(RBTNode<T> node) {
        RBTNode<T> y = null;
        RBTNode<T> x = this.mRoot;
        int cmp;
        //找到node节点的父亲节点
        while (x != null) {
            y = x;
            cmp = node.key.compareTo(x.key);
            if (cmp > 0) {
                x = x.right;
            } else {
                x = x.left;
            }
        }
        node.parent = y;
        if (y != null) {
            cmp = node.key.compareTo(y.key);
            if (cmp < 0)
                y.left = node;
            else
                y.right = node;
        } else {
            this.mRoot = node;
        }
        //设置节点颜色为红色
        node.color = RED;
        //插入后修复
        insert(node);
    }

    private void insertFixup(RBTNode<T> node){

    }

    /**
     * 对外接口
     * @param key
     */
    public void insert(T key){
        RBTNode<T> node=new RBTNode<T>(key,BLACK,null,null,null);

        // 如果新建结点失败，则返回。
        if (node != null)
            insert(node);
    }

}
