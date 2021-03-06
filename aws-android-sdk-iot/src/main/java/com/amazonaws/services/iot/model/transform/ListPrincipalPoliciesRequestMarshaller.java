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
package com.amazonaws.services.iot.model.transform;

import static com.amazonaws.util.StringUtils.UTF8;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;
import java.util.List;

import com.amazonaws.AmazonClientException;
import com.amazonaws.Request;
import com.amazonaws.DefaultRequest;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.iot.model.*;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.BinaryUtils;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;

/**
 * List Principal Policies Request Marshaller
 */
public class ListPrincipalPoliciesRequestMarshaller implements Marshaller<Request<ListPrincipalPoliciesRequest>, ListPrincipalPoliciesRequest> {

    public Request<ListPrincipalPoliciesRequest> marshall(ListPrincipalPoliciesRequest listPrincipalPoliciesRequest) {
    if (listPrincipalPoliciesRequest == null) {
        throw new AmazonClientException("Invalid argument passed to marshall(...)");
    }

        Request<ListPrincipalPoliciesRequest> request = new DefaultRequest<ListPrincipalPoliciesRequest>(listPrincipalPoliciesRequest, "AWSIot");
        String target = "AWSIotService.ListPrincipalPolicies";
        request.addHeader("X-Amz-Target", target);

        request.setHttpMethod(HttpMethodName.GET);
        if (listPrincipalPoliciesRequest.getPrincipal() != null)
          request.addHeader("x-amzn-iot-principal", StringUtils.fromString(listPrincipalPoliciesRequest.getPrincipal()));
        
        String uriResourcePath = "/principal-policies?marker={marker}&pageSize={pageSize}&isAscendingOrder={ascendingOrder}"; 
        uriResourcePath = uriResourcePath.replace("{marker}", (listPrincipalPoliciesRequest.getMarker() == null) ? "" : StringUtils.fromString(listPrincipalPoliciesRequest.getMarker())); 
        uriResourcePath = uriResourcePath.replace("{pageSize}", (listPrincipalPoliciesRequest.getPageSize() == null) ? "" : StringUtils.fromInteger(listPrincipalPoliciesRequest.getPageSize())); 
        uriResourcePath = uriResourcePath.replace("{ascendingOrder}", (listPrincipalPoliciesRequest.isAscendingOrder() == null) ? "" : StringUtils.fromBoolean(listPrincipalPoliciesRequest.isAscendingOrder())); 

        uriResourcePath = uriResourcePath.replaceAll("//", "/");

        if (uriResourcePath.contains("?")) {
            String queryString = uriResourcePath.substring(uriResourcePath.indexOf("?") + 1);
            uriResourcePath    = uriResourcePath.substring(0, uriResourcePath.indexOf("?"));

            for (String s : queryString.split("[;&]")) {
                String[] nameValuePair = s.split("=");
                if (nameValuePair.length == 2) {
                    if(!(nameValuePair[1].isEmpty()))
                        request.addParameter(nameValuePair[0], nameValuePair[1]);
                }
            }
        }
        request.setResourcePath(uriResourcePath);
        
        if (!request.getHeaders().containsKey("Content-Type")) {
            request.addHeader("Content-Type", "application/x-amz-json-1.0");
        }

        return request;
    }
}
