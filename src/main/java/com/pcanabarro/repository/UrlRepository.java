package com.pcanabarro.repository;

import com.pcanabarro.entity.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlRepository extends JpaRepository<Url, Long> {
    Url findById(long id);
    Url findByShortUrl(String shortUrl);
}
