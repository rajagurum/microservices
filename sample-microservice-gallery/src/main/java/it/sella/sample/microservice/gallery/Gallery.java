package it.sella.sample.microservice.gallery;

import java.util.List;

/**
 * Created by gbs04154 on 03-01-2019.
 */
public class Gallery {

    private Integer id;

    private GalleryImageList images;

    private String servicename;

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public GalleryImageList getImages() {
        return images;
    }

    public void setImages(final GalleryImageList images) {
        this.images = images;
    }

    public String getServicename() {
        return servicename;
    }

    public void setServicename(String servicename) {
        this.servicename = servicename;
    }
}
