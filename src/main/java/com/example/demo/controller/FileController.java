package com.example.demo.controller;

import com.example.demo.vo.DownloadRequestVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;
import java.util.Objects;

@Tag(name = "檔案")
@RestController
@RequestMapping("/file")
@Slf4j
public class FileController {

    @Value("${file.base.path}")
    private String fileBasePath;

    @Operation(summary = "上傳檔案", description = "")
    @PostMapping(value = "/upload",
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<?> upload(
            @RequestPart("file") MultipartFile uploadFile) {

        if (uploadFile.isEmpty()) {
            return ResponseEntity.ok("請上傳檔案");
        }

        try {

            File directoryPath = new File(fileBasePath);

            if (!directoryPath.exists()) {
                directoryPath.mkdirs();
            }

            File file = new File(directoryPath, Objects.requireNonNull(uploadFile.getOriginalFilename()));

            file.createNewFile();

            OutputStream outputStream = Files.newOutputStream(file.toPath());
            outputStream.write(uploadFile.getBytes());
            outputStream.close();


        } catch (IOException e) {
            log.error(e.getMessage());
            return ResponseEntity.ok("fail");
        }


        return ResponseEntity.ok("success");
    }

    @Operation(summary = "下載檔案", description = "")
    @PostMapping("/download")
    public ResponseEntity<?> download(
            HttpServletResponse response,
            @RequestBody DownloadRequestVO downloadRequestVO) {

        try {

            File file = new File(fileBasePath + downloadRequestVO.getFilename());

            if (!file.exists()) {
                return ResponseEntity.ok("fail not exists");
            }

            response.setHeader("Content-Disposition", String.format("attachment; filename=%s", file.getName()));

            InputStream inputStream = Files.newInputStream(file.toPath());

            OutputStream outputStream = response.getOutputStream();
            outputStream.write(inputStream.readAllBytes());
            outputStream.flush();

            outputStream.close();

        } catch (IOException e) {
            log.error(e.getMessage());
            return ResponseEntity.ok("fail");
        }


        return ResponseEntity.ok("success");
    }

}
