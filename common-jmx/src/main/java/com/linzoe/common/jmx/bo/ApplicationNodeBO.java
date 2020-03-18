package com.linzoe.common.jmx.bo;

import java.io.Serializable;


public class ApplicationNodeBO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private long id;
    private String name;
    private String ip;
    private String jmxPort;
    private String mbName;
    private String remark;
    
    
    /**
     * Returns this id object.
     * @return this id
     */
    public long getId() {
        return id;
    }

    
    /**
     * Sets this id.
     * @param id this id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Returns this name object.
     * @return this name
     */
    public String getName() {
        return name;
    }
    
    /**
     * Sets this name.
     * @param name this name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Returns this ip object.
     * @return this ip
     */
    public String getIp() {
        return ip;
    }
    
    /**
     * Sets this ip.
     * @param ip this ip to set
     */
    public void setIp(String ip) {
        this.ip = ip;
    }
    
    
    /**
     * Returns this jmxPort object.
     * @return this jmxPort
     */
    public String getJmxPort() {
        return jmxPort;
    }

    
    /**
     * Sets this jmxPort.
     * @param jmxPort this jmxPort to set
     */
    public void setJmxPort(String jmxPort) {
        this.jmxPort = jmxPort;
    }

    /**
     * Returns this mbName object.
     * @return this mbName
     */
    public String getMbName() {
        return mbName;
    }
    
    /**
     * Sets this mbName.
     * @param mbName this mbName to set
     */
    public void setMbName(String mbName) {
        this.mbName = mbName;
    }
    
    /**
     * Returns this remark object.
     * @return this remark
     */
    public String getRemark() {
        return remark;
    }
    
    /**
     * Sets this remark.
     * @param remark this remark to set
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

}
