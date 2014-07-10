import java.util.List;
import java.util.ArrayList;
/**
 * Created by xiangji on 7/6/14.
 */
public class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
}
