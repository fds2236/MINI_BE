package mini.vo;

import java.sql.Date;

public class ItemVO {
	// 상품
		private String proCode; // 상품번호
		private String brand; // 상품브랜드
		private String proName; // 상품이름
		private Date launDate; // 상품 발매일, 변환해줘야 함
		private Integer price; // 상품 가격, 변환해줘야 함
		private Integer size; // 상품 사이즈, 변환해줘야 함
		
		public String getProCode() {
			return proCode;
		}
		public void setProCode(String proCode) {
			this.proCode = proCode;
		}
		public String getBrand() {
			return brand;
		}
		public void setBrand(String brand) {
			this.brand = brand;
		}
		public String getProName() {
			return proName;
		}
		public void setProName(String proName) {
			this.proName = proName;
		}
		public Date getLaunDate() {
			return launDate;
		}
		public void setLaunDate(Date launDate) {
			this.launDate = launDate;
		}
		public Integer getPrice() {
			return price;
		}
		public void setPrice(Integer price) {
			this.price = price;
		}
		public Integer getSize() {
			return size;
		}
		public void setSize(Integer size) {
			this.size = size;
		}
		
		
}
