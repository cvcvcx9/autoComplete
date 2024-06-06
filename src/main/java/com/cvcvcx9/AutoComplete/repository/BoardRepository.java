package com.cvcvcx9.AutoComplete.repository;

import com.cvcvcx9.AutoComplete.Entity.Board;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board,Long>, BoardCustomRepository {
}
