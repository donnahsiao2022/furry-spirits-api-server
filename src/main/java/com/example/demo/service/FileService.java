package com.example.demo.service;

import com.example.demo.config.exception.CustomizeException;
import com.example.demo.enums.WebError;
import com.example.demo.vo.DownloadRequestVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.Objects;

@Service
@Slf4j
public class FileService {

    @Value("${file.base.path}")
    private String fileBasePath;

    public boolean uploadFile(MultipartFile uploadFile) {

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
            return false;
        }
        return true;
    }

    public InputStream downloadFile(DownloadRequestVO downloadRequestVO) throws IOException {

        File file = new File(fileBasePath + downloadRequestVO.getFilename());

        if (!file.exists()) {
            throw new CustomizeException(WebError.DATA_FILE_NOT_FOUND_EXCEPTION);
        }

        return Files.newInputStream(file.toPath());
    }
}
