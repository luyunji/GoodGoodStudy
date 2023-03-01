package org.example;

/**
 * {@link java.util.Collection}Java提供通用的容器,支持迭代器遍历
 * {@link java.util.Queue}队列接口，{@link java.util.Deque}双向队列接口
 * {@link java.util.TreeSet}基于红黑树实现，支持有序性操作，查找的时间复杂度是O(logN)
 * {@link java.util.HashSet}通过适配模式{@link java.util.HashMap}实现，但是无序
 * {@link java.util.LinkedHashSet}基于HashSet实现，使用{@link java.util.LinkedHashMap}加入了双向链表，增加了有序特性
 * {@link java.util.ArrayList}基于数组实现，支持随机访问，并可以自动扩容，会重新拷贝一份新的数组，每次扩容grow约原来的<<1倍，代价较高尽量避免，fail-fast机制，使迭代器能检测到并发读写，默认容量10
 * {@link java.util.Vector}基于数组实现，线程安全，基于synchronized
 * {@link java.util.LinkedList}基于双向链表实现，只能顺序访问，可以快速插入和删除元素,同时实现了List和Deque双端队列，也就是有队列和栈的特性，但是现在首选是ArrayDeque
 * {@link java.util.ArrayDeque}寻址快，内存开销小，是一个循环使用数组，扩容是两倍
 * {@link java.util.PriorityQueue}基于堆实现，可以实现优先级队列，获取权值最小的元素，默认是按照自然顺序，也可以使用比较器{@link java.util.Comparator},Tree相关的都不允许null，通过完全二叉树实现的小顶堆实现，通过数组存储
 * {@link java.util.Collections#synchronizedCollection(java.util.Collection)}可以封装成同步
 * @author luyunji
 */
public class Collection {

    public static void main(String[] args) {
    }
}
