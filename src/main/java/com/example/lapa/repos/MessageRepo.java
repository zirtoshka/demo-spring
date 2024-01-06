package com.example.lapa.repos;

import com.example.lapa.domain.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepo extends CrudRepository<Message, Long>{
}
