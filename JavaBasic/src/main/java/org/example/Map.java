package org.example;

/**
 * {@link java.util.TreeMap}基于红黑树实现
 * {@link java.util.HashMap}基于哈希表实现，初始容量16，负载系数0.75，线程不安全，使用的是冲突链表方式，key需要重写hashcode和equals，key和value放在Entry对象当中，Node数组按照2的倍数扩缩绒，1.8从头插改成尾插，头插多线程会导致死循环，数据丢失，数据覆盖
 * 转红黑树条件容量大于64，链表达到8，转链表条件,红黑树元素达到6
 * get的时候通过hash定位Node数组对象的下标，获取到链表或者红黑树遍历，put的时候通过hash定位Node数组对象的下标，元素加入到链表或者红黑树最后，并进行扩容检查
 * {@link java.util.Hashtable}基于哈希表实现，但是线程安全，基于synchronized
 * {@link java.util.LinkedHashMap}使用双向链表来维护顺序，顺序为插入顺序或LRU，使用accessOrder进行LRU配置，通过继承HashMap的node增加前后指针，可以做缓存，有一个FIFO的策略每次插入元素都会调用removeEldestEntry
 * {@link java.util.Collections#synchronizedMap(java.util.Map)}
 *
 * @author luyunji
 */
public class Map {
}
