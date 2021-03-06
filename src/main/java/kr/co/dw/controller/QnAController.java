package kr.co.dw.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.co.dw.domain.QnAReplyDTO;
import kr.co.dw.domain.QnaDTO;
import kr.co.dw.service.QnAReplyService;
import kr.co.dw.service.QnAService;
import kr.co.dw.service.QnAUploadService;
import kr.co.dw.utils.UploadUtils;

@Controller
public class QnAController {
	
	@Autowired
	private QnAService qnaservice;
	
	@Autowired
	private QnAUploadService qnauploadservice;
	
	@Autowired
	private QnAReplyService qnareplyservice;
	
	private final String UPLOADPATH = "C:" + File.separator + "coffeupload";
	
	
	@RequestMapping(value = "/makefolder", method = RequestMethod.GET)
	public String makeFolder(Model model) {
		
		UploadUtils.makeFolder(UPLOADPATH);

		return "redirect:/";
	}
	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String main() {
		return "home";
	}
	
	@RequestMapping(value = "/qna/insert", method = RequestMethod.GET)
	public String insert() {
		return "/qna/insert";
	}
	
	@RequestMapping(value = "/qna/insert", method = RequestMethod.POST, produces = "text/plain; charset=UTF-8")
	public ResponseEntity<String> insert(MultipartHttpServletRequest request) {
		ResponseEntity<String> entity = null;
		
		String userid = request.getParameter("userid");
		String qTitle = request.getParameter("qTitle");
		String qContent = request.getParameter("qContent");
		
		QnaDTO qDto = new QnaDTO(0, userid, qTitle, qContent, null, null, 0);
		
		try {
			Map<String, MultipartFile> map = request.getFileMap();
			Set<String> set = map.keySet();
			Iterator<String> it = set.iterator();
			
			List<String> filenameList = new ArrayList<String>();
			
			while (it.hasNext()) {
				String key = it.next();
				
				MultipartFile file = map.get(key);
				
				String uploadedFilename = UploadUtils.uploadFile(UPLOADPATH, file.getOriginalFilename(), file.getBytes());
				
				filenameList.add(uploadedFilename);
			}
				
			qDto.setFilenameList(filenameList);
			
			qnaservice.insert(qDto);
			
			entity = new ResponseEntity<String>(qDto.getQno()+"", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			
			entity = new ResponseEntity<String>(-1+"", HttpStatus.BAD_REQUEST);
		}
		
	
		return entity;
	}
	
	@RequestMapping(value = "/qna/list", method = RequestMethod.GET)
	public String list(Model model) {
		
		List<String> list = qnaservice.list();
		
		model.addAttribute("list", list);
		
		System.out.println(list);
		
		return "/qna/list";
	}
	
	@RequestMapping(value = "/qna/read/{qno}", method = RequestMethod.GET)
	public String read(Model model, @PathVariable("qno") int qno, HttpServletRequest request) {
		String ip = request.getRemoteAddr();
		
		QnaDTO qDto = qnaservice.read(qno, ip);
		
		model.addAttribute("qDto", qDto);
		
		return "/qna/read";
		
	}
	
	@RequestMapping(value = "/qna/{qno}/uploadall", method = RequestMethod.GET)
	public ResponseEntity<List<String>> getAllUpload(@PathVariable("qno") int qno) {
		ResponseEntity<List<String>> entity = null;
		
		try {
			List<String> list = qnauploadservice.getAllUpload(qno);
			entity = new ResponseEntity<List<String>>(list, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<List<String>>(HttpStatus.BAD_REQUEST);
		}
	
		
		return entity;
	}
	
	@RequestMapping(value = "/displayfile", method = RequestMethod.GET)
	public ResponseEntity<byte[]> displayFile(String filename) {
		ResponseEntity<byte[]> entity = null;
		
		InputStream in = null;
		
		try {
			in = new FileInputStream(new File(UPLOADPATH, filename));
			MediaType mType = UploadUtils.getMediaType(filename);
			
			HttpHeaders headers = new HttpHeaders();
			
			if(mType != null) {
				headers.setContentType(mType);
			}else {
				headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
				
				int idx = filename.indexOf("_") + 1;
				
				String oriName = filename.substring(idx);
				
				oriName = new String(oriName.getBytes("UTF-8"), "ISO-8859-1");
				
				headers.add("Content-Disposition", "attachmentfilename=\""+oriName+"\"");	
			}
			
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		} finally {
			if(in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return entity;
	}
	
	@Transactional
	@RequestMapping(value = "/qna/delete/{qno}", method = RequestMethod.POST)
	public String delete(@PathVariable("qno") int qno) {			
		
		qnauploadservice.delete(qno);
		
		qnaservice.delete(qno);		
		
		return "redirect:/qna/list";
	}
	
	@RequestMapping(value = "/qna/replies", method = RequestMethod.POST)
	public ResponseEntity<String> reply(QnAReplyDTO qnareplyDto) {
		ResponseEntity<String> entity = null;
		
		try {
			qnareplyservice.insert(qnareplyDto);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>("FAIL", HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	@RequestMapping(value = "/qna/{qno}/replyall", method = RequestMethod.GET)
	public ResponseEntity<List<QnAReplyDTO>> getReply(@PathVariable("qno") int qno) {
		ResponseEntity<List<QnAReplyDTO>> entity = null;
		
		try {
			List<QnAReplyDTO> list = qnareplyservice.getReply(qno);
			entity = new ResponseEntity<List<QnAReplyDTO>>(list, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<List<QnAReplyDTO>>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}

}
