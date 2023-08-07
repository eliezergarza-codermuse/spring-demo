package com.example.springdemo.user_message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service
public class UserMessageService {
    Logger logger = LogManager.getRootLogger();
    @Autowired
    private UserMessageRepository userMessageRepository;

    public Iterable<UserMessage> list(UserMessage exampleRecord, String sortString) {
        Example<UserMessage> example = Example.of(exampleRecord);
        Sort sort=Sort.by(Sort.Direction.ASC, "id");
        if(sortString!=null&&!sortString.trim().isEmpty()){
            logger.debug("Change Sort Order");
            sort = Sort.by(Sort.Direction.ASC, sortString.split(","));
        }
        return userMessageRepository.findAll(example, sort);
    }
    public UserMessage get(Long id) {return userMessageRepository.findById(id).get();}
    public UserMessage postAndPut(UserMessage userMessage) {return userMessageRepository.save(userMessage);}
    public void delete(Long id) {userMessageRepository.deleteById(id);}
}
