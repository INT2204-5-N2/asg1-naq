package Test;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyEventTest implements KeyListener {
	JFrame f=new JFrame("NAQ");
	JPanel pn=new JPanel();
	JTextArea ta1=new JTextArea("",10,5);
	JTextArea ta2=new JTextArea("",10,5);
	public KeyEventTest(){
		pn.setLayout(new BoxLayout(pn,BoxLayout.Y_AXIS));
		pn.setBackground(Color.BLACK);
		JLabel lb=new JLabel("  ");
		ta1.addKeyListener(this);
		ta2.setText("Enter here"); ta2.setForeground(Color.lightGray);
		pn.add(ta1);
		pn.add(lb);
		pn.add(ta2);
		f.add(pn);
		f.setSize(300,300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	public static void main(String[] args){
		KeyEventTest a=new KeyEventTest();
	}
	public void keyTyped(KeyEvent e) {
		ta2.setText("");
	}

	public void keyPressed(KeyEvent e) {
		ta2.setText("2");
	}

	public void keyReleased(KeyEvent e) {
		ta2.setText("3");
	}
}
