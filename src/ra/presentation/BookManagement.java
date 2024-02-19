package ra.presentation;

import ra.bussiness.model.Book;
import ra.bussiness.service.IBookService;
import ra.bussiness.service.impl.BookServiceImpl;
import ra.bussiness.util.InputMethods;

public class BookManagement {
    public static IBookService bookService = new BookServiceImpl();

    public static void main(String[] args) {
        while (true) {
            System.out.println("=================MENU------------------");
            System.out.println("1. Hiên thị danh sách");
            System.out.println("2. Thêm mơi sách");
            System.out.println("3. Cap nhật thông tin sách");
            System.out.println("4. Xóa sách");
            System.out.println("5. Thoát");
            System.out.println("-----------Nhap lua chon cua ban----------");
            byte choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    displayBook();
                    break;
                case 2:
                    addNewBook();
                    break;
                case 3:
                    updateBook();
                    break;
                case 4:
                    deleteBook();
                    break;
                case 5:
                    System.out.println("Thoát chuong trinh");
                    return;
                default:
                    System.err.println("Nhap khong hop le");
            }
        }
    }

    public static void displayBook() {
        if (bookService.findAll().isEmpty()) {
            System.err.println("Danh sach trong");
            return;
        }

        System.out.println("-------------------------------------Danh sach sach-------------------------------------------");
        System.out.printf("| %4s | %10s | %10s | %15s | %5s | %5s |\n", "ID", "Name", "Catalog", "Author", "Price", "Pages");
        bookService.findAll().forEach(Book::displayData);
    }

    public static void addNewBook() {
        System.out.println("Nhap so luong muon them");
        byte count = InputMethods.getByte();
        for (int i = 1; i <= count; i++) {
            System.out.println("Nhạp thong tin cho sach thu " + i);
            Book newBook = new Book();
            newBook.inputData(true);
            bookService.save(newBook);
        }
        System.out.println("Đã them mơi " + count + " cuốn sách");
    }

    public static void updateBook() {
        System.out.println("Nhap id sách");
        String id = InputMethods.getString();
        Book editBook = bookService.findById(id);
        if (editBook == null) {
            System.err.println("ko ton tai id");
            return;
        }
        System.out.println("Thông tin cũ :");
        editBook.displayData();
        System.out.println("Nhập tông tin mới");
        editBook.inputData(false);
        bookService.save(editBook);
        System.out.println("Đã cập nhật thành cong");
    }

    public static void deleteBook() {
        System.out.println("Nhap id sách");
        String id = InputMethods.getString();
        Book deleteBook = bookService.findById(id);
        if (deleteBook == null) {
            System.err.println("ko ton tai id");
            return;
        }
        bookService.deleteById(id);
        System.out.println("Đã xóa thành cong");
    }

}
