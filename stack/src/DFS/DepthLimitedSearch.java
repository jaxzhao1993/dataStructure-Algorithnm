package DFS;

import java.util.ArrayList;
import java.util.Stack;

/**
* Depth Limited Search Class
*/
public class DepthLimitedSearch {

   Node startNode;
   Node goalNode;
   int depth = 0;
   int limit = 2;

   public DepthLimitedSearch(Node start, Node goalNode){
       super(start, goalNode);
       this.startNode = start;
       this.goalNode = goalNode;
   }

   public boolean execute(){
       Stack<node> nodeStack = new Stack<>();
       ArrayList<node> visitedNodes = new ArrayList<>();
       nodeStack.add(startNode);

       depth = 0;

       while(!nodeStack.isEmpty()){
           if(depth <= limit) {
               Node current = nodeStack.pop();
               		if (current.equals(goalNode)) {
                   System.out.print(visitedNodes);
                   System.out.println("Goal node found"
                   return true;
               		} else { 
               			visitedNodes.add(current);
               			nodeStack.addAll(current.getChildren());
               			depth++;
               }
           } else {
               System.out.println("Goal Node not found within depth limit");
               return false;
           }
       }
       return false;
   }
}