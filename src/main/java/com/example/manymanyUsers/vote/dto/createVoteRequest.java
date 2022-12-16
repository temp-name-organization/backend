package com.example.manymanyUsers.vote.dto;

import com.example.manymanyUsers.vote.enums.Age;
import com.example.manymanyUsers.vote.enums.Category;
import com.example.manymanyUsers.vote.enums.Gender;
import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class createVoteRequest {

    @NotBlank
    private String postedUserEmail;

    @NotBlank
    private String title;

    @NotBlank
    private String ImageA;

    @NotBlank
    private String ImageB;

    @NotBlank
    private String detail;

    private Gender gender;

    private Age age;

    private Category category;


}
