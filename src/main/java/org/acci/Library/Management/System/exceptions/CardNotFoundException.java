package org.acci.Library.Management.System.exceptions;

import org.acci.Library.Management.System.repository.CardRepository;

public class CardNotFoundException extends Exception{
     public CardNotFoundException (String message)
     {
         super(message);
     }
}
