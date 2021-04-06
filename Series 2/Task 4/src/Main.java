import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class LinkedList {
    private static LinkedList list = new LinkedList();
    Node head = null;

    static class Node {
        int number;
        Node next;

        Node(int n) {
            number = n;
            next = null;
        }
    }

    public static void add(int k) {
        Node new_node = new Node(k);
        new_node.next = null;

        if (list.head == null) {
            list.head = new_node;
        }
        else {
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }

            last.next = new_node;
        }
    }

    public static void addFirst(int k) {
        Node new_node = new Node(k);
        new_node.next = null;

        new_node.next = list.head;
        list.head = new_node;

//        Node first = list.head;
//
//        while (first.next != null) {
//            first = first.next;
//        }
//
//        first.next = new_node;
    }

    public static void findMiddle() {
        int counter = 0;
        Node node = list.head;

        while (node != null && node.next != null) {
            counter++;
            node = node.next;
        }

        if (counter == 0) {
            System.out.println(-1);
        } else {
            node = list.head;
            for (int i = 0; i < counter/2; i++) {
                node = node.next;
            }
            System.out.println(node.number);
        }
    }

    public static void removeMiddle() {
        int counter = 0;
        Node node = list.head;

        while (node.next != null) {
            counter++;
            node = node.next;
        }

        if (counter > 0) {
            node = list.head;
            for (int i = 0; i < counter/2 - 1; i++) {
                node = node.next;
            }
            node.next = node.next.next;
        }
    }

    public static void print() {
        Node node = list.head;
        System.out.print(node.number + " ");

        while (node.next != null) {
            node = node.next;
            System.out.print(node.number + " ");
        }

        System.out.println();
    }

    public static void contains(int k) {
        boolean contains = false;
        int place = 0;
        Node node = list.head;

        if (node.number == k){
            contains = true;
            System.out.println(place);
        }

        while (node.next != null) {
            place++;
            node = node.next;
            if (node.number == k){
                contains = true;
                System.out.println(place);
            }
        }

        if (!contains) {
            System.out.println(-1);
        }
    }

    public static void removeIndex(int i) {
        int place = 0;
        Node node = list.head;

        if (i == 0){
            list.head = node.next;
            return;
        }

        while (node.next != null) {
            place++;
            node = node.next;
            if (place == i-1){
                node.next = node.next.next;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = "";
        while (!command.equals("finish")) {
            command = scanner.nextLine();

            if (command.matches("add \\d+")) {
                Pattern p = Pattern.compile("add (\\d+)");
                Matcher m = p.matcher(command);
                m.find();
                int number = Integer.parseInt(m.group(1));
                add(number);
            }
            else if (command.matches("addFirst \\d+")) {
                Pattern p = Pattern.compile("addFirst (\\d+)");
                Matcher m = p.matcher(command);
                m.find();
                int number = Integer.parseInt(m.group(1));
                addFirst(number);
            }
            else if (command.matches("findMiddle")) {
                findMiddle();
            }
            else if (command.matches("removeMiddle")) {
                removeMiddle();
            }
            else if (command.matches("print")) {
                print();
            }
            else if (command.matches("contains \\d+")) {
                Pattern p = Pattern.compile("contains (\\d+)");
                Matcher m = p.matcher(command);
                m.find();
                int number = Integer.parseInt(m.group(1));
                contains(number);
            }
            else if (command.matches("removeIndex \\d+")) {
                Pattern p = Pattern.compile("removeIndex (\\d+)");
                Matcher m = p.matcher(command);
                m.find();
                int index = Integer.parseInt(m.group(1));
                removeIndex(index);
            }
        }
    }
}
