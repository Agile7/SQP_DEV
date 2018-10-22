package com.agileseven.codereviewserver.Controller;

import com.agileseven.codereviewserver.DAO.ProjectDAO;
import com.agileseven.codereviewserver.DAO.ProjectDAOImpl;
import com.agileseven.codereviewserver.DAO.UserStoryDAO;
import com.agileseven.codereviewserver.DAO.UserStoryDAOImpl;
import com.agileseven.codereviewserver.DTO.ProjectDTO;
import com.agileseven.codereviewserver.DTO.UserstoryDTO;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * @author Mahmoud AL NAJAR
 */
@RestController
@RequestMapping(path="/CodeReviewer")
public class ProjectController {

    private UserStoryDAO userStoryDAO = new UserStoryDAOImpl();
    private ProjectDAO projectDAO = new ProjectDAOImpl();

    @RequestMapping(path = "/userStories", method= RequestMethod.GET, produces = "application/json")
    public List<UserstoryDTO> userStories(){

        try {
            return userStoryDAO.getAllUserStories();
        } catch (Exception e){
            return null;
        }

    }

    @RequestMapping(path = "/userStories/{projectId}", method= RequestMethod.GET, produces = "application/json")
    public List<UserstoryDTO> getUserStoriesOfProject(@PathVariable Integer projectId){

        try {
            return userStoryDAO.getAllUserStoriesOfProject(projectId);
        } catch (Exception e){
            return null;
        }

    }

    @RequestMapping(path = "/projects", method= RequestMethod.GET)
    public ArrayList<ProjectDTO> getProjectList(){

        try {
            return projectDAO.getProjectList();
        } catch (Exception e){
            return null;
        }

    }

}
