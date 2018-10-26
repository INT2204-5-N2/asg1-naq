package dictionary5;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class DictionaryApplication implements KeyListener {
	private JFrame f=new JFrame("DICTIONARY");
	private JPanel p=new JPanel();
	private JLabel lb1=new JLabel(); JTextField tf1=new JTextField("",15); JTextArea ta1=new JTextArea(20,15);
	private JLabel lb2=new JLabel(); JTextArea ta2=new JTextArea(20,15);
	private JButton bt1;
	private JButton bt2;
	private JButton bt3;
	private JButton bt4;
	private JButton bt5;
	private JButton bt6;
	private JButton bt7;
	JScrollPane scr1;
	JScrollPane scr2;
	/*public static void main(String [] args){
		DictionaryApplication a=new DictionaryApplication();
		a.run();
	}*/
	public DictionaryApplication(){
		p.setLayout(new BoxLayout(p,BoxLayout.Y_AXIS));
		//
		scr1=new JScrollPane(ta1);
		ta1.setForeground(Color.BLACK);
		tf1.setForeground(Color.BLACK);
		lb1.setForeground(Color.BLACK);
		lb2.setForeground(Color.BLACK);
		//scr2=new JScrollPane(ta2);
		//
		JPanel pn1=new JPanel();pn1.setBackground(Color.BLACK);
		JLabel a=new JLabel("kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");a.setForeground(Color.BLACK);
		bt1=new JButton(new ImageIcon("C:\\Users\\Administrator\\IdeaProjects\\Dictionary\\src\\main\\resources\\speak.png"));
		pn1.add(a);pn1.add(bt1);
		//
		JPanel pn2=new JPanel();pn2.setBackground(Color.BLACK);
		pn2.setLayout(new BoxLayout(pn2,BoxLayout.X_AXIS));
		//
		JPanel pn21 =new JPanel();pn21.setBackground(Color.BLACK);
		pn21.setLayout(new BoxLayout(pn21,BoxLayout.Y_AXIS));
		JLabel lb=new JLabel(new ImageIcon("C:\\Users\\Administrator\\IdeaProjects\\Dictionary\\src\\main\\resources\\if_accessories-dictionary_23662 (1).png"));
		JLabel kkkkk=new JLabel(" \n \n ");
		bt2=new JButton(new ImageIcon("C:\\Users\\Administrator\\IdeaProjects\\Dictionary\\src\\main\\resources\\ad.png"));
		JLabel k=new JLabel(" ");
		bt3=new JButton(new ImageIcon("C:\\Users\\Administrator\\IdeaProjects\\Dictionary\\src\\main\\resources\\dele.png"));
		JLabel kk=new JLabel(" ");
		bt4=new JButton(new ImageIcon("C:\\Users\\Administrator\\IdeaProjects\\Dictionary\\src\\main\\resources\\edi.png"));
		JLabel kkk=new JLabel(" ");
		bt5=new JButton(new ImageIcon("C:\\Users\\Administrator\\IdeaProjects\\Dictionary\\src\\main\\resources\\expo.png"));
		JLabel kkkk=new JLabel(" ");
		bt6=new JButton(new ImageIcon("C:\\Users\\Administrator\\IdeaProjects\\Dictionary\\src\\main\\resources\\hel.png"));
		JLabel i=new JLabel("k");i.setForeground(Color.BLACK);
		JLabel ii=new JLabel("k");ii.setForeground(Color.BLACK);
		JLabel iii=new JLabel("k");iii.setForeground(Color.BLACK);
		pn21.add(lb);pn21.add(kkkkk);pn21.add(bt2);pn21.add(k);pn21.add(bt3);pn21.add(kk);pn21.add(bt4);pn21.add(kkk);pn21.add(bt5);pn21.add(kkkk);pn21.add(bt6);pn21.add(i);pn21.add(ii);pn21.add(iii);
		//
		JLabel aa=new JLabel("   ");
		//
		JPanel pn22=new JPanel();pn22.setBackground(Color.BLACK);
		pn22.setLayout(new BoxLayout(pn22,BoxLayout.Y_AXIS));
		lb1.setText("ENGLISH:");
		Font font=new Font("Arial",Font.BOLD | Font.ITALIC,20);
		lb1.setFont(font);
		JPanel t1=new JPanel();
		t1.setBackground(Color.pink);
		t1.add(lb1);
		JLabel aaa=new JLabel("  ");
		pn22.add(t1);pn22.add(tf1);pn22.add(aaa);pn22.add(scr1);
		//
		JLabel aaaa=new JLabel("     ");
		//
		JPanel pn23=new JPanel();pn23.setBackground(Color.BLACK);
		pn23.setLayout(new BoxLayout(pn23,BoxLayout.Y_AXIS));
		lb2.setText("VIETNAMESE:");
		lb2.setFont(font);
		JPanel t3=new JPanel();
		t3.setBackground(Color.pink);
		t3.add(lb2);
		ta2.setLineWrap(true);
		pn23.add(t3);pn23.add(ta2);
		//
		JLabel aaaaa=new JLabel("   ");
		//
		pn2.add(pn21);pn2.add(aa);pn2.add(pn22);pn2.add(aaaa);pn2.add(pn23);pn2.add(aaaaa);
		//
		JPanel pn3=new JPanel();pn3.setBackground(Color.BLACK);
		JLabel aaaaaa=new JLabel("kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");aaaaaa.setForeground(Color.BLACK);
		bt7=new JButton(new ImageIcon("C:\\Users\\Administrator\\IdeaProjects\\Dictionary\\src\\main\\resources\\reset.png"));
		pn3.add(aaaaaa);pn3.add(bt7);
		//
		/*bt1.setBackground(Color.BLACK);
		bt2.setBackground(Color.BLACK);
		bt3.setBackground(Color.BLACK);
		bt4.setBackground(Color.BLACK);
		bt5.setBackground(Color.BLACK);
		bt6.setBackground(Color.BLACK);
		bt7.setBackground(Color.BLACK);*/
		p.add(pn1);p.add(pn2);p.add(pn3);
		f.add(p);
		f.setResizable(false);
		f.setSize(560,560);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	public void run(){
		tf1.addKeyListener(this);
		ta1.setEditable(false);
		ta2.setEditable(false);
		String d=new String("");
		FileText file=new FileText();
		//file.ReadAndWrite();
		ArrayList<String> list=new ArrayList<String>();
		//file.TextFile(list,"Dictionary.txt");
		file.TextFile(list,"C:\\Users\\Administrator\\IdeaProjects\\Dictionary\\src\\main\\resources\\English.txt");
		int i;
		for(i=0;i<list.size();i+=1){
			d+="+"+list.get(i)+"\n";
		}
		ta1.setText(d);
		Font font=new Font("Arial",Font.BOLD|Font.ITALIC,20);
		ta1.setFont(font); ta2.setFont(font);tf1.setFont(font);
		bt1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.setProperty("mbrola.base", "C:\\Users\\Administrator\\IdeaProjects\\Dictionary\\src\\main\\resources\\mbrola");
				VoiceManager vm = VoiceManager.getInstance();
				Voice voice = vm.getVoice("mbrola_us1");
				voice.allocate();
				voice.speak(tf1.getText());
			}
		});
		bt2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n=JOptionPane.showConfirmDialog(f,"Bạn muốn thêm từ vào từ điển?","Question", JOptionPane.YES_NO_OPTION);
				if(n== JOptionPane.YES_OPTION){
					SignIn a=new SignIn();
					a.run("add");
				}
			}
		});
		bt3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n=JOptionPane.showConfirmDialog(f,"Bạn muốn xóa từ khỏi từ điển?","Question", JOptionPane.YES_NO_OPTION);
				if(n== JOptionPane.YES_OPTION){
					SignIn a=new SignIn();
					a.run("delete");
				}
			}
		});
		bt4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n=JOptionPane.showConfirmDialog(f,"Bạn muốn sửa từ trong từ điển?","Question", JOptionPane.YES_NO_OPTION);
				if(n== JOptionPane.YES_OPTION){
					SignIn a=new SignIn();
					a.run("edit");
				}
			}
		});
		bt5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DictionaryManagement a=new DictionaryManagement();
				int n=JOptionPane.showConfirmDialog(f,"Bạn có muốn từ điển xuất ra file?","Question",JOptionPane.YES_NO_OPTION);
				if(n==JOptionPane.YES_OPTION) {
					a.dictionaryExportToFile();
					JOptionPane.showMessageDialog(f, "Đã xuất từ điển ra file!", "Message", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		bt6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(f,"Application: My Dictionary\nAuthor: Nguyễn Anh Quân\nAdd: " +
						"Thêm từ vào từ điển theo định dạng English      VietNamese(ngăn cách bởi dấu tap).\nDelete: Xóa từ bằng cách nhập từ tiếng anh bạn muốn xóa vào, mỗi từ trên một dòng." +
						"\nEdit: Nhấn vào nút con mắt để tìm nghĩa của từ.","Help",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		bt7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ta2.setText("");
				tf1.setText("");
				String d=new String("");
				FileText file=new FileText();
				ArrayList<String> list=new ArrayList<String>();
				file.TextFile(list,"C:\\Users\\Administrator\\IdeaProjects\\Dictionary\\src\\main\\resources\\Dictionary.txt");
				int i;
				for(i=0;i<list.size();i+=2){
					d+="+"+list.get(i)+"\n";
				}
				ta1.setText(d);
			}
		});
	}

	public void keyTyped(KeyEvent e) {

	}

	public void keyPressed(KeyEvent e) {

	}

	public void keyReleased(KeyEvent e) {
		DictionaryManagement a=new DictionaryManagement();
		String h=a.search(tf1.getText());
		ta1.setText(h);
		String[] l=tf1.getText().split("\n");
		String k=new String("");
		for(String temp:l){
			k+="#"+a.dictionaryLookup(temp)+"\n";
		}
		ta2.setText(k);
	}
}
