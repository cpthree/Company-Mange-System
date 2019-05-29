package com.ms.service;

import com.ms.entity.Finance;
import com.ms.entity.Report;

import java.util.List;

/**
 * Created by Dell on 2017/8/16.
 */
public interface FinanceService {
    List<Finance> selectFinance();
    List<Report> selectReport();
}
