package org.han.utill;

public class PageMaker {

	private int page;// current page Num
	private int cnt; // All data Count
	private int lineCount;// view page count
	private int perPage; // view data count

	private int first;// first view page Num
	private int last;// last view page Num
	private String preNum; // previous page Num
	private String nextNum; // next page Num


	public PageMaker() {
		this(1);
		// public PageMaker(int page)
	}

	public PageMaker(int page) {
		this(page, 0);
		// public PageMaker(int page, int cnt==0)
	}

	public PageMaker(String pageStr) {
		this(getNumber(pageStr), 0);
	}

	public PageMaker(int page, int cnt) {
		this(page, cnt, 5, 10);
		// PageMaker(int page, int cnt, int lineCount=5, int perPage=10)
	}

	public PageMaker(int page, int cnt, int lineCount, int perPage) {
		super();
		this.page = page; // Page Number
		this.cnt = cnt; // Data Count
		this.lineCount = lineCount; // View Page Count
		this.perPage = perPage; // Data Count in a page

		this.last = (int) (Math.ceil((double) page / lineCount)) * lineCount;
		this.first = last - (lineCount - 1);
		// <<first 2 3 4 last>>

		this.preNum = testPreNum(first); // previousTag
		this.nextNum = testNextNum(cnt); // NextTag
	}

	public String testNextNum(int cnt) {
		//check the last page Num
		int last = 0;
		if (cnt < getRowNum()) {
			this.last = (int) Math.ceil(cnt / 10)+1;
			last = this.last;
			
		} else {
			last = (getRowNum() - 1) / 10;
		}
		
		// check the NextTag of necessity
		String nextNum = String.valueOf(last + 1);
		if (cnt < getRowNum()) {
			nextNum = "true";
		}
		return nextNum;
	}

	// check the previousTag of necessity
	public String testPreNum(int first) {
		String preNum = String.valueOf(first - 1);
		if (preNum.equals("0")) {
			preNum = "true";
		}
		return preNum;
	}

	// count to view data at one go
	public int getRowNum() {
		return (((int) (Math.ceil(page / (double) lineCount))) * (perPage * lineCount)) + 1;
	}

	// count first view data
	public int getRnFirst() {
		return getRnLast() - perPage + 1;
	}

	// conut last view data
	public int getRnLast() {
		return (page * perPage);
	}

	// change the type to 'int', if input the param with 'String'
	public static int getNumber(String str) {
		try {
			return Integer.parseInt(str);
		} catch (Exception e) {
			return 1;
		}
	}
	
	// Get_Setter
	public int getFirst() {
		return first;
	}

	public void setFirst(int first) {
		this.first = first;
	}

	public int getLast() {
		return last;
	}

	public void setLast(int last) {
		this.last = last;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}
	
	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public int getLineCount() {
		return lineCount;
	}

	public void setLineCount(int lineCount) {
		this.lineCount = lineCount;
	}

	public int getPerPage() {
		return perPage;
	}

	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}

	public String getPreNum() {

		return preNum;
	}

	public void setPreNum(String preNum) {
		this.preNum = preNum;
	}

	public String getNextNum() {
		return nextNum;
	}

	public void setNextNum(String nextNum) {
		this.nextNum = nextNum;
	}

	@Override
	public String toString() {
		return "PageMaker [getRowNum()=" + getRowNum() + ", getRnFirst()="
				+ getRnFirst() + ", getRnLast()=" + getRnLast()
				+ ", getFirst()=" + getFirst() + ", getLast()=" + getLast()
				+ ", getPage()=" + getPage() + ", getCnt()=" + getCnt()
				+ ", getLineCount()=" + getLineCount() + ", getPerPage()="
				+ getPerPage() + "]";
	}

}
