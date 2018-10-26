package dictionary5;

public class Dictionary5 {
	public static void main(String[] args) {
		//Tạo file English.txt
		/*FileText k=new FileText();
		ArrayList<String> list=new ArrayList<String>();
		ArrayList<String> temp=new ArrayList<String>();
		k.TextFile(list,"Dictionary.txt");
		for(int i=0;i<list.size();i=i+2){
			temp.add(list.get(i));
		}
		k.ToFile(temp,"English.txt");*/
		DictionaryApplication a = new DictionaryApplication();
		a.run();
	}
}
