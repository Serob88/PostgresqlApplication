package com.example.developer.postgresql.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherDetail implements Serializable {

    private List<Review> reviews;

    private List<Address> addresses;
}
