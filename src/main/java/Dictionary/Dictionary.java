package Dictionary;

import java.util.LinkedList;

public class Dictionary {

    private LinkedList<Vertex> vertex = new LinkedList<>();
    private int vertexCount;

    public Dictionary(){
        vertexCount=0;
    }

    public void addVertex(char letter){
        vertex.add(new Vertex(letter));
        vertexCount++;
    }

    public void addEdge(char begin, char end){
////////////////////////////////////////////////////////////////////////////////////////////
    }

    public Vertex getVertex(char letter)
    {
        return vertex.get(letter);
    }


    public LinkedList<Vertex> getVertexList()
    {
        return new LinkedList<Vertex>(vertex);
    }

}
