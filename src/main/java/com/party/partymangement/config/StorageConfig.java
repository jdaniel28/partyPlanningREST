package com.party.partymangement.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class StorageConfig.
 */
@Configuration
public class StorageConfig {

	/** The Constant LOGGER. */
	private final static Logger LOGGER = LoggerFactory.getLogger(StorageConfig.class);

	/** The access key. */
	@Value("${cloud.aws.credentials.access-key}")
	private String accessKey;

	/** The access secret. */
	@Value("${cloud.aws.credentials.secret-key}")
	private String accessSecret;

	/** The region. */
	@Value("${cloud.aws.region.static}")
	private String region;

	/**
	 * S 3 client.
	 *
	 * @return the amazon S 3
	 */
	@Bean
	public AmazonS3 s3Client() {
		LOGGER.info("Start - s3Client");
		AWSCredentials credentials = new BasicAWSCredentials(accessKey, accessSecret);
		LOGGER.info("End - s3Client");
		return AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(credentials))
				.withRegion(region).build();
	}
}
