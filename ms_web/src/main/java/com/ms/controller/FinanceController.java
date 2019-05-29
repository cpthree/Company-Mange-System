package com.ms.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ms.entity.Finance;
import com.ms.entity.Report;
import com.ms.service.FinanceService;
import com.ms.utils.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Dell on 2017/8/16.
 */
@Controller
@RequestMapping("/")
public class FinanceController {

    @Autowired
    FinanceService financeService;


    @RequestMapping("/finance_manager")
    public String finance_manager(Model model, @RequestParam(value="pn",defaultValue="1") Integer pn){
        //升级为分页查询
        PageHelper.startPage(pn, 3);
        List<Finance> finance= financeService.selectFinance();
        //使用PageInfo包装查询页面，封装了详细的分页信息.第二个参数表示连续显示的页数
        PageInfo page = new PageInfo(finance,3);
        model.addAttribute("pageInfo", page);
        return "finance_manager";
    }

    @RequestMapping("/finance_report")
    public String finance_report(Model model, @RequestParam(value="pn",defaultValue="1") Integer pn){
        //升级为分页查询
        PageHelper.startPage(pn, 3);
        List<Report> report= financeService.selectReport();
        //使用PageInfo包装查询页面，封装了详细的分页信息.第二个参数表示连续显示的页数
        PageInfo page = new PageInfo(report,3);
        model.addAttribute("pageInfo", page);
        return "finance_report";
    }

    /**
     * 导出财务报表
     * @param response
     */
    @RequestMapping(value = "export_report",method = RequestMethod.GET)
    public void excelProductList(HttpServletResponse response) {
        try {
            List<Report> report = financeService.selectReport();
            ExcelUtil.exportExcel(report, "财务报表", "财务报表", response, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 导入报表
     */
//    @RequestMapping(value = "import_report",method = RequestMethod.POST)
//    @ResponseBody
//    public String importProductExcel(@RequestParam(value = "excel") MultipartFile excel) {
//        try {
//            ExcelUtil<ProductExcel> util = new ExcelUtil<ProductExcel>(ProductPriceExcel.class);// 创建excel工具类
//            List<ProductExcel> list = util.importExcel(excel.getOriginalFilename(),"财务报表", excel.getInputStream());// 导出
//            if(list.size() > 0){
//                if(productService.batchUpdateImportProduct(list,user) > 0){
//                    return "success";
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return "error";
//    }



}
