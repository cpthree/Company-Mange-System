package com.ms.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ms.entity.Employee;
import com.ms.entity.Project;
import com.ms.entity.ProjectAttachment;
import com.ms.service.ProjectService;
import com.ms.utils.ResponseJson;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by Dell on 2017/8/8.
 */
@Controller
@RequestMapping("/")
public class ProjectController {

    @Value("${FilePosition}")
    String filePosition;

    @Autowired
    ProjectService projectService;

    @RequestMapping("/project_manager")
    public String project_manager(Model model,@RequestParam(value="pn",defaultValue="1") Integer pn){

        //升级为分页查询
        PageHelper.startPage(pn, 5);
        List<Project> project= projectService.selectProject();
        //使用PageInfo包装查询页面，封装了详细的分页信息.第二个参数表示连续显示的页数
        PageInfo page = new PageInfo(project,5);
        model.addAttribute("pageInfo", page);
        return "project_manager";
    }

    @RequestMapping("addProject")
    public String addProject(){
        return "project_add";
    }


    @RequestMapping("saveProjectAdd")
    public String saveProjectAdd(String projectName, String location, Long landArea, Long buildArea, Integer floor, String eiaPeople, String permit, Integer auditFlag, Date successDate){
        projectService.addProject(projectName,location,landArea,buildArea,floor,eiaPeople,permit,auditFlag,successDate);
        return "forward:/project_manager";
    }

    @RequestMapping("editProject")
    public String editProject(Model model,Long id){
        Project project= projectService.selectByPrimaryKey(id);
        model.addAttribute("user", project);
        return "project_edit";
    }

    @RequestMapping("saveProjectEdit")
    public String saveProjectEdit(Long id,String projectName, String location, Long landArea, Long buildArea, Integer floor, String eiaPeople, String permit, Integer auditFlag, Date successDate){
        projectService.editProject(id,projectName,location,landArea,buildArea,floor,eiaPeople,permit,auditFlag,successDate);
        return "forward:/project_manager";
    }


    @RequestMapping("deleteProject")
    @ResponseBody
    public String deleteProject(Long id){
        projectService.deleteProject(id);
        return "success";
    }

    /**
     * 文件上传
     *
     * @param request
     * @param articleid
     * @return
     */
    @RequestMapping("/projectUpload")
    @ResponseBody
    public ResponseJson upload(HttpServletRequest request, @RequestParam("project_id_class") Long articleid) {
        projectService.upload(articleid, request,filePosition);
        Map<String, Object> map = new HashMap<String, Object>();
        List<ProjectAttachment> list = projectService.getAttachsByProjectId(articleid);
        map.put("build_project_attachList", list);
        ResponseJson json = new ResponseJson();
        json.setDatas(map);
        json.setCode(1l);
        return json;
    }

    /**
     * 文件上传列表
     */
    @RequestMapping("/attachment_list")
    @ResponseBody
    public ResponseJson attachment_list(Long project_id) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<ProjectAttachment> list = projectService.getAttachsByProjectId(project_id);
        map.put("build_project_attachList", list);
        ResponseJson json = new ResponseJson();
        json.setDatas(map);
        json.setCode(1l);
        return json;
    }

    /**
     * 删除附件
     *
     * action: delBuildAttachs
     */
    @RequestMapping(value = "/delBuildAttachs", method = RequestMethod.POST)
    @ResponseBody
    public ResponseJson delBuildAttachs(@RequestParam("idList[]") Long[] idList) {
        System.out.println("delBuildAttachs");
        ProjectAttachment attach = projectService.selectAttachById(idList[0]);

        projectService.delBuild_project_attachs(idList);

        Map<String, Object> map = new HashMap<String, Object>();
        List<ProjectAttachment> list = projectService.getAttachsByProjectId(attach.getProjectId());
        map.put("build_project_attachList", list);
        ResponseJson json = new ResponseJson();
        json.setDatas(map);
        json.setCode(1l);
        return json;
    }

    /**
     * 下载
     * @param attachid
     * @return
     * @throws Exception
     */
    @RequestMapping("/builddownload")
    public ResponseEntity<byte[]> download(@RequestParam("project_id_class") Long attachid) throws Exception{
        ProjectAttachment attach = projectService.selectAttachById(attachid);
        File file = new File(attach.getFilePath());
        HttpHeaders headers = new HttpHeaders();
        String filename = new String(attach.getFileName().getBytes("UTF-8"),"iso-8859-1");
        headers.setContentDispositionFormData("attachment", filename);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),headers,HttpStatus.CREATED);
    }


}







