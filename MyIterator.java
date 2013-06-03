/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Iterator;
/**
 *
 * @author Till
 */
public class MyIterator<T> implements Iterator<T> {
    private ListNode<T> pos;
    
    public void setPos(ListNode l){
        this.pos=l;
    }
    
    @Override
    public boolean hasNext() {
        return pos.getNext()!=null;
    }

    @Override
        public T next() {
        return pos.getNext().value();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
