package sc.model;



/**
 * 
 * Book Information
 */
public class Book {
	
	String name;
	String author;
	double price;
	String code;   
	String description;
	String imageUrl;
	
	public Book(){};
	
	public Book(String name,String author,double price,String code,String descr,String imageUrl){
		this.name=name;
		this.author=author;
		this.price=price;
		this.code=code;
		this.description=descr;
		this.imageUrl = imageUrl;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getType() {
		return description;
	}
	public void setType(String type) {
		this.description = type;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

}
