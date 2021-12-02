package com.example.developer.postgresql.entity;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

@MappedSuperclass
@TypeDefs({
        @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
})
public class BaseEntity {
    @Id
    @GeneratedValue(strategy  = GenerationType.IDENTITY)
    private String id;

    public BaseEntity() {
        this.id = UUID.randomUUID().toString();
    }
}
