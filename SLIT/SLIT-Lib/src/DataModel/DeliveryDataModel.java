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
public class DeliveryDataModel implements java.io.Serializable{
    private String id;
    private String deliveredBy;
    private String deliveryDate;
    private String content;
    private int moduleNr;
    
    public DeliveryDataModel(String id, String deliveredBy, String deliveryDate, String content, int moduleNr){
        this.id = id;
        this.deliveredBy = deliveredBy;
        this.deliveryDate = deliveryDate;
        this.content = content;
        this.moduleNr = moduleNr;
    }
    
    public String getId(){
        return id;
    }
    
    public void setId(String id){
        this.id = id;
    }
    
    public String getDeliveredBy(){
        return deliveredBy;
    }
    
    public void setDeliveredBy(String deliveredBy){
        this.deliveredBy = deliveredBy;
    }
    
    public String getDeliveryDate(){
        return deliveryDate;
    }
    
    public void setDeliveryDate(String deliveryDate){
        this.deliveryDate = deliveryDate;
    }
    
    public String getContent(){
        return content;
    }
    
    public void setContent(String content){
        this.content = content;
    }
    
    public int getModuleNr(){
        return moduleNr;
    }
    
    public void setModuleNr(int moduleNr){
        this.moduleNr = moduleNr;
    }
}
