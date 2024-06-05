package com.cvcvcx9.AutoComplete.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ReadBoardDto {
    private Long id;
    private String title;
    private String content;
}
