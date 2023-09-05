package br.com.tinylink.api.service;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.tinylink.api.models.Link;
import br.com.tinylink.api.repository.LinkRepository;

@Service
public class LinkService {
    
    @Autowired
    private LinkRepository linkRepository;

    public boolean add(Link link){

        try{
            linkRepository.save(link);
            return true;
            
        } catch(Exception e){
            return false;
        }

    }

    public List<Link> list(){
        return linkRepository.findAll();
    }

    public Link findLinkByCode(Integer code){
        ArrayList<Link> links = new ArrayList<>( list() );
        for(Link link : links){
            if(link.getCode().equals(code)){
                System.out.println("entrei");
                return link;
            }
        }
        return null;

    }
}
