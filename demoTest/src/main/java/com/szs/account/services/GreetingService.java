package com.szs.account.services;

import com.szs.account.models.Greeting;
import com.szs.account.repositories.GreetingRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GreetingService {

  private final GreetingRepository greetingRepository;

  public GreetingService(GreetingRepository greetingRepository) {
    this.greetingRepository = greetingRepository;
  }

  public Optional<Greeting> getMessage(long id) {
    return greetingRepository.findById(id);
  }

}
