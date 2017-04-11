/**
 * 
 */
package com.fixit.core.data.sql;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author 		Kostyantin
 * @createdAt 	2016/12/21 21:40:20 GMT+2
 */
@Entity
@Table(name = "StoredProperty")
@IdClass(StoredProperty.StoredPropertyPK.class)
public class StoredProperty implements SqlModelObject<StoredProperty.StoredPropertyPK> {
	
	@Id
	private String group;
	
	@Id
	private String key;
	
	private String value;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt;
	
	public StoredProperty() { }
	
	public StoredProperty(String group, String key, String value, Date updatedAt) {
		this.group = group;
		this.key = key;
		this.value = value;
		this.updatedAt = updatedAt;
	}

	@Override
	public StoredPropertyPK getId() {
		return new StoredPropertyPK(group, key);
	}

	@Override
	public void setId(StoredPropertyPK id) {
		this.group = id.group;
		this.key = id.key;
	}
	
	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "StoredProperty [group=" + group + ", key=" + key + ", value=" + value + ", updatedAt=" + updatedAt + "]";
	}

	public static class StoredPropertyPK implements Serializable {
		private static final long serialVersionUID = -4539230641532463574L;
		
		protected String group;
		protected String key;
		
		public StoredPropertyPK(String group, String key) {
			this.group = group;
			this.key = key;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((key == null) ? 0 : key.hashCode());
			result = prime * result + ((group == null) ? 0 : group.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			StoredPropertyPK other = (StoredPropertyPK) obj;
			if (key == null) {
				if (other.key != null)
					return false;
			} else if (!key.equals(other.key))
				return false;
			if (group == null) {
				if (other.group != null)
					return false;
			} else if (!group.equals(other.group))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "StoredPropertyPK [group=" + group + ", key=" + key + "]";
		}
		
	}
	
}
