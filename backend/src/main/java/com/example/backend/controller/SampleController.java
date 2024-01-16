package com.example.backend.controller;

import com.example.backend.common.MyLogger;
import com.example.backend.domain.Sample;
import com.example.backend.service.LogDemoService;
import com.example.backend.service.SampleService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SampleController {

    private final SampleService sampleService;
    private final LogDemoService logDemoService;
    private final MyLogger myLogger;

    @PostMapping("/sample/new")
    public Long create(Sample sample) {
        return sampleService.join(sample);
    }

    @GetMapping("/log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request) {
        String requestURL = request.getRequestURL().toString();

        myLogger.setRequestURL(requestURL);
        myLogger.log("Controller test");
        logDemoService.logic("testID");

        return "OK";
    }
}
