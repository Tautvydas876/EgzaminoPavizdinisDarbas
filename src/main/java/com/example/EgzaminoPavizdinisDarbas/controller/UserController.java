package com.example.EgzaminoPavizdinisDarbas.controller;


import com.example.EgzaminoPavizdinisDarbas.entity.Book;
import com.example.EgzaminoPavizdinisDarbas.entity.Category;
import com.example.EgzaminoPavizdinisDarbas.entity.User;
import com.example.EgzaminoPavizdinisDarbas.service.BookService;
import com.example.EgzaminoPavizdinisDarbas.service.CategoryService;
import com.example.EgzaminoPavizdinisDarbas.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;

    public UserController(CategoryService categoryService, UserService userService, BookService bookService) {
        this.categoryService = categoryService;
        this.userService = userService;
        this.bookService = bookService;
    }

    @PostMapping("/login")
    public String loginForm(@RequestParam("username") String userName, @RequestParam("password") String password, Model model) {
        User user = userService.findUserFromDb(userName, password);
        if (user.getAdmin()) {
            model.addAttribute("admin", user);
            return "redirect:/admin-page";
        } else {
            model.addAttribute("user", user);
            return "redirect:/user-page";
        }
    }

    @PostMapping("/admin-page/addBook")
    public String addBook(@RequestParam("name") String name, @RequestParam("pageNumber") int pageNumber,
                          @RequestParam("summary") String summary, @RequestParam("isbn") String isbn, @RequestParam("category") String categoryName) {

        Book book = new Book(name, summary, isbn, pageNumber, true);
        Category category = categoryService.findCategoryByName(categoryName);
        book.setCategory(category);


        System.out.println(book);
        bookService.save(book);
        return "redirect:/admin-page";

    }

    @PostMapping("/admin-page/delete")
    public String deleteBook(@RequestParam("book_id") int id) {
        System.out.println("book_id => " + id);
        Book book = bookService.findBookById(id);
        bookService.delete(book);
        return "redirect:/admin-page";
    }


    @PostMapping("/admin-page/updateBook")
    public String updateBook(@RequestParam("name") String name, @RequestParam("pageNumber") int pageNumber,
                             @RequestParam("summary") String summary, @RequestParam("isbn") String isbn,
                             @RequestParam("book_id") int id, @RequestParam("is_available") boolean isAvailable,
                             @RequestParam("category") String categoryName,
                             Model model) {

        Category category = categoryService.findCategoryByName(categoryName);
        System.out.println(isAvailable);

        Book book = new Book(id, name, summary, isbn, pageNumber, isAvailable);
        book.setCategory(category);
        model.addAttribute("book", book);

        bookService.save(book);
        return "redirect:/admin-page";
    }

    @PostMapping("/admin-page/updateCategory")
    public String updateCategory(@RequestParam("name") String name, @RequestParam("category_id") int id, Model model) {

        Category category = new Category(id, name);
        categoryService.save(category);
        model.addAttribute("category", category);
        return "/redirect:/admin-page";
    }


    @PostMapping("/admin-page/deleteCategory")
    public String deleteCategory(@RequestParam("category_id") int id, Model model) {
        categoryService.deleteById(id);
        return "redirect:/admin-page";
    }

    @PostMapping("/admin-page/addCategory")
    public String addCategory(@RequestParam("category_name") String name) {
        Category category = new Category(name);
        categoryService.save(category);
        return "redirect:/admin-page";
    }


//    Show Forms

    @GetMapping("/admin-page")
    public String showAdminPage(Model model) {
        model.addAttribute("category", categoryService.findAll());
        model.addAttribute("books", bookService.findAll());
        return "/admin-page";
    }

    @GetMapping("/user-page")
    public String showUserPage() {
        return "/user-page";
    }

    @GetMapping("/")
    public String ShowLoginForm() {
        return "/login";
    }


    @GetMapping("/admin-page/update")
    public String showUpdateBookForm(@RequestParam("book_id") int id, Model model) {
        Book book = bookService.findBookById(id);
        model.addAttribute("category", categoryService.findAll());
        model.addAttribute("book", book);
        return "/book-update";
    }

    @GetMapping("/admin-page/updateCategory")
    public String showUpdateCategoryForm(@RequestParam("category_name") String name, Model model) {
        System.out.println(name);
        Category category = categoryService.findCategoryByName(name);
        model.addAttribute("category", category);
        return "/category-update";
    }

}
