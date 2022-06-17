package com.demo.service.impl;

import com.demo.dto.FtDTO;
import com.demo.entity.FtEntity;
import com.demo.mapper.FtEntityMapper;
import com.demo.service.FtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class FtServiceImpl implements FtService {
    @Autowired
    FtEntityMapper ftEntityMapper;

    @Override
    public int save(FtDTO FtDTO) {
        FtEntity ftEntity = convertToFtEntity(FtDTO);
        int insert = ftEntityMapper.insert(ftEntity);
        return insert;
    }

    @Override
    public int delete(String id) {
        ftEntityMapper.deleteByPrimaryKey(id);
        return 0;
    }

    public static FtEntity convertToFtEntity(FtDTO item) {

        FtEntity ftEntity = new FtEntity();
        ftEntity.setId(item.getId());
        ftEntity.setCreateDate(item.getCreateDate());
        ftEntity.setDelFlag(item.getDelFlag());
        ftEntity.setRemarks(item.getRemarks());
        ftEntity.setUpdateDate(item.getUpdateDate());
        ftEntity.setCreateBy(item.getCreateBy());
        ftEntity.setUpdateBy(item.getUpdateBy());
        ftEntity.setIsOpen(item.getIsOpen());
        ftEntity.setPreTaskId(item.getPreTaskId());
        ftEntity.setState(item.getState());
        ftEntity.setExampleId(item.getExampleId());
        ftEntity.setInstanceId(item.getInstanceId());
        ftEntity.setTaskDefineId(item.getTaskDefineId());
        ftEntity.setThisDealManId(item.getThisDealManId());
        ftEntity.setIsDel(item.getIsDel());
        ftEntity.setAddSignTask(item.getAddSignTask());
        ftEntity.setTimeOut(item.getTimeOut());
        ftEntity.setUrge(item.getUrge());
        ftEntity.setExpireTime(item.getExpireTime());
        ftEntity.setUrgeNum(item.getUrgeNum());
        ftEntity.setTaskName(item.getTaskName());

        return ftEntity;
    }
}
