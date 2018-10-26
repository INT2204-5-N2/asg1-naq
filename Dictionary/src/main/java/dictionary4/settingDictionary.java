package dictionary4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class settingDictionary {
	private JFrame f=new JFrame("Setting");
	private JPanel p=new JPanel();
	private JButton bt1,bt2,bt3,bt4,bt6;
	private JTextArea ta1=new JTextArea("");
	private JTextArea ta2=new JTextArea("");
	private JTextField tf1=new JTextField("",8);
	private JTextField tf2=new JTextField("",8);
	private JLabel lb=new JLabel("");
	public static void main(String[] args){
		settingDictionary a=new settingDictionary();
		a.run();
	}
	public settingDictionary(){
		p.setLayout(new BoxLayout(p,BoxLayout.Y_AXIS));
		p.setBackground(Color.BLACK);
		JPanel p1=new JPanel();
		p1.setBackground(Color.BLACK);
		JPanel p2=new JPanel();
		p2.setBackground(Color.BLACK);
		JPanel p3=new JPanel();
		p3.setBackground(Color.BLACK);
		JPanel p4=new JPanel();
		p4.setBackground(Color.BLACK);
		JPanel p5=new JPanel();
		p5.setBackground(Color.WHITE);
		Font font=new Font("Arial",Font.BOLD|Font.ITALIC,15);
		ta1.setFont(font);
		ta2.setFont(font);
		tf1.setFont(font);
		tf2.setFont(font);
		bt1=new  JButton(new ImageIcon("C:\\Users\\Administrator\\IdeaProjects\\Dictionary\\src\\main\\resources\\add.png"));bt1.setBackground(Color.PINK);
		bt2=new  JButton(new ImageIcon("C:\\Users\\Administrator\\IdeaProjects\\Dictionary\\src\\main\\resources\\delete.png"));bt2.setBackground(Color.PINK);
		bt3=new  JButton(new ImageIcon("C:\\Users\\Administrator\\IdeaProjects\\Dictionary\\src\\main\\resources\\export.png"));bt3.setBackground(Color.PINK);
		bt4=new  JButton(new ImageIcon("C:\\Users\\Administrator\\IdeaProjects\\Dictionary\\src\\main\\resources\\edit.png"));bt4.setBackground(Color.PINK);
		bt6=new  JButton(new ImageIcon("C:\\Users\\Administrator\\IdeaProjects\\Dictionary\\src\\main\\resources\\find.png"));bt6.setBackground(Color.PINK);
		/*bt1=new JButton("ADD");p1.add(bt1);
		bt2=new JButton("DELETE");p2.add(bt2);
		bt3=new JButton("EXPORT");p3.add(bt3);
		bt4=new JButton("EDIT");p4.add(bt4);
		bt6=new JButton("FIND");bt6.setBackground(Color.BLACK);bt6.setForeground(Color.white);*/
		p1.add(bt1);
		p2.add(bt2);
		p3.add(bt3);
		p4.add(bt4);
		lb.setText("Xuất dữ liệu từ điển ra file.");p5.add(lb);
		JPanel p6=new JPanel();
		//p6.setLayout(new BoxLayout(p6,BoxLayout.X_AXIS));
		p6.setBackground(Color.WHITE);
		p6.add(tf1);p6.add(bt6);p6.add(tf2);
		p.add(p1);
		p.add(ta1);
		p.add(p2);
		p.add(ta2);
		p.add(p4);
		p.add(p6);
		p.add(p3);
		p.add(p5);
		f.add(p);
		f.setResizable(false);
		f.setSize(350,400);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f.setVisible(true);
	}
	public void run(){
		bt1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ta1.getText().equals("")){
					JOptionPane.showMessageDialog(f,"Bạn cần nhập từ vào!","Message",JOptionPane.INFORMATION_MESSAGE);
				}
				else{
					FileText k=new FileText();
					int n=JOptionPane.showConfirmDialog(f,"Bạn có muốn thêm?","Question",JOptionPane.YES_NO_OPTION);
					if(n==JOptionPane.YES_OPTION) {
						k.addFile(ta1.getText()+"\n");
						JOptionPane.showMessageDialog(f, "Đã thêm vào từ điển!", "Message", JOptionPane.INFORMATION_MESSAGE);
						ta1.setText("");
					}
				}
			}
		});
		bt2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ta2.getText().equals("")){
					JOptionPane.showMessageDialog(f,"Bạn cần nhập từ vào!","Message",JOptionPane.INFORMATION_MESSAGE);
				}
				else{
					FileText k=new FileText();
					int n=JOptionPane.showConfirmDialog(f,"Bạn có muốn xóa?","Question",JOptionPane.YES_NO_OPTION);
					if(n==JOptionPane.YES_OPTION) {
						String[] h=ta2.getText().split("\n");
						for(String temp:h) {
							k.deleteFile(temp);
						}
						JOptionPane.showMessageDialog(f, "Đã xóa khỏi từ điển!", "Message", JOptionPane.INFORMATION_MESSAGE);
						ta2.setText("");
					}
				}
			}
		});
		bt3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DictionaryManagement a=new DictionaryManagement();
				int n=JOptionPane.showConfirmDialog(f,"Bạn có muốn xuất ra file?","Question",JOptionPane.YES_NO_OPTION);
				if(n==JOptionPane.YES_OPTION) {
					a.dictionaryExportToFile();
					JOptionPane.showMessageDialog(f, "Đã xuất từ điển ra file!", "Message", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		bt4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tf1.getText().equals("")){
					JOptionPane.showMessageDialog(f,"Bạn cần nhập từ vào!","Message",JOptionPane.INFORMATION_MESSAGE);
				}
				else{
					int n=JOptionPane.showConfirmDialog(f,"Bạn có chắc muốn chỉnh sửa?","Question",JOptionPane.YES_NO_OPTION);
					if(n==JOptionPane.YES_OPTION) {
						FileText k = new FileText();
						k.deleteFile(tf1.getText());
						k.addFile(tf1.getText()+"	"+tf2.getText()+"\n");
						JOptionPane.showMessageDialog(f, "Đã chỉnh sửa xong!", "Message", JOptionPane.INFORMATION_MESSAGE);
						tf1.setText("");
						tf2.setText("");
					}
				}
			}
		});
		bt6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DictionaryManagement a=new DictionaryManagement();
				String[] h=tf1.getText().split("\n");
				String k=new String("");
				for(String temp:h){
					k+=a.dictionaryLookup(temp)+"\n";
				}
				tf2.setText(k);
			}
		});
	}
}
