/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import DataModel.DeliveryDataModel;
import DataModel.ResponseDataModel;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Melcor
 */
@Remote
public interface ResponseSessionBeanRemote {

    ResponseDataModel getResponseById(int id);
    List<ResponseDataModel> getAllResponses();
    List<ResponseDataModel> getResponsesByDelivery(DeliveryDataModel delivery);
    void saveResponse(ResponseDataModel response);
}
