package view;

public interface View {

	enum messageType {Error, Information}
	
	public void display(String title,String content,messageType type);
	public void exit();
}
