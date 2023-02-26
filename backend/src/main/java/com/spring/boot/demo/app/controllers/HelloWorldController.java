package com.spring.boot.demo.app.controllers;

import com.spring.boot.demo.app.models.responses.HelloWorldResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/helloworld")
@CrossOrigin(origins = "http://localhost:3000")
public class HelloWorldController
{
    @Autowired
    private MessageSource messageSource;

    @GetMapping()
    public String helloWorld()
    {
        return "Hello World";
    }

    @GetMapping("bean")
    public HelloWorldResponse helloWorldBean()
    {
        return new HelloWorldResponse("Hello World");
    }

    ///hello-world/path-variable/ufuk
    @GetMapping("pathvariable/{name}")
    public HelloWorldResponse helloWorldPathVariable(@PathVariable String name)
    {
        return new HelloWorldResponse(String.format("Hello World, %s", name));
    }

    @GetMapping("internationalized")
    public String helloWorldInternationalized()
    {
        return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
    }
}
