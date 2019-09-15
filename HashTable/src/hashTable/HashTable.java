package hashTable;

public class HashTable {

	//创建hash table用来管理多条链表
	//使用数组来管理列表
	private EmployeeLinkedList[] employeeList;
	private int size; //表示有多少条链表
	
	public HashTable(int size) {
		//初始化数组
		this.size = size;
		employeeList = new EmployeeLinkedList[size];
		//!!!!!!!
		//分别初始化每一条链表
		for (int i = 0; i < employeeList.length; i++) {
			employeeList[i] = new EmployeeLinkedList();
		}
	}

	public void add(Employee employee) {
		//根据员工的ID，得到该员工应当添加到哪条链表
		int number = hashTemp(employee);
		//将employee添加到对应的链表中
		employeeList[number].addEmployee(employee);
	}

	public void listAll() {
		for (int i = 0; i < employeeList.length; i++) {
			employeeList[i].list(i);
		}
	}
	
	public void findEmployeeByID(int id) {
		//先确定哪条链表
		int listno = id%size;
		Employee emp = employeeList[listno].findEmployee(id);
		if (emp ==null) {
			System.out.println("not found");
		}else {
			System.out.println("找到了："+ emp);
		}
	}
	
	public int hashTemp(Employee employee) {
		return employee.id % size;
	}

}
