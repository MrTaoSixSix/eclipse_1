package org.tag.entity;

public class Pagination {

	private Integer index = 1 ;
	private Integer total;
	private Integer size = 3;

	
	//
	public Integer getMaxPage() {
		return total % size == 0 ? total / size : total / size + 1;
	}


	public Pagination(Integer index, Integer total, Integer size) {
		super();
		this.index = index;
		this.total = total;
		this.size = size;
	}


	public Pagination() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Integer getIndex() {
		return index;
	}


	public void setIndex(Integer index) {
		this.index = index;
	}


	public Integer getTotal() {
		return total;
	}


	public void setTotal(Integer total) {
		this.total = total;
	}


	public Integer getSize() {
		return size;
	}


	public void setSize(Integer size) {
		this.size = size;
	}

	
	
	
	
	
}
