/**
 * Node element for a doubly linked list. Contains value and links to next and previous element.
 * Value  is immutable.
 */
public class ListNode<T> {
    private T obj;
    private ListNode<T> next;
    private ListNode<T> prev;

    /**
     * Creates a new ListNode
     * @param obj Value of type T
     * @param prev previous node
     * @param next next node
     */
    public ListNode(T obj, ListNode<T> prev, ListNode<T> next) {
        this.obj = obj;
        this.prev = prev;
        this.next = next;
    }

    /**
     * Next element in the list
     * @return Object
     */
    public ListNode<T> getNext() {
        return next;
    }

    /**
     * Set connection to the next element
     * @param next reference to the new element
     */
    public void setNext(ListNode<T> next) {
        this.next = next;
    }

    /**
     * Previous element in the list
     * @return Object
     */
    public ListNode<T> prev() {
        return prev;
    }

    /**
     * Set connection to the previous element
     * @param prev reference to the new element
     */
    public void setPrev(ListNode<T> prev) {
        this.prev = prev;
    }

    /**
     * Value of the node
     * @return saved value
     */
    public T value() {
        return obj;
    }
}
