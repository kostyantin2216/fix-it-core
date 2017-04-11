/**
 * 
 */
package com.fixit.core.data;

import java.util.Arrays;

/**
 * @author 		Kostyantin
 * @createdAt 	2016/12/16 20:20:35 GMT+2
 */
public class DataMapping {

	private int dataTypeId;
	private int[] dataIds;
	
	public DataMapping(int dataTypeId, int[] dataIds) {
		this.dataTypeId = dataTypeId;
		this.dataIds = dataIds;
	}

	public int getDataTypeId() {
		return dataTypeId;
	}

	public void setDataTypeId(int dataTypeId) {
		this.dataTypeId = dataTypeId;
	}

	public int[] getDataIds() {
		return dataIds;
	}

	public void setDataIds(int[] dataIds) {
		this.dataIds = dataIds;
	}

	@Override
	public String toString() {
		return "DataMapping [dataTypeId=" + dataTypeId + ", dataIds=" + Arrays.toString(dataIds) + "]";
	}
	
}
