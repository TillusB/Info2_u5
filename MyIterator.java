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
    private Kette<T> k;
    
    public MyIterator(Kette<T> k1){
    	pos = null;
    	k = k1;
    }
    
    public void setPos(ListNode<T> l){
        this.pos = l;
    }
    
    @Override
    public boolean hasNext() {
    	if (pos == null)
    		return k.length > 0;
        return pos.getNext() != null;
    }

    @Override
        public T next() {
    	if(pos == null){
    		pos = k.head;
    		return k.head.value();
    		
    	}
    	pos = pos.getNext();
        return pos.value();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
