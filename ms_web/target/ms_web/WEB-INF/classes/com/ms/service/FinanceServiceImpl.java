package com.ms.service;

import com.ms.dao.FinanceMapper;
import com.ms.dao.ReportMapper;
import com.ms.entity.Finance;
import com.ms.entity.FinanceExample;
import com.ms.entity.Report;
import com.ms.entity.ReportExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Dell on 2017/8/16.
 */
@Service
public class FinanceServiceImpl implements FinanceService {

    @Autowired
    FinanceMapper financeMapper;

    @Autowired
    ReportMapper reportMapper;

    @Override
    public List<Finance> selectFinance() {
        return financeMapper.selectByExample(new FinanceExample());
    }

    @Override
    public List<Report> selectReport() {
        return reportMapper.selectByExample(new ReportExample());
    }

}
