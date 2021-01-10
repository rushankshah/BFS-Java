import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class BFS {

    static class Node {
        int data;
        List<Node> nextNodes;

        Node(int data) {
            this.data = data;
            nextNodes = new ArrayList<>();
        }
    }

    public static boolean search(Node startingNode, Node nodeToSearch) {
        Queue<Node> nextNode = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        nextNode.offer(startingNode);
        visited.add(startingNode);
        while (!nextNode.isEmpty()) {
            Node currentNode = nextNode.poll();
            if (currentNode == nodeToSearch)
                return true;
            visited.add(currentNode);
            for (Node node : currentNode.nextNodes) {
                if (!visited.contains(node))
                    nextNode.offer(node);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Node node = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(6);
        Node node4 = new Node(7);
        Node node5 = new Node(10);
        node.nextNodes.add(node2);
        node.nextNodes.add(node3);
        node2.nextNodes.add(node4);
        node3.nextNodes.add(node5);
        System.out.println(search(node, node3));
    }
}