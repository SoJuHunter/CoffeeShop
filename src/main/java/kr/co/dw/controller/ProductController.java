package kr.co.dw.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.annotation.Pointcut;
import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.co.dw.utils.UploadUtils;
import kr.co.dw.domain.BossDTO;
import kr.co.dw.domain.PageTO;
import kr.co.dw.domain.ProductDTO;
import kr.co.dw.domain.UserDTO;
import kr.co.dw.service.ProductService;
import kr.co.dw.service.ProUploadService;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService pService;

	private String uploadPath = "C:" + File.separator + "coffeeupload";

	@Inject
	private ProUploadService uService;

	@RequestMapping(value = "/sales", method = RequestMethod.GET)
	public String sales() {
		return "/product/sales";
	}

	
	 
	  @RequestMapping(value="/stock", method = RequestMethod.GET) public String
	  stock(Integer curpage, Model model) 
	  
	  { if(curpage == null) {
		  curpage = 1;
	  
	  }
	  
	  
	  
	  
	 
	  PageTO<ProductDTO> pt = pService.stocklist(curpage);
	  
	  for (int i = 0; i < pt.getList().size(); i++) { int pno =
	  pt.getList().get(i).getPno();
	  
	  List<String> filenameList = uService.list(pno);
	  pt.getList().get(i).setFilenameList(filenameList); }
	  
	  model.addAttribute("stocklist", pt.getList()); model.addAttribute("pt", pt);
	  
	  
	  
	  return "/product/stock"; }
	  
	 

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String starsample() {

		return "/product/test";
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public void search(Integer curpage, String criteria, String keyword, Model model) {
		if (curpage == null) {
			curpage = 1;

		}

		PageTO<ProductDTO> pt = pService.search(curpage, criteria, keyword);

		for (int i = 0; i < pt.getList().size(); i++) {
			int pno = pt.getList().get(i).getPno();

			List<String> filenameList = uService.list(pno);
			pt.getList().get(i).setFilenameList(filenameList);
		}
		model.addAttribute("list", pt.getList());
		model.addAttribute("pt", pt);
		model.addAttribute("criteria", criteria);
		model.addAttribute("keyword", keyword);

	}

	@RequestMapping(value = "/{pno}/uploadall", method = RequestMethod.GET)
	public ResponseEntity<List<String>> getAllUpload(@PathVariable("pno") int pno) {
		ResponseEntity<List<String>> entity = null;

		try {
			List<String> list = uService.getAllUpload(pno);
			entity = new ResponseEntity<List<String>>(list, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			entity = new ResponseEntity<List<String>>(HttpStatus.BAD_REQUEST);

		}

		return entity;

	}

	@RequestMapping(value = "/category", method = RequestMethod.GET)
	public String category() {

		return "/product/category";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ResponseEntity<String> update(MultipartHttpServletRequest request) {
		ResponseEntity<String> entity = null;
		try {
			String sPno = request.getParameter("pno");
			int pno = Integer.parseInt(sPno);
			String pName = request.getParameter("pName");
			String pContent = request.getParameter("pContent");
			int pPrice = Integer.parseInt(request.getParameter("pPrice"));
			int pStock = Integer.parseInt(request.getParameter("pStock"));
			String pCategory = request.getParameter("pCategory");
			String pSize = request.getParameter("pSize");
			String pOrigin = request.getParameter("pOrigin");

			String deletFilenames = request.getParameter("deletFilenameArr");

			String[] arr = deletFilenames.split(",");
			Map<String, MultipartFile> map = request.getFileMap();
			List<String> fileList = new ArrayList<String>();

			Set<String> set = map.keySet();

			Iterator<String> it = set.iterator();
			while (it.hasNext()) {
				String key = it.next();

				MultipartFile file = map.get(key);
				String orgFilename = file.getOriginalFilename();
				try {
					String uploadedFilename = UploadUtils.uploadFile(uploadPath, orgFilename, file.getBytes());
					fileList.add(uploadedFilename);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			ProductDTO pDto = new ProductDTO(pno, pName, pContent, pPrice, pStock, pCategory, pSize, pOrigin, null);

			pService.update(pDto, arr, fileList);

			for (int i = 0; i < arr.length; i++) {
				String deletFilename = arr[i];
				UploadUtils.deleteFile(uploadPath, deletFilename);
			}

			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>("FAIL", HttpStatus.BAD_REQUEST);
		}

		return entity;
	}

	@RequestMapping(value = "/update/{pno}", method = RequestMethod.GET)
	public String updateUI(@PathVariable("pno") int pno, Model model, HttpSession session) {

		BossDTO bossLogin = (BossDTO) session.getAttribute("bossLogin");
		if (bossLogin == null) {
			return "redirect:/";
		}

		ProductDTO pDto = pService.updateUI(pno);
		model.addAttribute("pDto", pDto);
		return "/product/update";
	}

	@RequestMapping(value = "/delete/{pno}", method = RequestMethod.POST)
	public String delete(@PathVariable("pno") int pno, String pCategory) throws Exception {

		List<String> list = uService.getAllUpload(pno);

		pService.delete(pno);

		for (int i = 0; i < list.size(); i++) {
			String filename = list.get(i);
			UploadUtils.deleteFile(uploadPath, filename);
		}

		return "redirect:/product/list/" + URLEncoder.encode(pCategory, "UTF-8");

	}

	@RequestMapping(value = "/list/{category}", method = RequestMethod.GET)
	public String listbean(Integer curpage, Model model, @PathVariable("category") String category) {

		if (curpage == null) {
			curpage = 1;

		}

		PageTO<ProductDTO> pt = pService.list(curpage, category);

		for (int i = 0; i < pt.getList().size(); i++) {
			int pno = pt.getList().get(i).getPno();

			List<String> filenameList = uService.list(pno);
			pt.getList().get(i).setFilenameList(filenameList);

		}

		model.addAttribute("list", pt.getList());
		model.addAttribute("pt", pt);

		return "/product/" + category;

	}

	@RequestMapping(value = "/read/{pno}", method = RequestMethod.GET)
	public String read(@PathVariable("pno") int pno, Model model, HttpServletRequest request) {

		ProductDTO pDto = pService.read(pno);

		model.addAttribute("pDto", pDto);

		return "/product/read";

	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ResponseEntity<String> insert(MultipartHttpServletRequest request) {

		ResponseEntity<String> entity = null;

		String pName = request.getParameter("pName");

		String pContent = request.getParameter("pContent");

		int pPrice = Integer.parseInt(request.getParameter("pPrice"));

		int pStock = Integer.parseInt(request.getParameter("pStock"));

		String pCategory = request.getParameter("pCategory");

		String pSize = request.getParameter("pSize");

		String pOrigin = request.getParameter("pOrigin");

		ProductDTO pDto = new ProductDTO(0, pName, pContent, pPrice, pStock, pCategory, pSize, pOrigin);

		try {

			Map<String, MultipartFile> map = request.getFileMap();
			Set<String> set = map.keySet();
			Iterator<String> it = set.iterator();

			List<String> filenamelist = new ArrayList<String>();

			while (it.hasNext()) {
				String key = it.next();
				MultipartFile file = map.get(key);

				String uploadedFilename = UploadUtils.uploadFile(uploadPath, file.getOriginalFilename(),
						file.getBytes());

				filenamelist.add(uploadedFilename);

			}

			pDto.setFilenameList(filenamelist);

			pService.insert(pDto);

			entity = new ResponseEntity<String>(pDto.getPno() + "", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(-1 + "", HttpStatus.BAD_REQUEST);
		}

		return entity;

	}

	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insertUI(HttpSession session) {

		BossDTO bossLogin = (BossDTO) session.getAttribute("bossLogin");
		if (bossLogin == null) {
			return "redirect:/";
		}

		return "/product/insert";

	}

}
