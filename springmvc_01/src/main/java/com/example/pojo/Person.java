package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Person implements Serializable {
    private String pname;
    private String page;
    private String gender;
    private String[] hobby;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthdate;
    private Pet pet;
    private Map<String,Pet> petMap;
}
