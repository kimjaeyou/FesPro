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
		return "ListPublicReservationCulture [list_total_count=" + list_total_count + ", RESULT=" + RESULT + ", row="
				+ row + ", getList_total_count()=" + getList_total_count() + ", getRESULT()=" + getRESULT()
				+ ", getRow()=" + getRow() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

}
