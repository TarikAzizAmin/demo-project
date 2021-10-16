package tarik.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {
	
	
	public final String DIR = "C:\\Users\\tamin\\eclipse-workspace\\projectbackend\\src\\main\\resources\\static\\images";
	
	public boolean uploadFile(MultipartFile file) {
		boolean f = false;
		try {
			
			
			//reading images in byte[] array
//		InputStream is = file.getInputStream();
//		byte data[] = new byte[is.available()];
//		is.read(data);
//		
//
//		//writing image...
//		FileOutputStream fos = new FileOutputStream( DIR + "\\" + file.getOriginalFilename());
//		fos.write(data);
//		
//		fos.flush();
//		fos.close();
//		
//		f = true;
			
			
			Files.copy(file.getInputStream(), Paths.get(DIR + File.separator + file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
			f = true;
			
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		
		return f;
	}
	
	
}
