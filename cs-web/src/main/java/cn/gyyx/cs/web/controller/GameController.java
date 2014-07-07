/**
 * 版权所有：北京光宇在线科技有限责任公司
 * 作者：钟志华
 * 联系方式：zhongzhihua@gyyx.cn
 * 创建时间： 2014/07/02 10:40
 * 版本号：v1.0
 * 本类主要用途描述：游戏控制器
 */
package cn.gyyx.cs.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.gyyx.cs.model.GameInfo;
import cn.gyyx.cs.service.GameService;

@Controller
@RequestMapping("/game")
public class GameController {
	private GameService gameService;

	public GameService getGameService() {
		return gameService;
	}

	@Autowired
	public void setGameService(GameService gameService) {
		this.gameService = gameService;
	}
	
	@RequestMapping("/getAllGame")    
	@ResponseBody
	public List<GameInfo> getAllGame() {

		return gameService.getAllGame();
	}
}
