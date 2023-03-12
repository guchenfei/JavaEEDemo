package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Player {
    private int id;
    private String name;
    private String password;
    private String nickname;
    private String photo;
    private String filetype;
}
