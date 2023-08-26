package org.acci.Library.Management.System.repository;

import org.acci.Library.Management.System.entity.Student;
import org.acci.Library.Management.System.enums.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
  @Query(value = "select * from student s where s.branch =:branch",nativeQuery = true)
  public List<Student> findByBranch(String branch);
}
