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
    private int responseId;
    private String comment;
    private String date;
    private UserDataModel author;
    private DeliveryDataModel deliveryId;
    
    public ResponseDataModel(){
        
    }
    
    public ResponseDataModel(String comment, String date, UserDataModel author, DeliveryDataModel deliveryId){
        
        this.comment = comment;
        this.date = date;
        this.author = author;
        this.deliveryId = deliveryId;
    }
    
    public int getResponseId(){
        return responseId;
    }
    
    public void setResponseId(int responseId){
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
    
    public UserDataModel getAuthor(){
        return author;
    }
    
    public void setAuthor(UserDataModel author){
        this.author = author;
    }
    
    public DeliveryDataModel getDeliveryId(){
        return deliveryId;
    }
    
    public void setDeliveryId(DeliveryDataModel deliveryId){
        this.deliveryId = deliveryId;
    }
}
