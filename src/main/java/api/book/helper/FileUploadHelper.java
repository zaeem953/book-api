package api.book.helper;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Component
public class FileUploadHelper {
    //Static folder for images
//    public final String UPLOAD_DIR="D:\\rest\\src\\main\\resources\\static\\image";
    public final String UPLOAD_DIR=new ClassPathResource("static/image/").getFile().getAbsolutePath();

    public FileUploadHelper()throws IOException {}

    public boolean uplaodFile(MultipartFile file){
        boolean f=false;

        try {
            //File Management Via Input and Output stream package
//            //Reading File data
//            InputStream inputStream = file.getInputStream();
//            byte[] data=new byte[inputStream.available()];
//            inputStream.read(data);
//
//            //Writing file in our Directory
//            FileOutputStream outputStream=new FileOutputStream(UPLOAD_DIR+ File.separator+file.getOriginalFilename());
//            outputStream.write(data);
//
//            outputStream.flush();
//            outputStream.close();

            //File management Via NIO package
            Files.copy(file.getInputStream(), Paths.get(UPLOAD_DIR+ File.separator+file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
            f=true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return f;
    }
}
