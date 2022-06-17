package com.demo.service.impl;

import com.demo.dto.ACompareLogDTO;
import com.demo.entity.ACompareLog;
import com.demo.mapper.ACompareLogMapper;
import com.demo.service.ACompareLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ACompareLogServiceImpl implements ACompareLogService {

    @Autowired
    ACompareLogMapper aCompareLogMapper;
    @Override
    public int save(ACompareLogDTO aCompareLogDTO) {
        ACompareLog aCompareLog = new ACompareLog();
        convertToACompareLog(aCompareLogDTO);
        int insert = aCompareLogMapper.insert(aCompareLog);
        return insert;
    }

    public static ACompareLog convertToACompareLog(ACompareLogDTO item) {
        if (item == null) {
            return null;
        }
        ACompareLog result = new ACompareLog();
        result.setId(item.getId());
        result.setCreateDate(item.getCreateDate());
        result.setMobile(item.getMobile());
        result.setIsSend(item.getIsSend());
        result.setIsDel(item.getIsDel());
        result.setMessageContent(item.getMessageContent());
        result.setOatasks(item.getOatasks());
        result.setMetasks(item.getMetasks());
        return result;
    }
}
