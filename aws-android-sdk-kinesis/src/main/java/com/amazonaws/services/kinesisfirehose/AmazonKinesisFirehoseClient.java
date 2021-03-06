/*
 * Copyright 2010-2016 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 * 
 *  http://aws.amazon.com/apache2.0
 * 
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package com.amazonaws.services.kinesisfirehose;

import java.util.*;

import com.amazonaws.*;
import com.amazonaws.auth.*;
import com.amazonaws.handlers.*;
import com.amazonaws.http.*;
import com.amazonaws.internal.*;
import com.amazonaws.metrics.*;
import com.amazonaws.transform.*;
import com.amazonaws.util.*;
import com.amazonaws.util.AWSRequestMetrics.Field;

import com.amazonaws.services.kinesisfirehose.model.*;
import com.amazonaws.services.kinesisfirehose.model.transform.*;

/**
 * Client for accessing AmazonKinesisFirehose.  All service calls made
 * using this client are blocking, and will not return until the service call
 * completes.
 * <p>
 * Amazon Kinesis Firehose API Reference <p>
 * Amazon Kinesis Firehose is a fully-managed service that delivers
 * real-time streaming data to destinations such as Amazon S3 and Amazon
 * Redshift.
 * </p>
 */
public class AmazonKinesisFirehoseClient extends AmazonWebServiceClient implements AmazonKinesisFirehose {

    /** Provider for AWS credentials. */
    private AWSCredentialsProvider awsCredentialsProvider;

    /**
     * List of exception unmarshallers for all AmazonKinesisFirehose exceptions.
     */
    protected List<JsonErrorUnmarshaller> jsonErrorUnmarshallers;

    /**
     * Constructs a new client to invoke service methods on
     * AmazonKinesisFirehose.  A credentials provider chain will be used
     * that searches for credentials in this order:
     * <ul>
     *  <li> Environment Variables - AWS_ACCESS_KEY_ID and AWS_SECRET_KEY </li>
     *  <li> Java System Properties - aws.accessKeyId and aws.secretKey </li>
     *  <li> Instance profile credentials delivered through the Amazon EC2 metadata service </li>
     * </ul>
     *
     * <p>
     * All service calls made using this new client object are blocking, and will not
     * return until the service call completes.
     *
     * @see DefaultAWSCredentialsProviderChain
     */
    @Deprecated
    public AmazonKinesisFirehoseClient() {
        this(new DefaultAWSCredentialsProviderChain(), new ClientConfiguration());
    }

    /**
     * Constructs a new client to invoke service methods on
     * AmazonKinesisFirehose.  A credentials provider chain will be used
     * that searches for credentials in this order:
     * <ul>
     *  <li> Environment Variables - AWS_ACCESS_KEY_ID and AWS_SECRET_KEY </li>
     *  <li> Java System Properties - aws.accessKeyId and aws.secretKey </li>
     *  <li> Instance profile credentials delivered through the Amazon EC2 metadata service </li>
     * </ul>
     *
     * <p>
     * All service calls made using this new client object are blocking, and will not
     * return until the service call completes.
     *
     * @param clientConfiguration The client configuration options controlling how this
     *                       client connects to AmazonKinesisFirehose
     *                       (ex: proxy settings, retry counts, etc.).
     *
     * @see DefaultAWSCredentialsProviderChain
     */
    @Deprecated
    public AmazonKinesisFirehoseClient(ClientConfiguration clientConfiguration) {
        this(new DefaultAWSCredentialsProviderChain(), clientConfiguration);
    }

    /**
     * Constructs a new client to invoke service methods on
     * AmazonKinesisFirehose using the specified AWS account credentials.
     * 
     * <p>
     * All service calls made using this new client object are blocking, and will not
     * return until the service call completes.
     *
     * @param awsCredentials The AWS credentials (access key ID and secret key) to use
     *                       when authenticating with AWS services.
     */
    public AmazonKinesisFirehoseClient(AWSCredentials awsCredentials) {
        this(awsCredentials, new ClientConfiguration());
    }

