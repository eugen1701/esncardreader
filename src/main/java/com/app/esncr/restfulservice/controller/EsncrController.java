package com.app.esncr.restfulservice.controller;

import com.app.excel.HandleExcel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EsncrController {

    @GetMapping("/verify-id/{idToVerify}")
    public boolean verifyId(@PathVariable final String idToVerify) {
        return HandleExcel.verifyIdIsPresent(idToVerify);
    }
}
