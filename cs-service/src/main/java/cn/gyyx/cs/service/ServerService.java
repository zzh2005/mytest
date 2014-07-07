/**
 * 版权所有：北京光宇在线科技有限责任公司
 * 作者：钟志华
 * 联系方式：zhongzhihua@gyyx.cn
 * 创建时间： 2014/07/02 10:40
 * 版本号：v1.0
 * 本类主要用途描述：服务器服务接口
 */
package cn.gyyx.cs.service;

import java.util.List;

import cn.gyyx.cs.model.Result;
import cn.gyyx.cs.model.ServerInfo;

/**
 * 服务器服务接口
 */
public interface ServerService {
	
	/**
	 * 获取某个游戏的服务器列表
	 * @param gameId 游戏编号
	 * @return 游戏列表
	 */
	List<ServerInfo> getServerList(int gameId);
	
	/**
	 * 获取某个游戏的服务器列表
	 * @param serverId 服务器编号
	 * @return 游戏列表
	 */
	List<ServerInfo> getServerList(int gameId, int serverId);
	
	/**
	 * 获取某个游戏的服务器列表
	 * @param serverId 服务器编号
	 * @return 游戏列表
	 */
	ServerInfo getServerInfo(int gameId, int serverId);
	
	/**
	 * 修改服务器
	 * @param serverInfo 服务器信息
	 * @return 是否成功
	 */
	Result ModifyServer(ServerInfo serverInfo);
	
	/**
	 * 删除某个服务器
	 * @param serverId 服务器编号
	 * @return 是否成功
	 */
	void RemoveServer(int gameId, int serverId);
}
