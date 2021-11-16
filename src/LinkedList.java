import java.rmi.AccessException;

public class LinkedList<T>
{
    private Node<T> head;

    private static class Node<T>
    {
        public T data;
        public Node<T> next;

        public Node(T data) { this.data = data; }

        public Node(T data, Node<T> next)
        {
            this(data);
            this.next = next;
        }
    }

    public void addLast(T data) throws IllegalArgumentException
    {
        if (data == null)
            throw new IllegalArgumentException("Значение элемента: null");

        if (head == null)
            head = new Node<T>(data);
        else
        {
            Node<T> curr = head;

            while (curr.next != null)
                curr = curr.next;

            curr.next = new Node<T>(data);
        }
    }

    public void addFirst(T data)
    {
        head = new Node<T>(data, head);
    }

    public void insert(int index, T data)
    {
        Node<T> curr = get(index);
        Node<T> next = curr.next;
        curr.next = new Node<T>(data);
        curr.next.next = next;
    }

    public void remove(Node<T> node) throws IllegalArgumentException
    {
        if (node == null)
            throw new IllegalArgumentException("Значение элемента: null");

        if (node == head)
            head = head.next;
        else
        {
            Node<T> curr = head, prev = null;

            while (curr != null && curr != node)
            {
                prev = curr;
                curr = curr.next;
            }

            if (curr == null)
                throw new IllegalArgumentException("Такого элемента нет");
            else
                prev.next = curr.next;
        }
    }

    public void concat(LinkedList<T> addElem) throws AccessException
    {
        getTail().next = addElem.getHead();
    }

    public int getLength()
    {
        int length = 0;
        Node<T> curr = head;

        while (curr != null)
        {
            ++length;
            curr = curr.next;
        }

        return length;
    }

    @Override
    public String toString()
    {
        String list = "";
        Node<T> curr = head;

        while (curr != null)
        {
            list = list.concat(curr.data + " -> ");
            curr = curr.next;
        }

        return list + "null";
    }

    public void reverse()
    {
        Node<T> prev = null, curr = head, next;

        while (curr != null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head = prev;
    }

    public boolean exists(Node<T> node) throws IllegalArgumentException
    {
        if (node == null)
            throw new IllegalArgumentException("Значение элемента: null");

        Node<T> curr = head;
        while (curr != null)
        {
            if (curr == node)
                return true;

            curr = curr.next;
        }

        return false;
    }

    public boolean exists(T data) throws IllegalArgumentException
    {
        if (data == null)
            throw new IllegalArgumentException("Значение элемента: null");

        Node<T> curr = head;
        while (curr != null)
        {
            if (curr.data == data)
                return true;

            curr = curr.next;
        }

        return false;
    }

    public Node<T> getNext(Node<T> node) throws IllegalArgumentException
    {
        if (exists(node))
            return node.next;
        else
            throw new IllegalArgumentException("Такого элемента нет");
    }

    public Node<T> get(int index) throws IndexOutOfBoundsException
    {
        if (index < 0)
            throw new IndexOutOfBoundsException("Индекс все границ списка");

        Node<T> curr = head;
        for (int i = 0; curr != null; ++i, curr = curr.next)
        {
            if (i == index)
                return curr;
        }

        throw new IndexOutOfBoundsException("Индекс все границ списка");
    }

    public Node<T> getHead() throws AccessException
    {
        if (head == null)
            throw new AccessException("Список пуст");

        return head;
    }

    public Node<T> getTail() throws AccessException
    {
        if (head == null)
            throw new AccessException("Список пуст");

        Node<T> curr = head;
        while (curr.next != null)
            curr = curr.next;

        return curr;
    }
}
