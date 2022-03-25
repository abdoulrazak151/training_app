package entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="tutorial")
@DiscriminatorValue(value = "TUTORIAL")
public class Tutorial extends Module{
    @Column(name="video_link")
    private String videoLink;

    public String getVideoLink() {
        return videoLink;
    }

    public void setVideoLink(String videoLink) {
        this.videoLink = videoLink;
    }
    
    
}
