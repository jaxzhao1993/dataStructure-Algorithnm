package hashTable;

public class EmployeeLinkedList {
	//ͷָ��,ִ�е�һ��emp,ֱ��ָ���һ����Ա
	private Employee head = null;
	
	//�ٶ�ID����������
	public void addEmployee(Employee emp) {
		//����ǵ�һ����Ա
		if (head ==null) {
			head = emp;
			return;
		}else {
			//������ǵ�һ����Ա��ʹ��һ������ָ��
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
			System.out.println("��"+no+"����Ϊ��");
			return;
		}
		System.out.print("��"+no+"����");
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
			System.out.println("����Ϊ��");
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
