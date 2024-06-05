package com.cvcvcx9.AutoComplete.dto;

import com.cvcvcx9.AutoComplete.Entity.Board;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CreateBoardDto {

   @NotBlank
    private String title;
    @NotBlank
    private String content;

    public Board toEntity(){
        return Board.builder()
                .title(title)
                .content(content)
                .build();
    }
}
