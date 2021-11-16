public class Program
{
    public static void main(String[] args)
    {
        try
        {
            LinkedList<Integer> list = new LinkedList<>();
            for (int i = 0; i < 10; ++i)
                list.addLast(i);
            System.out.println(list);
            list.reverse();
            System.out.println(list);
            list.remove(list.getHead());
            System.out.println(list);
            list.addFirst(9);
            System.out.println(list);
            list.insert(3, -10);
            System.out.println(list);
            System.out.println(list.exists(-10));
            System.out.println(list.getLength());
        }
        catch (Exception exc)
        {
            System.out.println("Ошибка: " + exc.getMessage());
        }
    }
}
