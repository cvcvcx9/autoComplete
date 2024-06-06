package com.cvcvcx9.AutoComplete.repository;

import com.cvcvcx9.AutoComplete.document.EsBoard;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardEsRepository extends ElasticsearchRepository<EsBoard,Long>,BoardEsCustomRepository {
    public List<EsBoard> findByTitle(String title);

}
