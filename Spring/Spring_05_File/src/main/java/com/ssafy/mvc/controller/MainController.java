package com.ssafy.mvc.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class MainController {

	// file or class path 등 resource를 load 하는데 사용하는 interface
	private final ResourceLoader resourceLoader;
	
	@Autowired // 하나 일때는 생략해도 존재하는 것
	public MainController(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/singleFileForm")
	public String singleFileForm() {
		return "singleFileForm";
	}
	
	@PostMapping("/singleFileUpload")
	public String singleFileUpload(@RequestParam("file") MultipartFile file, Model model) throws Exception {
		// file이 있는지 검사, 용량이 없으면 등록 X
		if (file != null && file.getSize() > 0) {
//			String fileName = file.getOriginalFilename();
			// 왜 안될까?
			String fileName = "dog01.jfif";
			System.out.println(fileName);
			Resource resource = resourceLoader.getResource("resources/upload");
			file.transferTo(new File(resource.getFile(), fileName));
			model.addAttribute("fileName", fileName);
		}
		return "result";
	}
	
	@GetMapping("/download")
	public String download(@RequestParam("fileName") String fileName, Model model) {
		model.addAttribute("fileName", fileName);
		return "fileDownloadView";
	}
}