package com.linzoe.common.jmx.bo;

import java.io.Serializable;
import java.util.List;

public class Operation implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private long nodeId;
    private String opName;
    private List<String> fields;
    private String returnType;
    
    
    /**
     * Returns this nodeId object.
     * @return this nodeId
     */
    public long getNodeId() {
        return nodeId;
    }

    
    /**
     * Sets this nodeId.
     * @param nodeId this nodeId to set
     */
    public void setNodeId(long nodeId) {
        this.nodeId = nodeId;
    }

    /**
     * Returns this opName object.
     * @return this opName
     */
    public String getOpName() {
        return opName;
    }
    
    /**
     * Sets this opName.
     * @param opName this opName to set
     */
    public void setOpName(String opName) {
        this.opName = opName;
    }
    
    /**
     * Returns this fields object.
     * @return this fields
     */
    public List<String> getFields() {
        return fields;
    }
    
    /**
     * Sets this fields.
     * @param fields this fields to set
     */
    public void setFields(List<String> fields) {
        this.fields = fields;
    }

    
    /**
     * Returns this returnType object.
     * @return this returnType
     */
    public String getReturnType() {
        return returnType;
    }

    
    /**
     * Sets this returnType.
     * @param returnType this returnType to set
     */
    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

}
