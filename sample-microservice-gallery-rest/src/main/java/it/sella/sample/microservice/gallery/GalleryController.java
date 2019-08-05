package it.sella.sample.microservice.gallery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by gbs04154 on 03-01-2019.
 */
@RestController
@RequestMapping("rest/gallary")
public class GalleryController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{id}")
    public Gallery getGallery(@PathVariable final int id) {
        // create gallery object
        Gallery gallery = new Gallery();
        gallery.setId(id);

        // get list of available images
//        Map<String, Integer> uriFields = new HashMap<>();
//        uriFields.put("id",1);
        ResponseEntity<GalleryImageList> response = restTemplate.getForEntity("http://localhost:8200/rest/images/", GalleryImageList.class);
        GalleryImageList images = response.getBody();
        gallery.setImages(images);
        return gallery;
    }

}
