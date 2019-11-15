package com.wbj.mapper;

import java.sql.ResultSet;

import com.wbj.entity.Record;

public class TwoTabaleMapper  implements RowMapper<Record> {

	@Override
	public Record mapperObject(ResultSet rs) throws Exception {
		  Record record = new Record();
	        record.setRecordId(rs.getInt("r.record_id"));
	        record.setTicketId(rs.getInt("t.ticket_id"));
	        record.setBuyState(rs.getString("r.buy_state"));

	        return record;
	}

}
