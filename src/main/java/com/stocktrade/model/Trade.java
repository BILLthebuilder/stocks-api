package com.stocktrade.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Trade implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
   // @JoinColumn(name="id")
    @ManyToOne
    private User user;
    private String symbol;
    private Integer shares;
    private Float price;
    @Column(name = "date_created", updatable = false, nullable = false, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date dateCreated;

    @Column(name = "date_updated", columnDefinition = "DATETIME ON UPDATE CURRENT_TIMESTAMP")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date dateUpdated;

    @PrePersist
    void dateCreatedAt() {
        this.dateCreated = new Date();
    }

    @PreUpdate
    void dateUpdatedAt() {
        this.dateUpdated = new Date();
    }
}
