
import java.util.*;
class Node
{
protected int regd_no;
protected float mark;
protected Node next;
}
public class ll
{
public static Node create(Node start)
{
Node p,q;
p=new Node();
Scanner sc=new Scanner(System.in);
start=p;
System.out.println("Enter registration no. & mark of the student:");
p.regd_no=sc.nextInt();
p.mark=sc.nextFloat();
p.next=null;
System.out.println("Do You Want To Add Another Node(YES-1,NO-0)");
int option=sc.nextInt();
while(option!=0)
{
q=new Node();
System.out.println("Enter registration no. & mark of the student:");
q.regd_no=sc.nextInt();
q.mark=sc.nextFloat();
q.next=null;
p.next=q;
p=q;
System.out.println("Do You Want To Add Another Node(YES-1,NO-0)");
option=sc.nextInt();
}
return start;
}
public static void display(Node start)
{
while(start!=null)
{
	System.out.println(start.regd_no+"  "+start.mark);
	start=start.next;
}
}
public static Node InsBeg(Node start)
{
	Scanner sc=new Scanner(System.in);
	Node curr;
	curr=new Node();
	System.out.println("Enter registration no. & mark of the student:");
	curr.regd_no=sc.nextInt();
	curr.mark=sc.nextFloat();
	curr.next=null;
	if(curr==null)
	{
		System.out.println("Memory Underflow");
		System.exit(0);
	}
	if(start==null)
	{
		start=curr;
	}
	else
	{
		curr.next=start;
		start=curr;
	}
	return start;
}
public static Node InsEnd(Node start)
{
	Scanner sc=new Scanner(System.in);
	Node curr,ptr;
	curr=new Node();
	if(curr==null)
	{
		System.out.println("Memory Underflow");
		System.exit(0);
	}
	System.out.println("Enter registration no. & mark of the student:");
	curr.regd_no=sc.nextInt();
	curr.mark=sc.nextFloat();
	if(start==null)
	{
		start=curr;
	}
	else
	{
		ptr=start;
	while(ptr.next!=null)
	{
		ptr=ptr.next;
	}
	ptr.next=curr;   
	}
	return start;
}
public static Node InsAny(Node start)
{
	Scanner sc=new Scanner(System.in);
	Node curr,p;
	int i=1,c=0,loc;
	p=start;
	System.out.println("Enter the Location");
	loc=sc.nextInt();
	while(p!=null)
	{
		c++;
		p=p.next;
    }
	if(loc==1)
		start=InsBeg(start);
	else
	if(loc==c+1)
		start=InsEnd(start);
	else
	{
		p=start;
		while(i<loc-1)
		{
			p=p.next;
			i++;
		}
		curr=new Node();
		System.out.println("Enter the registration no. & marks of the student");
		curr.regd_no=sc.nextInt();
		curr.mark=sc.nextFloat();
		curr.next=p.next;
		p.next=curr;
	}
    return start;
}

public static void search(Node start)
{
	Node p,q;
	q=null;
	if(start==null)
		{
		System.out.println("Memory Underflow");
	    System.exit(0);
		}
	else
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the student's registration no whose mark to be updated");
		int item=sc.nextInt();
		p=start;
		while(p!=null)
		{
			if(p.regd_no==item)
				{
				System.out.println("Enter the updated mark");
				p.mark=sc.nextFloat();
				System.out.println("Node Found & Mark Updated");
				break;
				}
			p=p.next;
		}
		
		}
}
public static Node reverse(Node start)
{
	Node ptr1,ptr2,ptr3;
	ptr1=null;
	ptr2=start;
	ptr3=ptr2.next;
	ptr2.next=null;
	while(ptr3!=null)
	{
		ptr1=ptr2;
		ptr2=ptr3;
		ptr3=ptr3.next;
		ptr2.next=ptr1;
	}
	start=ptr2;
	return start;
}

