package ml.guest997.dao;

import ml.guest997.pojo.Books;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface BooksMapper {
    int addBook(Books book);
    int deleteBookById(@Param("bookID") int id);
    int updateBook(Books book);
    Books queryBookById(@Param("bookID")int id);
    List<Books> queryAllBooks();
}
