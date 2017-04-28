/**
 * 
 */
package com.fixit.core.data;

import java.util.Date;

/**
 * @author 		Kostyantin
 * @createdAt 	2017/03/29 21:51:15 GMT+3
 */
public class SynchronizationAction {

	public enum Action {
        INSERT,
        UPDATE,
        DELETE,
        OVERRIDE;

        private static Action find(String action) {
            if(action.equalsIgnoreCase(INSERT.name())) {
                return INSERT;
            } else if(action.equalsIgnoreCase(UPDATE.name())) {
                return UPDATE;
            } else if(action.equalsIgnoreCase(DELETE.name())) {
            	return DELETE;
            } else if(action.equalsIgnoreCase(OVERRIDE.name())) {
            	return OVERRIDE;
            }
            return null;
        }
        
        public String toLowerCaseName() {
        	return name().toLowerCase();
        }
    }

    private String action;
    private Date date;
    
    public SynchronizationAction(String action) {
    	this(action, new Date());
    }
    
    public SynchronizationAction(String action, Date date) {
        this.action = action;
        this.date = date;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Action getActionEnum() {
        return Action.find(action);
    }

    @Override
    public String toString() {
        return "SynchronizationAction{" +
                "action='" + action + '\'' +
                ", date=" + date +
                '}';
    }
}
