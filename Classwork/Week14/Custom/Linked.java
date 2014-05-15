public class Linked<E> {
    private Node<E> head;
    // private Node<E> tail;
    protected class Node<E> {
        E data;
        Node next;
        Node prev;
        public Node(E data) {
            this.data = data;
        }
    }
    public void add(E item) {
        Node<E> temp = new Node<>(item);
        if (head != null) {
            head.prev = temp;
            temp.next = head;
        }
        // head.prev = temp;
        // temp.next.prev = temp;
        head = temp;
    }
    public String toString() {
        String msg = new String();
        Node<E> temp = head;
        while (temp != null) {
            msg += "\t" + temp.data;
            temp = temp.next;
        }
        return msg;
    }
    public static void main(String[] args) {
        Linked<String> str = new Linked<>();
        str.add("MY");
        str.add("Name");
        str.add("isn't");
        str.add("MY");
        str.add("age");
        System.out.println(str);
    }
}