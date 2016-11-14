/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import DataModel.ResponseDataModel;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Melcor
 */
@Remote
public interface ResponseSessionBeanRemote {
    boolean addResponse(ResponseDataModel response);
    
    ResponseDataModel getResponseById(String id);
    
    List<ResponseDataModel> getAllResponses();
    
    List<ResponseDataModel> getAllResponsesByDelivery(String delivery);
}
