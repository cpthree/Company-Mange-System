package com.ms.service;

import com.ms.entity.Project;
import com.ms.entity.ProjectAttachment;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * Created by Dell on 2017/8/8.
 */
public interface ProjectService {
    List<Project> selectProject();
    Project selectByPrimaryKey(Long id);
    int addProject(String projectName, String location, Long landArea, Long buildArea, Integer floor, String eiaPeople, String permit, Integer auditFlag, Date successDate);
    int editProject(Long id, String projectName, String location, Long landArea, Long buildArea, Integer floor, String eiaPeople, String permit, Integer auditFlag, Date successDate);
    void deleteProject(Long id);
    void upload(Long articleid, HttpServletRequest request, String filePosition);
    public List<ProjectAttachment> getAttachsByProjectId(Long id);
    ProjectAttachment selectAttachById(Long id);
    void delBuild_project_attachs(Long[] idList);
}
