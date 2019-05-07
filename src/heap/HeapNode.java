package heap;

public class HeapNode {
    private int nodeId;
    private int priority;

    public HeapNode(int id, int priority){
        nodeId = id;
        this.priority = priority;
    }

    public int getNodeId(){
        return this.nodeId;
    }

    public int getPriority(){
        return this.priority;
    }
    public void setNodeId(int newId){
        this.nodeId = newId;
    }
    public void setPriority(int newPriority){
        this.priority = newPriority;
    }
}
