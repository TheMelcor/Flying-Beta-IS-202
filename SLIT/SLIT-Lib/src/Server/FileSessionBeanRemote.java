/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import DataModel.FileDataModel;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Melcor
 */
@Remote
public interface FileSessionBeanRemote {
    boolean addFile(FileDataModel file);
    
    FileDataModel getFileById(String id);
    
    List<FileDataModel> getFilesByName(String fileName);
    
    List<FileDataModel> getFilesByType(String fileType);
    
    List<FileDataModel> getAllFiles();
    
}
