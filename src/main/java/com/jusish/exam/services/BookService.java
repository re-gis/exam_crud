package com.jusish.exam.services;

import com.jusish.exam.dtos.CreateBookDto;
import com.jusish.exam.models.Book;

public interface BookService {
    Book createBook(CreateBookDto dto)throws Exception;
}
