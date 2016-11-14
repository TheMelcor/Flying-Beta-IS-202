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
public class ResourceDataModel {
    private String resourceId;
    private String content;
    private String resourceType;
    private int moduleNr;

    public ResourceDataModel(String resourceId, String content, String resourceType, int moduleNr) {
        this.resourceId = resourceId;
        this.content = content;
        this.resourceType = resourceType;
        this.moduleNr = moduleNr;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public int getModuleNr() {
        return moduleNr;
    }

    public void setModuleNr(int moduleNr) {
        this.moduleNr = moduleNr;
    }
    
    
}
