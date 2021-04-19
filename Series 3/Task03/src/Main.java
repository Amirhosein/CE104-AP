import java.util.Scanner;

/**
 * The type Main.
 */
public class Main {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        String[] nums = inputString.split(" ");

        for (String num : nums) {
            list.add(Integer.parseInt(num));
        }
        Stack stack = new Stack(list.size());
        LinkedList.Node node = list.getHead();
        while (node != null){
            stack.push(node.number);
            node = node.next;
        }
        node = list.getHead();
        while (!stack.isEmpty()){
            node.number = stack.pop();
            node = node.next;
        }
        list.print();

    }
}
