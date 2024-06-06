package com.cvcvcx9.AutoComplete.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SearchConditionDto {
    private SearchType type;
    private String query;
    private String sort;
}
