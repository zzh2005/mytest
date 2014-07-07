/**
 * 版权所有：北京光宇在线科技有限责任公司
 * 作者：钟志华
 * 联系方式：zhongzhihua@gyyx.cn
 * 创建时间： 2014/07/02 10:40
 * 版本号：v1.0
 * 本类主要用途描述：结果信息
 */
package cn.gyyx.cs.model;

/**
 * 结果信息
 */
public class Result {
	
	private boolean isSuccess;
	
	private String message;
	
	public boolean getIsSuccess() {
		return this.isSuccess;
	}
	
	public void setIsSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void SetMessage(String message) {
		this.message = message;
	}
}
