package Dictionary;

import java.util.LinkedList;

public class Vertex {
    private char letter;
    private LinkedList<Edge> edge = new LinkedList<>(); //lista z krawędziami wychodzącymi z tego wierzchołka


    public Vertex(char letter) {
        this.letter = letter;
    }

    public char getLetter() {
        return letter;
    }

    public LinkedList<Edge> getEdgeList() {
        return edge;
    }

    public void addEdge(Edge e){
        edge.add(e);
    }

    public void removeEdge(char letter) {
        int e = edge.size() - 1;
        while (e >= 0) {
            if (edge.get(e).getEnd().getLetter() == letter) {
                edge.remove(e);
                e--;
            }
        }
    }

    public Edge getEdge(char letter){
        for(Edge e : edge)
            if(e.getEnd().getLetter() == letter)
                return e;
        return null;
    }

    public Edge getEdgeAt(int n){
        if(n>=0 && n<edge.size()){
            return edge.get(n);
        }else{
            return null;
        }
    }

}
