package dictionary5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Edit {
	JFrame f=new JFrame("Edit");
	JPanel pn=new JPanel();
	JLabel lb1=new JLabel();
	JLabel lb2=new JLabel();
	JLabel lb;
	JTextField tf1=new JTextField(11);
	JTextField tf2=new JTextField(11);
	JButton bt1;
	JButton bt2;
	/*public static void main(String[] args){
		Edit a=new Edit();
		a.run();
	}*/
	public Edit(){
		pn.setLayout(new BoxLayout(pn,BoxLayout.Y_AXIS));pn.setBackground(Color.BLACK);
		//
		Font font=new Font("Arial",Font.BOLD|Font.ITALIC,15);
		tf1.setFont(font);
		tf2.setFont(font);
		JPanel pn1=new JPanel();pn1.setBackground(Color.BLACK);
		lb=new JLabel(new ImageIcon("C:\\Users\\Administrator\\IdeaProjects\\Dictionary\\src\\main\\resources\\if_Avengers_marvel_movie_comic_book_action_3108965.png"));
		pn1.add(lb);
		//
		lb1.setText("ENGLISH");lb1.setForeground(Color.WHITE);
		lb2.setText("VIETNAMESE");lb2.setForeground(Color.WHITE);
		lb1.setFont(font);
		lb2.setFont(font);
		//
		JPanel pn2=new JPanel();pn2.setBackground(Color.pink);
		//pn2.setLayout(new BoxLayout(pn2,BoxLayout.X_AXIS));
		//
		JPanel pn3=new JPanel();pn3.setBackground(Color.pink);
		pn3.setLayout(new BoxLayout(pn3,BoxLayout.Y_AXIS));
		JPanel pn31=new JPanel();pn31.setBackground(Color.BLACK);
		pn31.add(lb1);
		pn3.add(pn31);
		pn3.add(tf1);
		//
		JPanel pn4=new JPanel();pn4.setBackground(Color.pink);
		pn4.setLayout(new BoxLayout(pn4,BoxLayout.Y_AXIS));
		JPanel pn41=new JPanel();pn41.setBackground(Color.BLACK);
		pn41.add(lb2);
		pn4.add(pn41);
		pn4.add(tf2);
		//
		JPanel pn6=new JPanel();pn6.setBackground(Color.pink);
		pn6.setLayout(new BoxLayout(pn6,BoxLayout.Y_AXIS));
		bt1=new JButton(new ImageIcon("C:\\Users\\Administrator\\IdeaProjects\\Dictionary\\src\\main\\resources\\find.png"));
		JLabel k=new JLabel(" ");
		pn6.add(k);pn6.add(bt1);
		//bt1.setBackground(Color.BLACK);
		//
		pn2.add(pn3);pn2.add(pn6);pn2.add(pn4);
		//
		JPanel pn5=new JPanel();pn5.setBackground(Color.cyan);
		bt2=new JButton(new ImageIcon("C:\\Users\\Administrator\\IdeaProjects\\Dictionary\\src\\main\\resources\\edit.png"));
		pn5.add(bt2);
		//bt2.setBackground(Color.pink);
		//
		pn.add(pn1);
		pn.add(pn2);
		pn.add(pn5);
		f.add(pn);
		f.setSize(420,215);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		f.setResizable(false);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	public void run(){
		bt1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DictionaryManagement a=new DictionaryManagement();
				String k=a.dictionaryLookup(tf1.getText());
				tf2.setText(k);
				FileText m = new FileText();
				m.deleteFile(tf1.getText());
			}
		});
		bt2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tf1.getText().equals("")||tf2.getText().equals("")){
					JOptionPane.showMessageDialog(f,"Bạn cần nhập từ vào và nhấn vào nút con mắt!!!","Message",JOptionPane.INFORMATION_MESSAGE);
				}
				else{
					FileText k = new FileText();
					k.addFile(tf1.getText()+"	"+tf2.getText()+"\n");
					JOptionPane.showMessageDialog(f, "Đã chỉnh sửa xong!", "Message", JOptionPane.INFORMATION_MESSAGE);
					tf1.setText("");
					tf2.setText("");
				}
			}
		});
	}
}
