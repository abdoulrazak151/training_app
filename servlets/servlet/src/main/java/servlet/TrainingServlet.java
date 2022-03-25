package servlet;

import java.io.IOException;
import java.util.List;


import entities.Training;

import jakarta.ejb.EJB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sessions.TrainingManager;

@WebServlet(urlPatterns={"/home"})
public class TrainingServlet extends HttpServlet{
    @EJB
    TrainingManager trainingManager;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action=req.getParameter("action");
       
        String target="";
        
       
        switch (action){
            case "":{
                 target="accueil.jsp";
                 List<Training> trainings=trainingManager.fingAllTraining();
                 req.setAttribute("trainings", trainings);
                 
                 break;
            }
            case "accueil":{
                target="accueil.jsp";
                List<Training> trainings=trainingManager.fingAllTraining();
                req.setAttribute("trainings", trainings);
                break;
            }
            case "training":{
                target="new_training.jsp";
                break;
            }
            
        }

       
        RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/WEB-INF/view/"+target);
        dispatcher.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path=req.getServletPath();
        String action=req.getParameter("action");
        String target="";
        switch (action){
            case "create_training":{
                try{
                    String name=req.getParameter("name");
                    Training training=new Training();
                    training.setName(name);
                    
                    trainingManager.createTraining(training);
                    target="accueil.jsp";
                    RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/WEB-INF/view/"+target);
                    dispatcher.forward(req, resp);


                }catch (Exception e){
                    e.printStackTrace();
                }
                break;
            }
            case "list_training":{
                List<Training> trainings=trainingManager.fingAllTraining();
                req.setAttribute("trainings", trainings);
                break;

            }
        }
      
        RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/WEB-INF/view/"+target);
        dispatcher.forward(req, resp);
    }
    
}
