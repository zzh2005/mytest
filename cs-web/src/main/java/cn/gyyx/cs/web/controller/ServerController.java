/**
 * 版权所有：北京光宇在线科技有限责任公司
 * 作者：钟志华
 * 联系方式：zhongzhihua@gyyx.cn
 * 创建时间： 2014/07/02 10:40
 * 版本号：v1.0
 * 本类主要用途描述：服务器控制器
 */
package cn.gyyx.cs.web.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.gyyx.cs.model.ServerInfo;
import cn.gyyx.cs.service.GameService;
import cn.gyyx.cs.service.ServerService;

@Controller
@RequestMapping("/server")
public class ServerController {

	private GameService gameService;

	public GameService getGameService() {
		return gameService;
	}

	@Autowired
	public void setGameService(GameService gameService) {
		this.gameService = gameService;
	}
	
	private ServerService serverService;

	public ServerService getServerService() {
		return serverService;
	}

	@Autowired
	public void setServerService(ServerService serverService) {
		this.serverService = serverService;
	}
	
	@RequestMapping("/index")
	public ModelAndView index(@RequestParam(required = false, defaultValue="0")int gameId
			, @RequestParam(required = false,defaultValue="0")int serverId) {
		
		Map<String,Object> context = new HashMap<String,Object>(); 
		
		context.put("gameId", gameId);
		context.put("serverId", serverId);
		context.put("servers", serverService.getServerList(gameId, serverId));

		return new ModelAndView("server/index",context);
	} 
	
	@RequestMapping("/delete")
	public ModelAndView delete(int gameId, int serverId) {

		serverService.RemoveServer(gameId, serverId);
		
		Map<String,Object> context = new HashMap<String,Object>(); 
		
		context.put("gameId", gameId);
		
		return new ModelAndView("redirect:/server/index.do");
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView edit(int gameId, int serverId) {
		
		ServerInfo serverInfo = serverService.getServerInfo(gameId, serverId);
		
		Map<String,Object> context = new HashMap<String,Object>(); 
		
		context.put("gameId", gameId);
		context.put("serverId", serverId);
		context.put("server", serverInfo);
		
		return new ModelAndView("server/edit",context);
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public ModelAndView edit(ServerInfo serverInfo) {
		
		serverService.ModifyServer(serverInfo);
		
		Map<String,Object> context = new HashMap<String,Object>(); 
		
		context.put("server", serverInfo);
		
		return new ModelAndView("redirect:/server/index.do");
	}
	
	@RequestMapping("/getServerList")    
	@ResponseBody
	public List<ServerInfo> getServerList(int gameId) {
		
		return serverService.getServerList(gameId);
	}

}
