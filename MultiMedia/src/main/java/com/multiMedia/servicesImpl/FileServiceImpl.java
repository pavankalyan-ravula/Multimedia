package com.multiMedia.servicesImpl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.reactive.function.client.WebClient;

import com.multiMedia.model.UserHelper;
import com.multiMedia.services.FileService;
@Service
public class FileServiceImpl implements FileService{
	@Value("${webclinetBase.url}")
	private String baseUrl;
	
	private WebClient createWebClient()
	{
		return WebClient.builder().baseUrl(baseUrl).build();
	}
	@Override
	public void sample()
	{
		var data=createWebClient().get().uri("/getUserById/"+1)
							.retrieve().bodyToMono(UserHelper.class).blockOptional();
		System.out.println(data);
	}
	@Override
	public String uploadImage(String path, MultipartFile file) throws IOException {
		//fileNAme 
		String name =file.getOriginalFilename();
		
		String filePath=path+File.separator+name;//fullpath
		//folder check
		File f= new File(path);
		
		if(!f.exists())
			f.mkdir();
		
		
			Files.copy(file.getInputStream(), Paths.get(filePath));
		
		return name;
	}

}
