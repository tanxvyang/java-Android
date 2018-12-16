package util;

import java.sql.ResultSet;

/**
 * 结果集提取器
 * @author 李恒
 *
 */
public interface ResultSetExtractor {
	/**
	 * 提取数据
	 * @param rs 结果集
	 * @return 对结果集进行封装的数据
	 * @throws Exception 所有异常交给调用者处理
	 */
	public Object extractData(ResultSet rs)throws Exception;
}
