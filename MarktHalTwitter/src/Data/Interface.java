package Data;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.*;

import twitter4j.TwitterException;

import java.awt.*;
import java.io.File;
import java.io.IOException;


public class Interface {

	public static void userinterface() {


		        JFrame jFrame = new JFrame();
		        jFrame.setVisible(true);
		        jFrame.setSize(800, 600);
		        jFrame.setLayout(new FlowLayout());
		        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		       
		        
		          
		          
		          /*  
		            final Label label = new Label("Hallo");
		            label.setPreferredSize(new Dimension(775, 525));
		            label.setBackground(Color.BLACK);
		            label.setForeground(Color.WHITE);
		            jFrame.add(label);
		          */  
		          
		          JPanel panel = new JPanel();
		          panel.setBackground(Color.black);
		          panel.setSize(775, 525);
		          jFrame.setContentPane(panel);
		          
		          JButton button = new JButton("Country Infomation");
		          jFrame.add(button);
		          
		          JButton button2 = new JButton("Nothing");
		          jFrame.add(button2);
		        
		          JButton button3 = new JButton("Nothing");
		          jFrame.add(button3);
		        
		          JButton button4 = new JButton("Nothing");
		          jFrame.add(button4);
		        
		          JButton button5 = new JButton("Pick Twitter Data");
		          jFrame.add(button5);
		            
		          
		          
		                   
		              ActionListener mijnActie = new ActionListener() {
		                  @Override
		                   public void actionPerformed(ActionEvent a) {
		                	  try{
		                	  PieChart.MakeChart();
		                      String path = "C:/Users/Oscar Veldman/workspace/MarktHalTwitter/Country.jpeg";
		                      File file = new File(path);
		                      BufferedImage image;
		                      image = ImageIO.read(file);
		                      JLabel label = new JLabel(new ImageIcon(image));
		                      jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		                      jFrame.getContentPane().add(label);
		                      jFrame.pack();
		                      jFrame.setLocation(200,200);
		                      jFrame.setVisible(true);
		                	  }catch(Exception e){
		                	  
		                  }
		                  }
					
		              };
		                         
		               ActionListener mijnTerugActie = new ActionListener() {
		                   @Override
		                   public void actionPerformed(ActionEvent b) {
		            //	      label.setText("Hier komt alles in");
		                   }
		              };
		              
		               ActionListener StreamingTW = new ActionListener()  {
		                   @Override
		                   public void actionPerformed(ActionEvent b) {
		                	JFrame frame = new JFrame();
		           			String Twittername = JOptionPane.showInputDialog(frame, "Enter printer name:");
		        			try {
								TwitterApi.Streaming(Twittername);
							} catch (TwitterException e) {
								e.printStackTrace();
							}
		                   }
		              };
		              {
		               
		               
		             button.addActionListener(mijnActie);
		             button2.addActionListener(mijnTerugActie);
		             button3.addActionListener(mijnActie);
		             button4.addActionListener(mijnActie);
		             button5.addActionListener(StreamingTW);
		             
		             

}
		      };
	}

	
