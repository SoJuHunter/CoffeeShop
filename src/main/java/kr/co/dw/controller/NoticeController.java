package kr.co.dw.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.co.dw.domain.NoticeDTO;
import kr.co.dw.service.NoticeService;
import kr.co.dw.service.NoticeUploadService;
import kr.co.dw.utils.UpUtils;

@Controller
@RequestMapping("/notice")
public class NoticeController {
		
	@Inject
	private NoticeService nService;
	
	@Autowired
	private NoticeUploadService uService;
	private String uploadPath = "C:" + File.separator + "upload";
	

	
	@RequestMapping(value = "/{nno}/uploadall", method = RequestMethod.GET)
    public ResponseEntity<List<String>> getAllUpload(@PathVariable("nno") int nno){
       ResponseEntity<List<String>> entity = null;

       try {
		
    	List<String> list  = uService.getAllUpload(nno);
    	   entity = new ResponseEntity<List<String>>(list, HttpStatus.OK);
    	   
	} catch (Exception e) {
		e.printStackTrace();
		entity = new ResponseEntity<List<String>>(HttpStatus.BAD_REQUEST);
	}
       
       return entity;
       
    }
	
	
	
	
	@RequestMapping(value = "/update", method=RequestMethod.POST) public String
	update(NoticeDTO nDto) { nService.update(nDto);
	  
	return "redirect:/notice/read/"+nDto.getNno(); }
	 
	@RequestMapping(value="/update/{nno}", method =RequestMethod.GET)
	public String updateUI(@PathVariable("nno")int nno, Model model) {
		NoticeDTO nDto = nService.updateUI(nno);
		model.addAttribute("nDto",nDto);
		return "/notice/update";
		
	}
	
	
	@RequestMapping(value = "/delete/{nno}", method = RequestMethod.POST)
	public String delete(@PathVariable("nno") int nno) {
		
		nService.delete(nno);
		return "redirect:/notice/list";
	}
	

	@RequestMapping(value = "/read/{nno}", method = RequestMethod.GET)
	public String read(@PathVariable("nno") int nno, Model model, HttpServletRequest request) {
		String ip = request.getRemoteAddr();
		NoticeDTO nDto = nService.read(nno, ip);
		model.addAttribute("nDto", nDto);

		return "/notice/read";
	}
	
	
	
	 @RequestMapping(value = "/insert", method = RequestMethod.POST,produces = "text/plain;charset=UTF-8") 
	 public ResponseEntity<String> insert(MultipartHttpServletRequest request, Model model){
		 ResponseEntity<String> entity = null;
		 
			String nTitle =	request.getParameter("nTitle");
			String userId =	request.getParameter("userId");
			String nContent = request.getParameter("nContent");
			
			NoticeDTO nDto = new NoticeDTO(0, userId, nTitle, nContent, null, null, 0);
			
			try {
				Map<String, MultipartFile> map = request.getFileMap();
				Set<String> set = map.keySet();
				Iterator<String> it = set.iterator();
				List<String> filenameList = new ArrayList<String>();
				
				while (it.hasNext()) {
					String key =  it.next();
					MultipartFile file = map.get(key);
					
					 String uploadedFilename = UpUtils.uploadFile(uploadPath, 
			                  file.getOriginalFilename(), file.getBytes());
					 
					 filenameList.add(uploadedFilename);
				}
				
				nDto.setFilenameList(filenameList);
				nService.insert(nDto);
				
				entity = new ResponseEntity<String>(nDto.getNno()+"", HttpStatus.OK);
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				entity = new ResponseEntity<String>(-1+"", HttpStatus.BAD_GATEWAY);
			}
	  
	 return entity; 
	 }
	 
	
	
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert() {
		
		
		return "/notice/insert";
	}
	
	
	@RequestMapping( value = "/list", method = RequestMethod.GET)
	public String list(Model model) {
		List<NoticeDTO> list = nService.list();
		model.addAttribute("list", list);
		
		return "/notice/list";
	}
}
