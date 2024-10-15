package wep.mvc.dto;

public class BoardDTO {

	private int boardSeq;
	private int categorySeq;
	private int userSeq;
	private String sub; //제목 
	private String bContent; //내용
	private int hostSeq;
	
	
	public BoardDTO() {}
	
	public BoardDTO(int boardSeq, int categorySeq, int userSeq, String sub, String bContent, int hostSeq) {
		super();
		this.boardSeq = boardSeq;
		this.categorySeq = categorySeq;
		this.userSeq = userSeq;
		this.sub = sub;
		this.bContent = bContent;
		this.hostSeq = hostSeq;
	}
	
	
	
	public BoardDTO(int boardSeq, int categorySeq, String sub) {
		super();
		this.boardSeq = boardSeq;
		this.categorySeq = categorySeq;
		this.sub = sub;
	}
	public BoardDTO(int userSeq, int hostSeq) {
		super();
		this.userSeq = userSeq;
		this.hostSeq = hostSeq;
	}
	
	public int getBoardSeq() {
		return boardSeq;
	}
	
	public int getCategorySeq() {
		return categorySeq;
	}
	
	public int getUserSeq() {
		return userSeq;
	}
	
	public String getSub() {
		return sub;
	}
	
	public String getbContent() {
		return bContent;
	}
	
	public int getHostSeq() {
		return hostSeq;
	}
	
	public void setBoardSeq(int boardSeq) {
		this.boardSeq = boardSeq;
	}
	
	public void setCategorySeq(int categorySeq) {
		this.categorySeq = categorySeq;
	}
	
	public void setUserSeq(int userSeq) {
		this.userSeq = userSeq;
	}
	
	public void setSub(String sub) {
		this.sub = sub;
	}
	
	public void setbContent(String bContent) {
		this.bContent = bContent;
	}
	
	public void setHostSeq(int hostSeq) {
		this.hostSeq = hostSeq;
	}
	
	
	
	

}
