package sessions;

import java.util.List;

import entities.Training;
import jakarta.ejb.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Singleton
public class TrainingManager {
    @PersistenceContext
    private EntityManager em;

    public Training createTraining(Training training){
        em.persist(training);
        return training;
    }
    public Training findTrainingByid(int id){
        Training training=em.find(Training.class, id);
        if(training==null){
            throw new RuntimeException("training not exist, please creat it before");
        }
        return training;
    }
    
    public List<Training> fingAllTraining(){
        String query="SELECT t from Training t";
        return em.createQuery(query, Training.class).getResultList();

    }
    public Training updateTraining(Training training){
        em.merge(training);
        return training;
    }
    public void deleteTraining(int id){
        em.remove(findTrainingByid(id));
    }
}
