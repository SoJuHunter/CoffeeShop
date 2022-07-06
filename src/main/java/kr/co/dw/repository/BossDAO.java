package kr.co.dw.repository;

import java.util.List;

import kr.co.dw.domain.BossDTO;

public interface BossDAO {

	void insert(BossDTO bDto);

	List<BossDTO> list();

	BossDTO read(String bossId);

	BossDTO updateUI(String bossId);

	void update(BossDTO bDto);

	void delete(String bossId);

	BossDTO login(BossDTO bDTO);

}
