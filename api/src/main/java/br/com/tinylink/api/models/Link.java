package br.com.tinylink.api.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Entity
public class Link {
    
    @Id
    @Data()
    @NoArgsConstructor
    @AllArgsConstructor
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(nullable=false)
    private String url; 

    @Column(nullable=false, unique=true)
    private Integer code;

    public Link(String url, Integer code){
        this.setUrl(url);
        this.setCode(code);;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Link link = (Link) o;
        return Objects.equals(id, link.id) && Objects.equals(url, link.url) && Objects.equals(code, link.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, url, code);
    }
}
