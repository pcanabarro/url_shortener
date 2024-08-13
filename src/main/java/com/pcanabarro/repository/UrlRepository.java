package com.pcanabarro.repository;

import com.pcanabarro.entity.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UrlRepository extends JpaRepository<Url, Long> {
    Url findById(long id);
    List<Url> findByShortUrl(String shortUrl);

    @Query("FROM Url WHERE id = :id")
    Url findByIdQuery(@Param("id") long id);
}
