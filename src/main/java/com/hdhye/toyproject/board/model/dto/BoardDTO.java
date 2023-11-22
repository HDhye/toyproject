package com.hdhye.toyproject.board.model.dto;

import lombok.*;

import java.sql.Timestamp;
import java.util.Date;

@NoArgsConstructor
@Getter
@ToString
public class BoardDTO {

    private int bulletinCode;
    private String title;
    private int views;
    private String content;
    private Date creationDate;
    private String deleteYn;
    private Date modifiedDate;
    private String allowComments;
    private CategoryDTO category;
    private EmployeeDTO employee;

    @Builder
    public BoardDTO(int bulletinCode, String title, int views, String content, Date creationDate, String deleteYn, Date modifiedDate, String allowComments, CategoryDTO category, EmployeeDTO employee) {
        this.bulletinCode = bulletinCode;
        this.title = title;
        this.views = views;
        this.content = content;
        this.creationDate = creationDate;
        this.deleteYn = deleteYn;
        this.modifiedDate = modifiedDate;
        this.allowComments = allowComments;
        this.category = category;
        this.employee = employee;
    }


}
