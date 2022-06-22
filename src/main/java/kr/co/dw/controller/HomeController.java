package kr.co.dw.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.co.dw.domain.ProductDTO;
import kr.co.dw.utils.UpUtils;


@Controller
public class HomeController {
   private String uploadPath = "C:" + File.separator + "coffeeupload";

   
   @RequestMapping(value = "/test11", method = RequestMethod.GET)
	public String test11() {
		return "test11";
	}
	
	
	@RequestMapping(value = "/ajaxform", method = RequestMethod.POST, 
					produces = "text/plain;charset=UTF-8")
	public ResponseEntity<String> ajaxform(MultipartHttpServletRequest request, 
											Model model) throws Exception {
		
		String id = request.getParameter("id");
		System.out.println(id);
		System.out.println("id를 데이터베이스에 저장함.");
		System.out.println("저장이 잘 됐으면, 아래의 파일 저장하는 코드 실행");
		System.out.println("저장이 안 됐으면, 아래픠 파일 저장하는 코드 미실행");
		
		
		ResponseEntity<String> entity = null;
		
		try {
			//여러 개의 파일이 업로드 되었을 때, 해당 파일들의 목록을 가져오는 코드
			List<MultipartFile> list = request.getFiles("file");
			
			// 여러 개의 파일들이 업로드 된 후 파일명을 저장할 리스트
			List<String> filenameList = new ArrayList<String>();
			
			// 업로드 된 여러 개의 파일들을 반복문을 이용해서 실제로 저장하게 하는 코드
			for(int i=0;i<list.size();i++) {
				// list에 들어 있는 MultipartFile 객체 하나씩 획득
				MultipartFile file = list.get(i);
				
				// multipartfile에 들어 있는 파일 데이터를 파일로 저장하는 코드
				String uploadedFilename = UpUtils.uploadFile(uploadPath, 
						file.getOriginalFilename(), file.getBytes());
				
				// 여러 개의 업로드된 파일명을 저장하는 코드
				filenameList.add(uploadedFilename);
			}
			
			entity = new ResponseEntity<String>(filenameList.toString(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>("FAIL", HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}

	
	@RequestMapping(value = "/ajaxform", method = RequestMethod.GET)
	public String ajaxForm() {
		return "ajaxform";
	}
	
	
	@RequestMapping(value = "/deletefile", method = RequestMethod.POST)
	public ResponseEntity<String> deleteFile(String uploadedFilename){
		ResponseEntity<String> entity = null;
		
		try {
			
			UpUtils.deleteFile(uploadPath, uploadedFilename);
			
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>("FAIL", HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	
	@RequestMapping(value = "/displayfile", method = RequestMethod.GET)
	public ResponseEntity<byte[]> displayFile(String filename) {
		
		ResponseEntity<byte[]> entity = null;
		
		InputStream in = null;
		
		try {
			in = new FileInputStream(new File(uploadPath, filename));
			
			MediaType mType = UpUtils.getMediaType(filename);
			
			HttpHeaders headers = new HttpHeaders();
			
			if(mType != null) {//파일업로드하고 이미지파일의 썸네일을 보여줄 때
							   //img ~/2022/06/02/s_uuid_ori_name.png
				         // jsp파일에서 이미지파일의 썸네일을 클릭했을 때 원본파일 보여줄 때
						//img ~/2022/06/02/uuid_ori_name.png
				headers.setContentType(mType);
			}else {//여기는 일반파일의 썸네일을 클릭하면 실행되는 코드
				
				//파일을 다운로드하게 하는 마임타입(OCTET_STREAM)
				headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
				
				// 오리지널 네임을 추출하게 위해 오리지널 네임 바로 앞에 있는 _의 인덱스를 구하고
				// 그 인덱스에 1을 더해서 오리지널 네임의 첫 글자 인덱스 획득
				int idx = filename.indexOf("_") + 1;
				
				//오리지널 네임 추출
				String oriName = filename.substring(idx);
				
				//브라우저에서 파일명이 깨지지 않게 하기 위해서 브라우저에서 요구하는 인코딩으로 변경
				oriName = 
					new String(oriName.getBytes("UTF-8"), "ISO-8859-1");
				
				//헤더에 새로운 이름으로 파일명 지정
				//   \"는 문자열 안에 "(큰따옴표)를 넣기 위해서 \를 추가했음.
				// 큰따옴표는 이스케이프문자라 문자열에 표기할 때 단독으로 표기 불가능함.
				headers.add("Content-Disposition", 
						"attachment;filename=\""+oriName+"\"");
				
			}
			
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), 
												headers, 
												HttpStatus.OK);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		
		
		return entity;
		
		
	}
	
	@RequestMapping(value = "/uploadform", method = RequestMethod.POST)
	public String uploadForm(MultipartHttpServletRequest request, 
											Model model) throws Exception {
		
		String id = request.getParameter("id");
		
		//여러 개의 파일이 업로드 되었을 때, 해당 파일들의 목록을 가져오는 코드
		List<MultipartFile> list = request.getFiles("file");
		
		// 여러 개의 파일들이 업로드 된 후 파일명을 저장할 리스트
		List<String> filenameList = new ArrayList<String>();
		
		// 업로드 된 여러 개의 파일들을 반복문을 이용해서 실제로 저장하게 하는 코드
		for(int i=0;i<list.size();i++) {
			// list에 들어 있는 MultipartFile 객체 하나씩 획득
			MultipartFile file = list.get(i);
			
			// multipartfile에 들어 있는 파일 데이터를 파일로 저장하는 코드
			String uploadedFilename = UpUtils.uploadFile(uploadPath, 
					file.getOriginalFilename(), file.getBytes());
			
			// 여러 개의 업로드된 파일명을 저장하는 코드
			filenameList.add(uploadedFilename);
		}
						
		
		model.addAttribute("filenameList", filenameList);
		
		return "test";
	}
	
	
	
//	@RequestMapping(value = "/uploadform", method = RequestMethod.POST)
//	public String uploadForm(MultipartHttpServletRequest request, Model model) throws Exception {
//		String id = request.getParameter("id");
//		
//		
//		MultipartFile  file = request.getFile("file");
//		
//		String uploadedFilename = DWUtils.uploadFile(uploadPath, 
//				file.getOriginalFilename(), file.getBytes());
//		
//		//img ~/2022/06/02/s_uuid_ori_name.png
//		//general ~/2022/06/02/uuid_ori_name.txt
//		
//		
//		model.addAttribute("uploadedFilename", uploadedFilename);
//		
//		return "test";
//	}
	

	
	
	@RequestMapping(value = "/uploadform", method = RequestMethod.GET)
	public String uploadForm() {
		
		return "uploadform";
	}
	
	
	

	@RequestMapping(value = "/jsontest", method = RequestMethod.GET)
	@ResponseBody
	public ProductDTO jsonTest() {
		return new ProductDTO();
	}

	@RequestMapping(value = "/makefolder", method = RequestMethod.GET)
	public String makeFolder(Model model) {

		String uploadPath = UpUtils.makeFolder("C:"+File.separator+"coffeupload");
		System.out.println(uploadPath);

		return "redirect:/";
	}

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello(Model model) {
		String say = "mmmmmm";

		model.addAttribute("say", say);

		return "hello";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		
		
		String serverTime = "Hello";

		model.addAttribute("serverTime", serverTime);

		return "home";
	}
}