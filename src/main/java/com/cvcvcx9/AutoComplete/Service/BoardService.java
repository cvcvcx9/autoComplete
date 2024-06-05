package com.cvcvcx9.AutoComplete.Service;

import com.cvcvcx9.AutoComplete.Entity.Board;
import com.cvcvcx9.AutoComplete.dto.CreateBoardDto;
import com.cvcvcx9.AutoComplete.dto.ReadBoardDto;
import com.cvcvcx9.AutoComplete.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    public ReadBoardDto createNewArticle(CreateBoardDto dto){
        Board board = dto.toEntity();
        Board saved = boardRepository.save(board);
        return saved.toDto();
    }
}
