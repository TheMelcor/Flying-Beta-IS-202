/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataModel;

/**
 *
 * @author Melcor
 */
public class ResponseDataModel implements java.io.Serializable{
    private String responseId;
    private String comment;
    private String date;
    private String author;
    private String deliveryId;
    
    public ResponseDataModel(String responseId, String comment, String date, String author, String deliveryId){
        this.responseId = responseId;
        this.comment = comment;
        this.date = date;
        this.author = author;
        this.deliveryId = deliveryId;
    }
    
    public String getResponseId(){
        return responseId;
    }
    
    public void setResponseId(String responseId){
        this.responseId = responseId;
    }
    
    public String getComment(){
        return comment;
    }
    
    public void setComment(String comment){
        this.comment = comment;
    }
    
    public String getDate(){
        return date;
    }
    
    public void setDate(String date){
        this.date = date;
    }
    
    public String getAuthor(){
        return author;
    }
    
    public void setAuthor(String author){
        this.author = author;
    }
    
    public String getDeliveryId(){
        return deliveryId;
    }
    
    public void setDeliveryId(String deliveryId){
        this.deliveryId = deliveryId;
    }
}
