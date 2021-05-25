package com.back.office.entity;

/**
 * @author Viju Joseph (vijujoseph@gmail.com)
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Trade {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String tradeId;

    private String version;

    private String counterPartyId;

    private String bookId;

    private Timestamp maturityDate;

    private Timestamp createdDate;

    private boolean expired;

}