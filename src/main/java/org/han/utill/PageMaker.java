package org.han.utill;

public class PageMaker {

	private int page;// ���� ������ Num
	private int cnt; // ��ü ������ Count
	private int lineCount;// �ѹ��� ���� �� ������ ����
	private int perPage; // ���������� ���� �� �Խù� ��

	private int first;// ù��° ������
	private int last;// ������ ������
	private String preNum; // ���� ��ȣ
	private String nextNum; // ���� ��ȣ

	// ������, Overloading

	// ���޹��� param�� String Ÿ���� �� Int type���� parse
	public static int getNumber(String str) {
		try {
			return Integer.parseInt(str);
		} catch (Exception e) {

			// ������ �߻� �� ��� ������ 1�� return
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

	// param�� String type�� �� getNumber�� ����ȯ
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

		this.preNum = testPreNum(first); // ���� ��ȣ
		this.nextNum = testNextNum(cnt); // ���� ��ȣ
	}
	
	// ���� ������ ��������
	public String testNextNum(int cnt) {

		int last=0;
		if(cnt<getRowNum()){
			this.last= (int)Math.ceil(cnt/10)+1;
			last=this.last;
		}else{
		last= (getRowNum()-1)/10;}
		System.out.println("last: "+last);
		String nextNum =String.valueOf(last +1);
		
		//last/5�� 0�� �ƴϸ� true
		if (last%5 != 0 ) {
			nextNum = "true";
		}
		return nextNum;
	}

	// ���� ������ �������� Ȯ��
	public String testPreNum(int first) {
		String preNum = String.valueOf(first - 1);
		// ���� �������� 0�̸� true�����ֱ�
		if (preNum.equals("0")) {
			preNum = "true";
		}
		return preNum;
	}

	// �ҷ��� �Խù� Count �ϱ�
	public int getRowNum() {
		// Math.ceil ���� �� �� �ø�
		return (((int) (Math.ceil(page / (double) lineCount))) * (perPage * lineCount)) + 1;
	}

	// �������� ù��° �Խù�
	public int getRnFirst() {
		return getRnLast() - perPage + 1;
	}

	// �������� ������ �Խù�
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

	// ���� ������
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
