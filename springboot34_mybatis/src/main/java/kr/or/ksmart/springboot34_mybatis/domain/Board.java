package kr.or.ksmart.springboot34_mybatis.domain;

public class Board {
	private String bNum;
	private String bTitle;
	private String bContent;
	private String mId;
	private String bDate;
	
	
	
	public String getbNum() {
		return bNum;
	}
	public void setbNum(String bNum) {
		this.bNum = bNum;
	}
	public String getbTitle() {
		return bTitle;
	}
	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}
	public String getbContent() {
		return bContent;
	}
	public void setbContent(String bContent) {
		this.bContent = bContent;
	}
	public String getMId() {
		return mId;
	}
	public void setMId(String mId) {
		this.mId = mId;
	}
	public String getbDate() {
		return bDate;
	}
	public void setbDate(String bDate) {
		this.bDate = bDate;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Board [bNum=");
		builder.append(bNum);
		builder.append(", bTitle=");
		builder.append(bTitle);
		builder.append(", bContent=");
		builder.append(bContent);
		builder.append(", mId=");
		builder.append(mId);
		builder.append(", bDate=");
		builder.append(bDate);
		builder.append("]");
		return builder.toString();
	}

}
