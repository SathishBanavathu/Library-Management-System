package org.acci.Library.Management.System.repository;

import org.acci.Library.Management.System.DTOS.request.TransactionDtos.IssueBookRequestDto;
import org.acci.Library.Management.System.DTOS.response.TransactionDtos.IssueBookResponseDto;
import org.acci.Library.Management.System.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Integer> {
}
