package com.JGG.JDBC.Section26OneToManyUnidirectional;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//225
@Entity
@Table(name="course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="title")
    private String title;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn (name="instructor_id")
    private Instructor instructor;

    //245
    @OneToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.ALL})
    @JoinColumn(name="course_id")
    private List<Review> reviews;


    // Constructors
    public Course(String title) {
        this.title = title;
    }

    public Course() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> courses) {
        this.reviews = courses;
    }

    // Convenience method

    public void addReview(Review review){
        if(reviews==null){
            reviews = new ArrayList<Review>();
        }
        reviews.add(review);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