    /**
     * Constructs a new client to invoke service methods on
     * AmazonKinesisFirehose using the specified AWS account credentials
     * and client configuration options.
     * 
     * <p>
     * All service calls made using this new client object are blocking, and will not
     * return until the service call completes.
     *
     * @param awsCredentials The AWS credentials (access key ID and secret key) to use
     *                       when authenticating with AWS services.
     * @param clientConfiguration The client configuration options controlling how this
     *                       client connects to AmazonKinesisFirehose
     *                       (ex: proxy settings, retry counts, etc.).
     */
    public AmazonKinesisFirehoseClient(AWSCredentials awsCredentials, ClientConfiguration clientConfiguration) {
        this(new StaticCredentialsProvider(awsCredentials), clientConfiguration);
    }

    /**
     * Constructs a new client to invoke service methods on
     * AmazonKinesisFirehose using the specified AWS account credentials provider.
     * 
     * <p>
     * All service calls made using this new client object are blocking, and will not
     * return until the service call completes.
     *
     * @param awsCredentialsProvider
     *            The AWS credentials provider which will provide credentials
     *            to authenticate requests with AWS services.
     */
    public AmazonKinesisFirehoseClient(AWSCredentialsProvider awsCredentialsProvider) {
        this(awsCredentialsProvider, new ClientConfiguration());
    }

    /**
     * Constructs a new client to invoke service methods on
     * AmazonKinesisFirehose using the specified AWS account credentials
     * provider and client configuration options.
     * 
     * <p>
     * All service calls made using this new client object are blocking, and will not
     * return until the service call completes.
     *
     * @param awsCredentialsProvider
     *            The AWS credentials provider which will provide credentials
     *            to authenticate requests with AWS services.
     * @param clientConfiguration The client configuration options controlling how this
     *                       client connects to AmazonKinesisFirehose
     *                       (ex: proxy settings, retry counts, etc.).
     */
    public AmazonKinesisFirehoseClient(AWSCredentialsProvider awsCredentialsProvider, ClientConfiguration clientConfiguration) {
        this(awsCredentialsProvider, clientConfiguration, new UrlHttpClient(clientConfiguration));
    }

    /**
     * Constructs a new client to invoke service methods on
     * AmazonKinesisFirehose using the specified AWS account credentials
     * provider, client configuration options and request metric collector.
     * 
     * <p>
     * All service calls made using this new client object are blocking, and will not
     * return until the service call completes.
     *
     * @param awsCredentialsProvider
     *            The AWS credentials provider which will provide credentials
     *            to authenticate requests with AWS services.
     * @param clientConfiguration The client configuration options controlling how this
     *                       client connects to AmazonKinesisFirehose
     *                       (ex: proxy settings, retry counts, etc.).
     * @param requestMetricCollector optional request metric collector
     */
    @Deprecated
    public AmazonKinesisFirehoseClient(AWSCredentialsProvider awsCredentialsProvider,
            ClientConfiguration clientConfiguration,
            RequestMetricCollector requestMetricCollector) {
        super(adjustClientConfiguration(clientConfiguration), requestMetricCollector);
        
        this.awsCredentialsProvider = awsCredentialsProvider;
        
        init();
    }

    /**
     * Constructs a new client to invoke service methods on
     * AmazonKinesisFirehose using the specified AWS account credentials
     * provider, client configuration options and request metric collector.
     * 
     * <p>
     * All service calls made using this new client object are blocking, and will not
     * return until the service call completes.
     *
     * @param awsCredentialsProvider
     *            The AWS credentials provider which will provide credentials
     *            to authenticate requests with AWS services.
     * @param clientConfiguration The client configuration options controlling how this
     *                       client connects to AmazonKinesisFirehose
     *                       (ex: proxy settings, retry counts, etc.).
     * @param httpClient A http client
     */
    public AmazonKinesisFirehoseClient(AWSCredentialsProvider awsCredentialsProvider,
            ClientConfiguration clientConfiguration, HttpClient httpClient) {
        super(adjustClientConfiguration(clientConfiguration), httpClient);
        
        this.awsCredentialsProvider = awsCredentialsProvider;
        
        init();
    }

