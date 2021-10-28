package ml.guest997.service;

import ml.guest997.dao.BooksMapper;
import ml.guest997.pojo.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BooksServiceImpl implements BooksService{

    //组合的方式调 dao 层
    private BooksMapper booksMapper;
    @Autowired
    public void setBooksMapper(BooksMapper booksMapper) {
        this.booksMapper = booksMapper;
    }

    @Override
    public int addBook(Books book) {
        return booksMapper.addBook(book);
    }

    @Override
    public int deleteBookById(int id) {
        return booksMapper.deleteBookById(id);
    }

    @Override
    public int updateBook(Books book) {
        return booksMapper.updateBook(book);
    }

    @Override
    public Books queryBookById(int id) {
        return booksMapper.queryBookById(id);
    }

    @Override
    public List<Books> queryAllBooks() {
        return booksMapper.queryAllBooks();
    }
}
