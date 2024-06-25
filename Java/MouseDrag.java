
import java.awt.MouseInfo; 
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MouseDrag {
	
	public static JFrame frame = new JFrame();
	
	public static void main(String[] args) {
		frame.setSize(400,400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton button = new JButton("Drag Me");
		
		frame.add(button);
		frame.setLayout(null);
		
		button.setBounds(10,10,100,20);
		
		button.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseDragged(MouseEvent e) {
				PointerInfo mouseCor = MouseInfo.getPointerInfo();
				Point l = mouseCor.getLocation();
				int x = (int) l.getX();
				int y = (int) l.getY();
				
				System.out.println(x+ " "+y);
				
				button.setLocation((int) l.getX()-50,(int) l.getY()-50);
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}		
		});
	}

}
