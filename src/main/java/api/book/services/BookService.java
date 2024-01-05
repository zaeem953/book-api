package api.book.services;

import api.book.dao.BookRepository;
import api.book.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service()
@Qualifier("firstDatabase")
public class BookService {
//    private static List<Book> bookList=new ArrayList<>();
//
//    static {
//        bookList.add(new Book(1,"Pakistan A Hard Country","Anatol Lieven"));
//        bookList.add(new Book(2,"Java","ABC"));
//        bookList.add(new Book(3,"CPP","FDS"));
//    }

    @Autowired
    private BookRepository bookList;
    public List<Book> getAllBooks(){
        List<Book> list= (List<Book>) this.bookList.findAll();
        return list;
    }

    public Book getBookById(int id){
        Book book=null;
//        book=bookList.stream().filter(e->e.getId()==id).findFirst().get();
//        book = this.bookList.findById(id);
        book=this.bookList.findById(id);
        return book;
    }

    public Book addBook(Book b){
        Book result=bookList.save(b);
        return result;
    }

    public void deleteBook(int bookId) {
//        bookList=bookList.stream().filter(e->e.getId()!=bookId).collect(Collectors.toList());
        bookList.deleteById(bookId);
    }

    public void updateBook(Book book, int bookId){
        book.setId(bookId);
        bookList.save(book);
    }
}
