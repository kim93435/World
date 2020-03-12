package bingo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class BingoGame {
	static JPanel panelNorth;
	static JPanel paneLCenter;
	static JLabel labelMessage;
	
	static JFrame f = new JFrame();
	
	
	static JButton[] buttons = new JButton[16];
	static JButton btnClear = new JButton("Game Clear");
	static String[] images= {"1.PNG","2.PNG","3.PNG","4.PNG","5.PNG","6.PNG","7.PNG","8.PNG","1.PNG","2.PNG","3.PNG","4.PNG","5.PNG","6.PNG","7.PNG","8.PNG"};
	
	static int openCount =0;
	static int buttonIndexSave1 =0;
	static int buttonIndexSave2=0;
	static Timer timer;
	static int tryCount =0;
	static int successCount =0;
	static class MyFrame extends JFrame implements ActionListener{
		public MyFrame(String title) {
			super(title);
			this.setLayout(new BorderLayout());
			this.setSize(400,500);
			this.setVisible(true);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			initUI(this);
			mixCard();
			
			this.pack();
		}
		MyFrame()
		{
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			btnClear.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{
					System.exit(0);
				}
			});
			add(btnClear);
		}
		public void actionPerformed(ActionEvent e) {
			
			if(openCount==2) {
				return;
			}
			
			
			JButton btn = (JButton)e.getSource();
			int index = getButtonIndex(btn);
			btn.setIcon(changeImage(images[index]));
			
			openCount++;
			if(openCount ==1) {
				buttonIndexSave1 = index;
				
			}
			else if(openCount==2) {
				buttonIndexSave2=index;
				tryCount++;
				labelMessage.setText("Find Same Card" + "Try" + tryCount);
				
				boolean isBingo = checkCard(buttonIndexSave1,buttonIndexSave2);
				if(isBingo==true) {
					openCount =0;
					successCount ++;
					if(successCount ==8) {
						labelMessage.setText("Game Clear");
						f.setVisible(true);
						f.setSize(500, 400);
						f.add(btnClear);
					}
				}else {
					backToQuestion();
				}
			}
		}
		public void backToQuestion() {
			timer = new Timer(500, new ActionListener() {
				public void actionPerformed(ActionEvent e) { 
					System.out.println("Timer");
					
					openCount=0;
					buttons[buttonIndexSave1].setIcon(changeImage("a.PNG"));
					buttons[buttonIndexSave2].setIcon(changeImage("a.PNG"));
					timer.stop();
					
				}
			});
			timer.start();
		}
		public boolean checkCard(int index1,int index2) {
			if(index1 == index2) {
				return false;
			}
			if(images[index1].equals(images[index2])) {
				return true;
			}else {
				return false;
			}
		}
		public int getButtonIndex(JButton btn) {
			int index = 0;
			for(int i=0; i<16; i++) {
				if(buttons[i] == btn) {
					index =i;
				}
			}
			return index;
		}
	}
	
	static void mixCard() {
		Random rand = new Random();
		for(int i=0;i<1000;i++) {
			int random = rand.nextInt(15)+1;
			String temp = images[0];
			images[0] = images[random];
			images[random]=temp;
		}
	}
	static void initUI(MyFrame myFrame){
		panelNorth = new JPanel();
		panelNorth.setPreferredSize(new Dimension(400,100));
		panelNorth.setBackground(Color.BLUE);
		labelMessage = new JLabel("Find Same Fruit!" + "Try 0");
		labelMessage.setPreferredSize(new Dimension(400,100));
		labelMessage.setForeground(Color.WHITE);
		labelMessage.setFont(new Font("monaco",Font.BOLD,20));
		labelMessage.setHorizontalAlignment(JLabel.CENTER);
		panelNorth.add(labelMessage);
		myFrame.add("North",panelNorth);
		
		paneLCenter = new JPanel();
		paneLCenter.setLayout(new GridLayout(4,4));
		paneLCenter.setPreferredSize(new Dimension(400,400));
		for(int i=0;i<16;i++) {
			buttons[i]=new JButton();
			buttons[i].setPreferredSize(new Dimension(100,100));
			buttons[i].setIcon(changeImage("a.PNG"));
			buttons[i].addActionListener(myFrame);
			paneLCenter.add(buttons[i]);
		}
		myFrame.add("Center",paneLCenter);
	}
	static ImageIcon changeImage(String filename) {
		ImageIcon icon=new ImageIcon("./img/" + filename);
		Image originImage = icon.getImage();
		Image changedImage = originImage.getScaledInstance(100,100,Image.SCALE_SMOOTH);
		ImageIcon icon_new = new ImageIcon(changedImage);
		return icon_new;
	}
	public static void main(String[] args) {
		new MyFrame("Bingo Game");
		new MyFrame();
	}
}
