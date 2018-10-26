package dictionary4;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class dictionaryApplication {
	private JFrame f=new JFrame("DICTIONARY");
	private JPanel p=new JPanel();
	private JLabel lb1=new JLabel(); JTextArea tf1=new JTextArea("",3,8); JTextArea ta1=new JTextArea(20,8);
	private JLabel lb2=new JLabel(); JTextArea ta2=new JTextArea(20,10);
	private JButton bt1;
	private JButton bt2;
	private JButton bt3;
	private JButton bt4;
	private JButton bt5;
	JScrollPane scr1;
	JScrollPane scr2;
	public static void main(String [] args){
		dictionaryApplication a=new dictionaryApplication();
		a.run();
	}
	public dictionaryApplication(){
		//f.setContentPane(new JLabel(new ImageIcon("C:\\Users\\Administrator\\IdeaProjects\\Dictionary\\src\\main\\resources\\bk.jpg")));
		p.setLayout(new BorderLayout());
		//f.setLayout(new BorderLayout());
		//Thanh cuốn
		scr1=new JScrollPane(ta1);
		scr2=new JScrollPane(ta2);
		//tf1.setBackground(Color.pink);
		//ta1.setBackground(Color.pink);
		//ta2.setBackground(Color.pink);
		//tự động xuống dòng
		tf1.setWrapStyleWord(true);tf1.setLineWrap(true);
		//ta1.setWrapStyleWord(true);ta1.setLineWrap(true);
		//ta2.setWrapStyleWord(true);ta2.setLineWrap(true);
		//Phụ
		JLabel s=new JLabel("a"); s.setForeground(Color.BLACK);
		JLabel w=new JLabel("a"); w.setForeground(Color.BLACK);
		JLabel e=new JLabel("a"); e.setForeground(Color.BLACK);
		JLabel n=new JLabel("AH"); n.setForeground(Color.BLACK);
		JLabel c=new JLabel("AHJ"); c.setForeground(Color.BLACK);
		JLabel n1=new JLabel("AHJAAAAAAAAAAAAAAA"); n1.setForeground(Color.BLACK);
		//
		JPanel pNorth=new JPanel();
		pNorth.setBackground(Color.BLACK);
		pNorth.setLayout(new BoxLayout(pNorth,BoxLayout.X_AXIS));
		bt1=new JButton(new ImageIcon("C:\\Users\\Administrator\\IdeaProjects\\Dictionary\\src\\main\\resources\\search.png"));
		bt2=new JButton(new ImageIcon("C:\\Users\\Administrator\\IdeaProjects\\Dictionary\\src\\main\\resources\\look.png"));
		bt3=new JButton(new ImageIcon("C:\\Users\\Administrator\\IdeaProjects\\Dictionary\\src\\main\\resources\\admin.png"));
		bt4=new JButton(new ImageIcon("C:\\Users\\Administrator\\IdeaProjects\\Dictionary\\src\\main\\resources\\reset.png"));
		bt5=new JButton(new ImageIcon("C:\\Users\\Administrator\\IdeaProjects\\Dictionary\\src\\main\\resources\\speak.png"));
		bt1.setBackground(Color.pink);
		bt2.setBackground(Color.pink);
		bt3.setBackground(Color.pink);
		bt4.setBackground(Color.pink);
		bt5.setBackground(Color.pink);
		/*bt1=new JButton("Search");
		bt2=new JButton("Look");
		bt3.setText("Admin");
		bt4.setText("Reset");*/
		pNorth.add(n);
		pNorth.add(bt1);
		pNorth.add(bt2);
		pNorth.add(bt3);
		pNorth.add(n1);
		pNorth.add(bt5);
		//các phía xung quanh
		JPanel pWest=new JPanel();
		pWest.setBackground(Color.BLACK); pWest.add(w);
		//
		JPanel pEast=new JPanel();
		pEast.setBackground(Color.BLACK); pEast.add(e);
		//
		JPanel pSouth=new JPanel();
		JLabel bb=new JLabel("kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");bb.setForeground(Color.BLACK);
		pSouth.add(bb);
		pSouth.add(bt4);
		pSouth.setBackground(Color.BLACK);
		pSouth.add(s);
		//
		JPanel pCenter=new JPanel();
		pCenter.setLayout(new BoxLayout(pCenter, BoxLayout.X_AXIS));
		pCenter.setBackground(Color.BLACK);
		//
		JPanel c1=new JPanel();
		c1.setLayout(new BoxLayout(c1,BoxLayout.Y_AXIS));
		c1.setBackground(Color.pink);
		lb1.setText("ENGLISH:");lb1.setForeground(Color.BLACK);
		Font font=new Font("Arial",Font.BOLD | Font.ITALIC,20);
		lb1.setFont(font);
		JPanel t1=new JPanel();
		t1.setBackground(Color.PINK);
		t1.add(lb1);
		//Phụ
		JLabel l=new JLabel("  ");
		JPanel t2=new JPanel();
		t2.setBackground(Color.BLACK);
		JLabel l1=new JLabel(" ");
		t2.add(l1);
		c1.add(t2);c1.add(t1);c1.add(tf1);c1.add(l);c1.add(scr1);
		//
		JPanel c2=new JPanel();
		c2.setLayout(new BoxLayout(c2,BoxLayout.Y_AXIS));
		c2.setBackground(Color.pink);
		lb2.setText("VIETNAMESE:");lb2.setForeground(Color.BLACK);
		lb2.setFont(font);
		JPanel t3=new JPanel();
		t3.setBackground(Color.PINK);
		t3.add(lb2);
		//Phụ
		JPanel t4=new JPanel();
		t4.setBackground(Color.BLACK);
		JLabel l2=new JLabel(" ");
		t4.add(l2);
		c2.add(t4);c2.add(t3);c2.add(scr2);
		//
		pCenter.add(c1);pCenter.add(c);pCenter.add(c2);
		p.add(pNorth,BorderLayout.NORTH);
		p.add(pSouth,BorderLayout.SOUTH);
		p.add(pWest,BorderLayout.WEST);
		p.add(pEast,BorderLayout.EAST);
		p.add(pCenter,BorderLayout.CENTER);

		//
		//f.setContentPane(new JLabel(new ImageIcon("C:\\Users\\Administrator\\IdeaProjects\\Dictionary\\src\\main\\resources\\background.png")));
		f.add(p);
		//f.pack();
		f.setSize(450,450);
		f.setResizable(false);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		//DictionaryManagement b=new DictionaryManagement();
		//b.dictionaryExportToFile();
	}
	public void run(){
		ta1.setEditable(false);
		ta2.setEditable(false);
		String d=new String("");
		FileText file=new FileText();
		//file.ReadAndWrite();
		ArrayList<String> list=new ArrayList<String>();
		file.TextFile(list,"Dictionary.txt");
		int i;
		for(i=0;i<list.size();i+=2){
			d+="+"+list.get(i)+"\n";
		}
		Font font=new Font("Arial",Font.BOLD|Font.ITALIC,20);
		ta1.setFont(font); ta2.setFont(font); tf1.setFont(font);
		ta1.setText(d);
		bt1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(tf1.getText().equals("")){
					JOptionPane.showMessageDialog(f,"Bạn cần phải nhập từ!","Message",JOptionPane.INFORMATION_MESSAGE);
				}
				else{
					DictionaryManagement a=new DictionaryManagement();
					String h=a.search(tf1.getText());
					ta1.setText(h);
				}
			}
		});
		bt2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tf1.getText().equals("")){
					JOptionPane.showMessageDialog(f,"Bạn cần phải nhập từ!","Message",JOptionPane.INFORMATION_MESSAGE);
				}
				else{
					DictionaryManagement a=new DictionaryManagement();
					String[] h=tf1.getText().split("\n");
					String k=new String("");
					for(String temp:h){
						k+=a.dictionaryLookup(temp)+"\n";
					}
					ta2.setText(k);
				}
			}
		});
		bt4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ta2.setText("");
				tf1.setText("");
				String d=new String("");
				FileText file=new FileText();
				ArrayList<String> list=new ArrayList<String>();
				file.TextFile(list,"Dictionary.txt");
				int i;
				for(i=0;i<list.size();i+=2){
					d+="+"+list.get(i)+"\n";
				}
				ta1.setText(d);
			}
		});
		bt3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n=JOptionPane.showConfirmDialog(f,"Bạn muốn chỉnh sửa từ điển?","Question",JOptionPane.YES_NO_OPTION);
				if(n==JOptionPane.YES_OPTION){
					SignIn a=new SignIn();
					a.run();
				}
			}
		});
	}
}
