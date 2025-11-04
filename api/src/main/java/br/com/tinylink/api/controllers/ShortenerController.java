package br.com.tinylink.api.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;
 

import br.com.tinylink.api.models.Link;
import br.com.tinylink.api.models.Entry;
import br.com.tinylink.api.service.LinkService;
import br.com.tinylink.api.utils.ShortenerUtil;

@RestController
@RequestMapping("/tinylink")
public class ShortenerController {

    @Autowired
    LinkService linkService;

    @Autowired
    ShortenerUtil shortenerUtil;

    @GetMapping("/{code}")
    public RedirectView redirect(@PathVariable Integer code) {
        RedirectView redirectView = new RedirectView();
        Optional<Link> link = linkService.findLinkByCode(code);
        if (link.isPresent()) {
            redirectView.setUrl(link.get().getUrl());
        } else {
            // not found -> redirect to ping or home
            redirectView.setUrl("/tinylink");
        }

        return redirectView;
    }

    @GetMapping("/{code}/qr")
    public ResponseEntity<byte[]> qr(@PathVariable Integer code) {
        byte[] png = linkService.generateQrImage(code, 300);
        if (png == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok().header("Content-Type", "image/png").body(png);
    }

    @PostMapping()
    public String shortener(@RequestBody Entry entry){
        return shortenerUtil.shortener(entry.url);
    }

    @GetMapping
    public ResponseEntity<Object> ping(){
        return new ResponseEntity<>("pong", HttpStatus.ACCEPTED);
    }

}
