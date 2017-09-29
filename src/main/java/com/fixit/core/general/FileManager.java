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
	
	public String storeTradesmanFeatureImage(String tradesmanId, String fileExtension, InputStream sourceInputStream) throws IOException {
		PropertyGroup properties = storedPropertyDao.getPropertyGroup(Group.web);
		
		String directoryRoot = properties.getString(StoredProperties.WEB_DIR_DIRECTORY_ROOT, null);
		String pathImages = properties.getString(StoredProperties.WEB_PATH_IMAGES, null);
		String pathFeatureImages = properties.getString(StoredProperties.WEB_PATH_TRADESMAN_FEATURE_IMAGE, null);
		
		String filePath = pathImages + pathFeatureImages + tradesmanId + fileExtension;
		storeFile(sourceInputStream, directoryRoot + filePath);
		
		return transformToHostedPath(properties, filePath);
	}
	
	public String storeTradesmanLogo(String tradesmanId, String fileExtension, InputStream sourceInputStream) throws IOException {
		PropertyGroup properties = storedPropertyDao.getPropertyGroup(Group.web);
		
		String directoryRoot = properties.getString(StoredProperties.WEB_DIR_DIRECTORY_ROOT, null);
		String pathImages = properties.getString(StoredProperties.WEB_PATH_IMAGES, null);
		String pathLogos = properties.getString(StoredProperties.WEB_PATH_TRADESMAN_LOGO, null);
	
		String filePath = pathImages + pathLogos + tradesmanId + fileExtension;
		storeFile(sourceInputStream, directoryRoot + filePath);
		
		return transformToHostedPath(properties, filePath);
	}
	
	private String transformToHostedPath(PropertyGroup properties, String filePath) {
		String fileHost = properties.getString(StoredProperties.WEB_URL_FILE_HOST, null);
		return fileHost + filePath.replace("\\", "/");
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
