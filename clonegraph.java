/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        var clone = new Node(node.val, new ArrayList<>());
        var nodeDict = new HashMap<Node, Node>();

        Queue<Node> queue = new LinkedList<>();

        nodeDict.put(node, clone);
        queue.add(node);
        while (!queue.isEmpty()) {

            var u = queue.poll();

            var uClone = nodeDict.get(u);

            for (Node v : u.neighbors) {
                if (!nodeDict.containsKey(v)) {
                    queue.add(v);
                    nodeDict.put(v, new Node(v.val, new ArrayList<>()));
                }
                uClone.neighbors.add(nodeDict.get(v));
            }
        }

        return clone;
    }
}
