package org.acci.Library.Management.System.DTOS.response.Card;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.acci.Library.Management.System.enums.CardStatus;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CardEntityResponseDto {

    int id;

     Date issueDate;

     CardStatus cardStatus;

    String validTill;
}
