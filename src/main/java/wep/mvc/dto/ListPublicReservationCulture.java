package wep.mvc.dto;

import java.util.List;

public class ListPublicReservationCulture {
	private int list_total_count;
	private RESULT RESULT;
	private List<row> row;

	public ListPublicReservationCulture() {
		super();
		this.list_total_count = list_total_count;
		RESULT = RESULT;
		this.row = row;
	}

	public int getList_total_count() {
		return list_total_count;
	}

	public void setList_total_count(int list_total_count) {
		this.list_total_count = list_total_count;
	}

	public RESULT getRESULT() {
		return RESULT;
	}

	public void setRESULT(RESULT rESULT) {
		RESULT = rESULT;
	}

	public List<row> getRow() {
		return row;
	}

	public void setRow(List<row> row) {
		this.row = row;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ListPublicReservationCulture [list_total_count=");
		builder.append(list_total_count);
		builder.append(", RESULT=");
		builder.append(RESULT);
		builder.append(", row=");
		builder.append(row);
		builder.append("]");
		return builder.toString();
	}
	

}
