/**
 * The type Linked list.
 */
public class LinkedList {
    private Node head = null;

    /**
     * Instantiates a new Linked list.
     */
    public LinkedList() {
    }

    /**
     * The type Node.
     */
    class Node {
        /**
         * The Number.
         */
        int number;
        /**
         * The Next.
         */
        Node next;

        /**
         * Instantiates a new Node.
         *
         * @param n the n
         */
        Node(int n) {
            number = n;
            next = null;
        }
    }

    /**
     * Gets head.
     *
     * @return the head
     */
    public Node getHead() {
        return head;
    }

    public int size() {
        int count = 0;
        Node last = head;
        while (last != null) {
            count++;
            last = last.next;
        }
        return count;
    }

    /**
     * Add.
     *
     * @param k the k
     */
    public void add(int k) {
        Node new_node = new Node(k);
        new_node.next = null;

        if (head == null) {
            head = new_node;
        } else {
            Node last = head;
            while (last.next != null) {
                last = last.next;
            }

            last.next = new_node;
        }
    }

    /**
     * Add first.
     *
     * @param k the k
     */
    public void addFirst(int k) {
        Node new_node = new Node(k);
        new_node.next = null;

        new_node.next = head;
        head = new_node;

//        Node first = list.head;
//
//        while (first.next != null) {
//            first = first.next;
//        }
//
//        first.next = new_node;
    }


    /**
     * Print.
     */
    public void print() {
        Node node = head;
        System.out.print(node.number + " ");

        while (node.next != null) {
            node = node.next;
            System.out.print(node.number + " ");
        }

        System.out.println();
    }

    /**
     * Contains.
     *
     * @param k the k
     */
    public void contains(int k) {
        boolean contains = false;
        int place = 0;
        Node node = head;

        if (node.number == k) {
            contains = true;
            System.out.println(place);
        }

        while (node.next != null) {
            place++;
            node = node.next;
            if (node.number == k) {
                contains = true;
                System.out.println(place);
            }
        }

        if (!contains) {
            System.out.println(-1);
        }
    }

    /**
     * Remove index.
     *
     * @param i the
     */
    public void removeIndex(int i) {
        int place = 0;
        Node node = head;

        if (i == 0) {
            head = node.next;
            return;
        }

        while (node.next != null) {
            place++;
            node = node.next;
            if (place == i - 1) {
                node.next = node.next.next;
            }
        }
    }
}
