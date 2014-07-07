/**
 * 版权所有：北京光宇在线科技有限责任公司
 * 作者：钟志华
 * 联系方式：zhongzhihua@gyyx.cn
 * 创建时间： 2014/07/02 10:40
 * 版本号：v1.0
 * 本类主要用途描述：游戏服务器实体类
 */
package cn.gyyx.cs.model;

/**
 * 服务器信息
 */
public class ServerInfo {
	
	/**
	 * 服务器编号
	 */
	private int code;
	
	public int getCode() {
		return code;
	}
	
	public void setCode(int code) {
		this.code = code;
	}
	
	/**
	 * 游戏编号
	 */
	private int gameId;
	
	public int getGameId() {
		return gameId;
	}
	
	public void setGameId(int gameId) {
		this.gameId = gameId;
	}
	
	
	/**
	 * 服务器名称
	 */
	private String name;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 服务器名称
	 */
	private GameInfo game;
	
	public GameInfo getGame() {
		return game;
	}
	
	public void setGame(GameInfo game) {
		this.game = game;
	}
}
