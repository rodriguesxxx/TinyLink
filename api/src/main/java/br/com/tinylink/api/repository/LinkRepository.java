package br.com.tinylink.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tinylink.api.models.Link;

public interface LinkRepository extends JpaRepository<Link, Integer>{}
