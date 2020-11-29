package List;

class Node {
    public Node(Object data) {
        this.data = data;
    }

    Object data;
    Node next;
}

public class List {
    private Node root;

    public void add(Object item) {
        if (item == null) {
            System.out.println("Don't add null object!");
            return;
        }
        Node tmpItem = new Node(item);
        Node lastItem = findLast();

        if (lastItem != null) {
            lastItem.next = tmpItem;
        } else {
            root = tmpItem;
        }
    }

    public Object get(int i) {
        if (i < 0 || i > size() || size() == 0) {
            System.out.println("Don't have index = " + i);
            return null;
        } else {
            int j = 1;
            Node rezNode = root;
            if (i <= j) {
                return rezNode.data;
            }
            while (j < i) {
                rezNode = rezNode.next;
                j += 1;
            }
            return rezNode.data;
        }
    }

    public int size() {
        int size;

        if (root == null)
            return 0;
        else {
            size = 1;

            Node current = root;
            while (current.next != null) {
                size++;
                current = current.next;
            }
        }

        return size;

    }

    public Node findLast() {
        if (root == null)
            return null;
        else {
            Node current = root;

            while (current.next != null) {
                current = current.next;
            }

            return current;
        }
    }

    @Override
    public String toString() {

        int i = size();
        if (i == 0) {
            return "";
        }
        String str = root.data.toString() + "-->";
        Node tmp = root;
        while (i > 1) {
            tmp = tmp.next;
            str += tmp.data.toString() + "-->";
            i--;
        }
        return str.length() > 0 ? str.substring(0, str.length() - 3) : "";
    }
}
