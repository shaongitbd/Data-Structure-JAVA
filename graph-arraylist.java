// please use with proper credit

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


}


public class Myprogram {


    public static void main(String[] args) {

 
   
    Graph graph = new Graph();
    
    graph.addNode("A");
    graph.addNode("B");
    graph.addNode("C");

    graph.addEdge("A","C");
    graph.addEdge("A","B");
     graph.addEdge("B","A");
     graph.addEdge("B","C");
    graph.traverse();

    
    
    

    // now our work bellow 
    
    
 
   
    } //main
    
} //end of class
