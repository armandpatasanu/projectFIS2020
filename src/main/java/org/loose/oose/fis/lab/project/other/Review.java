package org.loose.oose.fis.lab.project.other;

import static org.loose.oose.fis.lab.project.controllers.LoginController.active_user;

public class Review {

    private boolean like;
    private boolean dislike;
    private String VURL;

    public Review(){}

    public boolean getLike() {
        return like;
    }

    public void setLike(boolean like) {
        this.like = like;
    }

    public void setDislike(boolean dislike) {
        this.dislike = dislike;
    }

    public  boolean getDislike() {
        return dislike;
    }

    public void setVURL(String VURL) {
        this.VURL = VURL;
    }

    public Review(String VURL, boolean like, boolean dislike){
        this.VURL = VURL;
        this.like = like;
        this.dislike = dislike;
    }

    public static Review getReview(String URL){
        for(Review r : active_user.getReviews()){
            if(r.getVURL().equals(URL)){
                return r;
            }
        }
        return null;
    }

    public String getVURL(){
        return this.VURL;
    }
}