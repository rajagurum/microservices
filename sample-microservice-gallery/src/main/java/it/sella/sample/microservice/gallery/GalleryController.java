package it.sella.sample.microservice.gallery;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

/**
 * Created by gbs04154 on 03-01-2019.
 */
@RestController
@RequestMapping("discovery/gallary")
public class GalleryController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {"application/json"})
    public String getGallery(@PathVariable final int id) throws IOException {
        // create gallery object
        Gallery gallery = new Gallery();
        gallery.setId(id);
        // get list of available images
        ResponseEntity<GalleryImageList> response = restTemplate.getForEntity("http://image-service-discovery/discovery/images/", GalleryImageList.class);
        GalleryImageList images = response.getBody();
        gallery.setImages(images);
        gallery.setServicename("======================GALLARY SERVICE=====================");

        String formattedData = new ObjectMapper().writerWithDefaultPrettyPrinter()
                .writeValueAsString(gallery);
        return formattedData;
    }


}
