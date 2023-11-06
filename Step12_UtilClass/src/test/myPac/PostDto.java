package test.myPac;

public class PostDto {

	private int num;
	private String writer;
	private String title;
	
	public  PostDto(){}

	public PostDto(int num, String writer, String title) {
		super();
		this.num = num;
		this.writer = writer;
		this.title = title;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	

	
	
}
