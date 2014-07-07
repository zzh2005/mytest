/**
 * 版权所有：北京光宇在线科技有限责任公司
 * 作者：钟志华
 * 联系方式：zhongzhihua@gyyx.cn
 * 创建时间： 2014/07/02 10:40
 * 版本号：v1.0
 * 本类主要用途描述：游戏服务实现
 */
package cn.gyyx.cs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.gyyx.cs.model.GameInfo;
import cn.gyyx.cs.persist.GameMapper;

/**
 * 游戏服务实现
 */
@Service("gameService")
public class GameServiceImpl implements GameService {
	
	private GameMapper gameMapper;
	
	public GameMapper getGameMapper() {
		return gameMapper;
	}

	@Autowired
	public void setGameMapper(GameMapper gameMapper) {
		this.gameMapper = gameMapper;
	}
	
	
	@Override
	public List<GameInfo> getAllGame() {
		
		return this.gameMapper.getAllGame();
	}
	
}
