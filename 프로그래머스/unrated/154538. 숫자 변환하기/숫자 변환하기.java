import java.util.*;
class Solution {
    public int solution(int x, int y, int n) {
     int answer = 1;
        int currentNode=0;
        Set<Integer> nodeSet=new HashSet<>();

        if(y==x){
            return 0;
        }

        currentNode=x+n;

        if(currentNode<y){
            nodeSet.add(currentNode);
        }else if(currentNode==y){
            return 1;
        }

        currentNode=x*2;

        if(currentNode<y){
            nodeSet.add(currentNode);
        }else if(currentNode==y){
            return 1;
        }

        currentNode=x*3;

        if(currentNode<y){
            nodeSet.add(currentNode);
        }else if(currentNode==y){
            return 1;
        }

        mainLoop:
        while (true){
            Set<Integer> newNode=new HashSet<>();

            answer++;
            for(int parentNode:nodeSet){
                currentNode=parentNode+n;

                if(currentNode<y){
                    newNode.add(currentNode);
                }else if(currentNode==y){
                    break mainLoop;
                }

                currentNode=parentNode*2;
                
                if(currentNode<y){
                    newNode.add(currentNode);
                }else if(currentNode==y){
                    break mainLoop;
                }
                
                currentNode=parentNode*3;
                
                if(currentNode<y){
                    newNode.add(currentNode);
                }else if(currentNode==y){
                    break mainLoop;
                }
            }
            
            if(newNode.isEmpty()){
                return -1;
            }
            
            nodeSet=newNode;
        }

        return answer;
    }
}