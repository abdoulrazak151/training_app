package ws;




import javax.print.attribute.standard.Media;

import entities.Course;
import entities.Module;
import entities.Project;
import entities.Tutorial;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import sessions.ModuleManager;

@Path(value="/module-service")
public class ModuleRessource {

    @Inject
    ModuleManager moduleManager;


   @GET
   @Path("/getAllModule")
   @Produces(MediaType.APPLICATION_JSON)
   public Response getAllModule(){
       return Response.status(Status.OK).entity(moduleManager.findAllModule()).build();
   }

   @GET
   @Path("/getAllModule/{id_training}")
   @Produces(MediaType.APPLICATION_JSON)
   public Response getAllModuleByTraining(@PathParam(value = "id_training")int id){
       return  Response.status(Status.OK).entity(moduleManager.findModuleByTraining(id)).build();
   }

   @POST
   @Path("/create_tutorial/{id}")
   @Produces(MediaType.APPLICATION_JSON)
   @Consumes(MediaType.APPLICATION_JSON)
   public Response createTutorial(@PathParam(value = "id")int id, Tutorial tutorial){
    Module tuto=moduleManager.createTutorial(id, tutorial);
    return Response.status(Status.OK).entity(tuto).build();
   }
   @POST
   @Path("/create_project/{id}")
   @Produces(MediaType.APPLICATION_JSON)
   @Consumes(MediaType.APPLICATION_JSON)
   public Response createProject(@PathParam(value = "id")int id, Project project){
       Project pro=(Project) moduleManager.createProject(id, project);
       return Response.status(Status.OK).entity(pro).build();
   }
    @POST
   @Path("/create_course/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createCourse(@PathParam(value = "id") int id, Course course){
        Course course2=(Course)moduleManager.createCourse(id, course);
       return Response.status(Status.OK).entity(course2).build();
    }

//   @POST
//    @Path(value = "/createTraining")
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response createModule(int training, Module module){
//       Module module1=moduleManager.createModule(training,module);
//       return Response.status(Status.OK).entity(module1).build();
//   }
  @DELETE
   @Path(value="/deleteModule/{id}")
   public Response deleteModule(@PathParam(value ="id")int id){
    moduleManager.deleteModule(id);
        return Response.status(Status.OK).build();
  }


    
}
