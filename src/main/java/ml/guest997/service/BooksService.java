package ml.guest997.service;

import ml.guest997.pojo.Books;
import java.util.List;

public interface BooksService {
    int addBook(Books book);
    int deleteBookById(int id);
    int updateBook(Books book);
    Books queryBookById(int id);
    List<Books> queryAllBooks();
}
