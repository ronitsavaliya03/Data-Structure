class Node {
    int data;
    Node link;

    public Node(int data) {
        this.data = data;
        this.link = null;
    }
}

class LL {
    Node first;

    public void insert(int data) {
        Node newNode = new Node(data);
        if (first == null) {
            first = newNode;
            return;
        }

        Node currNode = first;
        while (currNode.link != null) {
            currNode = currNode.link;
        }
        currNode.link = newNode;
    }

    public void display() {
        if (first == null) {
            System.out.println("List is Empty.!");
            return;
        }

        Node currNode = first;
        while (currNode != null) {
            System.out.print(currNode.data + " --> ");
            currNode = currNode.link;
        }
        System.out.println("NULL");
    }

    public void sort() {
        Node save = first;
        Node next = save.link;


        while (save != null) {
            next=save.link;
            while (next != null) {
                if (save.data > next.data) {
                    int temp = save.data;
                    save.data = next.data;
                    next.data = temp;
                }
                next = next.link;
            }
            save = save.link;
        }

    }

}

public class SortLL {
    public static void main(String[] args) {
        LL list = new LL();

        list.insert(8);
        list.insert(7);
        list.insert(6);
        list.insert(9);
        list.insert(3);
        list.insert(2);
        list.insert(7);
        list.insert(1);

        list.display();

        list.sort();
        list.display();

    }
}

