/*
 * Copyright (c) 2017, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.wso2.carbon.business.rules.core.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wso2.carbon.analytics.msf4j.interceptor.common.AnalyticsResponseInterceptor;
import org.wso2.carbon.analytics.msf4j.interceptor.common.AuthenticationInterceptor;
import org.wso2.carbon.business.rules.core.api.factories.BusinessRulesApiServiceFactory;
import org.wso2.msf4j.Microservice;
import org.wso2.msf4j.Request;
import org.wso2.msf4j.formparam.FormDataParam;
import org.wso2.msf4j.interceptor.annotation.RequestInterceptor;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import io.swagger.annotations.ApiParam;
import org.wso2.msf4j.interceptor.annotation.ResponseInterceptor;

@RequestInterceptor(AuthenticationInterceptor.class)
@ResponseInterceptor(AnalyticsResponseInterceptor.class)
@io.swagger.annotations.Api(description = "the business-rules API")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaMSF4JServerCodegen",
        date = "2017-10-11T05:39:16.839Z")
public class BusinessRulesApi implements Microservice {
    private static final Logger log = LoggerFactory.getLogger(BusinessRulesApi.class);
    private final BusinessRulesApiService delegate = BusinessRulesApiServiceFactory.getBusinessRulesApi();

    public static final String API_CONTEXT_PATH = "/";

    @POST
    @Path("/instances")
    @Consumes({"multipart/form-data"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Creates a business rule",
            notes = "Creates a business rule instance from template / from scratch from the given form data",
            response = Object.class, responseContainer = "List", tags = {"business-rules",})
    @io.swagger.annotations.ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation", response = Object.class,
                    responseContainer = "List"),

            @io.swagger.annotations.ApiResponse(code = 405, message = "Business rule creation failed",
                    response = Object.class, responseContainer = "List")})
    public Response createBusinessRule(@Context Request request, @FormDataParam("businessRule") String businessRule
            , @ApiParam(value = "States whether the created business rule should be deployed or not.",
            defaultValue = "true")  @DefaultValue("true") @QueryParam("deploy") Boolean shouldDeploy
    )
            throws NotFoundException {
        return delegate.createBusinessRule(request, businessRule, shouldDeploy);
    }

    @DELETE
    @Path("/instances/{businessRuleInstanceID}")

    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Deletes a business rule",
            notes = "Deletes the business rule that has the given ID", response = void.class,
            tags = {"business-rules",})
    @io.swagger.annotations.ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation", response = void.class),

            @io.swagger.annotations.ApiResponse(code = 404, message = "Business rule not found",
                    response = void.class)})
    public Response deleteBusinessRule(@Context Request request,
                                       @ApiParam(value = "ID of the business rule to be deleted", required = true)
                                       @PathParam("businessRuleInstanceID") String businessRuleInstanceID,
                                       @ApiParam(value = "ID of the business rule to be deleted", required = true)
                                       @DefaultValue("true") @QueryParam("force-delete") Boolean forceDelete)
            throws NotFoundException {
        return delegate.deleteBusinessRule(request, businessRuleInstanceID, forceDelete);
    }

    @GET
    @Path("/instances")

    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Returns list of business rule instances",
            notes = "Gets available list of business rule instances", response = Object.class, responseContainer =
            "List", tags = {"business-rules",})
    @io.swagger.annotations.ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation",
                    response = Object.class, responseContainer = "List")})
    public Response getBusinessRules(@Context Request request)
            throws NotFoundException {
        return delegate.getBusinessRules(request);
    }

    @GET
    @Path("/template-groups/{templateGroupID}/templates/{ruleTemplateID}")

    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Returns a rule template",
            notes = "Gets the rule template that has the given ID, which is available under the template group" +
                    " with the given ID", response = Object.class, tags = {"rule-templates",})
    @io.swagger.annotations.ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation", response = Object.class)})
    public Response getRuleTemplate(@Context Request request,
                                    @ApiParam(value = "ID of the template group", required = true)
                                    @PathParam("templateGroupID") String templateGroupID,
                                    @ApiParam(value = "ID of the rule template", required = true)
                                        @PathParam("ruleTemplateID") String ruleTemplateID)
            throws NotFoundException {
        return delegate.getRuleTemplate(request, templateGroupID, ruleTemplateID);
    }

    @GET
    @Path("/template-groups/{templateGroupID}/templates")

    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Returns rule templates",
            notes = "Gets rule templates available under the template group with the given ID",
            response = Object.class, responseContainer = "List", tags = {"rule-templates",})
    @io.swagger.annotations.ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation",
                    response = Object.class, responseContainer = "List")})
    public Response getRuleTemplates(@Context Request request,
                                     @ApiParam(value = "ID of the template group", required = true)
                                     @PathParam("templateGroupID") String templateGroupID)
            throws NotFoundException {
        return delegate.getRuleTemplates(request, templateGroupID);
    }

    @GET
    @Path("/template-groups/{templateGroupID}")

    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Returns a template group",
            notes = "Gets template group that has the given ID", response = Object.class, tags = {"template-groups",})
    @io.swagger.annotations.ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation", response = Object.class),

            @io.swagger.annotations.ApiResponse(code = 404, message = "Template group not found",
                    response = Object.class)})
    public Response getTemplateGroup(@Context Request request,
                                     @ApiParam(value = "ID of the template group", required = true)
                                     @PathParam("templateGroupID") String templateGroupID)
            throws NotFoundException {
        return delegate.getTemplateGroup(request, templateGroupID);
    }

    @GET
    @Path("/template-groups")

    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Returns template groups",
            notes = "Gets available template groups", response = Object.class, responseContainer = "List",
            tags = {"template-groups",})
    @io.swagger.annotations.ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation", response = Object.class,
                    responseContainer = "List")})
    public Response getTemplateGroups(@Context Request request)
            throws NotFoundException {
        return delegate.getTemplateGroups(request);
    }

    @GET
    @Path("/instances/{businessRuleInstanceID}")

    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Returns a business rule instance",
            notes = "Gets a business rule instance that has the given ID", response = Object.class,
            tags = {"business-rules",})
    @io.swagger.annotations.ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation", response = Object.class),

            @io.swagger.annotations.ApiResponse(code = 404, message = "Business rule not found",
                    response = Object.class)})
    public Response loadBusinessRule(@Context Request request,
                                     @ApiParam(value = "ID of the business rule to be loaded", required = true)
                                     @PathParam("businessRuleInstanceID") String businessRuleInstanceID
    )
            throws NotFoundException {
        return delegate.loadBusinessRule(request, businessRuleInstanceID);
    }

    @GET
    @Path("/instances/{businessRuleInstanceID}/deployment-info")
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Returns deployment information of a business rule instance",
            notes = "Gets deployment information of the business rule instance that has the given ID",
                response = Object.class,
            tags = {"business-rules",})
    @io.swagger.annotations.ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = Object.class),

            @io.swagger.annotations.ApiResponse(code = 404, message = "Business rule not found",
                    response = Object.class)})
    public Response loadDeploymentInfo(@Context Request request,
                                     @ApiParam(value = "ID of the business rule instance", required = true)
                                     @PathParam("businessRuleInstanceID") String businessRuleInstanceID
    )
            throws NotFoundException {
        return delegate.loadDeploymentInfo(request, businessRuleInstanceID);
    }

    @POST
    @Path("/instances/{businessRuleInstanceID}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Redeploys the specified business rule instance.",
            response = Object.class, responseContainer = "List", tags = {"business-rules",})
    @io.swagger.annotations.ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation", response = Object.class,
                    responseContainer = "List"),

            @io.swagger.annotations.ApiResponse(code = 405, message = "Business rule validation exception",
                    response = Object.class, responseContainer = "List")})
    public Response redeployBusinessRule(@Context Request request,
                                         @ApiParam(value = "UUID of the business rule which needed to be re-deployed.",
            required = true) @PathParam("businessRuleInstanceID") String businessRuleInstanceID,
                                         @DefaultValue("false") @QueryParam("shouldUndeploy") Boolean shouldUndeploy)
            throws NotFoundException {
        return delegate.deployOrUndeployBusinessRule(request, businessRuleInstanceID, shouldUndeploy);
    }

    @PUT
    @Path("/instances/{businessRuleInstanceID}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Updates a business rule instance",
            notes = "Updates a business rule instance that has the given ID", response = void.class,
            tags = {"business-rules",})
    @io.swagger.annotations.ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation", response = void.class),

            @io.swagger.annotations.ApiResponse(code = 404, message = "Business rule not foound", response = void.class),

            @io.swagger.annotations.ApiResponse(code = 405, message = "Business rule validation exception",
                    response = void.class)})
    public Response updateBusinessRule(@Context Request request,
                                       @ApiParam(value = "Updated business rules name", required = true)
                                               Object businessRule,
                                       @ApiParam(value = "ID of the business rule to be edited", required = true)
                                           @PathParam("businessRuleInstanceID") String businessRuleInstanceID,
                                       @ApiParam(value = "Query parameter for deployment", required = true)
                                       @DefaultValue("true") @QueryParam("deploy") Boolean deploy)
            throws NotFoundException {
        return delegate.updateBusinessRule(request, businessRule, businessRuleInstanceID, deploy);
    }

    @POST
    @Path("/manager/deploy")
    @Consumes({"text/plain"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Deploy Siddhi App",
            notes = "Deploy siddhi application in server node", response = void.class,
            tags = {"manager",})
    @io.swagger.annotations.ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation", response = void.class),

            @io.swagger.annotations.ApiResponse(code = 405, message = "siddhi app validation exception",
                    response = void.class)})
    public Response deploySiddhiApp(@Context Request request,
                                       @ApiParam(value = "Updated business rules name", required = true)
                                               Object siddhiApp)
            throws NotFoundException {
        return delegate.deploySiddhiApp(request, siddhiApp);
    }

    @DELETE
    @Path("/manager/{siddhiApplication}")
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Deletes a siddhi app",
            notes = "Deletes the siddhi appplication provideed", response = void.class,
            tags = {"manager",})
    @io.swagger.annotations.ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "Siddhi Application is successfully deleted.",
                    response = void.class),
            @io.swagger.annotations.ApiResponse(code = 404, message = "Siddhi app not found",
                    response = void.class),
            @io.swagger.annotations.ApiResponse(code = 500, message = "Internal Server Error",
            response = void.class),})
    public Response deleteBusinessRule(@Context Request request,
                                       @ApiParam(value = "Name of the siddhi app to be deleted", required = true)
                                       @PathParam("siddhiApplication") String siddhiAppName)
            throws NotFoundException {
        return delegate.deleteSiddhiApp(request, siddhiAppName);
    }

    @PUT
    @Path("/manager/deploy")
    @Consumes({"text/plain"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Update deployed Siddhi App",
            notes = "Update siddhi application in server node", response = void.class,
            tags = {"manager",})
    @io.swagger.annotations.ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "siddhi App updated successfully",
                    response = void.class),
            @io.swagger.annotations.ApiResponse(code = 400, message = "validation error occured",
                    response = void.class),
            @io.swagger.annotations.ApiResponse(code = 404, message = "Siddhi app not found",
                    response = void.class),
            @io.swagger.annotations.ApiResponse(code = 500, message = "internal server error",
                    response = void.class),})
    public Response updateSiddhiApp(@Context Request request,
                                    @ApiParam(value = "Updated siddhi app", required = true) Object siddhiApp)
            throws NotFoundException {
        return delegate.updateSiddhiApp(request, siddhiApp);
    }

    @POST
    @Path("/manager/reShuffle")
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Suffel the deployed siddhi apps",
            notes = "Shuffle the deployed siddhi app equally accros the nodes", response = void.class,
            tags = {"manager",})
    @io.swagger.annotations.ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "Reshuffle Process completed successfully",
                    response = void.class),
            @io.swagger.annotations.ApiResponse(code = 403, message = "forbidden",
                    response = void.class),
            @io.swagger.annotations.ApiResponse(code = 500, message = "Internal Server Error",
                    response = void.class)})
    public Response reShuffle(@Context Request request)
            throws NotFoundException {
        return delegate.reShuffle(request);
    }

}
