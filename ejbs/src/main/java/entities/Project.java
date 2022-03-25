package entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
@Entity
@Table(name="projects")
@DiscriminatorValue(value = "PROJECT")
public class Project extends Module {
    @Column(name = "nbr_of_group")
    private int nbrOfGroup;
    @Column(name="nbr_of_students_per_group")
    private int nbrOfStudentPerGroup;
    @Transient
    public int nbreOfStudents(){
        return this.nbrOfGroup* this.nbrOfStudentPerGroup;
    }
    public int getNbrOfGroup() {
        return nbrOfGroup;
    }
    public void setNbrOfGroup(int nbrOfGroup) {
        this.nbrOfGroup = nbrOfGroup;
    }

    public int getNbrOfStudentPerGroup() {
        return nbrOfStudentPerGroup;
    }
    public void setNbrOfStudentPerGroup(int nbrOfStudentPerGroup) {
        this.nbrOfStudentPerGroup = nbrOfStudentPerGroup;
    }
    
}
