package org.han.utill;

public class PageMaker {

	private int page;// 현재 페이지 Num
	private int cnt; // 전체 데이터 Count
	private int lineCount;// 한번에 보여 줄 페이지 개수
	private int perPage; // 한페이지에 보여 줄 게시물 수

	private int first;// 첫번째 페이지
	private int last;// 마지막 페이지
	private String preNum; // 이전 번호
	private String nextNum; // 다음 번호

	// 생성자, Overloading

	// 전달받은 param이 String 타입일 때 Int type으로 parse
	public static int getNumber(String str) {
		try {
			return Integer.parseInt(str);
		} catch (Exception e) {

			// 에러가 발생 할 경우 무조건 1을 return
			return 1;
		}
	}

	public PageMaker() {
		this(1);
		// public PageMaker(int page)
	}

	public void setPage(int page) {
		this.page = page;
	}

	public PageMaker(int page) {
		this(page, 0);
		// public PageMaker(int page, int cnt==0)
	}

	// param이 String type일 때 getNumber로 형변환
	public PageMaker(String pageStr) {
		this(getNumber(pageStr), 0);
	}

	public PageMaker(int page, int cnt) {
		this(page, cnt, 5, 10);
		// PageMaker(int page, int cnt, int lineCount=5, int perPage=10)
	}

	public PageMaker(int page, int cnt, int lineCount, int perPage) {
		super();
		this.page = page;
		// Page Number
		this.cnt = cnt;
		// Data Count
		this.lineCount = lineCount;
		// View Page Count
		this.perPage = perPage;
		// Data Count in a page

		this.last = (int) (Math.ceil((double) page / lineCount)) * lineCount;
		this.first = last - (lineCount - 1);
		// <<1 2 3 4 5>>

		this.preNum = testPreNum(first); // 이전 번호
		this.nextNum = testNextNum(cnt); // 다음 번호
	}
	
	// 다음 페이지 생성여부
	public String testNextNum(int cnt) {

		int last=0;
		if(cnt<getRowNum()){
			this.last= (int)Math.ceil(cnt/10)+1;
			last=this.last;
		}else{
		last= (getRowNum()-1)/10;}
		System.out.println("last: "+last);
		String nextNum =String.valueOf(last +1);
		
		//last/5가 0이 아니면 true
		if (last%5 != 0 ) {
			nextNum = "true";
		}
		return nextNum;
	}

	// 이전 페이지 생성여부 확인
	public String testPreNum(int first) {
		String preNum = String.valueOf(first - 1);
		// 이전 페이지가 0이면 true던져주기
		if (preNum.equals("0")) {
			preNum = "true";
		}
		return preNum;
	}

	// 불러올 게시물 Count 하기
	public int getRowNum() {
		// Math.ceil 지정 된 수 올림
		return (((int) (Math.ceil(page / (double) lineCount))) * (perPage * lineCount)) + 1;
	}

	// 페이지당 첫번째 게시물
	public int getRnFirst() {
		return getRnLast() - perPage + 1;
	}

	// 페이지당 마지막 게시물
	public int getRnLast() {
		return (page * perPage);
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

	// 현재 페이지
	public int getPage() {
		return page;
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
