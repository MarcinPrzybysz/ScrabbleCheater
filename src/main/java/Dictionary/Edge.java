package Dictionary;

public class Edge {
    private Vertex begin, end;
    private Edge(){}


    public Edge(Vertex begin, Vertex end){
        this.begin=begin;
        this.end=end;
    }

    public Vertex getBegin(){
        return begin;
    }

    public Vertex getEnd(){
        return end;
    }




}
