package org.acci.Library.Management.System.repository;

import org.acci.Library.Management.System.entity.Book;
import org.acci.Library.Management.System.enums.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Integer> {

    @Query(value = " select * from book b where b.genre =:genre",nativeQuery = true)
    public List<Book> getByGenre(String genre);

    @Query(value = "select * from book b where b.price<=:price",nativeQuery = true)
    List<Book> getBookByPrice(int price);

    @Query(value = "select * from book b order by b.price desc limit :range",nativeQuery = true)
    List<Book> getExpensiveBooks(int range);

    @Query(value = "select * from book b order by b.price asc limit :range",nativeQuery = true)
    List<Book> getCheapBooks(int range);
}
