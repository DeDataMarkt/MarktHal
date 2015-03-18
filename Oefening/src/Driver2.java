import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


public class Driver2 {

	public static void main(String[] args) {
		JFrame jframe= new JFrame();
		jframe.setVisible(true);
		jframe.setSize(200, 200);
		jframe.setLayout(new FlowLayout());
		jframe.setDefaultCloseOperation(jframe.EXIT_ON_CLOSE);
		
		JButton button = new JButton("Klik hier!");
		jframe.add(button);
		
		ActionListener mijnActie = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)	{
				System.out.println("Er is geklikt");
			}
		};
		button.addActionListener(mijnActie);
		
		jframe.add(new JButton("test2"));
		
	}
	

}
