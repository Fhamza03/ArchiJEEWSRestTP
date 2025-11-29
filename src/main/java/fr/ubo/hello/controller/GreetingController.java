package fr.ubo.hello.controller;


import fr.ubo.hello.bean.Greeting;
import fr.ubo.hello.business.GreetingBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    @Autowired
    private GreetingBusiness business;

    @RequestMapping(value = "/greeting", produces = MediaType.APPLICATION_JSON_VALUE)
    public Greeting greeting(){
        return business.badGreeting();
    }

    @RequestMapping(value = "/greeting/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Greeting greeting(@PathVariable("name") String name){
        return business.greeting(name);
    }
    @RequestMapping(value = "/greeting2", produces = MediaType.APPLICATION_JSON_VALUE)
    public Greeting greeting2(@RequestParam(value = "name", required = false, defaultValue = "world") String name){
        return business.greeting(name);
    }
    @RequestMapping(value = "/greeting3", produces = MediaType.APPLICATION_JSON_VALUE)
    public Greeting greeting3(@RequestParam(value = "name", required = true) String name){
        return business.greeting(name);
    }
}
