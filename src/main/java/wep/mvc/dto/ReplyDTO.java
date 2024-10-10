package wep.mvc.dto;

public class ReplyDTO {
	private int reqlSeq;
	private int boardSeq;
	private int userSeq;
	private int reContent;
	private int hostSeq;
	
	
	
	
	public ReplyDTO(int reqlSeq, int boardSeq, int userSeq, int reContent, int hostSeq) {
		super();
		this.reqlSeq = reqlSeq;
		this.boardSeq = boardSeq;
		this.userSeq = userSeq;
		this.reContent = reContent;
		this.hostSeq = hostSeq;
	}


	
	
	public int getReqlSeq() {
		return reqlSeq;
	}


	public int getBoardSeq() {
		return boardSeq;
	}


	public int getUserSeq() {
		return userSeq;
	}


	public int getReContent() {
		return reContent;
	}


	public int getHostSeq() {
		return hostSeq;
	}


	public void setReqlSeq(int reqlSeq) {
		this.reqlSeq = reqlSeq;
	}


	public void setBoardSeq(int boardSeq) {
		this.boardSeq = boardSeq;
	}


	public void setUserSeq(int userSeq) {
		this.userSeq = userSeq;
	}


	public void setReContent(int reContent) {
		this.reContent = reContent;
	}


	public void setHostSeq(int hostSeq) {
		this.hostSeq = hostSeq;
	}
	
	
	
	
	
}
