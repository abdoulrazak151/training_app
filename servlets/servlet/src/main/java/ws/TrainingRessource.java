package ws;



import entities.Training;
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
import sessions.TrainingManager;

@Path(value = "/training-service")
public class TrainingRessource {
    @Inject
    TrainingManager trainingManager;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAllTraining(){
        return Response.status(Status.OK).entity(trainingManager.fingAllTraining()).build();
    }

    @GET
    @Path(value = "/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findTrainingById(@PathParam(value = "id") int id){
        try{
            return Response.status(Status.FOUND).entity(trainingManager.findTrainingByid(id)).build();

        }
        catch(RuntimeException exception){
            return Response.status(Status.NOT_FOUND).build();
        }
    }

    @POST
    @Path(value="/createTraining")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createTraining(Training training){
        try{
        Training trainin=trainingManager.createTraining(training);
        return Response.status(Status.OK).entity(trainin).build();
        }catch(RuntimeException exception){
            return Response.status(Status.BAD_REQUEST).build();
        }
    }

    @DELETE
    @Path(value="/{id}")
    public Response deleteTraining(@PathParam(value="id") int id){
        try{
            trainingManager.deleteTraining(id);
            return Response.status(Status.OK).build();
        
        }catch(Exception e){
            return Response.status(Status.NOT_FOUND).build();
        }
    }
}
