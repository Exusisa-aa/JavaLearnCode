package com.learnMybatisplus.controller;

import com.learnMybatisplus.utils.AliyunOSSOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/upload")
public class UploadController {
    @Autowired
    AliyunOSSOperator aliyunOSSOperator;
    @PostMapping
    public Result upload(MultipartFile file) throws Exception{
        String url = aliyunOSSOperator.upload(file.getBytes(),file.getOriginalFilename());
        Integer code = file.getBytes().length > 0 ? Code.UPLOAD_OK.getCode(): Code.UPLOAD_ERR.getCode();
        String message = file.getBytes().length > 0 ? "上传成功" : "上传失败";
        return new Result(code,url,message);
    }
}
