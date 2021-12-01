package com.example.developer.postgresql.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;

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
    @OneToMany(fetch = FetchType.LAZY)
    private List<TeacherInfo> infos;

}
