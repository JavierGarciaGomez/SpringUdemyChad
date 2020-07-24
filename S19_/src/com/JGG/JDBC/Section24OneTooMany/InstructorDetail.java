package com.JGG.JDBC.Section24OneTooMany;

import javax.persistence.*;

//210anotate the class as an entity and map to db table
//216 Updated to bidireccional
@Entity
@Table(name="instructor_detail")
public class InstructorDetail {
    //define the fields
    //annotate the fields with db column tables
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="youtube_channel")
    private String youtubeChannel;

    @Column(name="hobby")
    private String hobby;

    //216 Add new field for instructor

    @OneToOne(mappedBy = "instructorDetail", cascade = CascadeType.ALL)
    private Instructor instructor;

    //create constructors
    public InstructorDetail() {
    }
    public InstructorDetail(String youtubeChannel, String hobby){
        this.youtubeChannel=youtubeChannel;
        this.hobby=hobby;
    }

    //getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYoutubeChannel() {
        return youtubeChannel;
    }

    public void setYoutubeChannel(String youtubeChannel) {
        this.youtubeChannel = youtubeChannel;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    //to string


    @Override
    public String toString() {
        return "InstructorDetail{" +
                "id=" + id +
                ", youtubeChannel='" + youtubeChannel + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}
