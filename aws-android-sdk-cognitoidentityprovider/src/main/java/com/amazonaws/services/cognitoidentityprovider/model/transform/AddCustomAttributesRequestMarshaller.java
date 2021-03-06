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
package com.amazonaws.services.cognitoidentityprovider.model.transform;

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
import com.amazonaws.services.cognitoidentityprovider.model.*;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.BinaryUtils;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;

/**
 * Add Custom Attributes Request Marshaller
 */
public class AddCustomAttributesRequestMarshaller implements Marshaller<Request<AddCustomAttributesRequest>, AddCustomAttributesRequest> {

    public Request<AddCustomAttributesRequest> marshall(AddCustomAttributesRequest addCustomAttributesRequest) {
    if (addCustomAttributesRequest == null) {
        throw new AmazonClientException("Invalid argument passed to marshall(...)");
    }

        Request<AddCustomAttributesRequest> request = new DefaultRequest<AddCustomAttributesRequest>(addCustomAttributesRequest, "AmazonCognitoIdentityProvider");
        String target = "AWSCognitoIdentityProviderService.AddCustomAttributes";
        request.addHeader("X-Amz-Target", target);

        request.setHttpMethod(HttpMethodName.POST);
        request.setResourcePath("");
        
        try {
            StringWriter stringWriter = new StringWriter();
            AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);

            jsonWriter.beginObject();
            
            if (addCustomAttributesRequest.getUserPoolId() != null) {
                jsonWriter.name("UserPoolId").value(addCustomAttributesRequest.getUserPoolId());
            }

            com.amazonaws.internal.ListWithAutoConstructFlag<SchemaAttributeType> customAttributesList = (com.amazonaws.internal.ListWithAutoConstructFlag<SchemaAttributeType>)(addCustomAttributesRequest.getCustomAttributes());
            if (customAttributesList != null && !(customAttributesList.isAutoConstruct() && customAttributesList.isEmpty())) {

                jsonWriter.name("CustomAttributes");
                jsonWriter.beginArray();

                for (SchemaAttributeType customAttributesListValue : customAttributesList) {
                    if (customAttributesListValue != null) {
                        jsonWriter.beginObject();
                        if (customAttributesListValue.getName() != null) {
                            jsonWriter.name("Name").value(customAttributesListValue.getName());
                        }
                        if (customAttributesListValue.getAttributeDataType() != null) {
                            jsonWriter.name("AttributeDataType").value(customAttributesListValue.getAttributeDataType());
                        }
                        if (customAttributesListValue.isDeveloperOnlyAttribute() != null) {
                            jsonWriter.name("DeveloperOnlyAttribute").value(customAttributesListValue.isDeveloperOnlyAttribute());
                        }
                        if (customAttributesListValue.isMutable() != null) {
                            jsonWriter.name("Mutable").value(customAttributesListValue.isMutable());
                        }
                        if (customAttributesListValue.isRequired() != null) {
                            jsonWriter.name("Required").value(customAttributesListValue.isRequired());
                        }
                        NumberAttributeConstraintsType numberAttributeConstraints = customAttributesListValue.getNumberAttributeConstraints();
                        if (numberAttributeConstraints != null) {

                            jsonWriter.name("NumberAttributeConstraints");
                            jsonWriter.beginObject();

                            if (numberAttributeConstraints.getMinValue() != null) {
                                jsonWriter.name("MinValue").value(numberAttributeConstraints.getMinValue());
                            }
                            if (numberAttributeConstraints.getMaxValue() != null) {
                                jsonWriter.name("MaxValue").value(numberAttributeConstraints.getMaxValue());
                            }
                            jsonWriter.endObject();
                        }
                        StringAttributeConstraintsType stringAttributeConstraints = customAttributesListValue.getStringAttributeConstraints();
                        if (stringAttributeConstraints != null) {

                            jsonWriter.name("StringAttributeConstraints");
                            jsonWriter.beginObject();

                            if (stringAttributeConstraints.getMinLength() != null) {
                                jsonWriter.name("MinLength").value(stringAttributeConstraints.getMinLength());
                            }
                            if (stringAttributeConstraints.getMaxLength() != null) {
                                jsonWriter.name("MaxLength").value(stringAttributeConstraints.getMaxLength());
                            }
                            jsonWriter.endObject();
                        }
                        jsonWriter.endObject();
                    }
                }
                jsonWriter.endArray();
            }

            jsonWriter.endObject();

            jsonWriter.close();
            String snippet = stringWriter.toString();
            byte[] content = snippet.getBytes(UTF8);
            request.setContent(new StringInputStream(snippet));
            request.addHeader("Content-Length", Integer.toString(content.length));
            request.addHeader("Content-Type", "application/x-amz-json-1.1");
        } catch(Throwable t) {
            throw new AmazonClientException("Unable to marshall request to JSON: " + t.getMessage(), t);
        }

        return request;
    }
}
