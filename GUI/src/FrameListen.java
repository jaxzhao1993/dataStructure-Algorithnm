import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
//�¼��������ƣ�
/*	A. �¼�Դ    �¼������ĵط�
	B. �¼�   Ҫ����ʲô
	C. �¼�����  �����ʲô
	D. �¼����������ǰ��¼�Դ���¼���ϵ����*/
public class FrameListen {
	public static void main(String[] args) {
		//�ô���ر�
		Frame frame = new Frame("�����¼�");
		frame.setBounds(400, 200, 600, 500);
		frame.setVisible(true); 
		frame.setLayout(new FlowLayout());
		
		Button button1 = new Button("start Server");
		button1.setSize(20, 10);
		Button button2 = new Button("start client");
		button2.setSize(20, 10);
		frame.add(button1);
		frame.add(button2);
		//�¼�Դ
		//�¼�
		//�¼�����     system.exit(0)
		//�¼�����
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
		//ʵ�ֽӿڹ����鷳�������ǿ�ʵ��
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
