package com.example.developer.postgresql.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course extends BaseEntity {

    private String name;
    private int workload;
    private short rate;

    @ManyToOne
    @JoinColumn
    private Teacher teacher;

}
