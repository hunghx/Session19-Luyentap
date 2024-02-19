package ra.bussiness.model;

import ra.bussiness.util.InputMethods;

import java.io.Serializable;
import java.math.BigDecimal;

public class Book implements IOData, Serializable {
    private String bookName;
    private String id;
    private String category;
    private BigDecimal price;
    private String author;
    private int totalPages;

    public Book() {
    }

    public Book(String bookName, String id, String category, BigDecimal price, String author, int totalPages) {
        this.bookName = bookName;
        this.id = id;
        this.category = category;
        this.price = price;
        this.author = author;
        this.totalPages = totalPages;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    @Override
    public void inputData(boolean isAdd) {
        if (isAdd) {
            System.out.println("Nhap mã sach :");
            this.id = InputMethods.getString();
        }
        System.out.println("Nhập ten sach");
        this.bookName = InputMethods.getString();
        System.out.println("Nhap danh mục :");
        this.category = InputMethods.getString();
        System.out.println("Nhập giá tiền");
        this.price = new BigDecimal(InputMethods.getString());
        System.out.println("Nhập tác giả");
        this.author = InputMethods.getString();
        System.out.println("Nhập tổng số trang");
        this.totalPages = InputMethods.getInteger();
    }

    @Override
    public void displayData() {
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.printf("| %4s | %10s | %10s | %15s | %5s | %5d |\n",id,bookName,category,author,price,totalPages);
    }
}
