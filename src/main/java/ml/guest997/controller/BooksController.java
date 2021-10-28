package ml.guest997.controller;

import ml.guest997.pojo.Books;
import ml.guest997.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
@RequestMapping("/books")
public class BooksController {

    //组合的方式调 service 层
    private BooksService booksService;
    @Autowired
    public void setBooksService(BooksService booksService) {
        this.booksService = booksService;
    }

    //跳转到增加书籍页面
    @RequestMapping("/toAddPage")
    public String toAddPage() {
        return "addBook";
    }

    //添加书籍
    @RequestMapping("/addBook")
    public String addBook(Books books) {
        booksService.addBook(books);
        return "redirect:/books/allBooks";
    }

    //删除书籍
    @RequestMapping("/deleteBook/{bookID}")
    public String deleteBook(@PathVariable("bookID") int id) {
        booksService.deleteBookById(id);
        return "redirect:/books/allBooks";
    }

    //跳转到修改书籍页面
    @RequestMapping("/toUpdatePage")
    public String toUpdatePage(Model model, int id) {
        Books book = booksService.queryBookById(id);
        model.addAttribute("book", book);
        return "updateBook";
    }

    //修改书籍
    @RequestMapping("/updateBook")
    public String updateBook(Model model, Books book) {
        booksService.updateBook(book);
        return "redirect:/books/allBooks";
    }

    //查询全部书籍
    @RequestMapping("/allBooks")
    public String list(Model model) {
        List<Books> booksList = booksService.queryAllBooks();
        model.addAttribute("booksList", booksList);
        return "allBooks";
    }

}
