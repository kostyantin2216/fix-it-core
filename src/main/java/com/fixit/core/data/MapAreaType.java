/**
 * 
 */
package com.fixit.core.data;

/**
 * @author 		Kostyantin
 * @createdAt 	2016/12/24 21:49:21 GMT+2
 */
public enum MapAreaType {
	Province(0),
    Municipality(1),
    District(2),
    Ward(3);
	
	public final int level;
	
	private MapAreaType(int level) {
		this.level = level;
	}
	
	public static MapAreaType findByLevel(int level) {
		for(MapAreaType type : values()) {
			if(level == type.level) {
				return type;
			}
		}
		return null;
	}
}
