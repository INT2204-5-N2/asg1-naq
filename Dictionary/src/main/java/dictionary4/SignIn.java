package dictionary4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SignIn {
	private JFrame f=new JFrame("Sign In");
	private JPanel p=new JPanel();
	private JLabel lb1=new JLabel("");
	private JLabel lb2=new JLabel(); JTextField tf2=new JTextField("");
	private JLabel lb3=new JLabel(); JPasswordField tf3=new JPasswordField("");
	private JButton bt1,bt2;
	private JLabel lb4=new JLabel();
	private JButton bt4=new JButton();
	private ArrayList<String> list=new ArrayList<String>();
	private FileText file=new FileText();
	/*public static void main(String[] args){
		SignIn a=new SignIn();
		a.run();
	}*/
	public SignIn(){
		p.setLayout(new BoxLayout(p,BoxLayout.Y_AXIS));
		//
		JPanel p3=new JPanel();
		p3.setLayout(new FlowLayout());
		p3.setBackground(Color.BLACK);
		lb1.setText("Sign In");
		Font font=new Font("Arial",Font.BOLD | Font.ITALIC,20);
		lb1.setFont(font);
		lb1.setForeground(Color.WHITE);
		p3.add(lb1);
		//
		JPanel p1=new JPanel();
		p1.setLayout(new GridLayout(2,2));
		p1.setBackground(Color.pink);
		lb2.setText("USER NAME:");
		lb3.setText("PASSWORD:");
		p1.add(lb2); p1.add(tf2);
		p1.add(lb3); p1.add(tf3);
		//
		JPanel p2=new JPanel();
		p2.setLayout(new FlowLayout());
		p2.setBackground(Color.cyan);
		bt1=new JButton("Sign In");
		bt2=new JButton("Cancel");
		p2.add(bt1);
		p2.add(bt2);
		//
		/*JPanel p4=new JPanel();
		p4.setLayout(new FlowLayout());
		p4.setBackground(Color.BLACK);
		lb4.setText("If you don't have an account: ");
		lb4.setForeground(Color.WHITE);
		bt4.setText("Sign Up");
		p4.add(lb4); p4.add(bt4);*/
		//
		p.add(p3);
		p.add(p1);
		p.add(p2);
		//p.add(p4);
		f.add(p);
		f.setResizable(false);
		f.setSize(300,150);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f.setVisible(true);
		//
		file.TextFile(list,"CopyAccount.txt");
	}
	public void run(){
		bt2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n=JOptionPane.showConfirmDialog(f,"Bạn muốn thoát?","Question",JOptionPane.YES_NO_OPTION);
				if(n== JOptionPane.YES_OPTION) f.setVisible(false);
			}
		});
		/*bt4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				SignUp b=new SignUp();
				b.run();
			}
		});*/
		bt1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tf2.getText().equals("")||tf3.getText().equals("")){
					JOptionPane.showMessageDialog(f,"Bạn cần nhập đầy đủ!","Message",JOptionPane.INFORMATION_MESSAGE);
				}
				else{
					String s=tf2.getText()+" "+tf3.getText();
					int i;
					int t=0;
					for(i=0;i<list.size();i++){
						if(list.get(i).equals(s)){
							JOptionPane.showMessageDialog(f,"Đăng nhập thành công","Message",JOptionPane.INFORMATION_MESSAGE);
							f.setVisible(false);
							settingDictionary a=new settingDictionary();
							a.run();
						}
						else t++;
					}
					if(t==list.size()){
						JOptionPane.showMessageDialog(f,"Thất bai.Mời bạn đăng nhập lại:","Message",JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});
	}
}
