package com.cvcvcx9.AutoComplete.Service;

import com.cvcvcx9.AutoComplete.Entity.Board;
import com.cvcvcx9.AutoComplete.document.EsBoard;
import com.cvcvcx9.AutoComplete.dto.CreateBoardDto;
import com.cvcvcx9.AutoComplete.dto.ReadBoardDto;
import com.cvcvcx9.AutoComplete.dto.SearchConditionDto;
import com.cvcvcx9.AutoComplete.repository.BoardEsRepository;
import com.cvcvcx9.AutoComplete.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    private final BoardEsRepository boardEsRepository;
    public ReadBoardDto createNewArticle(CreateBoardDto dto){
        Board board = dto.toEntity();
        Board saved = boardRepository.save(board);
        return saved.toDto();
    }

    public List<ReadBoardDto> searchBoard(SearchConditionDto dto){
        List<Board> search = boardRepository.search(dto);
        return search.stream().map(Board::toDto).collect(Collectors.toList());
    }

    public List<ReadBoardDto> searchEsBoard(SearchConditionDto dto){

        List<EsBoard> result =  boardEsRepository.findByTitle(dto.getQuery());
//        boardEsRepository.findAll().iterator().forEachRemaining(result::add);
        return result.stream().map(EsBoard::toDto).collect(Collectors.toList());
//        return search.stream().map(EsBoard::toDto).collect(Collectors.toList());
    }

}
