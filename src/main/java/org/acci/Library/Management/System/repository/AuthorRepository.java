package org.acci.Library.Management.System.repository;

import org.acci.Library.Management.System.DTOS.response.AuthorDtos.AuthorEntityResponseDto;
import org.acci.Library.Management.System.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Integer> {

    @Query(value = "select * from author a where a.age>:age",nativeQuery = true)
    List<Author> getByAge(int age);

}
