
/*
 갯수를 모르는 여러 파일이 있는데그 중 이미지 파일만 골라서
 랜덤으로 한장 출력하는걸 만들고
 그 위에 클릭할때마다 빨간색 원을 생성하는 프로그램
*/
package day2;
import day2.file_io;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.ScrollPane;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class main extends JFrame  {
	
	JFrame f = new JFrame();
	private MyPanel panel = new MyPanel();
	//파일아이오 클래스에 저장된 파일경로리스트 가져오기
	file_io file = new file_io();
	//사진이 저장된 리스트 랜덤하게 선택
	Random random = new Random();
	int a=random.nextInt(7)+1;
	//랜덤한 사진파일 경로랑합쳐서 이미지불러올준비
	String imageicon = file.path+"\\"+file.fileList[a];
	ImageIcon icon = new ImageIcon(imageicon);
	
	public main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 1000);
        setContentPane(panel);
        //panel.addMouseListener(new Mouselistener());
        addMouseListener(new Mouselistener());
        setVisible(true);
	}
	
	class MyPanel extends JPanel {
		public void paintComponent(Graphics g) {
			//이미지 풀사이즈로 보이기
			g.drawImage(icon.getImage(), 0, 0, null);
			setOpaque(false);
			super.paintComponent(g);
		}
		
	}
	
	public void drawCircle(Graphics g,int x,int y) {
		//repaint();
		g.setColor(Color.blue);
		g.drawOval(x, y, 50, 50);
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
			drawCircle(getGraphics(),x,y);
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new main();
	}

}
