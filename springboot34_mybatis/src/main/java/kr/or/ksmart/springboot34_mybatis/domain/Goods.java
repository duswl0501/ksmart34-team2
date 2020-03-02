package kr.or.ksmart.springboot34_mybatis.domain;

public class Goods {
	private String gCode;
	private String mId;
	private String gName;
	private String gCate;
	private String gPrice;
	private String gColor;
	private String gSize;
	private String gDesc;
	private String gDate;
	
	public String getgCode() {
		return gCode;
	}
	public void setgCode(String gCode) {
		this.gCode = gCode;
	}
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
	public String getgName() {
		return gName;
	}
	public void setgName(String gName) {
		this.gName = gName;
	}
	public String getgCate() {
		return gCate;
	}
	public void setgCate(String gCate) {
		this.gCate = gCate;
	}
	public String getgPrice() {
		return gPrice;
	}
	public void setgPrice(String gPrice) {
		this.gPrice = gPrice;
	}
	public String getgColor() {
		return gColor;
	}
	public void setgColor(String gColor) {
		this.gColor = gColor;
	}
	public String getgSize() {
		return gSize;
	}
	public void setgSize(String gSize) {
		this.gSize = gSize;
	}
	public String getgDesc() {
		return gDesc;
	}
	public void setgDesc(String gDesc) {
		this.gDesc = gDesc;
	}
	public String getgDate() {
		return gDate;
	}
	public void setgDate(String gDate) {
		this.gDate = gDate;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Goods [gCode=");
		builder.append(gCode);
		builder.append(", mId=");
		builder.append(mId);
		builder.append(", gName=");
		builder.append(gName);
		builder.append(", gCate=");
		builder.append(gCate);
		builder.append(", gPrice=");
		builder.append(gPrice);
		builder.append(", gColor=");
		builder.append(gColor);
		builder.append(", gSize=");
		builder.append(gSize);
		builder.append(", gDesc=");
		builder.append(gDesc);
		builder.append(", gDate=");
		builder.append(gDate);
		builder.append("]");
		return builder.toString();
	}
	
}
