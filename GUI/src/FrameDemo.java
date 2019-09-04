import java.awt.Frame;

public class FrameDemo {
	public static void main(String[] args) {
		//窗体是线程
		Frame frame = new Frame("方法调用的前后关系");
//		frame.setSize(100, 400);
//		frame.setLocation(500, 500);
		frame.setBounds(100, 400, 300, 500);
		frame.setVisible(true); 
		
		System.out.println("hello");
	}
}
