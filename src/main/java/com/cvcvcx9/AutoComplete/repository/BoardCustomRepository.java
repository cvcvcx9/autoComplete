package com.cvcvcx9.AutoComplete.repository;

import com.cvcvcx9.AutoComplete.Entity.Board;
import com.cvcvcx9.AutoComplete.dto.SearchConditionDto;

import java.util.List;

public interface BoardCustomRepository {
    public List<Board> search(SearchConditionDto dto);
}
