package dictionary1;

public class DictionaryCommandline {
	DictionaryManagement b=new DictionaryManagement();
	//Hiển thị danh sách từ
	public void showAllWords(){
		b.show();
	}
	public void dictionaryBasic(){
		b.insertFromCommandline();
		showAllWords();
	}
}
