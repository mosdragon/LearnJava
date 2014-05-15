public class MyLink<E> {
    private class Node<E> {
        E item;
        Node<E> next;
        public Node(E item, Node<E> next) {
            this.item = item;
            this.next = next;
        }
    }
    Node<E> front;
    Node<E> back;
    
    // Constant time
    public void addToFront(E item) {
        Node<E> temp = new Node(item, front);
        temp.next = front;
        front = temp;

    }
    // Constant time
    public void addToBack(E item) {
        Node<E> temp = new Node(item, null);
        back.next = temp;
        temp = back;
    }
    // Constant time
    public void removeFront() {
        if (front != null) {
            front = front.next;
        }
    }
    // Cannot be constant time on a singly-LinkedList
    public void removeBack() {
        if (head != null) {
            Node<E> currNode = head;
            Node<E> nextNode = currNode.next;
            while (nextNode != null) {
                currNode = nextNode;
                nextNode = currNode.next;
            }
            currNode.next = null;
        }
        throw new Exception("Can't do that, BST is empty");
    }
    public static void main(String[] args) {
        System.out.println("Yeehaww" + null + "AAA");
    }
}