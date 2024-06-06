package com.cvcvcx9.AutoComplete.document;

import com.cvcvcx9.AutoComplete.dto.ReadBoardDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Getter
@Setter
@Builder
@Document(indexName = "board")
public class EsBoard {
    @Id
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
