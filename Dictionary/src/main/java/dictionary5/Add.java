package dictionary5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Add {
	JFrame f=new JFrame("Add");
	JPanel pn=new JPanel();
	JTextArea ta=new JTextArea("",5,5);
	JButton bt;
	JLabel lb;
	/*public static void main(String[] args){
		Add a=new Add();
		a.run();
	}*/
	public Add(){
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
		bt=new JButton(new ImageIcon("C:\\Users\\Administrator\\IdeaProjects\\Dictionary\\src\\main\\resources\\add.png"));
		pn2.add(bt);
		//
		//bt.setBackground(Color.pink);
		pn.add(pn1);pn.add(ta);pn.add(pn2);
		f.add(pn);
		f.setSize(300,300);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//f.setResizable(false);
		f.setVisible(true);
	}
	public void run(){
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ta.getText().equals("")) {
					JOptionPane.showMessageDialog(f, "Bạn cần nhập từ vào!", "Message", JOptionPane.INFORMATION_MESSAGE);
				} else {
					FileText k = new FileText();
					ArrayList<String> list1 = new ArrayList<String>();
					ArrayList<String> temp = new ArrayList<String>();
					ArrayList<String> temp1 = new ArrayList<String>();
					ArrayList<String> temp2 = new ArrayList<String>();
					k.TextFile(list1, "C:\\Users\\Administrator\\IdeaProjects\\Dictionary\\src\\main\\resources\\English.txt");
					k.WriteAFile("C:\\Users\\Administrator\\IdeaProjects\\Dictionary\\src\\main\\resources\\temp.txt", ta.getText() + "\n");
					k.ReadAndWrite("C:\\Users\\Administrator\\IdeaProjects\\Dictionary\\src\\main\\resources\\temp1.txt", "C:\\Users\\Administrator\\IdeaProjects\\Dictionary\\src\\main\\resources\\temp.txt");
					k.TextFile(temp, "C:\\Users\\Administrator\\IdeaProjects\\Dictionary\\src\\main\\resources\\temp.txt");
					k.TextFile(temp2,"C:\\Users\\Administrator\\IdeaProjects\\Dictionary\\src\\main\\resources\\temp1.txt");
					for (int i = 0; i < temp2.size(); i = i + 2) {
						temp1.add(temp2.get(i));
					}
					int n = JOptionPane.showConfirmDialog(f, "Bạn có muốn thêm?", "Question", JOptionPane.YES_NO_OPTION);
					if (n == JOptionPane.YES_OPTION) {
						for (int i = 0; i < temp1.size(); i++) {
							for (int j = 0; j < list1.size(); j++) {
								if (temp1.get(i).equals(list1.get(j))) {
									int m = JOptionPane.showConfirmDialog(f, "Từ " + temp1.get(i) + " trùng. Bạn có muốn thay thế " +
											"từ này trong từ điển???", "Question", JOptionPane.YES_NO_OPTION);
									if (m == JOptionPane.NO_OPTION) {
										temp.remove(i);
									}
									else{
										if(m==JOptionPane.YES_OPTION){
											k.deleteFile(temp1.get(i));
										}
									}
								}
							}
						}
						String s=new String("");
						for(int i=0;i<temp.size();i++){
							s+=temp.get(i)+"\n";
						}
						k.addFile(s);
						JOptionPane.showMessageDialog(f, "Đã thêm vào từ điển!", "Message", JOptionPane.INFORMATION_MESSAGE);
						ta.setText("");
					}
				}
			}
		});
	}
}
