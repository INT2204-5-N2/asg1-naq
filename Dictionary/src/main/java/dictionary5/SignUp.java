package dictionary5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class SignUp {
	private JFrame f=new JFrame("Sign Up ");
	private JPanel p=new JPanel();
	private JLabel lb1=new JLabel("",JLabel.CENTER);
	private JLabel lb2;
	private JLabel lb21=new JLabel(); JLabel lb22=new JLabel(); JLabel lb23=new JLabel(); JLabel lb24=new JLabel();
	private JTextField tf21=new JTextField(""); JTextField tf22=new JTextField(""); JTextField tf23=new JTextField(""); JTextField tf24=new JTextField("");
	private JLabel lb3;
	private JLabel lb31=new JLabel(); JLabel lb32=new JLabel(); JLabel lb33=new JLabel();
	private JTextField tf31=new JTextField(""); JPasswordField tf32=new JPasswordField(""); JPasswordField tf33=new JPasswordField("");
	private JButton bt1,bt2,bt3;
	/*public static void main(String[] args){
		SignUp a=new SignUp();
		a.run();
	}*/
	public SignUp(){
		p.setLayout(new BoxLayout(p,BoxLayout.Y_AXIS));
		p.setBackground(Color.BLACK);
		p.setForeground(Color.WHITE);
		JLabel temp1=new JLabel("*~*"); temp1.setForeground(Color.BLACK);
		JLabel temp2=new JLabel("*~*"); temp2.setForeground(Color.BLACK);
		Font font=new Font("Arial",Font.BOLD | Font.ITALIC,20);
		lb1.setFont(font);
		lb1.setText("Sign Up");
		lb1.setForeground(Color.WHITE);
		JPanel p1=new JPanel();
		p1.setBackground(Color.BLACK);
		p1.add(lb1);
		p.add(temp1);
		p.add(p1);
		p.add(temp2);
		//
		JPanel p2=new JPanel();
		p2.setLayout(new BoxLayout(p2,BoxLayout.Y_AXIS));
		p2.setBackground(Color.LIGHT_GRAY);
		lb2=new JLabel("Information: ");
		p2.add(lb2);
		JPanel p21=new JPanel();
		p21.setLayout(new GridLayout(4,2));
		p21.setBackground(Color.PINK);
		lb21.setText("First Name:");
		lb22.setText("Last Name:");
		lb23.setText("Sex:");
		lb24.setText("Address:");
		p21.add(lb21);p21.add(tf21);
		p21.add(lb22);p21.add(tf22);
		p21.add(lb23);p21.add(tf23);
		p21.add(lb24);p21.add(tf24);
		p2.add(p21);
		//
		JPanel p3=new JPanel();
		p3.setLayout(new BoxLayout(p3,BoxLayout.Y_AXIS));
		p3.setBackground(Color.LIGHT_GRAY);
		lb3=new JLabel("Account: ");
		p3.add(lb3);
		JPanel p31=new JPanel();
		p31.setLayout(new GridLayout(3,2));
		p31.setBackground(Color.PINK);
		lb31.setText("User Name:");
		lb32.setText("Password:");
		lb33.setText("Confirm:");
		p31.add(lb31);p31.add(tf31);
		p31.add(lb32);p31.add(tf32);
		p31.add(lb33);p31.add(tf33);
		p3.add(p31);
		//
		bt1=new JButton("Sign Up");
		bt2=new JButton("Reset");
		bt3=new JButton("Exit");
		JPanel p4=new JPanel();
		p4.setLayout(new FlowLayout());
		p4.setBackground(Color.CYAN);
		p4.add(bt1);
		p4.add(bt2);
		p4.add(bt3);
		//
		p.add(p2);
		p.add(p3);
		p.add(p4);
		f.add(p);
		f.setSize(400,320);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f.setVisible(true);
	}
	public void run(){
		bt3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				f.setVisible(false);
			}
		});
		bt2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				tf21.setText("");
				tf22.setText("");
				tf23.setText("");
				tf24.setText("");
				tf31.setText("");
				tf32.setText("");
				tf33.setText("");
			}
		});
		/*FileText file=new FileText();
		file.WriteAFile("Account.txt","");
		file.WriteAFile("CopyAccount.txt","");*/
		bt1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tf21.getText().equals("")||tf22.getText().equals("")||tf23.getText().equals("")||tf24.getText().equals("")
						||tf31.getText().equals("")||tf32.getText().equals("")||tf33.getText().equals("")){
					JOptionPane.showMessageDialog(f,"Bạn cần nhập đầy đủ thông tin!!!","Message",JOptionPane.INFORMATION_MESSAGE);
				}
				else{
					if(tf32.getText().equals(tf33.getText())){
						try {
							FileWriter temp = new FileWriter("C:\\Users\\Administrator\\IdeaProjects\\Dictionary\\src\\main\\resources\\Account.txt", true);
							temp.write(tf21.getText() + "," + tf22.getText() + "," + tf23.getText() + "," + tf24.getText() + "," + tf31.getText() + "," + tf32.getText() + "\n");
							temp.close();
						}catch(IOException h){
							h.printStackTrace();
						}
						try{
							FileWriter temp=new FileWriter("C:\\Users\\Administrator\\IdeaProjects\\Dictionary\\src\\main\\resources\\CopyAccount.txt",true);
							temp.write(tf31.getText()+" "+tf32.getText()+"\n");
							temp.close();
						}catch(IOException l){
							l.printStackTrace();
						}
						JOptionPane.showMessageDialog(f,"Đăng kí thành công!","Message",JOptionPane.INFORMATION_MESSAGE);
						f.setVisible(false);
					}
					else{
						JOptionPane.showMessageDialog(f,"Mời bạn nhập lại mật khẩu!","Message",JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});
	}
}

