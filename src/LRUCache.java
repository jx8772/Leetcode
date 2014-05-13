import java.util.HashMap;
/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 5/8/14
 * Time: 6:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class LRUCache {
    public static void main(String[] args){
        LRUCache c = new LRUCache(4);
        c.set(1,11);
        c.set(2,22);
        c.set(3,33);
        System.out.println(c.get(3));
        c.set(4,44);
        c.set(5,55);
        System.out.println(c.get(1));
        return;
    }

    class Node{
        Node prev;
        Node next;
        java.util.AbstractMap.SimpleEntry<Integer, Integer> entry;
    }

    private int capacity = 0;
    private HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    private Node head = null;

    public LRUCache(int capacity){
        this.capacity = capacity;
    }

    public int get(int key){
        if(map.containsKey(key)){
            Node n = map.get(key);
            //update the list
            detach(n);
            attach(n);
            return n.entry.getValue();
        }
        else{
            return -1;
        }
    }

    public void set(int key, int value){
        if(map.containsKey(key)){
            //update the node in map
            Node n = map.get(key);
            n.entry.setValue(value);
            //update the list
            detach(n);
            attach(n);
        }
        else{
            if(map.size() < capacity){
                Node n = new Node();
                n.entry = new java.util.AbstractMap.SimpleEntry<Integer, Integer>(key, value);
                attach(n);
                map.put(key,n);
            }
            else{
                Node n = new Node();
                n.entry = new java.util.AbstractMap.SimpleEntry<Integer, Integer>(key, value);
                //get the least used node, remove it from map and linked list
                Node last = head.prev;
                detach(last);
                map.remove(last.entry.getKey());
                //add the new node into the linked list and map
                attach(n);
                map.put(key,n);
            }
        }
    }

    //detach the node n to doublely linked list
    private void detach(Node n){
        if(n == head){
            head = n.next;
        }
        n.next.prev = n.prev;
        n.prev.next = n.next;
    }

    //attach the node n to doublely linked list
    private void attach(Node n){
        if(head != null){
            n.prev = head.prev;
            n.next = head;
            head.prev.next = n;
            head.prev = n;
            head = n;
        }
        else{
            head = n;
            n.next = n;
            n.prev = n;
        }
    }
}
