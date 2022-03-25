package sessions;

import java.util.List;

import entities.Course;
import entities.Module;
import entities.Project;
import entities.Training;
import entities.Tutorial;
import jakarta.ejb.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Singleton
public class ModuleManager {
    @PersistenceContext
    private EntityManager em;

    public Module createModule(int id_training, Module module){
        Training training=em.find(Training.class, id_training);
        if(training==null){
            throw new RuntimeException("there is no  training with this id");
          
        }

        module.setTraining(training);
        em.persist(module);
        return module;


    }
    public Module createTutorial(int id_training, Tutorial tutorial){
        Training training=em.find(Training.class, id_training);
        if(training==null){
            throw new RuntimeException("there is no  training with this id");
          
        }

        tutorial.setTraining(training);
        em.persist(tutorial);
        return tutorial;


    }

    public Module createProject(int id_training, Project project){
        Training training=em.find(Training.class, id_training);
        if(training==null){
            throw new RuntimeException("there is no  training with this id");
          
        }

        project.setTraining(training);
        em.persist(project);
        return project;


    }
    public Module createCourse(int id_training, Course course){
        Training training=em.find(Training.class, id_training);
        if(training==null){
            throw new RuntimeException("there is no  training with this id");
          
        }

        course.setTraining(training);
        em.persist(course);
        return course;


    }
    public Module findModuleById(int id){
        Module module=em.find(Module.class,id);
        if(module==null){
            throw new RuntimeException("module with id not exist");
        
        }
        return module;
    }
    public List<Module> findAllModule(){
        String query="select m from Module m JOIN FETCH m.training ";
        return em.createQuery(query, Module.class).getResultList();
    }
    public List<Module> findModuleByTraining(int idTraining){
        String query="select m from Module m JOIN FETCH m.training where m.training.id=:id_training";
        return em.createQuery(query,Module.class).setParameter("id_training", idTraining).getResultList();
    }
    public Module updateModule(Module module){
        Module m=em.find(Module.class, module.getId());
        if(m==null){
            throw new RuntimeException("no module to update");

        }
        if(!module.getDescription().isEmpty())
        m.setDescription(module.getDescription());
        if(module.getDuration()!=0)
        m.setDuration(module.getDuration());
        if(!module.getName().isEmpty())
        m.setName(module.getName());
        if(module.getNbrOfStudents()!=0)
        m.setNbrOfStudents(module.getNbrOfStudents());
        em.merge(m);
        return m;
    }
public void deleteModule(int id){
        em.remove(findModuleById(id));
}
    
}
