package com.example.developer.postgresql.entity;

import com.example.developer.postgresql.model.TeacherDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Teacher extends BaseEntity {

    private String name;
    private String pictureURL;
    private String email;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    @Basic(fetch = FetchType.LAZY)
    private TeacherDetail detail;

}
