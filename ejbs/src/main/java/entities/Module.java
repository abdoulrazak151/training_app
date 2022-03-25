package entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "modules")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name="categorie", discriminatorType = DiscriminatorType.STRING, length = 25)
public abstract class Module implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    
    @Column(name="name")
    private String name;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    @Column(name = "description")
    private String description;
    @Column(name="nbr_of_students")
    private int nbrOfStudents;
    @Column(name = "duration")
    private int duration;
    @ManyToOne(targetEntity=Training.class,optional = false)
    @JoinColumn(name="training_id", referencedColumnName = "id", nullable = false)
    private Training training;

    public Training getTraining() {
        return training;
    }
    public void setTraining(Training training) {
        this.training = training;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public int getNbrOfStudents() {
        return nbrOfStudents;
    }
    public void setNbrOfStudents(int nbrOfStudents) {
        this.nbrOfStudents = nbrOfStudents;
    }
    public int getDuration() {
        return duration;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }

    
}
