package p4;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class copy {
public static void main(String[] args) throws IOException{
	
	FileInputStream fileInput = new FileInputStream("a.txt");
	FileOutputStream fileOutput = new FileOutputStream("b.txt");
	int len;
	int temp = 0;
	byte[] b = new byte[1024];
	while(true)
	{
		if((len= fileInput.read(b))==-1)
		{
			break;
		}
		temp = len;
	}
	fileOutput.write(b,0,temp);
	fileInput.close();
	fileOutput.close();
}
}
