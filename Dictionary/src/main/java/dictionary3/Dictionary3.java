package dictionary3;

import java.util.Scanner;

public class Dictionary3 {
	public static void main(String[] args){
		DictionaryCommandline b=new DictionaryCommandline();
		DictionaryManagement c=new DictionaryManagement();
		Scanner input=new Scanner(System.in);
		String userName=new String("nguyenanhquan");
		String pass=new String("21111999");
		//b.dictionaryBasic();
		b.dictionaryAdvanced();
		System.out.print("Bạn có muốn chỉnh sửa từ điển không? [Y/N]: ");
		String s=input.nextLine();
		if(s.equals("Y")){
			System.out.print("USER NAME: ");
			String k=input.nextLine();
			System.out.print("PASSWORD: ");
			String l=input.nextLine();
			if(k.equals(userName)&&l.equals(pass)){
				System.out.println("Ban muốn: ");
				System.out.println("1. Thêm dữ liệu.");
				System.out.println("2. Xóa dữ liệu.");
				System.out.println("3. Ghi từ điển ra file");
				System.out.print("Lựa chọn của bạn: ");
				int n=input.nextInt();
				String d=input.nextLine();
				switch(n){
					case 1:{
						c.addDictionary();
						break;
					}
					case 2:{
						c.deleteDictionary();
						break;
					}
					case 3:{
						c.dictionaryExportToFile();
						break;
					}
					default:{
						System.out.println("Không có lựa chọn đó.");
						break;
					}
				}
			}
			else{
				System.out.println("Bạn nhập sai tài khoản");
			}
			System.out.print("Bạn có muốn tiếp tục chỉnh sửa từ điển? [Y/N]: ");
			String h=input.nextLine();
			while(h.equals("Y")){
				System.out.print("USER NAME: ");
				k=input.nextLine();
				System.out.print("PASSWORD: ");
				l=input.nextLine();
				if(k.equals(userName)&&l.equals(pass)){
					System.out.println("Ban muốn: ");
					System.out.println("1. Thêm dữ liệu.");
					System.out.println("2. Xóa dữ liệu.");
					System.out.println("3. Ghi từ điển ra file");
					System.out.print("Lựa chọn của ban: ");
					int n=input.nextInt();
					String e=input.nextLine();
					switch(n){
						case 1:{
							c.addDictionary();
							break;
						}
						case 2:{
							c.deleteDictionary();
							break;
						}
						case 3:{
							c.dictionaryExportToFile();
							break;
						}
						default:{
							System.out.println("Không có lựa chọn đó.");
							break;
						}
					}
				}
				else{
					System.out.println("Bạn nhập sai tài khoản");
				}
				System.out.print("Bạn có muốn tiếp tục chỉnh sữa từ điển? [Y/N]: ");
				h=input.nextLine();
			}
		}
		else System.out.println("Kết thúc!!!");
		b.dictionarySearcher();
	}
}
