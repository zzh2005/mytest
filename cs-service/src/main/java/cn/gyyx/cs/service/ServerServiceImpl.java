/**
 * 版权所有：北京光宇在线科技有限责任公司
 * 作者：钟志华
 * 联系方式：zhongzhihua@gyyx.cn
 * 创建时间： 2014/07/02 10:40
 * 版本号：v1.0
 * 本类主要用途描述：服务器服务实现
 */
package cn.gyyx.cs.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ContextLoader;

import cn.gyyx.cs.model.GameCategory;
import cn.gyyx.cs.model.GameInfo;
import cn.gyyx.cs.model.Result;
import cn.gyyx.cs.model.ServerInfo;
import cn.gyyx.cs.persist.GameMapper;
import cn.gyyx.cs.persist.ServerMapper;

/**
 * 服务器服务实现
 */
@Service("serverService")
public class ServerServiceImpl implements ServerService {
	
	private GameMapper gameMapper;
	
	public GameMapper getGameMapper() {
		return gameMapper;
	}

	@Autowired
	public void setGameMapper(GameMapper gameMapper) {
		this.gameMapper = gameMapper;
	}

	@Override
	public List<ServerInfo> getServerList(int gameId) {
		
		String beanName = GameCategory.values()[gameId-1].name() + "ServerMapper";
		
		ServerMapper mapper = (ServerMapper)ContextLoader.getCurrentWebApplicationContext().getBean(beanName);
		
		return mapper.getServerList(gameId);
	}
	
	@Override
	public List<ServerInfo> getServerList(int gameId, int serverId) {
		
		List<ServerInfo> serverList = new ArrayList<ServerInfo>();
		
		if(gameId == 0) {
			
			List<GameInfo> gameList = gameMapper.getAllGame();
			
			for(GameInfo gameInfo : gameList) {
				String beanName = GameCategory.values()[gameInfo.getCode()-1].name() + "ServerMapper";
				
				ServerMapper mapper = (ServerMapper)ContextLoader.getCurrentWebApplicationContext().getBean(beanName);
				
				serverList.addAll(mapper.getServerList(gameInfo.getCode()));
			}
			
		} else {
			String beanName = GameCategory.values()[gameId-1].name() + "ServerMapper";
			
			ServerMapper mapper = (ServerMapper)ContextLoader.getCurrentWebApplicationContext().getBean(beanName);
			
			if (serverId == 0) {
				serverList.addAll(mapper.getServerList(gameId));
			} else {
				serverList.add(mapper.getServerInfoByCode(serverId));
			}
		}
		
		return serverList;
	}
	
	@Override
	public ServerInfo getServerInfo(int gameId, int serverId) {
		
		String beanName = GameCategory.values()[gameId-1].name() + "ServerMapper";
		
		ServerMapper mapper = (ServerMapper)ContextLoader.getCurrentWebApplicationContext().getBean(beanName);
		
		return mapper.getServerInfoByCode(serverId);
	}
	
	
	@Override
	public Result ModifyServer(ServerInfo serverInfo) {
		
		Result result = new Result();
		
		result.setIsSuccess(false);
		
		String beanName = GameCategory.values()[serverInfo.getGameId()-1].name() + "ServerMapper";
		
		ServerMapper mapper = (ServerMapper)ContextLoader.getCurrentWebApplicationContext().getBean(beanName);
		
		ServerInfo oriServer = mapper.getServerInfoByCode(serverInfo.getCode());
		
		if(oriServer.getName().equals(serverInfo.getName())
				&& oriServer.getCode() == serverInfo.getCode()) {
			result.SetMessage("服务器名称不能重复");
			return result;
		}
		
		mapper.updateServer(serverInfo);
		
		result.setIsSuccess(true);
		return result;
	}
	
	@Override
	public void RemoveServer(int gameId, int serverId) {
		
		String beanName = GameCategory.values()[gameId-1].name() + "ServerMapper";
		
		ServerMapper mapper = (ServerMapper)ContextLoader.getCurrentWebApplicationContext().getBean(beanName);
		
		mapper.deleteServer(serverId);
		
	}
}
