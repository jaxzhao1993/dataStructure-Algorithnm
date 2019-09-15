package hashTable;

public class EmployeeLinkedList {
	//头指针,执行第一个emp,直接指向第一个雇员
	private Employee head = null;
	
	//假定ID是自增长的
	public void addEmployee(Employee emp) {
		//如果是第一个雇员
		if (head ==null) {
			head = emp;
			return;
		}else {
			//如果不是第一个雇员，使用一个辅助指针
			Employee current = head;
			while(true)
			{
				if(current.next==null)
				{
					break;
				}
				current = current.next;
			}
			current.next = emp;
			emp.next = null;
		}
	}
	
	public void list(int no) {
		if(head ==null)
		{
			System.out.println("第"+no+"链表为空");
			return;
		}
		System.out.print("第"+no+"链表：");
		Employee current = head;
		while(true)
		{	
			System.out.println("=>ID="+current.id+" name="+current.name +"\t");
			if (current.next==null) 
			{
			break;
			}
			current = current.next;
		}
		System.out.println();
	}
	
	public Employee findEmployee(int id) {
		if (head==null) {
			System.out.println("链表为空");
			return null;
		}
		Employee current = head;
		while(true)
		{
			if (current.id == id) {
				return current;
			}
			if (current.next==null) {
				System.out.println("not found");
				return null;
			}
			current = current.next;
			
		}
	}
}
