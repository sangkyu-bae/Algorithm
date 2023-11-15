import java.util.*;
import java.util.stream.Collectors;

class Solution {
      int[][] result;
    int index;
    public int[][] solution(int[][] nodeinfo) {

        List<Node> nodeList = new ArrayList<>();
        for(int i = 0 ;i<nodeinfo.length;i++){
            nodeList.add(new Node(nodeinfo[i][0],nodeinfo[i][1],i+1,null,null));
        }

        nodeList = nodeList.stream()
                .sorted((o1, o2) -> {
                    if (o1.y == o2.y) {
                        return o1.x - o2.x;
                    } else {
                        return o2.y - o1.y;
                    }
                })
                .collect(Collectors.toList());

        Node parentNode = nodeList.get(0);
        for(int i = 1; i<nodeList.size();i++) {
            insertNode(parentNode, nodeList.get(i));
        }

        result = new int[2][nodeinfo.length];
        index = 0;
        firstOrder(parentNode);
       
        index = 0;
        lastOrder(parentNode);

        return result;
    }
     void firstOrder(Node root){
        if(root!= null){
            result[0][index++] = root.value;
            firstOrder(root.left);
            firstOrder(root.right);
        }
    }

    void lastOrder(Node root){
        if(root!=null){
            lastOrder(root.left);
            lastOrder(root.right);
            result[1][index++] = root.value;
        }
    }
    void insertNode(Node parentNode, Node childNode){
        if(parentNode.x > childNode.x){
            if(parentNode.left == null){
                parentNode.left = childNode;
            }else{
                insertNode(parentNode.left,childNode);
            }
        }else{
            if(parentNode.right == null){
                parentNode.right = childNode;
            }else{
                insertNode(parentNode.right,childNode);
            }
        }
    }
    public class Node{
        int x;
        int y;
        int value;
        Node left;
        Node right;
        public Node(int x, int y, int value, Node left, Node right) {
            this.x = x;
            this.y = y;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

}