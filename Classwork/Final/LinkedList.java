public class LinkedList<E> {
    private class Node<E> {
        E data;
        Node<E> next;
        Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }
    private Node<E> head;

    public void add(E data) {
        head = new Node<E>(data, head);
    }

    private void printList() {
        Node<E> currNode = head;
        String msg = new String();
        while (currNode != null) {
            msg += " " + currNode.data;
            currNode = currNode.next;
        }
        System.out.println(msg);
    }

    public static void main(String[] args) {
        LinkedList<String> strings = new LinkedList<>();
        strings.add("reverse.");
        strings.add("in");
        strings.add("is");
        strings.add("message");
        strings.add("This");
        strings.printList();
    }
}