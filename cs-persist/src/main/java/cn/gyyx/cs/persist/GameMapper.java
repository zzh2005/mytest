/**
 * 版权所有：北京光宇在线科技有限责任公司
 * 作者：钟志华
 * 联系方式：zhongzhihua@gyyx.cn
 * 创建时间： 2014/07/02 10:40
 * 版本号：v1.0
 * 本类主要用途描述：游戏数据访问接口
 */
package cn.gyyx.cs.persist;

import java.util.List;
import cn.gyyx.cs.model.GameInfo;

/**
 * 游戏数据访问接口
 */
public interface GameMapper 
{
	 /**
	  * 获取所有游戏
	  * @return 游戏列表
	  */
     List<GameInfo> getAllGame();
}
