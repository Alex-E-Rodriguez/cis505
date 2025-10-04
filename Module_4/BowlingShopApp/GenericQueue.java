/*
    Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
    Comprehensive Version (12th ed.). Pearson Education, Inc.
    Modified by R. Krasso 2021
    Additional modifications by A. Rodriguez 2025
*/

package Module_4.BowlingShopApp;
import java.util.LinkedList;

public class GenericQueue<E> {
    // Instanced Variables
    private LinkedList<E> list = new LinkedList<E>(); // A private generic LinkedList that contains a list of objects for the queue. Default empty LinkedList.

    /** 
     * Method with one argument, which is used to add a generic item to the first slot in the queue.
     * @param E item
    */
    public void enqueue(E item) {
        list.addFirst(item);
    } // end enqueue

    /** 
     * Method with no arguments, which is used to remove the first item from the queue.
     * @return the item removed from the queue.
    */
    public E dequeue() {
        E item = list.getFirst();
        list.removeFirst();
        return item;
    } // end dequeue

    /** 
     * Method with no arguments, which is used as an accessor for the queue's current size.
     * @return the LinkedList represent the queue's current size.
    */
    public int size() {
        return list.size();
    } // end size

}
