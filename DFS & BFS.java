
package sub.cse;
import java.util.*;




class Graph{
   
    
ArrayList<ArrayList<Integer>> ajct  ;
HashMap<String, Integer> map = new HashMap<>();
HashMap<Integer, String> revmap = new HashMap<>();

int index=0; 
Graph(){
    ajct  = new ArrayList<ArrayList<Integer>>();
    
}

void addNode(String name){

    ajct.add(new ArrayList<Integer>());
    
    map.put(name, index);
    revmap.put(index, name);
    index +=1;

}   

void addEdge(String src, String des){

int a;
int b;

a = map.get(src);
b = map.get(des);

ajct.get(a).add(b);
   
}

void traverse(){

    for(int i=0;i<ajct.size();i++){
    
    
    
        for(int j=0; j<ajct.get(i).size();j++ ){
        
        
            System.out.println(revmap.get(i)  +" ==> "+revmap.get(ajct.get(i).get(j)) +" ");
            
            
        }
        
        
    }
    

}

void bfs(){

    
    Queue<Integer> queue = new LinkedList<>();
    
    ArrayList<Integer> done = new ArrayList<>();
    
    int root =0;
    int item;
    queue.add(root);
    
    while(queue.isEmpty()!=true){
    
        item = queue.poll();
        
       if(done.contains(item)==false){
        done.add(item);
         
        
        
            System.out.println(revmap.get(item));
            //now finding adjcents
            
            for(int i=0;i<ajct.get(item).size();i++){
            
            
                if(done.contains(ajct.get(item).get(i))==false){
                
                    
                
                    queue.add(ajct.get(item).get(i));
                    
                    
                
                }
                
            
            }
            
        
        
       }
    
    }
    
    


}

void dfs(){

    
    Stack<Integer> st = new Stack<>();
    
    ArrayList<Integer> dfs_done = new ArrayList<>();
    
    
    int root = 0;
    int item;
    st.push(root);
  
    while(st.isEmpty()!=true){
    
        item= st.pop();
        
        
        if(dfs_done.contains(item)==false){
        
        
            System.out.println(revmap.get(item));
            dfs_done.add(item);
            
            for(int i=0;i<ajct.get(item).size();i++){
            
            
               if(dfs_done.contains(ajct.get(item).get(i))==false){
               
                   st.push(ajct.get(item).get(i));
               
               }
            
            }
            
        
        }    
        
        
        
    
    
    }


}


}


public class Myprogram {


    public static void main(String[] args) {

 
   
    Graph graph = new Graph();
    
    //Testing with our own nodes with edges
    
    graph.addNode("A");
    graph.addNode("B");
    graph.addNode("C");
    graph.addNode("D");
    graph.addNode("E");
    graph.addNode("F");
    
    graph.addEdge("A","B");
    graph.addEdge("A","C");
     graph.addEdge("A","F");
     graph.addEdge("B","A");
     graph.addEdge("B","C");
     graph.addEdge("B","D");
     graph.addEdge("D","C");
     graph.addEdge("D","E");
     graph.addEdge("E","F");
     graph.addEdge("C","D");
    
    graph.traverse();
    
    //Breath First Search
    
     System.out.println("Breath first search");
    graph.bfs();
    
    //Depth First Search
    
    System.out.println("deapth first search");
    graph.dfs();

    
    
    

   
    } //main
    
} //end of class
