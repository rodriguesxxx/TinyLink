package br.com.tinylink.api.service;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.client.j2se.MatrixToImageWriter;

import br.com.tinylink.api.models.Link;
import br.com.tinylink.api.repository.LinkRepository;

@Service
public class LinkService {

    @Autowired
    private LinkRepository linkRepository;

    private static final Logger logger = LoggerFactory
            .getLogger(LinkService.class);

    public boolean add(Link link){

        try {
            linkRepository.save(link);
            return true;
        } catch(Exception e){
            return false;
        }

    }

    public List<Link> list(){
        return linkRepository.findAll();
    }

    public Optional<Link> findLinkByCode(Integer code) {
        logger.info("ENTREI");

        return linkRepository.findByCode(code);
    }

    /**
     * Generate a PNG byte[] containing a QR code for the short URL associated with code.
     * Returns null if link not found or generation fails.
     */
    public byte[] generateQrImage(Integer code, int size) {
        Optional<Link> opt = findLinkByCode(code);
        if (opt.isEmpty()) {
            return null;
        }

        String url = opt.get().getUrl();

        try {
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = qrCodeWriter.encode(url, BarcodeFormat.QR_CODE, size, size);
            ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
            MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);
            return pngOutputStream.toByteArray();
        } catch (Exception e) {
            logger.error("Failed to generate QR code for url: {}", url, e);
            return null;
        }
    }
}
