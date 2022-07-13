package kr.co.dw.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.dw.domain.PageTO;
import kr.co.dw.domain.UserDTO;

@Repository
public class UserDAOImpl implements UserDAO {
   
   @Autowired
   private SqlSession sqlSession;      
   
   private final String NAMESPACE = "kr.co.dw.user";

   @Override
   public void insert(UserDTO uDto) {
      // TODO Auto-generated method stub
      
      sqlSession.insert(NAMESPACE+".insert", uDto);
      
   }

   @Override
   public List<UserDTO> list() {
      // TODO Auto-generated method stub
      
      return sqlSession.selectList(NAMESPACE+".list");
   }

   @Override
   public UserDTO read(String userId) {
      // TODO Auto-generated method stub
      return sqlSession.selectOne(NAMESPACE + ".read", userId);
   }

   @Override
   public UserDTO updateUI(String userId) {
      // TODO Auto-generated method stub
      return sqlSession.selectOne(NAMESPACE + ".updateUI", userId);
   }

   @Override
   public void update(UserDTO uDto) {
      // TODO Auto-generated method stub
      
      sqlSession.update(NAMESPACE+".update", uDto);
   }

   @Override
   public void delete(String userId) {
      // TODO Auto-generated method stub
      sqlSession.delete(NAMESPACE + ".delete", userId);
      
   }

   @Override
   public int checkId(String userId) {
      // TODO Auto-generated method stub
      return sqlSession.selectOne(NAMESPACE+".checkId", userId);
   }

   @Override
   public int checkNk(String uNickname) {
      // TODO Auto-generated method stub
      return sqlSession.selectOne(NAMESPACE+".checkNk", uNickname);
   }

   @Override
   public int checkEmail(String uEmail) {
      // TODO Auto-generated method stub
      return sqlSession.selectOne(NAMESPACE+".checkEmail", uEmail);
   }
   
   
   
   @Override
   public int checkPhone(String uPhone) {
   	// TODO Auto-generated method stub
   	return sqlSession.selectOne(NAMESPACE+".checkPhone", uPhone);
   }


   @Override
   public UserDTO login(UserDTO uDTO) {
      // TODO Auto-generated method stub
      return sqlSession.selectOne(NAMESPACE+".login", uDTO);
   }

   @Override
   public UserDTO findid(UserDTO uDTO) {
      // TODO Auto-generated method stub
      return sqlSession.selectOne(NAMESPACE+".findid", uDTO);
   }

   @Override
   public UserDTO readUser(String userId) {
      // TODO Auto-generated method stub
      return sqlSession.selectOne(NAMESPACE + ".readUser", userId);
   }

  @Override
   public void updatePw(UserDTO uDTO) {
     // TODO Auto-generated method stub

      
      sqlSession.update(NAMESPACE+".updatePw", uDTO);
      
   }


   @Override
   public Integer getAmountUser() {
      // TODO Auto-generated method stub
      return sqlSession.selectOne(NAMESPACE+".getAmountUser");
   }

   @Override
   public List<UserDTO> list(PageTO<UserDTO> pt) {
      // TODO Auto-generated method stub
      RowBounds rb = new RowBounds(pt.getStartNum()-1, pt.getPerPage());
      
      return sqlSession.selectList(NAMESPACE+".list", null, rb);
   }
   
   @Override
   public List<UserDTO> search(PageTO<UserDTO> pt, String criteria, String keyword) {
      // TODO Auto-generated method stub
      Map<String, String> map = new HashMap<String, String>();
      map.put("criteria", criteria);
      map.put("keyword", keyword);
      
      
      RowBounds rb = new RowBounds(pt.getStartNum()-1, pt.getPerPage());
      
      return sqlSession.selectList(NAMESPACE+".search", map, rb);
      
      
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
   public void modifyPw(UserDTO uDto) {
      // TODO Auto-generated method stub
      
      sqlSession.update(NAMESPACE+".modifyPw", uDto);
      
   }

@Override
public void insertNV(UserDTO uDTO) {
	// TODO Auto-generated method stub
	sqlSession.insert(NAMESPACE+".insertNV", uDTO);
}

@Override
public UserDTO naverChk(UserDTO uDTO) {
	// TODO Auto-generated method stub
	return sqlSession.selectOne(NAMESPACE+".naverChk", uDTO);
}

@Override
public UserDTO nvlogin(UserDTO uDTO) {
	// TODO Auto-generated method stub
	return sqlSession.selectOne(NAMESPACE+".nvlogin", uDTO);
}

@Override
public UserDTO getUserInfo(String userId) {
	// TODO Auto-generated method stub
	return sqlSession.selectOne(NAMESPACE+".getUserInfo", userId);
}



	
}