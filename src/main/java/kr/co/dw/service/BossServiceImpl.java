package kr.co.dw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.dw.domain.BossDTO;
import kr.co.dw.repository.BossDAO;

@Service
public class BossServiceImpl implements BossService {
	
		@Autowired
		private BossDAO bDAO;

		@Override
		public void insert(BossDTO bDto) {
			// TODO Auto-generated method stub
			bDAO.insert(bDto);
			
		}

		@Override
		public List<BossDTO> list() {
			// TODO Auto-generated method stub
			return bDAO.list();
		}

		@Override
		public BossDTO read(String bossId) {
			// TODO Auto-generated method stub
			return bDAO.read(bossId);
		}

		@Override
		public BossDTO updateUI(String bossId) {
			// TODO Auto-generated method stub
			return bDAO.updateUI(bossId);
		}

		@Override
		public void update(BossDTO bDto) {
			// TODO Auto-generated method stub
			bDAO.update(bDto);
			
		}

		@Override
		public void delete(String bossId) {
			// TODO Auto-generated method stub
			bDAO.delete(bossId);
		}

		@Override
		public BossDTO login(BossDTO bDTO) {
			// TODO Auto-generated method stub
			return bDAO.login(bDTO);
		}
}
