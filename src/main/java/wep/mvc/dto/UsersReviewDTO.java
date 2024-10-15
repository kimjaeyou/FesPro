package wep.mvc.dto;

public class UsersReviewDTO extends UsersDTO {
	private int reviewScore;
	
	public UsersReviewDTO() {
	}

	public int getReviewScore() {
		return reviewScore;
	}

	public void setReviewScore(int reviewScore) {
		this.reviewScore = reviewScore;
	}
	
}
