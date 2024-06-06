package com.cvcvcx9.AutoComplete.controller;

import com.cvcvcx9.AutoComplete.Service.BoardService;
import com.cvcvcx9.AutoComplete.dto.CreateBoardDto;
import com.cvcvcx9.AutoComplete.dto.ReadBoardDto;
import com.cvcvcx9.AutoComplete.dto.SearchConditionDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/board")
@RequiredArgsConstructor
@Slf4j
public class BoardController {

    private final BoardService boardService;
    @PostMapping("/")
    public ResponseEntity<ReadBoardDto> addNewPost (@Valid @RequestBody CreateBoardDto dto){
        return ResponseEntity.ok(boardService.createNewArticle(dto));
    }

    @GetMapping("/")
    public ResponseEntity<List<ReadBoardDto>> searchBoard(SearchConditionDto dto){
        List<ReadBoardDto> searchResult = boardService.searchBoard(dto);
        return ResponseEntity.ok(searchResult);
    }
    @GetMapping("/es")
    public ResponseEntity<List<ReadBoardDto>> esSearchBoard(SearchConditionDto dto){
        List<ReadBoardDto> searchResult = boardService.searchEsBoard(dto);
        return ResponseEntity.ok(searchResult);
    }
}
