
public class LinkedList {

	static class Node{
		int data;
		Node next;
		Node(int d){
			data = d;
			next = null;
		}
	}
	
	Node head;
	


public void push(int data){
	Node new_node = new Node(data);
	new_node.next = head;
	head = new_node;
	
}

public void append(int data){
	Node new_node = new Node(data);
	new_node.next = null;
	if (head == null)
    {
        head = new_node;
        return;
    }
	Node n = head;
	while(n.next != null){
		n = n.next;
	}
	n.next = new_node;
	
}

public void insert(Node prev, int data){
	Node new_node = new Node(data);
	Node n = head;
	
	while(n != prev){
		n = n.next;
	}
	Node temp = n.next;
	n.next = new_node;
	new_node.next = temp;
	
}

public void delete(int data){
	Node n = head;
	if(n != null && n.data == data){
		n.next = head;
		n = null;
		return;
	}
	Node prev = null;
	while(n.data != data){
		 prev = n;
		n = n.next;
	}
	prev.next = n.next;
}

public void deleteAt(int pos){
	int count =0;
	Node n = head;
	if(n != null && pos == count){
		n.next = head;
		n = null;
		return;
	}
	Node prev = null;
	while(count != pos){
		prev = n;
		n = n.next;
		count++;
	}
	prev.next = n.next;
}

public void swap(int x, int y){
	if(x == y){
		return;
	}
	Node n = head;
	Node prevn = null;
	while(n.data != x){
		prevn = n;
		n = n.next;
	}
	Node m = head;
	Node prevm = null;
	while(m.data != y){
		prevm = m;
		m = m.next;
	}
	prevn.next = m;
	Node temp = m.next;
	m.next = n.next;
	prevm.next = n;
	n.next = temp;
	
}

public void middleOf(){
	Node i = head;
	Node j = head;
	
	if(head.next == null){
		System.out.println(head);
		return;
	}
	while(j.next != null){
		i = i.next;
		j= j.next.next;
	}
	System.out.println(i.data);
}

public void nthFfromBehind(int n){
	Node i = head;
	Node j = head;
	int count = 0;
	
	while( count != n){
		j = j.next;
		count++;
	}
	while(j != null){
		i = i.next;
		j = j.next;
	}
	System.out.println(i.data);
}

public void deleteList(){
	head = null;
	//Deletes entire linked list (In java garbage collection is done automatically)
}

public void reverse(){
Node prev = null;
Node current = head;
Node next = null;

while(current != null){
	next = current.next;
	current.next = prev;
	prev = current;
	current = next;
}
	head = prev;
}

public Node reverse(Node head,int k){
	Node prev = null;
	Node current = head;
	Node next = null;
	int count = 0;
	while(current != null && count < k){
		next = current.next;
		current.next = prev;
		prev = current;
		current = next;
		count++;
	}
	if (next != null) {
		head.next = reverse(next, k);
	}
        
		return prev;
}


	public boolean isLooped(){
		Node i = head;
		Node j = head;
		while(j != null && j.next != null){
			i = i.next;
			j = j.next.next;
			if(i == j){
				return true;
			}
		}
		return false;
	}


public void printList(){
	Node n = head;
	while(n != null){
		System.out.print(n.data + " ");
		n = n.next;
	}
	System.out.print("\n");
}

public static void main(String[] args){
	LinkedList llist = new LinkedList();
	llist.append(9);
	llist.append(8);
	llist.append(7);
	llist.insert(llist.head.next,6);
	llist.deleteAt(2);
	llist.append(5);
	llist.append(4);
	llist.append(3);
	llist.swap(8, 4);
	llist.append(2);
	llist.middleOf();
	llist.nthFfromBehind(3);
	llist.printList();
	llist.reverse();
	llist.printList();
}

}
