import java.io.*;
class BasicLinkedList 
{
    public static void main(String args[]) throws IOException 
    {
        LinkedList l = new LinkedList();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int element, choice = 1;
        while ( choice != 0 ) 
        {
            System.out.println("-----MENU-----");
            System.out.println("1. Insert at beginning");
            System.out.println("2. Insert at end");
            System.out.println("3. Insert after a node");
            System.out.println("4. Delete from Beginning");
            System.out.println("5. Delete from end");
            System.out.println("6. Delete element according at a position");
            System.out.println("0. Exit from program");
            System.out.println("Enter your choice: (1/2/3) ");
            choice = Integer.parseInt(br.readLine());
            switch(choice) 
            {
                case 1: 
                System.out.println("Enter the element to be added to beginning: ");
                element = Integer.parseInt(br.readLine());
                l.insertAtBeginning(element);
                l.displayList();
                break;
                case 2: 
                System.out.println("Enter the element to be added to end: ");
                element = Integer.parseInt(br.readLine());
                l.insertAtEnd(element);
                l.displayList();
                break;
                case 3:
                System.out.println("Enter the element to be added: ");
                element = Integer.parseInt(br.readLine());
                System.out.println("Enter the position at which the node should be added: ");
                int position = Integer.parseInt(br.readLine());
                l.insertAfterANode(element, position);
                l.displayList();
                break;
                case 4:
                System.out.println("Deleting the element from beginning");
                l.deleteFromBeginning();
                l.displayList();
                break;
                case 5:
                System.out.println("Deleting the element from the end");
                l.deleteFromEnd();
                l.displayList();
                break;
                case 6:
                System.out.println("Enter the position of node which has to be deleted: ");
                element = Integer.parseInt(br.readLine());
                System.out.println("Deleting the element at the position " + element);
                l.deleteAtAPosition(element);
                l.displayList();
                break;
                case 0: 
                System.out.println("Exiting from the program...");
                break;
                default: 
                System.out.println("Invalid Choice! Try Again!");
                l.displayList();
            }
        }
    }
}
class Link 
{
    int data;
    Link next;
    public Link( int data ) 
    {
        this.data = data;
    }
}
class LinkedList 
{
    Link first = null;
    public void insertAtBeginning(int data) 
    {
        Link newLink = new Link(data);
        newLink.next = first;
        first = newLink;
    }
    public void insertAtEnd(int data) 
    {
        Link newLink = new Link(data);
        if ( first == null ) 
        {
            first = newLink;
        } 
        else 
        {
            Link current = null;
            current = first;
            while (current.next != null) 
            {
                current = current.next;
            }
            current.next = newLink;
        }
        newLink.next = null;
    }
    public void insertAfterANode( int data, int position ) 
    {
        Link newLink = new Link(data) ;
        int length = 0;
        Link temp = first;
        while ( temp.next != null && length != position - 2 ) 
        {
            temp = temp.next;
            length++;
        }
        if ( position <=length ) 
        {
            System.out.println("Element at the position " + position + " doesn't exist!");
        } 
        else 
        {
            newLink.next = temp.next;
            temp.next = newLink;
        }
    }
    public void deleteFromBeginning() 
    {
        if ( !isEmpty() ) 
        {
            first = first.next;
        }
    }
    public void deleteFromEnd() 
    {
        if ( !isEmpty() ) 
        {
            Link temp = first;
            while ( temp.next.next != null) 
                temp = temp.next;
            temp.next = null;
        }
    }
    public void deleteAtAPosition( int key ) 
    {
        if ( !isEmpty() ) 
        {
            Link temp = first;
            int pos = 0;
            while ( pos != key - 1 ) 
            {
                pos++;
                temp = temp.next;
            }
            try 
            {
                temp.next = temp.next.next;
            } 
            catch (Exception e) 
            {
                if ( e.toString().contains("NullPointerException") )
                    temp.next = null;
                System.out.println("ERROR: " + e);
            }
        }
    }
    public void displayList() 
    {
        Link current = first;
        if ( isEmpty() ) 
            System.out.print("List is empty!");
        else 
        {
            System.out.print("Linkedlist: ");
            System.out.print(current.data);
            while ( current.next != null ) 
            {
                current = current.next;
                System.out.print(" --> " + current.data);
            }
        }
        System.out.println('\n');
    }
    public boolean isEmpty() {
        if ( first == null ) return true;
        return false;
    }
}