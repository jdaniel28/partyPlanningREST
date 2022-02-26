package com.party.partymangement.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;

// TODO: Auto-generated Javadoc
/**
 * The Class StorageService.
 */
@Service
public class StorageService {

	/** The Constant LOGGER. */
	private final static Logger LOGGER = LoggerFactory.getLogger(StorageService.class);

	/** The bucket name. */
	@Value("${application.bucket.name}")
	private String bucketName;

	/** The s 3 client. */
	@Autowired
	private AmazonS3 s3Client;

	/**
	 * Upload photo.
	 *
	 * @param file     the file
	 * @param fileName the file name
	 */
	public void uploadPhoto(File file, String fileName) {
		LOGGER.info("Start - uploadPhoto");
		s3Client.putObject(new PutObjectRequest(bucketName, fileName, file));
		LOGGER.info("End - uploadPhoto");
		file.delete();
	}

	/**
	 * Upload file.
	 *
	 * @param file     the file
	 * @param fileName the file name
	 * @return the string
	 */
	public String uploadFile(MultipartFile file, String fileName) {
		LOGGER.info("Start - uploadFile");
		File fileObj = convertMultiPartFileToFile(file);
		s3Client.putObject(new PutObjectRequest(bucketName, fileName, fileObj));
		fileObj.delete();
		LOGGER.info("End - uploadFile");
		return "File uploaded : " + fileName;
	}

	/**
	 * Convert multi part file to file.
	 *
	 * @param file the file
	 * @return the file
	 */
	private File convertMultiPartFileToFile(MultipartFile file) {
		LOGGER.info("Start - convertMultiPartFileToFile");
		File convertedFile = new File(file.getOriginalFilename());
		try (FileOutputStream fos = new FileOutputStream(convertedFile)) {
			fos.write(file.getBytes());
		} catch (IOException e) {
			System.err.println(e.getStackTrace());
		}
		LOGGER.info("End - convertMultiPartFileToFile");
		return convertedFile;
	}

}
