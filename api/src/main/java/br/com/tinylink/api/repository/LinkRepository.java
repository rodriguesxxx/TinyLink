package br.com.tinylink.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tinylink.api.models.Link;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface LinkRepository extends JpaRepository<Link, Integer> {
    Optional<Link> findByCode(Integer code);
}
