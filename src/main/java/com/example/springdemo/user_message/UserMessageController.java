package com.example.springdemo.user_message;
//# Spring Framework Anotations
//Enable CORS to test multiple ports on the same computer
//THIS IS A DEMO, NEVER USE ON PRODUCTION GRADE CODE!
import org.springframework.web.bind.annotation.CrossOrigin; 
//Rest Services Mapping
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
//Parameters, Request and Response Mappings
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springdemo.user_account.UserAccount;

//# Spring Framework Autowired Service
import org.springframework.beans.factory.annotation.Autowired;

//Enable CORS
@CrossOrigin
@RestController
public class UserMessageController {
    //Data Repository
    @Autowired
    private UserMessageService userMessageService;
    
    //Split Get Mapping to use AutoMap of the Response (1/2) Retrieve a list
    //Using multiple endpoints in value to avoid end hypen no end hypen confusion
    @GetMapping(value = {"/rest/user_message","/rest/user_message/"}, produces = "application/json")
	@ResponseBody
    public Iterable<UserMessage> getList(
        @RequestParam(required = false) Long userAccountId, 
        @RequestParam(required = false) String message, 
        @RequestParam(required = false) String sort) {
        UserMessage userMessage = new UserMessage(null, new UserAccount(userAccountId), message);
        return userMessageService.list(userMessage, sort);
    }
    
    //Split Get Mapping to use AutoMap of the Response (2/2) Retrieve a single object
    @GetMapping(value = {"/rest/user_message/{id}", "/rest/user_message/{id}/"}, produces = "application/json")
	@ResponseBody
    public UserMessage get(@PathVariable(required = true) Long id) {return userMessageService.get(id);}
    
    //Insert a new object if id is sent it will be ignored
    @PostMapping(value = {"/rest/user_message","/rest/user_message/"}, consumes = "application/json", produces = "application/json")
    @ResponseBody
    public UserMessage post(@RequestBody UserMessage userMessage) {
        userMessage.setId(null);
        return userMessageService.postAndPut(userMessage);
    }

    //Update an object
    @PutMapping(value = {"/rest/user_message/{id}", "/rest/user_message/{id}/"}, consumes = "application/json", produces = "application/json")
    @ResponseBody
    public UserMessage put(@PathVariable(required = true) Long id, @RequestBody UserMessage userMessage) {
        //make object id and uri id match
        userMessage.setId(id);
        return userMessageService.postAndPut(userMessage);
    }

    //Delete an object
    @DeleteMapping(value = {"/rest/user_message/{id}", "/rest/user_message/{id}/"}, produces = "application/json")
	public void delete(@PathVariable(required = true) Long id) {userMessageService.delete(id);}
}
