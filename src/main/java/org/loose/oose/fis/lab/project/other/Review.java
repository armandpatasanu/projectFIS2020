package org.loose.oose.fis.lab.project.other;

public class Review {

    private boolean like;
    private boolean dislike;
    private String VURL;

    public Review(String VURL, boolean like, boolean dislike){
        this.VURL = VURL;
        this.like = like;
        this.dislike = dislike;
    }

    private int getReviewOnVideo(){
        if(like == true && (dislike == false)){
            return 1;
        }
        else if((like == false) && (dislike == true)){
            return -1;
        }
        else return 0;
    }

    public String getVURL(){
        return this.VURL;
    }
}