package com.Myex.base.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
//@RequestMapping("/upload")
//@CrossOrigin(origins = "http://localhost:4200")
public class UploadController {

	private static String UPLOADED_FOLDER = ".\\frontend\\src\\assets\\";

	@PostMapping("/upload")
	//@CrossOrigin(origins = "http://localhost:4200")
	public String[] singleFileUpload(@RequestParam("file[]") MultipartFile[] file,
			@RequestParam("fileCount") String fileCount) {

		try {
			for (int i = 0; i < Integer.parseInt(fileCount); i++) {
				byte[] bytes = file[i].getBytes();
				Path path = Paths.get(UPLOADED_FOLDER  + file[i].getOriginalFilename());
				Files.write(path, bytes);
			}

		} catch (IOException e) {
			Logger logger = LoggerFactory.getLogger(UploadController.class);
			logger.error("File upload failed:", e);
			e.printStackTrace();
		}
		System.out.println("Sikeres feltoltes: \\assets\\" +  "\\" + file[0].getOriginalFilename());
		String[] filePath = new String[Integer.parseInt(fileCount)];
		for (int i = 0; i < Integer.parseInt(fileCount); i++) {
			filePath[i] = "\\assets\\"   +  file[i].getOriginalFilename();
		}
		return filePath;

	}
}
