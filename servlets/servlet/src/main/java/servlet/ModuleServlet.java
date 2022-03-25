package servlet;

import entities.Module;
import jakarta.ejb.EJB;
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
                req.setAttribute("id_training", id);
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
                // req.setAttribute("id_training", id);
                break;
            }
            case "new_course":{
                target="new_course.jsp";
                // req.setAttribute("id_training", id);
                break;
            }
            case "all_module":{
                List<Module> modules=moduleManager.findAllModule();
                req.setAttribute("modules", modules);
                target="list_module_all.jsp";
                break;
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
        switch(action){
            case "create_project":{
                int id=Integer.parseInt(req.getParameter("id"));
                String name=req.getParameter("name_project");
                String description=req.getParameter("description_project");
                String nbrOfStudents=req.getParameter("number_student_project");
                String nbrGroup=req.getParameter("number_group");
                String nbrStudent=req.getParameter("number_student");
                if(name.isEmpty() || description.isEmpty() || nbrGroup.isEmpty() || nbrOfStudents.isEmpty() ||  nbrStudent.isEmpty()){

                }else{
                    int nbrS=Integer.parseInt(nbrOfStudents);
                    int nbrSG=Integer.parseInt(nbrStudent);
                    int group=Integer.parseInt(nbrGroup);

                    try{

                    }catch(Exception e){
                        
                    }
                }
                break;
            }
        }
    }
}
