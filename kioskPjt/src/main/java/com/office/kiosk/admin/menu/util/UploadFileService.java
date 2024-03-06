package com.office.kiosk.admin.menu.util;

import java.io.File;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadFileService {

	public String upload(MultipartFile file) {
		
		boolean result = false;
		
		//file 저장
		String fileOriName = file.getOriginalFilename();
		String fileExtetion = 
				fileOriName.substring(fileOriName.lastIndexOf("."), fileOriName.length());
		String uploadDir = "D:\\project\\menu\\";
		
		UUID uuid = UUID.randomUUID();
		String uniqueName = uuid.toString().replaceAll("-", "");
		
		File saveFile = new File(uploadDir + uniqueName + fileExtetion);
		
		if (!saveFile.exists())
			saveFile.mkdirs();
		
		try {
				
			file.transferTo(saveFile);
			result = true;
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		if (result) {
			System.out.println("[UploadFileService] FILE UPLOAD SUCCESS!!");
			return uniqueName + fileExtetion;
			
			
		} else {
			System.out.println("[UploadFileService] FILE UPLOAD FAIL!!");
			return null;
			
		}
	}
}
