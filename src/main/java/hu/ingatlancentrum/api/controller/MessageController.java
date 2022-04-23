package hu.ingatlancentrum.api.controller;

import hu.ingatlancentrum.api.model.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/messages")
public class MessageController {

    @GetMapping
    public ResponseEntity<List<Message>> getMessages() {
        var message1 = new Message();
        message1.setText("Hello world! #1");

        var message2 = new Message();
        message2.setText("Hello world! #2");

        var messages = new ArrayList<Message>();
        messages.add(message1);
        messages.add(message2);

        return new ResponseEntity<List<Message>>(messages, HttpStatus.OK);
    }
}
