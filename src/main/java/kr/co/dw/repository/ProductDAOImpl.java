package kr.co.dw.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import kr.co.dw.domain.PageTO;
import kr.co.dw.domain.ProductDTO;

@Repository
public class ProductDAOImpl implements ProductDAO {
	
	@Autowired 
	private SqlSession sqlSession;
	
	private final String NAMESPACE = "kr.co.dw.product";

	@Override
	public void insert(ProductDTO pDto) {
		// TODO Auto-generated method stub
		sqlSession.insert(NAMESPACE+".insert", pDto);
		
	}

	@Override
	public List<ProductDTO> list() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESPACE+".list");
	}

	@Override
	public ProductDTO read(int pno) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE+".read", pno);
	}

	@Override
	public void delete(int pno) {
		// TODO Auto-generated method stub
		sqlSession.delete(NAMESPACE+".delete", pno);
	}

	@Override
	public ProductDTO updateUI(int pno) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE + ".updateUI", pno);
		
	}

	@Override
	public void update(ProductDTO pDto) {
		// TODO Auto-generated method stub
		sqlSession.update(NAMESPACE + ".update", pDto);
		
	}

	
	@Override
	public List<ProductDTO> list(PageTO<ProductDTO> pt, String category) {
		// TODO Auto-generated method stub
		
		RowBounds rb = new RowBounds(pt.getStartNum()-1, pt.getPerPage());
		return sqlSession.selectList(NAMESPACE+".list", category, rb);
	}

	@Override
	public Integer getAmountProduct(String category) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE+".getAmountProduct", category );
	}

	@Override
	public Integer getAmountSearch(String criteria, String keyword) {
		// TODO Auto-generated method stub
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("criteria", criteria);
		map.put("keyword", keyword);
		
		return sqlSession.selectOne(NAMESPACE+".getAmountSearch", map);
		
		
	}

	@Override
	public List<ProductDTO> search(PageTO<ProductDTO> pt, String criteria, String keyword) {
		// TODO Auto-generated method stub
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("criteria", criteria);
		map.put("keyword", keyword);
		
		RowBounds rb = new RowBounds(pt.getStartNum() - 1, pt.getPerPage());
		
		
		
		return sqlSession.selectList(NAMESPACE+".search", map, rb);
	}

	@Override
	public ProductDTO getProductStock(int pno) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE+".getProductStock", pno);
	}
	
	@Override
	public List<ProductDTO> stocklist(PageTO<ProductDTO> pt) {
		// TODO Auto-generated method stub
		
		RowBounds rb = new RowBounds(pt.getStartNum() - 1, pt.getPerPage());
		return sqlSession.selectList(NAMESPACE+".stocklist", pt, rb);
	}

	@Override
	public Integer getAmountStock() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE+".getAmountStock");
	}


	



	


	

}
