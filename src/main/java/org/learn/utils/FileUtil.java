package org.learn.utils;

import org.learn.enums.ConstEnum;
import org.learn.enums.MessageEnum;
import org.learn.exception.CustomizeException;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class FileUtil {
    /**
     * 上传文件返回全路径
     * @param file
     * @param path
     * @return
     */
    public static String uploadFile(MultipartFile file, String path){
        String fullPath = null;
        if (file != null && !file.isEmpty()){
            String dir = FileUtil.class.getResource(ConstEnum.UPLOAD_ROOT_PATH.getValue()).getPath();
            String originalFilename = file.getOriginalFilename();
            if (originalFilename == null || originalFilename.length() > 50){
                originalFilename = "";
            }
            UUID uuid = UUID.randomUUID();
            String newName = uuid.toString() + "_" + originalFilename;
            path = path == null ? "" : path;
            fullPath = dir + path + newName;
            File newFile = new File(fullPath);
            try {
                file.transferTo(newFile);
            } catch (IOException e) {
                e.printStackTrace();
                throw new CustomizeException(MessageEnum.FILE_UPLOAD_FAIL);
            }
        }
        return fullPath;
    }
}
