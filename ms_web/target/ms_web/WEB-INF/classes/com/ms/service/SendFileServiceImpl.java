package com.ms.service;

import com.ms.dao.SendfileMapper;
import com.ms.entity.Sendfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Dell on 2017/8/8.
 */
@Service
public class SendFileServiceImpl implements SendFileService{

    @Autowired
    SendfileMapper sendfileMapper;

    @Override
    public List<Sendfile> selectSendfile() {
        return sendfileMapper.selectSendfile();
    }
}
