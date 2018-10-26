package dictionary5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Delete {
	JFrame f=new JFrame("Delete");
	JPanel pn=new JPanel();
	JTextArea ta=new JTextArea("",5,5);
	JButton bt;
	JLabel lb;
	/*public static void main(String[] args){
		Delete a=new Delete();
		a.run();
	}*/
	public Delete(){
		pn.setLayout(new BoxLayout(pn,BoxLayout.Y_AXIS));
		//
		JPanel pn1=new JPanel();pn1.setBackground(Color.BLACK);
		lb=new JLabel(new ImageIcon("C:\\Users\\Administrator\\IdeaProjects\\Dictionary\\src\\main\\resources\\if_Avengers_marvel_movie_comic_book_action_3108965.png"));
		pn1.add(lb);
		//
		ta.setLineWrap(true); ta.setBackground(Color.pink); ta.setForeground(Color.BLACK);
		Font font=new Font("Arial",Font.BOLD|Font.ITALIC,20);
		ta.setFont(font);
		//
		JPanel pn2=new JPanel();pn2.setBackground(Color.cyan);
		bt=new JButton(new ImageIcon("C:\\Users\\Administrator\\IdeaProjects\\Dictionary\\src\\main\\resources\\delete.png"));
		pn2.add(bt);
		//bt.setBackground(Color.pink);
		//
		pn.add(pn1);pn.add(ta);pn.add(pn2);
		f.add(pn);
		f.setSize(300,300);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f.setResizable(false);
		f.setVisible(true);
	}
	public void run(){
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ta.getText().equals("")){
					JOptionPane.showMessageDialog(f,"Bạn cần nhập từ vào!","Message",JOptionPane.INFORMATION_MESSAGE);
				}
				else{
					FileText k=new FileText();
					int n=JOptionPane.showConfirmDialog(f,"Bạn có muốn xóa?","Question",JOptionPane.YES_NO_OPTION);
					if(n==JOptionPane.YES_OPTION) {
						String[] h=ta.getText().split("\n");
						for(String temp:h) {
							k.deleteFile(temp);
						}
						JOptionPane.showMessageDialog(f, "Đã xóa khỏi từ điển!", "Message", JOptionPane.INFORMATION_MESSAGE);
						ta.setText("");
					}
				}
			}
		});
	}
}
