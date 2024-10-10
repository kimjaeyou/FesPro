package wep.mvc.dto;

public class BoardCategoryDTO {

	private int categorySeq;
	private String ctgContent;
	
	
	public BoardCategoryDTO(int categorySeq, String ctgContent) {
		super();
		this.categorySeq = categorySeq;
		this.ctgContent = ctgContent;
	}


	public int getCategorySeq() {
		return categorySeq;
	}


	public String getCtgContent() {
		return ctgContent;
	}


	public void setCategorySeq(int categorySeq) {
		this.categorySeq = categorySeq;
	}


	public void setCtgContent(String ctgContent) {
		this.ctgContent = ctgContent;
	}
	
	
	
}
