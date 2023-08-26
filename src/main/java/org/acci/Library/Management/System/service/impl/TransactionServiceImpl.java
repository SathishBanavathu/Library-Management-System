package org.acci.Library.Management.System.service.impl;

import lombok.AllArgsConstructor;
import org.acci.Library.Management.System.DTOS.request.TransactionDtos.IssueBookRequestDto;
import org.acci.Library.Management.System.DTOS.request.TransactionDtos.RecoverBookRequestDto;
import org.acci.Library.Management.System.DTOS.response.TransactionDtos.IssueBookResponseDto;
import org.acci.Library.Management.System.entity.Book;
import org.acci.Library.Management.System.entity.Card;
import org.acci.Library.Management.System.entity.Transaction;
import org.acci.Library.Management.System.enums.CardStatus;
import org.acci.Library.Management.System.enums.TransactionStatus;
import org.acci.Library.Management.System.exceptions.BookNotFountException;
import org.acci.Library.Management.System.exceptions.CardNotFoundException;
import org.acci.Library.Management.System.repository.BookRepository;
import org.acci.Library.Management.System.repository.CardRepository;
import org.acci.Library.Management.System.repository.TransactionRepository;
import org.acci.Library.Management.System.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TransactionServiceImpl  implements TransactionService {

    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    CardRepository cardRepository;

//    @Autowired
//    private JavaMailSender mailSender;
    @Override
    public IssueBookResponseDto issueBook(IssueBookRequestDto issueBookRequestDto) throws Exception
    {
        Card card;
        Transaction transaction = new Transaction();
        transaction.setTransactionNumber(String.valueOf(UUID.randomUUID()));
        transaction.setIssueOperation(true);
        try{
            card = cardRepository.findById(issueBookRequestDto.getCardId()).get();
        }
        catch(Exception e)
        {
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new CardNotFoundException("Invalid Card Id");
        }
        transaction.setCard(card);
        Book book;
        try{
            book = bookRepository.findById(Integer.valueOf(issueBookRequestDto.getBookId())).get();
        }
        catch(Exception e)
        {
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new BookNotFountException("Invalid Book Id");
        }
        transaction.setBook(book);

        if(card.getCardStatus()!= CardStatus.ACTIVATE)
        {
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Card is not in active.........!");
        }
        if(book.isIssueStatus()==true)
        {
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Book is not in available.........!");
        }
        transaction.setTransactionStatus(TransactionStatus.SUCCESS);

        book.setIssueStatus(true);
        book.setCard(card);
        book.getTransactionsList().add(transaction);

        card.getBooksIssued().add(book);
        card.getTransactionList().add(transaction);

        cardRepository.save(card);//save card,book,transaction

        //Response Entity
        IssueBookResponseDto issueBookResponseDto = new IssueBookResponseDto();
        issueBookResponseDto.setBookName(book.getTitle());
        issueBookResponseDto.setTransactionNumber(transaction.getTransactionNumber());
        issueBookResponseDto.setTransactionStatus(TransactionStatus.SUCCESS);


//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setFrom("accilmsauto@gmail.com");
//        message.setTo(card.getStudent().getEmail());//To mail
//        message.setSubject("Issue Book");//Subject of the mail
//        message.setText(""+book.getTitle()+"Book is issued");//text
//
//        mailSender.send(message);



        return issueBookResponseDto;


    }

    @Override
    public String recoverBook(RecoverBookRequestDto recoverBookRequestDto) throws Exception
    {
        Transaction transaction = new Transaction();
        transaction.setTransactionNumber(String.valueOf(UUID.randomUUID()));
        transaction.setIssueOperation(false);
        Book book;
        try{
            book = bookRepository.findById(recoverBookRequestDto.getBookId()).get();
            book.setIssueStatus(false);
        }
        catch (Exception e){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            throw  new Exception("Book Id Not Exist");
        }
        Card card;
        try{
            card = cardRepository.findById(recoverBookRequestDto.getCardId()).get();
        }
        catch (Exception e)
        {
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            throw new CardNotFoundException("Invalid Card Id");
        }
        transaction.setTransactionStatus(TransactionStatus.SUCCESS);
        card.getTransactionList().add(transaction);
        book.getTransactionsList().add(transaction);
        cardRepository.save(card);
        return "Book Received Successfully";

    }
}
