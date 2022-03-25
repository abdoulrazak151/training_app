package servlet;

import entities.Course;
import entities.Module;
import entities.Project;
import entities.Tutorial;
import jakarta.ejb.EJB;
import jakarta.persistence.criteria.CriteriaBuilder.In;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sessions.ModuleManager;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/module"})
public class ModuleServlet extends HttpServlet {
    @EJB
    ModuleManager moduleManager;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String target="";
       
        String action=req.getParameter("action");
      
        
        switch(action){
            case "new_project":{
                target="new_project.jsp";
                int id=Integer.parseInt(req.getParameter("id"));
                req.setAttribute("id_training", id);
                break;
            }
            case "list_module":{
                target="list_module.jsp";
                int id=Integer.parseInt(req.getParameter("id"));
                List<Module> modules=moduleManager.findModuleByTraining(id);
               req.setAttribute("id_training", id);
                req.setAttribute("modules", modules);
                break;
            }
            case "new_module":{
                target="new_module.jsp";
               int id=Integer.parseInt(req.getParameter("id"));
                req.setAttribute("id_training", id);
                break;
            }
            case "new_tutorial":{
                target="new_tutorial.jsp";
                int id=Integer.parseInt(req.getParameter("id"));
                req.setAttribute("id_training", id);
                break;
            }
            case "new_course":{
                target="new_course.jsp";
                int id=Integer.parseInt(req.getParameter("id"));
                req.setAttribute("id_training", id);
                break;
            }
            case "all_module":{
                List<Module> modules=moduleManager.findAllModule();
                req.setAttribute("modules", modules);
                target="list_module_all.jsp";
                break;
            }
            case "view":{
                int id=Integer.parseInt(req.getParameter("id"));
                Module module=moduleManager.findModuleById(id);
                req.setAttribute("module", module);
                target="module_view.jsp";
                break;
            }
            case "delete":{
                int id=Integer.parseInt(req.getParameter("id"));
                moduleManager.deleteModule(id);
                target="list_module.jsp";
                
                
            }
           
            
        }



        RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/WEB-INF/view/"+target);
        dispatcher.forward(req, resp);
        // String action=req.getServletPath();
        // String target="";
        // int id=Integer.parseInt(req.getParameter("id"));

    
        //      if(action.equals("/list_module")){
        //         List<Module> modules=moduleManager.findModuleByTraining(id);
        //         req.setAttribute("training_module_list", modules);

        //         target="list_module.jsp";
               
        //     }
        //     if(action.equals("/create_module")){
        //         req.setAttribute("training_module", id);
        //         target="new_module.jsp";
                
        //     }
        //     if(action.equals("/delete_module")) {
        //         moduleManager.deleteModule(id);
        //         target="list_module.jsp";
                
        //     }
        //     if(action.equals("/create_project")){
        //         target="new_project.jsp";
        //     }
        //     if(action.equals("/create_course")){
        //         target="new_course.jsp";
        //     }
        //     if(action.equals("/create_tutorial")){
        //         target="new_course.jsp";
        //     }
        
       


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String target="";
        String action=req.getParameter("action");
        String errorMessage="";
        switch(action){
            case "create_project":{
                int id=Integer.parseInt(req.getParameter("id"));
                String name=req.getParameter("name_project");
                String description=req.getParameter("description_project");
                String nbrOfStudents=req.getParameter("number_student_project");
                String nbrGroup=req.getParameter("number_group");
                String nbrStudent=req.getParameter("number_student");
                String duration=req.getParameter("duration_project");
                if(name.isEmpty() || description.isEmpty() || nbrGroup.isEmpty() || nbrOfStudents.isEmpty() ||  nbrStudent.isEmpty()){
                    target="new_tutorial.jsp";
                    errorMessage="erreur";
                    req.setAttribute("errorMessage",errorMessage);
                }else{
                    int dur=Integer.parseInt(duration);
                    int nbrS=Integer.parseInt(nbrOfStudents);
                    int nbrSG=Integer.parseInt(nbrStudent);
                    int group=Integer.parseInt(nbrGroup);
                    Project project=new Project();
                    project.setDescription(description);
                    project.setName(name);
                    project.setNbrOfGroup(group);
                    project.setNbrOfStudents(nbrS);
                    project.setNbrOfStudentPerGroup(nbrSG);
                    project.setDuration(dur);
                    moduleManager.createProject(id, project);
                   target= "accueil.jsp";

                    try{

                    }catch(Exception e){
                        
                    }
                }
                break;
            }
            case "create_tutorial":{
                int id=Integer.parseInt(req.getParameter("id"));
                String name=req.getParameter("name_tutorial");
                String description =req.getParameter("description_tutorial");
                String nbreStudents=req.getParameter("number_student_tutorial");
                String duration=req.getParameter("duration_tutorial");
                String videoLink=req.getParameter("video_link");
                if(name.isEmpty() || description.isEmpty() || nbreStudents.isEmpty() || duration.isEmpty() || videoLink.isEmpty()){
                    target="new_tutorial.jsp";
              
                }else{
                    int nbre=Integer.parseInt(nbreStudents);
                    int dur=Integer.parseInt(duration);
                    try{
                        Tutorial tutorial=new Tutorial();
                        tutorial.setDuration(dur);
                        tutorial.setDescription(description);
                        tutorial.setVideoLink(videoLink);
                        tutorial.setName(name);
                        tutorial.setNbrOfStudents(nbre);
                        moduleManager.createTutorial(id, tutorial);
                        target="accueil.jsp";

                    }catch(Exception e){
                        errorMessage="a";

                    }
                    
                }
                break;
               
            } 
            case "create_course":{
                int id=Integer.parseInt(req.getParameter("id"));
                String name=req.getParameter("name_course");
                String description=req.getParameter("description_course");
                String numberStudent=req.getParameter("number_student_course");
                String duration=req.getParameter("duration_course");
                String classroom=req.getParameter("classroom");
                if(name.isEmpty() || description.isEmpty() || numberStudent.isEmpty() || duration.isEmpty() || numberStudent.isEmpty()){
                    target="new_course.jsp";
                }else{
                    try{
                        int dur=Integer.parseInt(duration);
                        int num=Integer.parseInt(numberStudent);
                        Course course=new Course();
                        course.setClassroom(classroom);
                        course.setDescription(description);
                        course.setName(name);
                        course.setNbrOfStudents(num);
                        course.setDuration(dur);
                    
                        moduleManager.createCourse(id, course);
                        target="accueil.jsp";


                    }catch(Exception e){

                    }
                }

            }
            

        }
        RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/WEB-INF/view/"+target);
        dispatcher.forward(req, resp);
    }
}
