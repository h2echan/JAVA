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
	JButton btn0 = new JButton("게임 시작하기");
	JButton btn1 = new JButton("다시 하기");
	MyPanel panel = new MyPanel();
	Point point = new Point();
	
	
	
	class MyPanel extends JPanel {
		
		public void paintComponent(Graphics g) {
			//이미지 풀사이즈로 보이기
			g.drawImage(background.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
			setOpaque(false);
			super.paintComponent(g);
		}
		
	}
	
	//파일아이오 클래스에 저장된 파일경로리스트 가져오기
	file_io file = new file_io();
	
	//사진이 저장된 리스트 랜덤하게 선택
	Random random = new Random();
	int a=random.nextInt(5)+1;
	
	//백그라운드 사진 블러오기
	String backgr_icon="C:\\Users\\h2ech\\Desktop\\길드 사진\\소스사진들\\background1.jpg";
	ImageIcon background = new ImageIcon(backgr_icon);
	
	//게임오버 이미지
	String gameover_icon="C:\\Users\\h2ech\\Desktop\\길드 사진\\소스사진들\\브론즈.jpg";
	ImageIcon gameover = new ImageIcon(gameover_icon);
	
	//게임 클리어 이미지
	String Challenger_icon="C:\\Users\\h2ech\\Desktop\\길드 사진\\소스사진들\\challenger1.jpg";
	ImageIcon Challenger = new ImageIcon(Challenger_icon);
	
	//랜덤한 사진파일 경로랑합쳐서 이미지불러올준비
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
	
	//게임 이미지의 하트 내에서 랜덤하게 생성될 포인트
	class Point{
		int x1;
		int y1;
		
		Point(){
			x1=280;
			y1=202;
		}
		
	}
	
	//MouseListener는 인터페이스고 추상메소드가 5개이기 때문에, 5개 메소드를 다 구현해야한다.
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
