package it.sella.sample.microservice.image.samplemicroserviceimage;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeoutException;

/**
 * Created by gbs04154 on 03-01-2019.
 */
@RestController
@RequestMapping("/")
public class ImageController {

    @Autowired
    private Environment env;

    private List<Image> images;

    public ImageController(){
        images = Arrays.asList(
                new Image(1, "Treehouse of Horror V", "https://www.imdb.com/title/tt0096697/mediaviewer/rm3842005760"),
                new Image(2, "The Town", "https://www.imdb.com/title/tt0096697/mediaviewer/rm3698134272"),
                new Image(3, "The Last Traction Hero", "https://www.imdb.com/title/tt0096697/mediaviewer/rm1445594112"));
    }

//    @HystrixCommand(groupKey = "imageHystrixGroupKey", commandKey = "imageHystrixCommandKey", fallbackMethod = "fallbackImages")
    @RequestMapping("/images")
    public ImageList getImages() throws TimeoutException {
        try {
            Thread.sleep(9000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new ImageList(images, env.getProperty("local.server.port"));
    }

    public ImageList fallbackImages() throws TimeoutException {
        return new ImageList(images, env.getProperty("local.server.port"));
    }


}
