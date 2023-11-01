package com.hdhye.toyproject.board.model.dto;

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
