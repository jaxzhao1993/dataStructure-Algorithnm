import java.awt.Frame;

public class FrameDemo {
	public static void main(String[] args) {
		//�������߳�
		Frame frame = new Frame("�������õ�ǰ���ϵ");
//		frame.setSize(100, 400);
//		frame.setLocation(500, 500);
		frame.setBounds(100, 400, 300, 500);
		frame.setVisible(true); 
		
		System.out.println("hello");
	}
}
