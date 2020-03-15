package Classes.NodeIntervals;

import Interfaces.INodeList;

public class NodeListIntervalResult<T> {
    private INodeList<T> lastNodeBeforeTargetNode;
    private INodeList<T> nextNodeAfterTargetNode;
    private INodeList<T> targetNode;

    public INodeList<T> getLastNodeBeforeTargetNode() {
        return this.lastNodeBeforeTargetNode;
    }

    public INodeList<T> getTargetNode() {
        return this.targetNode;
    }

    public INodeList<T> getNextNodeAfterTargetNode() {
        return this.nextNodeAfterTargetNode;
    }

    public void setNextNodeAfterTargetNode(INodeList<T> node) {
        this.nextNodeAfterTargetNode = node;
    }

    public void setLastNodeBeforeTargetNode(INodeList<T> node) {
        this.lastNodeBeforeTargetNode = node;
    }

    public void setTargetNode(INodeList<T> node) {
        this.targetNode = node;
    }

    public boolean HasLastNode() {
        return this.lastNodeBeforeTargetNode != null;
    }

    public boolean HasNextNode() {
        return this.nextNodeAfterTargetNode != null;
    }
}