public static Node sort(Node start)
{
	Node ptr1,ptr2;
	float temp,temp1;
	for(ptr1=start;ptr1!=null;ptr1=ptr1.next)
	{
		for(ptr2=ptr1.next;ptr2!=null;ptr2=ptr2.next)
		{
			if(ptr1.mark>ptr2.mark)
			{
				temp=ptr1.regd_no;
				ptr1.regd_no=ptr2.regd_no;
				ptr2.regd_no=(int)temp;
				temp1=ptr1.mark;
				ptr1.mark=ptr2.mark;
				ptr2.mark=temp1;
				}
		}	
	}
	return start;
}
public static Node DelBeg(Node start)
{
	Node p;
	if(start==null)
		{
		System.out.println("Linked List is empty");
	    System.exit(0);
		}
	else
	{
	    p=start;
	    start=start.next;
	    p.next=null;
	}
	    return start;
}


public static Node DelEnd(Node start)
{
	Node p,q;
	q=null;
	if(start==null)
		{
		System.out.println("Linked List is empty");
	    System.exit(0);
		}
	else
	{
		p=start;
		while(p.next!=null)
		{
			q=p;
			p=p.next;
		}
		q.next=null;
	}
	return start;
}


public static Node DelSpecific(Node start)
{
	Node p,q;
	q=null;
	if(start==null)
		{
		System.out.println("The Linked List is empty");
	    System.exit(0);
		}
	else
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the regd_no of the student to be deleted:");
		int n=sc.nextInt();
		p=start;
		while(p!=null)
		{
			if(p.regd_no==n)
				break;
		       q=p;
		       p=p.next;
		}
		q.next=p.next;
		p.next=null;
		}
	return start;
}
public static Node delany(Node start)
{
	Scanner sc= new Scanner(System.in);
	Node p,q=null;
	p=start;
	int count=0;
		
	if(start!=null)
	{
		while(p.next!=null)
	
	{
		count++;
		p=p.next;
		
	}
	//System.out.println("number of nodes present= "+(count+1));
	}
	p=start;
	int c=count+1;
	System.out.println("enter the position  of node which you want to delete");
	int n=sc.nextInt();
	if (n==1)
	{
		start=DelBeg(start);
		return start;
	}
	else if(n==c)
	{
		start=DelEnd(start);
		return start;
	}
	else if(n>1 && n<c)
	{
		for(int i=1;i<n;i++)
		{
			q=p;
			p=p.next;
			
		}
		q.next=p.next;
		p.next=null;
		return start;
		
	}
	return start;
}

public static void count(Node start)
{
	Node p;
	p=start;
	int count=0;
		
	if(start!=null)
	{
		while(p.next!=null)
	
	{
		count++;
		p=p.next;
		
	}
	System.out.println("number of nodes present= "+(count+1));
	}
}

public static void main(String[] args) {
Node start=new Node();
start=null;
	while(true)
{
System.out.println("******************MENU********************");
System.out.println("0:Exit");
System.out.println("1:Creation");
System.out.println("2:Display");
System.out.println("3:Insertion at the beginning of the list");
System.out.println("4:Insertion at the end of the list");
System.out.println("5:Insertion at any location of the list");
System.out.println("6:Search a node based on regd_no and update its mark");
System.out.println("7:reverse the linked list");
System.out.println("8:sort based on student's marks");
System.out.println("9:count the no. of elements in the list");
System.out.println("10:Delete a node from beginning");
System.out.println("11:Delete a node from end");
System.out.println("12:Delete a specific node");
System.out.println("13:Delete from any position of the list");

System.out.println("******************************************");
System.out.println("Enter the choice:");
Scanner sc=new Scanner(System.in);
int choice=sc.nextInt();
switch(choice)
{
case 0:
System.exit(0);
case 1:
start=create(start);
break;
case 2:
display(start);
break;
case 3:
start=InsBeg(start);
break;
case 4:
start=InsEnd(start);
break;
case 5:
start=InsAny(start);
break;
case 6:
search(start);
break;
case 7:
start=reverse(start);
break;
case 8:
start=sort(start);
break;
case 9:
count(start);
break;
case 10:
start=DelBeg(start);
break;
case 11:
start=DelEnd(start);
break;
case 12:
start=DelSpecific(start);
break;
case 13:
start=delany(start);
break;
default:
System.out.println("Wrong choice");
}
}
}
}

