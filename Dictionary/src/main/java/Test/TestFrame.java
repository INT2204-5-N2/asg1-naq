package Test;

//import javafx.scene.paint.Color;

import javax.swing.*;
import java.awt.*;

public class TestFrame {
	public static void main(String[] args){
		JFrame f=new JFrame("NAQ");
		JButton bt=new JButton("Next");
		//Color color=Color.hsb(165,63,100);
		bt.setBackground(Color.getHSBColor(100,65,80));
		f.setLayout(new FlowLayout());
		f.add(bt);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(500,500);
		f.setVisible(true);
	}
}
