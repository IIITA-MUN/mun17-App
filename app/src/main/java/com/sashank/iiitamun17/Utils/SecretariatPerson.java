package com.sashank.iiitamun17.Utils;

/**
 * Created by sashank on 31/7/17.
 */

public class SecretariatPerson {
    private int imageRef;
    private String name;
    private String designation;
    private String number;
    private String emailLink;
    private String fbLink;
    private boolean isLeft;
    private String bio;

    public SecretariatPerson(int imageRef, String name, String designation, String number, String emailLink, String fbLink,
                             boolean isLeft,String bio) {
        this.imageRef = imageRef;
        this.name = name;
        this.designation = designation;
        this.number = number;
        this.emailLink = emailLink;
        this.fbLink = fbLink;
        this.isLeft = isLeft;
        this.bio = bio;

    }

    public int getImageRef() {
        return imageRef;
    }

    public String getName() {
        return name;
    }

    public String getDesignation() {
        return designation;
    }

    public String getNumber() {
        return number;
    }

    public String getEmailLink(){
        return emailLink;
    }

    public String getFbLink() {
        return fbLink;
    }

    public boolean isLeft() {
        return isLeft;
    }

    public String getBio() {return bio;}
}

