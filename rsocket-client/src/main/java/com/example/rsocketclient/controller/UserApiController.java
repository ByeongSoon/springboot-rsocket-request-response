package com.example.rsocketclient.controller;

import com.example.rsocketclient.model.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserApiController {

  private final RSocketRequester requester;

  @GetMapping("{id}")
  Mono<User> findOneUserById(@PathVariable Long id) {
    return this.requester
        .route("request-response")
        .data(id)
        .retrieveMono(User.class);
  }

}
