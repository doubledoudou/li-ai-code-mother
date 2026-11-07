package com.tianji.liaicodemother.controller;

import com.tianji.liaicodemother.common.BaseResponse;
import com.tianji.liaicodemother.common.ResultUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class HealthController {
    @GetMapping
    public BaseResponse<String> getHealth() {
        return ResultUtils.success("ok");
    }
}