    private void init() {
        jsonErrorUnmarshallers = new ArrayList<JsonErrorUnmarshaller>();
        jsonErrorUnmarshallers.add(new InvalidArgumentExceptionUnmarshaller());
        jsonErrorUnmarshallers.add(new ResourceNotFoundExceptionUnmarshaller());
        jsonErrorUnmarshallers.add(new ServiceUnavailableExceptionUnmarshaller());
        
        jsonErrorUnmarshallers.add(new JsonErrorUnmarshaller());
        
        // calling this.setEndPoint(...) will also modify the signer accordingly
        this.setEndpoint("firehose.us-east-1.amazonaws.com");
        
        HandlerChainFactory chainFactory = new HandlerChainFactory();
        requestHandler2s.addAll(chainFactory.newRequestHandlerChain(
                "/com/amazonaws/services/kinesisfirehose/request.handlers"));
        requestHandler2s.addAll(chainFactory.newRequestHandler2Chain(
                "/com/amazonaws/services/kinesisfirehose/request.handler2s"));
    }

    private static ClientConfiguration adjustClientConfiguration(ClientConfiguration orig) {
        ClientConfiguration config = orig;
        
        return config;
    }

    /**
     * <p>
     * Writes multiple data records into a delivery stream in a single call,
     * which can achieve higher throughput per producer than when writing
     * single records. To write single data records into a delivery stream,
     * use PutRecord. Applications using these operations are referred to as
     * producers.
     * </p>
     * <p>
     * Each PutRecordBatch request supports up to 500 records. Each record
     * in the request can be as large as 1,000 KB (before 64-bit encoding),
     * up to a limit of 4 MB for the entire request. By default, each
     * delivery stream can take in up to 2,000 transactions per second, 5,000
     * records per second, or 5 MB per second. Note that if you use PutRecord
     * and PutRecordBatch, the limits are an aggregate across these two
     * operations for each delivery stream. For more information about limits
     * and how to request an increase, see
     * <a href="http://docs.aws.amazon.com/firehose/latest/dev/limits.html"> Amazon Kinesis Firehose Limits </a>
     * .
     * </p>
     * <p>
     * You must specify the name of the delivery stream and the data record
     * when using PutRecord. The data record consists of a data blob that can
     * be up to 1,000 KB in size, and any kind of data, for example, a
     * segment from a log file, geographic location data, web site
     * clickstream data, and so on.
     * </p>
     * <p>
     * Amazon Kinesis Firehose buffers records before delivering them to the
     * destination. To disambiguate the data blobs at the destination, a
     * common solution is to use delimiters in the data, such as a newline (
     * <code>\n</code> ) or some other character unique within the data. This
     * allows the consumer application(s) to parse individual data items when
     * reading the data from the destination.
     * </p>
     * <p>
     * The PutRecordBatch response includes a count of any failed records,
     * <code>FailedPutCount</code> , and an array of responses,
     * <code>RequestResponses</code> . The <code>FailedPutCount</code> value
     * is a count of records that failed. Each entry in the
     * <code>RequestResponses</code> array gives additional information of
     * the processed record. Each entry in <code>RequestResponses</code>
     * directly correlates with a record in the request array using the same
     * ordering, from the top to the bottom of the request and response.
     * <code>RequestResponses</code> always includes the same number of
     * records as the request array. <code>RequestResponses</code> both
     * successfully and unsuccessfully processed records. Amazon Kinesis
     * Firehose attempts to process all records in each PutRecordBatch
     * request. A single record failure does not stop the processing of
     * subsequent records.
     * </p>
     * <p>
     * A successfully processed record includes a <code>RecordId</code>
     * value, which is a unique value identified for the record. An
     * unsuccessfully processed record includes <code>ErrorCode</code> and
     * <code>ErrorMessage</code> values. <code>ErrorCode</code> reflects the
     * type of error and is one of the following values:
     * <code>ServiceUnavailable</code> or <code>InternalFailure</code> .
     * <code>ErrorMessage</code> provides more detailed information about the
     * error.
     * </p>
     * <p>
     * If <code>FailedPutCount</code> is greater than 0 (zero), retry the
     * request. A retry of the entire batch of records is possible; however,
     * we strongly recommend that you inspect the entire response and resend
     * only those records that failed processing. This minimizes duplicate
     * records and also reduces the total bytes sent (and corresponding
     * charges).
     * </p>
     * <p>
     * If the PutRecordBatch operation throws a
     * <code>ServiceUnavailableException</code> , back off and retry. If the
     * exception persists, it is possible that the throughput limits have
     * been exceeded for the delivery stream.
     * </p>
     * <p>
     * Data records sent to Amazon Kinesis Firehose are stored for 24 hours
     * from the time they are added to a delivery stream as it attempts to
     * send the records to the destination. If the destination is unreachable
     * for more than 24 hours, the data is no longer available.
     * </p>
     *
     * @param putRecordBatchRequest Container for the necessary parameters to
     *           execute the PutRecordBatch service method on AmazonKinesisFirehose.
     * 
     * @return The response from the PutRecordBatch service method, as
     *         returned by AmazonKinesisFirehose.
     * 
     * @throws InvalidArgumentException
     * @throws ResourceNotFoundException
     * @throws ServiceUnavailableException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonKinesisFirehose indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public PutRecordBatchResult putRecordBatch(PutRecordBatchRequest putRecordBatchRequest) {
        ExecutionContext executionContext = createExecutionContext(putRecordBatchRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<PutRecordBatchRequest> request = null;
        Response<PutRecordBatchResult> response = null;
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new PutRecordBatchRequestMarshaller().marshall(putRecordBatchRequest);
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }
            Unmarshaller<PutRecordBatchResult, JsonUnmarshallerContext> unmarshaller = new PutRecordBatchResultJsonUnmarshaller();
            JsonResponseHandler<PutRecordBatchResult> responseHandler = new JsonResponseHandler<PutRecordBatchResult>(unmarshaller);

            response = invoke(request, responseHandler, executionContext);
            
        return response.getAwsResponse();
        } finally {
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    @Override
    public void setEndpoint(String endpoint) {
        super.setEndpoint(endpoint);
    }

    @Override
    public void setEndpoint(String endpoint, String serviceName, String regionId) throws IllegalArgumentException {
        super.setEndpoint(endpoint, serviceName, regionId);
    }

    /**
     * Returns additional metadata for a previously executed successful, request, typically used for
     * debugging issues where a service isn't acting as expected.  This data isn't considered part
     * of the result data returned by an operation, so it's available through this separate,
     * diagnostic interface.
     * <p>
     * Response metadata is only cached for a limited period of time, so if you need to access
     * this extra diagnostic information for an executed request, you should use this method
     * to retrieve it as soon as possible after executing the request.
     *
     * @param request
     *            The originally executed request
     *
     * @return The response metadata for the specified request, or null if none
     *         is available.
     *
     * @deprecated ResponseMetadata cache can hold up to 50 requests and
     *             responses in memory and will cause memory issue. This method
     *             now always returns null.
     */
    @Deprecated
    public ResponseMetadata getCachedResponseMetadata(AmazonWebServiceRequest request) {
        return client.getResponseMetadataForRequest(request);
    }

    private <X, Y extends AmazonWebServiceRequest> Response<X> invoke(Request<Y> request,
            HttpResponseHandler<AmazonWebServiceResponse<X>> responseHandler,
            ExecutionContext executionContext) {
        request.setEndpoint(endpoint);
        request.setTimeOffset(timeOffset);

        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        AWSCredentials credentials;
        awsRequestMetrics.startEvent(Field.CredentialsRequestTime);
        try {
            credentials = awsCredentialsProvider.getCredentials();
        } finally {
            awsRequestMetrics.endEvent(Field.CredentialsRequestTime);
        }

        AmazonWebServiceRequest originalRequest = request.getOriginalRequest();
        if (originalRequest != null && originalRequest.getRequestCredentials() != null) {
            credentials = originalRequest.getRequestCredentials();
        }

        executionContext.setCredentials(credentials);
        JsonErrorResponseHandler errorResponseHandler = new JsonErrorResponseHandler(jsonErrorUnmarshallers);
        Response<X> result = client.execute(request, responseHandler,
                errorResponseHandler, executionContext);
        return result;
    }
}
        