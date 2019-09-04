import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
//事件监听机制：
/*	A. 事件源    事件发生的地方
	B. 事件   要发生什么
	C. 事件处理  结果是什么
	D. 事件监听，就是把事件源和事件联系起来*/
public class FrameListen {
	public static void main(String[] args) {
		//让窗体关闭
		Frame frame = new Frame("处理事件");
		frame.setBounds(400, 200, 600, 500);
		frame.setVisible(true); 
		frame.setLayout(new FlowLayout());
		
		Button button1 = new Button("start Server");
		button1.setSize(20, 10);
		Button button2 = new Button("start client");
		button2.setSize(20, 10);
		frame.add(button1);
		frame.add(button2);
		//事件源
		//事件
		//事件处理     system.exit(0)
		//事件监听
		//
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);;
			}
		});
		
		button1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Server is starting");
			}
		});
		
		button2.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("A new client is starting");
			}
		});
		//实现接口过于麻烦，哪怕是空实现
		/*
		 * frame.addWindowListener(new WindowListener() {
		 * 
		 * @Override public void windowOpened(WindowEvent e) { // TODO Auto-generated
		 * method stub
		 * 
		 * }
		 * 
		 * @Override public void windowIconified(WindowEvent e) { // TODO Auto-generated
		 * method stub
		 * 
		 * }
		 * 
		 * @Override public void windowDeiconified(WindowEvent e) { // TODO
		 * Auto-generated method stub
		 * 
		 * }
		 * 
		 * @Override public void windowDeactivated(WindowEvent e) { // TODO
		 * Auto-generated method stub
		 * 
		 * }
		 * 
		 * @Override public void windowClosing(WindowEvent e) { // TODO Auto-generated
		 * method stub System.exit(0); }
		 * 
		 * @Override public void windowClosed(WindowEvent e) { // TODO Auto-generated
		 * method stub
		 * 
		 * }
		 * 
		 * @Override public void windowActivated(WindowEvent e) { // TODO Auto-generated
		 * method stub
		 * 
		 * } });
		 */
	}
	
	

}
