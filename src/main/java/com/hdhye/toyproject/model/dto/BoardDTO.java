package com.hdhye.toyproject.model.dto;

import lombok.*;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class BoardDTO {

    private int no;
    private String name;
    private String title;
    private String nickname;
    private Timestamp createdDate;


}
