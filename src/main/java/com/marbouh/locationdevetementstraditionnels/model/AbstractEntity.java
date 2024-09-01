package com.marbouh.locationdevetementstraditionnels.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import java.time.Instant;
@Data
@MappedSuperclass
public class AbstractEntity implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        @CreatedDate
        private Instant creationDate;
        @LastModifiedDate
        private Instant lastModifiedDate;
}
