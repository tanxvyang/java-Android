package util;

import java.sql.ResultSet;

/**
 * 行映射
 * @author 李恒
 *
 */
public interface RowMapper {
	/**
	 * 将结果集中一行数据映射成一个对象
	 * @param rs 结果集合
	 * @return 一个对象
	 * @throws Exception 所有异常交给调用者处理
	 */
	public Object mapRow(ResultSet rs)throws Exception;
}
