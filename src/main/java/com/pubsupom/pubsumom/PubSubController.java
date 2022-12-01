package com.pubsupom.pubsumom;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import java.util.Base64;

@RestController
public class PubSubController {
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity receiveMessage(@RequestBody Body body) {
        // Get PubSub message from request body.
        Body.Message message = body.getMessage();
        if (message == null) {
            String msg = "Bad Request: invalid Pub/Sub message format";
            System.out.println(msg);
            return new ResponseEntity(msg, HttpStatus.BAD_REQUEST);

        }




        String data = message.getData();
        String target =
                !StringUtils.isEmpty(data) ? new String(Base64.getDecoder().decode(data)) : "World";
        String msg = "Wiadomość: " + target + "!";

        System.out.println(msg);
        return new ResponseEntity(msg, HttpStatus.OK);
    }
}
