import java.io.*;

class Node
{
    private Object data;    
    private Node next;
    
    //Ctor
    Node(Object data, Node next){
        this.data = data;       
        this.next = next;
    }
    
    //mutators
    public void setData(Object data){ this.data = data; }    
    public void setNext(Node node){ this.next = node; }
    
    //accessors
    public Object getData(){ return this.data; }    
    public Node getNext() { return this.next; }
}
class LinkList{
    private Node head = null;
    private Node tail = null;
    
    //methods
    public boolean isEmpty(){ return null == head; }
    public void frontInsert(Object item){
        if(this.isEmpty()){
            head = tail = new Node(item,null);
        }else{
            head = new Node(item,head);
        }
    }
    public void backInsert(Object item){
        if(this.isEmpty()){
            head = tail = new Node(item, null);
        }else{
            tail.setNext(new Node(item,null));
            tail = tail.getNext();
        }
    }
    public Object deleteFront(){
        if(this.isEmpty()){
            return null;
        }else{
            Node removed = head;
            if(head == tail)
            {
                head = tail = null;
            }else{
                head = head.getNext();
            }
            return removed.getData();
        }
    }
    public Node getHead(){
        return head;
    }
    public void printList(){
        for(Node current = head; current != null; current = current.getNext()){
            System.out.print((Integer)current.getData() + " --> ");
        }
        System.out.println("NULL");
    }
}
class Queue{
    private LinkList list;
    
    //Ctor
    Queue(){
        list = new LinkList();
    }
    //methods
    public boolean isEmpty(){  return list.isEmpty();  }
    public void enq(Object item){
        list.backInsert(item);
    }
    public Object deq(){
        if(list.isEmpty()){
            return null;
        }
        else{
            return list.deleteFront();
        }
    }
}
class Graph{
    private LinkList [] list; // adjecency list rep
    private Queue Q;
    private int noOfNodes;
    private String [] nodeColor;
    private boolean [] visited;
    private int [] parent;    
    private boolean hasEvenCycle;
    private boolean hasCycle;
    
    //Ctor
    Graph(int num){
        noOfNodes = num;
        Q = new Queue();
        list = new LinkList[noOfNodes];
        nodeColor = new String[noOfNodes];
        visited = new boolean[noOfNodes];
        parent = new int[noOfNodes];
        for(int i=0;i<this.noOfNodes;i++){
            list[i] = new LinkList();
            nodeColor[i] = null;
            visited[i] = false;
            parent[i] = -1;
            list[i].backInsert((Integer)(i+1));
        }
    }
    public void buildGraph() throws IOException{
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        int u = 0; 
        int v = 0;
        String line ;
        boolean flag = true;
        while(flag){
            System.out.println("Input an edge u --> v : ");
            System.out.println("value of vertex u : ");  
            System.out.flush();                
            if((line = stdin.readLine())  != null)
                u = Integer.valueOf(line).intValue();
            System.out.println("value of vertex v : ");
            System.out.flush();
            if((line = stdin.readLine())  != null)
                v = Integer.valueOf(line).intValue(); 
            this.adjacencyList(u,v);
            System.out.println("Wanna add more edge ? < 1-9 for yes  & 0 for no > : ");
            System.out.flush();
            if((line = stdin.readLine())  != null)
                u = Integer.valueOf(line).intValue();
            if(0 == u)
                flag = false;
        }        
    }
    public void adjacencyList(int u, int v){
        this.list[u-1].backInsert(new Integer(v));
        this.list[v-1].backInsert(new Integer(u));
    }
    public void printAdjacencyList(){
        System.out.println("Adjacency List is : ");
        for(int i=0;i<this.noOfNodes;i++)        
           this.list[i].printList();        
    }
    public boolean isBipartiteColorTheorem(){
        boolean flag = true;
        int i=0;
        int j=0;
        //visit each of the vertex and its associated list
        for(j=0;j<this.noOfNodes;j++){
            if(!visited[j]){
                this.nodeColor[j] = "R";            
            Q.enq(list[0].getHead().getData());
            while(!Q.isEmpty()){
            i = (Integer)Q.deq() - 1 ;
            this.visited[i] = true;
            for(Node current = list[i].getHead();current != null;current = current.getNext()){
                if(null == this.nodeColor[((Integer)current.getData())-1] && this.nodeColor[i] == "R"){
                    this.nodeColor[((Integer)current.getData())-1] = "G";
                }
                else if(null == this.nodeColor[((Integer)current.getData())-1] && this.nodeColor[i] == "G")
                    this.nodeColor[((Integer)current.getData())-1] = "R";
                else if(i != (((Integer)current.getData())-1) && "R" == this.nodeColor[i] && this.nodeColor[((Integer)current.getData())-1] == "R")
                    return false;
                else if(i != (((Integer)current.getData())-1) && "G" == this.nodeColor[i] && this.nodeColor[((Integer)current.getData())-1] == "G")
                    return false;
                if(!visited[((Integer)current.getData())-1]){
                    Q.enq(current.getData());
                }
            }            
        }           
       }
      }
        return flag;
    }
    public boolean isBipartiteOddCycle(){
        
        for(int i=0;i<this.noOfNodes;i++){
            this.nodeColor[i] = "W";
        }
        for(int i=0;i<this.noOfNodes;i++){
            if("W" == this.nodeColor[i])
                this.FC_Visit(i);
        }
        if(!this.hasCycle){
            return true;
        }
        else if(this.hasCycle && this.hasEvenCycle){            
            return true;
        }
        else{
            return false;
        }            
    }
    private void FC_Visit(int u){
        this.nodeColor[u] = "G";
        for(Node current = list[u].getHead().getNext();current != null;current = current.getNext()){
            int v = ((Integer)current.getData())-1;            
            if("G" == this.nodeColor[v] && v != this.parent[u]){
                this.parent[v] = u;
                this.hasEvenCycle = this.FC_isEven(v);
                this.hasCycle = true;
                if(!this.hasEvenCycle){
                    return;
                }                    
            }
            if("W" == this.nodeColor[v]){
                this.parent[v] = u;
                this.FC_Visit(v);
            }
        }
    }
    private boolean FC_isEven(int v){
        int w = v;
        int count = 0;
        System.out.println("Cycle in the graph is :");
        do{
            w = this.parent[w];
            System.out.print((w+1) + " --> ");
            ++count;
        }while(w != v);
        System.out.println("NULL");
        if(0 == count%2)
            return true;
        else
            return false;
    }    
}
public class MyClient{
    public static void main(String [] args) throws IOException{
        int numNodes = 0;
        String line = null;
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Number of nodes in Graph ? ");  
        System.out.flush();                
        if((line = stdin.readLine())  != null)
          numNodes = Integer.valueOf(line).intValue();
        Graph G = new Graph(numNodes);
        G.buildGraph();
        G.printAdjacencyList();        
        System.out.println("Is given graph bipartite ? Using color theorem :" + G.isBipartiteColorTheorem());
        System.out.println("Is given graph bipartite ? Using Odd-Even Cycle theorem :" + G.isBipartiteOddCycle());
    }
}