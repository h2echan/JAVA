package find_hided_image_game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;




public class main extends JFrame{
	

	int lifecount=600;
	JFrame f = new JFrame();
	JButton btn0 = new JButton("���� �����ϱ�");
	JButton btn1 = new JButton("�ٽ� �ϱ�");
	MyPanel panel = new MyPanel();
	Point point = new Point();
	
	
	
	class MyPanel extends JPanel {
		
		public void paintComponent(Graphics g) {
			//�̹��� Ǯ������� ���̱�
			g.drawImage(background.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
			setOpaque(false);
			super.paintComponent(g);
		}
		
	}
	
	//���Ͼ��̿� Ŭ������ ����� ���ϰ�θ���Ʈ ��������
	file_io file = new file_io();
	
	//������ ����� ����Ʈ �����ϰ� ����
	Random random = new Random();
	int a=random.nextInt(5)+1;
	
	//��׶��� ���� ������
	String backgr_icon="C:\\Users\\h2ech\\Desktop\\��� ����\\�ҽ�������\\background1.jpg";
	ImageIcon background = new ImageIcon(backgr_icon);
	
	//���ӿ��� �̹���
	String gameover_icon="C:\\Users\\h2ech\\Desktop\\��� ����\\�ҽ�������\\�����.jpg";
	ImageIcon gameover = new ImageIcon(gameover_icon);
	
	//���� Ŭ���� �̹���
	String Challenger_icon="C:\\Users\\h2ech\\Desktop\\��� ����\\�ҽ�������\\challenger1.jpg";
	ImageIcon Challenger = new ImageIcon(Challenger_icon);
	
	//������ �������� ��ζ����ļ� �̹����ҷ����غ�
	String imageicon = file.path+"\\"+file.fileList[a];
	
	ImageIcon icon = new ImageIcon(imageicon);
	
	public main() {
		panel.add(btn0,BorderLayout.NORTH);
		panel.add(btn1,BorderLayout.NORTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 1000);
        this.add(panel,BorderLayout.CENTER);
        //panel.addMouseListener(new Mouselistener());
        addMouseListener(new Mouselistener());
        btn0.addActionListener(new buttonlistner());
        btn1.addActionListener(new buttonlistner());
        setVisible(true);
       
	}

	
	public void drawCircle(Graphics g,int x,int y) {
		//repaint();
		g.setColor(Color.blue);
		g.drawOval(x-25, y-25, 50, 50);
	}
	
	//���� �̹����� ��Ʈ ������ �����ϰ� ������ ����Ʈ
	class Point{
		int x1;
		int y1;
		
		Point(){
			x1=280;
			y1=202;
		}
		
	}
	
	//MouseListener�� �������̽��� �߻�޼ҵ尡 5���̱� ������, 5�� �޼ҵ带 �� �����ؾ��Ѵ�.
	class Mouselistener implements MouseListener{
		
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			/*
			if(e.getClickCount()==2) {
				int x,y;
				x=e.getX();
				y=e.getY();
				drawCircle(getGraphics(),x,y);
			}
			*/
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			int x,y;
			x=e.getX();
			y=e.getY();
			//System.out.println("x="+x+" y="+y);
			drawCircle(getGraphics(),x,y);
			if(x-25<point.x1&&point.x1<x+25&&y-25<point.y1&&point.y1<y+25) {
				getGraphics().drawImage(Challenger.getImage(), 0, 0, panel.getWidth(), panel.getHeight(), null);
				System.out.println("Success! you found right point!");
				lifecount=600;
			}
			else {
				System.out.println("oops you lost your life");
				repaint(lifecount, 900, 30, 30);
				lifecount=lifecount-100;
			}
			if(lifecount==200) {
				System.out.println("you lose!!!!!!!!!!!!!");
				getGraphics().drawImage(gameover.getImage(), 0, 0, panel.getWidth(), panel.getHeight(), null);
			}
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	
	class buttonlistner implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource().equals(btn0)){
				getGraphics().drawImage(icon.getImage(), 0, 0, panel.getWidth(), panel.getHeight(), null);
				get_Oval(getGraphics());
				lifecount=600;
			}
			else if(e.getSource().equals(btn1)) {
				getGraphics().drawImage(icon.getImage(), 0, 0, panel.getWidth(), panel.getHeight(), null);
				get_Oval(getGraphics());
				lifecount=600;
			}
		}
	}
	
	public void get_Oval(Graphics g) {
		g.setFont(new Font("Arial",Font.ITALIC, 30));
		g.setColor(Color.RED);
		g.drawString("life", 200, 925);
		g.fillOval(300, 900, 30, 30);
		g.fillOval(400, 900, 30, 30);
		g.fillOval(500, 900, 30, 30);
		g.fillOval(600, 900, 30, 30);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new main();
	}

}
