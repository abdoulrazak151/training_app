package entities;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name="tranings")
public class Training implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Column(name="name")
    private String name;
    @OneToMany(targetEntity=Module.class, mappedBy = "training", orphanRemoval = true)
    private List<Module> modules;
    @Transient
    public int nbrOfStudents(){
        int somme=0;
        for(Module module:modules){
            somme+=module.getNbrOfStudents();
        }
        return somme;
    }
    @Transient
    public int duration(){
        int somme=0;
        for(Module module:modules){
            somme+=module.getDuration();
        }
        return somme;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Module> getModules() {
        return modules;
    }

    public void setModules(List<Module> modules) {
        this.modules = modules;
    }
    
    
}
