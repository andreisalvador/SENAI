package Classes.NodeIntervals;

import Interfaces.INodeList;

public class NodeListInterval<T> {

    private INodeList<T> firstNode;
    private final int INITIAL_INDEX = 0;

    public NodeListInterval(INodeList<T> firstNode) {
        this.firstNode = firstNode;
    }

    public NodeListIntervalResult<T> GetIntervalFromTargetNodeIndex(int nodeIndex) {
        INodeList<T> node = this.firstNode;

        NodeListIntervalResult<T> result = new NodeListIntervalResult<T>();

        for (int index = 0; index <= nodeIndex; index++) {
            if (INITIAL_INDEX == nodeIndex) {
                result.setLastNodeBeforeTargetNode(null);
                result.setTargetNode(node);
                result.setNextNodeAfterTargetNode(node.getNext());
                break;
            } else if (index == nodeIndex - 1) {
                result.setLastNodeBeforeTargetNode(node);
                result.setTargetNode(node.getNext());
            }

            if (node != null)
                node = node.getNext();

            result.setNextNodeAfterTargetNode(node);
        }
        return result;
    }
}