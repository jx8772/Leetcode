import java.util.Queue;
import java.util.ArrayList;
import java.util.HashMap;
/**
 * Created by xiangji on 7/6/14.
 */
public class CloneGraph {
    public static void main(String[] args){
        UndirectedGraphNode n0 = new UndirectedGraphNode(0);
        UndirectedGraphNode n1 = new UndirectedGraphNode(1);
        UndirectedGraphNode n2 = new UndirectedGraphNode(2);
        n0.neighbors.add(n1);
        n0.neighbors.add(n2);
        n1.neighbors.add(n2);
        n2.neighbors.add(n2);
        UndirectedGraphNode res = cloneGraph(null);
    }

    public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
//        if(node == null){
//            return null;
//        }
        //step 1: map original node with duplicate node
        ArrayList<UndirectedGraphNode> queue = new ArrayList<UndirectedGraphNode>();
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        queue.add(node);
        //UndirectedGraphNode dup = new UndirectedGraphNode(node.label);
        //map.put(node,dup);
        while(!queue.isEmpty()){
            UndirectedGraphNode c = queue.remove(0);
            //if the the node is never seen before
            if(!map.containsKey(c)){
                //put itself and its duplicate into map
                map.put(c, new UndirectedGraphNode(c.label));
                //put its neighbors into queue
                for(UndirectedGraphNode n : c.neighbors){
                    queue.add(n);
                }
            }
        }
        //step 2: add neighbor links to duplicate nodes
        for(UndirectedGraphNode c : map.keySet()){
            for(UndirectedGraphNode n : c.neighbors){
                map.get(c).neighbors.add(map.get(n));
            }
        }
        return map.get(node);
    }
}
