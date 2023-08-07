package com.example.springdemo.user_account;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.springdemo.application.ApplicationDefaults;
//# Spring Framework Autowired Service
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

//Enable CORS
@CrossOrigin
@RestController
@RequestMapping("rest")
public class UserAccountController {
    //Data Repository
    @Autowired
    private UserAccountService userAccountService;
    
    //Split Get Mapping to use AutoMap of the Response (1/2) Retrieve a list
    //Using multiple endpoints in value to avoid end hypen no end hypen confusion
    @GetMapping(value = {"/user_account","/user_account/"}, produces = "application/json")
	@ResponseBody
    public Iterable<UserAccount> getList(
        @RequestParam(required = false) String firstName, 
        @RequestParam(required = false) String lastName, 
        @RequestParam(defaultValue = "true") Boolean active, 
        @RequestParam(required = false) String sort) {
        UserAccount userAccount = new UserAccount(null, firstName, lastName, active);
        return userAccountService.list(userAccount, sort);
    }

    @GetMapping(value = {"/paged/user_account","/paged/user_account/"}, produces = "application/json")
	@ResponseBody
    public Page<UserAccount> getPageSorted(
        @RequestParam(required = false) String firstName 
        ,@RequestParam(required = false) String lastName
        ,@RequestParam(required = false) Boolean active
        ,@RequestParam(defaultValue = ApplicationDefaults.DEF_PAGE_NUMBER) Integer pageNumber 
        ,@RequestParam(defaultValue = ApplicationDefaults.DEF_PAGE_SIZE) Integer pageSize
        ,@RequestParam(defaultValue = "id") String sortField
        ,@RequestParam(defaultValue = "asc") String sortDirection) {
        Sort sort = Sort.by(sortField);
        System.out.println(String.format("sortDirection:%s", sortDirection));
        if(sortDirection.equalsIgnoreCase("desc")){
            System.out.println("sort descending");
            sort = sort.descending();
        }
        UserAccount filter=null;
        if(firstName!=null||lastName!=null||active!=null){
            filter= new UserAccount(null, firstName, lastName, active);
        }
        Pageable pageAndSort = PageRequest.of(pageNumber, pageSize, Sort.by(sortField));
        return userAccountService.pageSorted(filter, pageAndSort);
    }

    @GetMapping(value = {"/user_account_top","/user_account_top/"}, produces = "application/json")
	@ResponseBody
    public Iterable<UserAccount> getTopList(@RequestParam(defaultValue = "10") Integer top) {
        return userAccountService.getTop(top);
    }

    
    //Split Get Mapping to use AutoMap of the Response (2/2) Retrieve a single object
    @GetMapping(value = {"/user_account/{id}", "/user_account/{id}/"}, produces = "application/json")
	@ResponseBody
    public UserAccount get(@PathVariable(required = true) Long id) {
        return userAccountService.get(id);
    }
    
    //Insert a new object if id is sent it will be ignored
    @PostMapping(value = {"/user_account","/user_account/"}, consumes = "application/json", produces = "application/json")
    @ResponseBody
    public UserAccount post(@RequestBody UserAccount userAccount) {
        //reset user id
        userAccount.setId(null);
        return userAccountService.postAndPut(userAccount);
    }

    //Update an object
    @PutMapping(value = {"/user_account/{id}", "/user_account/{id}/"}, consumes = "application/json", produces = "application/json")
    @ResponseBody
    public UserAccount put(@PathVariable(required = true) Long id, @RequestBody UserAccount userAccount) {
        //make object id and uri id match
        userAccount.setId(id);
        return userAccountService.postAndPut(userAccount);
    }

    //Delete an object
    @DeleteMapping(value = {"/user_account/{id}", "/user_account/{id}/"}, produces = "application/json")
	public void delete(@PathVariable(required = true) Long id) {
        userAccountService.delete(id);
    }
}
