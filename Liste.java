/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
/**
 *
 * @author Till
 */
public interface Liste<T> extends Iterable<T> {
    T get(int i);
    T set(int i, T obj);
    T append(T obj);
    T prepend(T obj);
    T insert(int i, T obj);
    T remove(int i);
    int getIndex(T obj);
    int length();
    boolean contains(T obj);
    ListNode<T> head();
    ListNode<T> tail();
}