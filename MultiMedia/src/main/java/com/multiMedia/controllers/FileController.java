package com.multiMedia.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.multiMedia.payload.FileResponce;
import com.multiMedia.services.FileService;

@RestController
@RequestMapping("/file")
public class FileController {
	
	@Autowired
	//@Qualifier("fileServiceImpl")
	private FileService fileservice;// = new FileServiceImpl()
	
	
	@Value("${file.image}")
	private String path;

	@PostMapping("/upload")
//	@RequestMapping(value ="/upload", method =RequestMethod.POST)
	public ResponseEntity<FileResponce> fileUpload(
			@RequestParam("image")MultipartFile image){
		String responseFile;
		try {
			responseFile = fileservice.uploadImage(path, image);
			fileservice.sample();
		} catch (IOException e) {		
			e.printStackTrace();
			return new ResponseEntity<>(new FileResponce(null,"Image upload Filed"),HttpStatus.BAD_REQUEST);	
		}
		
		
		return new ResponseEntity<>(new FileResponce(responseFile,"Image uploaded"),HttpStatus.OK);
	}
//	@GetMapping("/sample")
//	public void sample()
//	{
//		
//	}
}
