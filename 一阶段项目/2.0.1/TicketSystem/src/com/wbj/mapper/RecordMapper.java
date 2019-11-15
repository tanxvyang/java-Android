package com.wbj.mapper;

import com.wbj.entity.Record;

import java.sql.ResultSet;

public class RecordMapper implements RowMapper<Record> {
    @Override
    public Record mapperObject(ResultSet rs) throws Exception {
        Record record = new Record();
        record.setRecordId(rs.getInt("record_id"));
        record.setUserId(rs.getInt("user_id"));
        record.setTicketId(rs.getInt("ticket_id"));
        record.setTrainNumber(rs.getString("train_number"));
        record.setBuyTime(rs.getString("buy_time"));
        record.setBuyState(rs.getString("buy_state"));

        return record;
    }
}
