package com.ms.service;

import com.ms.dao.ProjectAttachmentMapper;
import com.ms.dao.ProjectMapper;
import com.ms.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Dell on 2017/8/8.
 */
@Service
public class ProjectServiceImpl implements ProjectService{

    @Autowired
    ProjectMapper projectMapper;

    @Autowired
    ProjectAttachmentMapper projectAttachmentMapper;

    @Override
    public List<Project> selectProject() {
        return projectMapper.selectByExample(new ProjectExample());
    }

    @Override
    public Project selectByPrimaryKey(Long id) {
        return projectMapper.selectByPrimaryKey(id);
    }

    @Override
    public int addProject(String projectName, String location, Long landArea, Long buildArea, Integer floor, String eiaPeople, String permit, Integer auditFlag, Date successDate) {
        return projectMapper.insertSelective(new Project(projectName,location,landArea,buildArea,floor,eiaPeople,permit,auditFlag,successDate));
    }

    @Override
    public int editProject(Long id, String projectName, String location, Long landArea, Long buildArea, Integer floor, String eiaPeople, String permit, Integer auditFlag, Date successDate) {
        return projectMapper.updateByPrimaryKeySelective(new Project(id,projectName,location,landArea,buildArea,floor,eiaPeople,permit,auditFlag,successDate));
    }


    @Override
    public void deleteProject(Long id) {
        projectMapper.deleteByPrimaryKey(id);
    }

    @Transactional
    public void upload(Long articleid, HttpServletRequest request, String filePosition) {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
                request.getSession().getServletContext());

        if (multipartResolver.isMultipart(request)) {
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;

            Iterator<String> iter = multiRequest.getFileNames();

            while (iter.hasNext()) {
                MultipartFile file = multiRequest.getFile((String) iter.next());

                if (file != null) {
                    try {
                        // 得到上传的文件名
                        String fileName = file.getOriginalFilename();
                        // 得到服务器项目发布运行所在地址
                        String path1 = filePosition;
                        // 此处未使用UUID来生成唯一标识,用日期做为标识
                        String path = path1 + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "_"
                                + fileName;
                        // 查看文件上传路径,方便查找
                        System.out.println(path);
                        System.err.println(fileName);
                        // 把文件上传至path的路径
                        File localFile = new File(path);

                        // 赋值
                        ProjectAttachment attach = new ProjectAttachment();

                        Employee employee1 = new Employee();
                        request.setAttribute("employee",employee1);
                        Employee employee = (Employee) request.getSession().getAttribute("employee");
                        attach.setCreateby(employee.getId());

                        attach.setCreateDate(new Date());
                        attach.setFileName(fileName);
                        attach.setFilePath(path);
                        attach.setProjectId(articleid);
                        // 插入数据库
                        projectAttachmentMapper.insert(attach);

                        file.transferTo(localFile);
                    } catch (IllegalStateException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    @Override
    public List<ProjectAttachment> getAttachsByProjectId(Long id) {
        ProjectAttachmentExample example = new ProjectAttachmentExample();
        example.createCriteria().andProjectIdEqualTo(id);
        return projectAttachmentMapper.selectByExample(example);
    }

    public ProjectAttachment selectAttachById(Long id) {
        return projectAttachmentMapper.selectByPrimaryKey(id);
    }

    @Transactional
    public void delBuild_project_attachs(Long[] idList) {
        for(Long id:idList){
            projectAttachmentMapper.deleteByPrimaryKey(id);
        }
    }


}
