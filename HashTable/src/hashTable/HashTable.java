package hashTable;

public class HashTable {

	//����hash table���������������
	//ʹ�������������б�
	private EmployeeLinkedList[] employeeList;
	private int size; //��ʾ�ж���������
	
	public HashTable(int size) {
		//��ʼ������
		this.size = size;
		employeeList = new EmployeeLinkedList[size];
		//!!!!!!!
		//�ֱ��ʼ��ÿһ������
		for (int i = 0; i < employeeList.length; i++) {
			employeeList[i] = new EmployeeLinkedList();
		}
	}

	public void add(Employee employee) {
		//����Ա����ID���õ���Ա��Ӧ����ӵ���������
		int number = hashTemp(employee);
		//��employee��ӵ���Ӧ��������
		employeeList[number].addEmployee(employee);
	}

	public void listAll() {
		for (int i = 0; i < employeeList.length; i++) {
			employeeList[i].list(i);
		}
	}
	
	public void findEmployeeByID(int id) {
		//��ȷ����������
		int listno = id%size;
		Employee emp = employeeList[listno].findEmployee(id);
		if (emp ==null) {
			System.out.println("not found");
		}else {
			System.out.println("�ҵ��ˣ�"+ emp);
		}
	}
	
	public int hashTemp(Employee employee) {
		return employee.id % size;
	}

}
