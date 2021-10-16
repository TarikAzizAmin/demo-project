package tarik.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import tarik.helper.FileUploadHelper;

@RestController
public class FileUploadController {
	
	
	@Autowired
	private FileUploadHelper fileUploadHelper;
	
	@PostMapping("/upload-file")
	public ResponseEntity<String> uploadFile(@RequestParam("image")MultipartFile file) throws IOException{
		
//		System.out.println("original name => " + file.getOriginalFilename());
//		System.out.println("size => "+ file.getSize());
//		System.out.println("name => "+ file.getName());
//		System.out.println("Input Stream => " + file.getInputStream());
//		System.out.println("bytes => " + file.getBytes());
//		System.out.println("toString => " + file.toString());
//		System.out.println("content type => " + file.getContentType());

		
		try {
			
			if(file.isEmpty()) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("file can't be empty");
			}
			if(!file.getContentType().equals("image/png")) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("only PNG type content are alowed");
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		//now file upload code
		boolean f = fileUploadHelper.uploadFile(file);
		
		if(f) {
			return ResponseEntity.ok("file is successfully uploaded");
		}
		
		
		
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("something went worng");
	}
	
	
	
	
	

}
