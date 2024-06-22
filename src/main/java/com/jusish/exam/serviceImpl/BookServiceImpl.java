package com.jusish.exam.serviceImpl;

import com.jusish.exam.dtos.CreateBookDto;
import com.jusish.exam.models.Book;
import com.jusish.exam.models.User;
import com.jusish.exam.repositories.BookRepository;
import com.jusish.exam.repositories.UserRepository;
import com.jusish.exam.services.BookService;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl  implements BookService {
    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    BookServiceImpl(BookRepository bookRepository, UserRepository userRepository){
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Book createBook(CreateBookDto dto) throws Exception {
        try{
            if(dto.getTitle() == null || dto.getUser_id() == 0){
                throw new Exception("Book title is required...");
            }else {
                User user = userRepository.findById(dto.getUser_id()).orElseThrow((() -> new Exception("User not found!")));
                Book book = new Book();
                book.setTitle(dto.getTitle());
                book.setUser(user);
                user.getBooks().add(book);
                bookRepository.save(book);
                userRepository.save(user);
                return book;
            }
        }catch(Exception e){e.printStackTrace();throw new Exception(e.getMessage());}
    }
}
