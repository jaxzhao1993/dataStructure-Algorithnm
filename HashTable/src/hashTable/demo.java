package hashTable;

import java.util.Scanner;

public class demo {

	public static void main(String[] args) {
		HashTable hashTable = new HashTable(5);
		String keyString = " ";
		Scanner input = new Scanner(System.in);
		while(true)
		{
			System.out.println("add");
			System.out.println("list");
			System.out.println("find");
			keyString = input.next();
			switch (keyString) {
			case "add":
				System.out.println(" ‰»ÎID");
				int id = input.nextInt();
				System.out.println(" ‰»Îname");
				String name = input.next();
				
				Employee emp = new Employee(id, name);
				hashTable.add(emp);
				break;
				
			case "list":
				hashTable.listAll();
				break;

			case "find":
				System.out.println("ID £ø£ø");
				int id1 = input.nextInt();
				hashTable.findEmployeeByID(id1);
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + keyString);
			}
		}
	}
}
