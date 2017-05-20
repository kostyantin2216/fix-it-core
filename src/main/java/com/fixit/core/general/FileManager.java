/**
 * 
 */
package com.fixit.core.general;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fixit.core.dao.sql.StoredPropertyDao;
import com.fixit.core.general.PropertyGroup.Group;

/**
 * @author 		Kostyantin
 * @createdAt 	2017/05/05 13:20:51 GMT+3
 */
@Component
public class FileManager {
	
	private final StoredPropertyDao storedPropertyDao;
	
	@Autowired
	public FileManager(StoredPropertyDao storedPropertyDao) {
		this.storedPropertyDao = storedPropertyDao;
	}
	
	public String storeTradesmanLogo(String tradesmanId, String fileExtension, InputStream sourceInputStream) throws IOException {
		PropertyGroup properties = storedPropertyDao.getPropertyGroup(Group.web);
		
		String uploadsDir = properties.getString(StoredProperties.WEB_DIR_UPLOADS, null);
		String logosDir = properties.getString(StoredProperties.WEB_DIR_TRADESMAN_LOGO, null);
		
		storeFile(sourceInputStream, uploadsDir + logosDir + tradesmanId + fileExtension);
		
		return null;
	}
	
	private void storeFile(InputStream sourceInputStream, String outputPath) throws IOException {
		File targetFile = new File(outputPath);
		 
	    Files.copy(
	      sourceInputStream, 
	      targetFile.toPath(), 
	      StandardCopyOption.REPLACE_EXISTING
	    );
	}

}
