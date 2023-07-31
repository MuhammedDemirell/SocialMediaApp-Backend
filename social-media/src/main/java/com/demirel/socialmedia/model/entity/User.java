package com.demirel.socialmedia.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
public class User {



        @Id
        @Column(name = "product_id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long productId;

        @Column(name = "product_name")
        private String productName;

        @Column(name = "quantity")
        private int quantity;

        @Column(name = "price")
        private double price;

        @Builder.Default
        @Column(name = "product_updated_date")
        @Temporal(TemporalType.TIMESTAMP)
        @JsonFormat(pattern = "yyyy-MM-dd")
        private Date productUpdatedDate = new Date();

        @Builder.Default
        @Column(name = "product_created_date")
        @Temporal(TemporalType.TIMESTAMP)
        @JsonFormat(pattern = "yyyy-MM-dd")
        private Date productCreatedDate = new Date();

        @Column(name = "is_deleted")
        private boolean deleted;


    }

