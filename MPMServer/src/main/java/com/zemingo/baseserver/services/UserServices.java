package com.zemingo.baseserver.services;

import java.io.IOException;
import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wordnik.swagger.annotations.ApiResponses;
import com.wordnik.swagger.annotations.ApiResponse;
import com.zemingo.baseserver.model.User;
import com.zemingo.baseserver.services.requests.BaseRequest;
import com.zemingo.baseserver.services.requests.LoginRequest;
import com.zemingo.baseserver.services.requests.RegisterUserRequest;
import com.zemingo.baseserver.services.requests.UpdateDeviceRequest;
import com.zemingo.baseserver.services.response.EmptyResponse;
import com.zemingo.baseserver.services.response.LoginResponse;

@Path("user")
@Api(value="user", description="Operations about users")
public class UserServices extends BaseServices{	
	

	
	@POST
	@Path("/login")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Login to the system",  
	notes = "login explanation", response = LoginResponse.class)
	@ApiResponses(value = {
	  @ApiResponse(code = 200, message = "Success")
	   })
	public String login(LoginRequest loginRequest)
	{			
		//TODO: add validation: token and request
		System.out.println("got login request");
		System.out.println(loginRequest.username);
		
		//asaf comment
		//asaf comment2
		//TODO: do work on BL layer, update the DB if needed
		
		//TODO: return answer
		
		//TODO: move to BL				
		
		//Niv comment
		responseWrapper.setResponse(null, new LoginResponse(UUID.randomUUID().toString())); //for example
		try {
			responseJson = jsonMapper.writeValueAsString(responseWrapper);
		} catch (IOException e) {
			//TODO: deal with exception return an error code
			e.printStackTrace();
		}
		return responseJson;
	}
	
	@POST
	@Path("/register")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Register into to the system (sign up)",  
	notes = "Register notes", response = LoginResponse.class)
	@ApiResponses(value = {
	  @ApiResponse(code = 200, message = "Success")
	   })
	public String register(RegisterUserRequest registerRequest)
	{
		return login(null); //on this example, bahave as same as login
	}
	
	@POST
	@Path("/logout")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "logout from the system",  
	notes = "Logout from the system")
	@ApiResponses(value = {
	  @ApiResponse(code = 200, message = "Success")
	   })
	public String logout(BaseRequest registerRequest)
	{
		//TODO: add validation: token and request
								
		//TODO: do work on BL layer, update the DB if needed				
		
		responseWrapper.setResponse(null, new EmptyResponse()); //exampl: return an empty response
		try {
			responseJson = jsonMapper.writeValueAsString(responseWrapper);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return responseJson;

	}
	
	@POST
	@Path("/updateDevice")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Update device properties",  
	notes = "Used for updating PnToken, timeZone etc.")
	@ApiResponses(value = {
	  @ApiResponse(code = 200, message = "Success")
	   })
	public String updateDevice(UpdateDeviceRequest registerRequest)
	{
		responseWrapper.setResponse(null, new EmptyResponse());
		try {
			responseJson = jsonMapper.writeValueAsString(responseWrapper);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return responseJson;

	}
	
	//Example to get request
	@GET
	@Path("/verifyemail")
	@Produces(MediaType.TEXT_HTML)
	@ApiOperation(value = "Verify email address", notes="Email address verification")
	public String verifyemail(@QueryParam("verificationToken") String verificationToken)
	{
		return verificationToken == null ? "nnull" : "Your verification token is "+ verificationToken;
	}

	@GET
	@Path("/hello/{param}")
	@ApiOperation(value="just to test the sample api")
	public Response getMsg(@ApiParam(value="param",required=true)@PathParam("param") String msg ) {
		String output = "Hello : " + msg;
		return Response.status(200).entity(output).build();
	}
	
	@GET
	@Path("/createUser/{name}/{description}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "creating user")
	public User createUser (@PathParam("name") String name,@PathParam("description") String description){
		User user = new User();
		return user;
	}
	
}
