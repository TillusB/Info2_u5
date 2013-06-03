
import java.util.Iterator;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Till
 */
public class Kette<T> implements Liste<T> {

    protected int length;
    protected ListNode<T> head;
    protected ListNode<T> tail;
    
    public Kette(){
        length = 0;
        head = null;
        tail = null;
    }
    @Override
    public T get(int i) {
        ListNode<T> node = getNode(i);
        if (null != node)
            return node.value();
        return null;
    }


    /**
     * Looks for the index of a given item in the list
     * @param obj Item to search for
     * @return index of the item or -1
     */
    @Override
    public int getIndex(T obj) {
        ListNode<T> current = head;
        for (int j = 0; j < length; j++) {
            if (current.value().equals(obj))
                return j;
            current = current.getNext();
        }
        return -1;
    }

    /**
     * Gets the list node at index i
     * @param i Index
     * @return The item if found or null
     */
    public ListNode<T> getNode(int i) {
        if (i >= length)
            return null;
        ListNode<T> res;
        if (i <= length/2) {
            res = head;
            for (int j = 0; j < i; j++) {
                res = res.getNext();
            }
        }
        else {
            res = tail;
            for (int j = length - 1; j > i; j--) {
                res = res.prev();
            }
        }
        return res;
    }

    /**
     * Replaces an item in the list
     * @param i Index of the item to replace
     * @param obj Item
     * @return the inserted item or null if unsuccessful
     */
    @Override
    public T set(int i, T obj) {
        ListNode<T> target = getNode(i);
        if (null == target)
            return null;

        ListNode<T> before = target.prev();
        ListNode<T> after = target.getNext();
        ListNode<T> newNode = new ListNode<T>(obj, before, after);

        if (null != before)
            before.setNext(newNode);
        else
            head = newNode;
        if (null != after)
            after.setPrev(newNode);
        else
            tail = newNode;

        return obj;
    }

    /**
     * Adds a new item at the end of the  list
     * @param obj Item
     * @return Inserted item
     */
    @Override
    public T append(T obj) {
        if (length == 0) {
            ListNode<T> node = new ListNode<T>(obj, null, null);
            head = node;
            tail = node;
        }
        else {
            ListNode<T> node = new ListNode<T>(obj, tail, null);
            tail.setNext(node);
            tail = node;
        }
        length++;
        return obj;
    }

    /**
     * Adds an item to the beginning of the list
     * @param obj Item
     * @return Item if successful
     */
    @Override
    public T prepend(T obj) {
        if (length == 0) {
            ListNode<T> node = new ListNode<T>(obj, null, null);
            head = node;
            tail = node;
        }
        else {
            ListNode<T> node = new ListNode<T>(obj, null, head);
            head.setPrev(node);
            head = node;
        }
        length++;
        return obj;
    }

    /**
     * Insert element at the index
     * @param i index
     * @param obj new element
     * @return inserted element if successful
     */
    @Override
    public T insert(int i, T obj) {
        ListNode<T> atIndex = getNode(i);

        if (null != atIndex) {
            ListNode<T> newNode = new ListNode<T>(obj, atIndex.prev(), atIndex);
            newNode.prev().setNext(newNode);
            newNode.getNext().setPrev(newNode);
            length++;
            return obj;
        }
        return null;
    }


    /**
     * removes an item from the list
     * @param obj item to remove
     * @return boolean for success of operation
     */
    public boolean remove(T obj) {
        int i = getIndex(obj);
        return (-1 != i) && remove(i) != null;
    }

    /**
     * removes the item at a position
     * @param i index
     * @return true on success, false if not found
     */
    @Override
    public T remove(int i) {
        ListNode<T> atIndex = getNode(i);
        if (null == atIndex)
            return null;
        ListNode<T> before = atIndex.prev();
        ListNode<T> after = atIndex.getNext();

        if (null != before)
            before.setNext(after);
        else
            head = after;

        if (null != after)
            after.setPrev(before);
        else
            tail = before;

        length--;
        return atIndex.value();
    }

    /**
     * Number of items in the list
     * @return number of elements in the list
     */
    @Override
    public int length() {
        return length;
    }

    /**
     * finds out if the list contains an object
     * @param obj object so look for
     * @return true if found
     */
    @Override
    public boolean contains(T obj) {
        return -1 != getIndex(obj);
    }

    /**
     * First node in the list
     * @return First node in the list
     */
    @Override
    public ListNode<T> head() {
        return head;
    }

    /**
     * Last node in the list
     * @return Last node in the list
     */
    @Override
    public ListNode<T> tail() {
        return tail;
    }

    @Override
    public MyIterator<T> iterator() {
        MyIterator<T> i = new MyIterator<>();
        i.setPos(head);
        return i;
    }
    public static void main(String[]args){
        int a=1;
        int b=2;
        int c=3;
        Kette kette=new Kette();
        kette.append(a);
        kette.append(b);
        kette.append(c);
        for(Object i:kette){
            System.out.println(i.toString());
        }
    }
}