package kr.co.dw.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.dw.domain.AdminDTO;
import kr.co.dw.domain.Criteria;
import kr.co.dw.domain.OrderDTO;

@Repository
public class AdminDAOImpl implements AdminDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE = "kr.co.dw.admin";

	@Override
	public void insert(AdminDTO aDto) {
		// TODO Auto-generated method stub
		sqlSession.insert(NAMESPACE+".insert", aDto);
		
	}

	@Override
	public List<AdminDTO> list() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESPACE+".list");
	}

	@Override
	public AdminDTO read(String adminId) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE+".read", adminId);
	}

	@Override
	public AdminDTO updateUI(String adminId) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE+".updateUI", adminId);
	}

	@Override
	public void delete(String adminId) {
		// TODO Auto-generated method stub
		sqlSession.delete(NAMESPACE + ".delete", adminId);
		
	}

	@Override
	public void update(AdminDTO aDto) {
		// TODO Auto-generated method stub
		sqlSession.update(NAMESPACE+".update", aDto);
		
	}

	@Override
	public AdminDTO login(AdminDTO aDTO) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE+".login", aDTO);
	}

	@Override
	public List<OrderDTO> getOrderList(Criteria cri) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESPACE+".getOrderList", cri);
	}

	@Override
	public int getOrderTotal(Criteria cri) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE+".getOrderTotal", cri);
	}
}
