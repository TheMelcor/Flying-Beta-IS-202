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
    private int id;
    private UserDataModel deliveredBy;
    private String deliveryDate;
    private String content;
    private ModuleDataModel moduleNr;
    
    public DeliveryDataModel(){
        
    }
    
    public DeliveryDataModel(UserDataModel deliveredBy, String deliveryDate, String content, ModuleDataModel moduleNr){
        this.deliveredBy = deliveredBy;
        this.deliveryDate = deliveryDate;
        this.content = content;
        this.moduleNr = moduleNr;
    }
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public UserDataModel getDeliveredBy(){
        return deliveredBy;
    }
    
    public void setDeliveredBy(UserDataModel deliveredBy){
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
    
    public ModuleDataModel getModuleNr(){
        return moduleNr;
    }
    
    public void setModuleNr(ModuleDataModel moduleNr){
        this.moduleNr = moduleNr;
    }
}
