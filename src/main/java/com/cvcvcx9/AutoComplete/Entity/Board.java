package com.cvcvcx9.AutoComplete.Entity;


import com.cvcvcx9.AutoComplete.dto.ReadBoardDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String content;

    public ReadBoardDto toDto(){
        return ReadBoardDto.builder()
                            .id(id)
                            .title(title)
                            .content(content)
                           .build();
    }

}
