package com.fastJson.model;

import lombok.*;

/**
 * Created by pc5 on 2017/3/23.
 * 实体类    j
 */
@Data
@NoArgsConstructor
//@RequiredArgsConstructor
@AllArgsConstructor
public class studentInfo {
    private String studentName;
    private boolean studentSex;
    private int studentAge;
    private String[] likes;
}
