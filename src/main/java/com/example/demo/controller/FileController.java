package com.example.demo.controller;

import com.example.demo.config.exception.CustomizeException;
import com.example.demo.enums.WebError;
import com.example.demo.service.AccountService;
import com.example.demo.service.FileService;
import com.example.demo.vo.DownloadRequestVO;
import com.example.demo.vo.web.SuccessfullyResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Tag(name = "檔案")
@RestController
@RequestMapping("/file/v1")
@SecurityRequirement(name = "JWT_Authentication")
@Slf4j
public class FileController {

    @Autowired
    FileService fileService;

    @Autowired
    AccountService accountService;

    @SecurityRequirement(name = "JWT_Authentication")
    @Operation(summary = "上傳檔案", description = "")
    @PostMapping(value = "/upload",
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<?> upload(
            @RequestPart("file") MultipartFile uploadFile) {

        if (!accountService.isAccountAdmin()) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }

        if (uploadFile.isEmpty()) {
            throw new CustomizeException(WebError.FILE_UPLOAD_FAIL);
        }

        if (!fileService.uploadFile(uploadFile)) {
            throw new CustomizeException(WebError.FILE_UPLOAD_FAIL);
        }

        return ResponseEntity.ok(
                new SuccessfullyResponse<>(null));
    }

    @Operation(summary = "下載檔案", description = "")
    @PostMapping("/download")
    public ResponseEntity<?> download(
            HttpServletResponse response,
            @RequestBody DownloadRequestVO downloadRequestVO) {

        response.setHeader(
                "Content-Disposition",
                String.format("attachment; filename=%s",
                        downloadRequestVO.getFilename()));

        try {

            InputStream inputStream = fileService.downloadFile(downloadRequestVO);

            OutputStream outputStream = response.getOutputStream();
            outputStream.write(inputStream.readAllBytes());
            outputStream.flush();

            outputStream.close();

        } catch (IOException e) {
            throw new CustomizeException(WebError.FILE_DOWNLOAD_FAIL);
        }

        return ResponseEntity.ok(
                new SuccessfullyResponse<>(null));
    }

}
