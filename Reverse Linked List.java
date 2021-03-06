import java.io.*;
class ReverseLinkedList 
{
    public static void main(String[] args) throws IOException 
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        boolean online = true;
        int input;
        String choice;
        LinkedList straighList = new LinkedList();
        LinkedList reversedList = new LinkedList();
        while (online) 
        {
            System.out.println("____________");
            System.out.print("\nEnter a value to be inserted to LinkedList : ");
            input = Integer.parseInt(in.readLine());
            straighList.insertLast(input);
            reversedList.insertFirst(input);
            System.out.print("Do you want to continue (y/n) : ");
            choice = in.readLine();
            if (choice.equals("y")) online = true;
            else online = false;
        }
        System.out.println("\nThe original LinkedList is : ");
        straighList.displayList();
        System.out.println("\nThe reversed LinkedList is : ");
        reversedList.displayList();
    }
}
class Link 
{
    public int data;
    public Link next;
    public Link (int d) 
    {
        data = d;
    }
    public void displayLink() 
    {
        System.out.print(data);
    }
}
class LinkedList 
{
    private Link first;
    public LinkedList() 
    {
        first = null;
    }
    public boolean isEmpty() 
    {
        return (first == null);
    }
    public void insertFirst(int element) 
    {
        Link newLink = new Link(element);
        newLink.next = first;
        first = newLink;
    }
    public Link deleteFirst() 
    {
        Link lastLink = first;
        if (!isEmpty()) 
        {
            first = first.next;
            return lastLink;
        }
        return null;
    }
    public void insertLast(int element) 
    {
        Link newLink = new Link(element);
        if (first == null) 
        {
            first = newLink;
        } 
        else 
        {
            Link current = null;
            current = first;
            while(current.next != null) 
            {
                current = current.next;
            }
            current.next = newLink;
            newLink.next = null;
        }
    }
    public Link deleteLast() 
    {
        Link lastLink = null;
        if (!isEmpty()) 
        {
            lastLink = first;
            if (first.next != null)
                while (lastLink.next.next != null)
                        lastLink = lastLink.next;
            lastLink.next = null;
            return lastLink;
        }
        return null;
    }
    public void insert(int key, int d) 
    {
        Link temp = new Link(d);
        Link currentLink = first;
        Link previousLink = first;
        while (currentLink.data != key) 
        {
            if (currentLink.next == null)
                break;
            else 
            {
                previousLink = currentLink;
                currentLink = currentLink.next;
            }
        }
        temp.next = previousLink.next;
        previousLink.next = temp;
    }
    public Link delete(int key) 
    {
        Link currentLink = first;
        Link previousLink = first;
        while (currentLink.data != key) 
        {
            if (currentLink.next == null)
                return null;
            else 
            {
                previousLink = currentLink;
                currentLink = currentLink.next;
            }
        }
        if (currentLink == first)
            first = first.next;
        else
            previousLink.next = currentLink.next;
        return currentLink;
    }
    public void displayList() 
    {
        first.displayLink();
        Link currentLink = first.next;
        while(currentLink != null) 
        {
            System.out.print(" -> ");
            currentLink.displayLink();
            currentLink = currentLink.next;
        }
    }
}