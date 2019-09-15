package hashTable;

public class Employee {
	public int id;
	public String name;
	public Employee next;
	
	public Employee(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public String toString()
	{
		return "id:"+id + "  name:"+name; 
	}
	
}
