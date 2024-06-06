package com.cvcvcx9.AutoComplete.repository;

import com.cvcvcx9.AutoComplete.Entity.Board;
import com.cvcvcx9.AutoComplete.dto.SearchConditionDto;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.cvcvcx9.AutoComplete.Entity.QBoard.board;

@Repository
public class BoardCustomRepositoryImpl implements BoardCustomRepository{

    @PersistenceContext
    private EntityManager em;

    private final JPAQueryFactory queryFactory;
    public BoardCustomRepositoryImpl(EntityManager em){
        this.em = em;
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<Board> search(SearchConditionDto dto) {
        List<Board> result = queryFactory.selectFrom(board)
                                        .where(getSearchPredicate(dto))
                                        .fetch();
        return result;
    }

    private BooleanBuilder getSearchPredicate(SearchConditionDto dto){
        BooleanBuilder builder = new BooleanBuilder();
        if (dto.getQuery() == null || dto.getQuery().isEmpty()){
            return builder;
        }
        switch (dto.getType()){
            case TITLE :
                builder.and(board.title.containsIgnoreCase(dto.getQuery()));
                break;
            case CONTENT:
                builder.and(board.content.containsIgnoreCase(dto.getQuery()));
                break;
            case TITLE_OR_CONTENT:
                builder.and(board.title.containsIgnoreCase(dto.getQuery()))
                        .or(board.content.containsIgnoreCase(dto.getQuery()));
                break;
            default:
                break;
        }
        return builder;
    }
}
