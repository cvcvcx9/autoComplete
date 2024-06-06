package com.cvcvcx9.AutoComplete.repository;

import com.cvcvcx9.AutoComplete.document.EsBoard;
import com.cvcvcx9.AutoComplete.dto.SearchConditionDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

public class BoardEsCustomRepositoryImpl implements BoardEsCustomRepository{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<EsBoard> findByTitleOrContent(SearchConditionDto dto) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<EsBoard> cq = cb.createQuery(EsBoard.class);

        Root<EsBoard> board = cq.from(EsBoard.class);
        Predicate titlePredicate = cb.like(board.get("title"),"%"+dto.getQuery()+"%");
        Predicate contentPredicate = cb.like(board.get("content"),"%"+dto.getQuery()+"%");
        cq.where(titlePredicate,contentPredicate);
        TypedQuery<EsBoard> query = em.createQuery(cq);
        return query.getResultList();
    }
}
