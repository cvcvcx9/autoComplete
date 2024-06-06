package com.cvcvcx9.AutoComplete.repository;

import com.cvcvcx9.AutoComplete.document.EsBoard;
import com.cvcvcx9.AutoComplete.dto.SearchConditionDto;

import java.util.List;

public interface BoardEsCustomRepository {
    public List<EsBoard> findByTitleOrContent(SearchConditionDto dto);
}
