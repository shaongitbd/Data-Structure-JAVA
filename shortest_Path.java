
package sub.cse;
import java.util.*;


// Unweighted graph with string 
// Our graph class using ArrayList(Dynamic array in Java)
// You can also use a matrix to represent your graph but the code will be slightly different in that case


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


// Our function of breath first search
// BFS use Queue

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


// Our function of Depth first Search
// DFS use Stack 

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



// Shortest Path function 
// You can use it only in unweighted graph.
// This is similar to bfs but without keeping the visited array list and using a distance array 
// We can use a path array to keep track of our vetices where we get the minimum value 

void shortestPath(String a, String b){
    
 // Getting index of Sting a and b using map 
    
int from = map.get(a);
int to = map.get(b);
    
int item;
int distance[] = new int[ajct.size()]; 

for(int i=0;i<distance.length;i++){


    distance[i] = Integer.MAX_VALUE;
}


Queue <Integer> queue  =  new LinkedList<>();

// setting the distance to itself to 0
//example setting "E" > index 4 to 0 zero if we want to get distance of E to somewhere else. so if you want to print distance of E to E we get 0.

distance[from] =0;

 
       
       
queue.add(from);

while(!queue.isEmpty()){

    item = queue.poll();
   
    
        for(int j=0;j<ajct.get(item).size();j++){
            System.out.println(ajct.get(item));
        
            if(distance[ajct.get(item).get(j)]>distance[item]+1){
            
                
            distance[ajct.get(item).get(j)]= distance[item]+1;
            
            queue.add(ajct.get(item).get(j));
                
            }
            
        
        }
        
        
 
    



}

//Printing all the distance 
    
 System.out.println("Distance Array");
 
          for(Integer s : distance) { 
  System.out.println(s.toString()); 
}
          
          
 //Printing shortest distance from source a to source b  using  our array       
    
  System.out.println("Distance from " +a +" to " +b+"  is "+distance[to] );
  
    
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
     graph.addEdge("B","C");
     graph.addEdge("B","D");
     graph.addEdge("D","E");
     graph.addEdge("E","F");
     graph.addEdge("C","D");
    
    graph.traverse();
    
    //Breath First Search
    
     System.out.println("Breath first search");
    graph.bfs();
    
    //Depth First Search
    
    System.out.println("Depth  first search");
    graph.dfs();
    
    //Shortest Path
    
    System.out.println("Finding Shortest path ");
    graph.shortestPath("B","F");
    
    

   
    } //main
    
} //end of class
