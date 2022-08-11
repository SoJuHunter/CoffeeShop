package kr.co.dw.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.dw.domain.ProductDTO;

@Repository
public class ProductDAOImpl implements ProductDAO {

	@Autowired 
	private	SqlSession sqlSession;
	
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
	public void delete(int pno) {
		// TODO Auto-generated method stub
		sqlSession.delete(NAMESPACE+".delete", pno);
	}

}
