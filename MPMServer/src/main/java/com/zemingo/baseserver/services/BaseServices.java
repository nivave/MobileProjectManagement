package com.zemingo.baseserver.services;

import java.io.IOException;
//import java.util.logging.Logger;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

import com.zemingo.baseserver.ACErrorEnum;
//import com.zemingo.baseserver.GlobalData;
import com.zemingo.baseserver.services.JSonValidator;
import com.zemingo.baseserver.util.ACLogger;
import com.zemingo.baseserver.services.response.ValidationError;


public class BaseServices {

	protected JSonValidator mJValidator;
	protected Log LOG;
	protected ObjectMapper jsonMapper = new ObjectMapper();
	protected String[] mandatoryParams;
	protected ServiceResponse responseWrapper;
	protected String responseJson;

	/*********************************************************************
	 * BaseServices
	 ********************************************************************/
	public BaseServices() {
//		if (!GlobalData.SERVER_INITIATED) {
//			GlobalData.initiateServer();
//		}
//
//		LOG = ACLogger.getLogger();
		LOG = LogFactory.getLog(BaseServices.class);		
		mJValidator = new JSonValidator();
		responseWrapper = new ServiceResponse();
	}

	/**********************************************************************
	 * 
	 * generateUnknownErrorJson
	 * 
	 **********************************************************************/
	public String generateUnknownErrorJson() {
		String jsonErr;
		jsonErr = "{\"errorObj\":{\"errorCode\":999,\"errorDesc\":\"Unknown Error\",\"errorMessage\":\"Unknown Error\"},\"result\":null}";
		return jsonErr;
	}

	public void setInvalidUserTokenResponse() {
		responseWrapper.setResponse(
				ACError.factory(ACErrorEnum.ERROR_INVALID_USER_TOKEN), null);
		try {
			responseJson = jsonMapper.writeValueAsString(responseWrapper);
		} catch (IOException e) {
			e.printStackTrace();
			responseJson = generateUnknownErrorJson();
		}
	}

	protected String jSonMapperToReturnString(ObjectMapper jmap,
			ServiceResponse res) {
		try {
			responseJson = (jmap.writeValueAsString(res));
			return responseJson;
		} catch (IOException e) {
			return generateUnknownErrorJson();
		}
	}

	protected JsonNode readAndValidateObject(String pJsonReq,
			ValidationError errorResponse) {
		JsonNode actualObj = null;
		try {
			actualObj = null;
			try {
				actualObj = jsonMapper.readTree(pJsonReq);
			} catch (Exception e) {
				responseWrapper.setResponse(ACError
						.factory(ACErrorEnum.ERROR_JSON_OBJECT_IS_NOT_VALID),
						null);				
				LOG.error("JSON object is not valid -- "
						+ responseWrapper.ErrorObj.errorDesc);
				errorResponse.setError(jsonMapper
						.writeValueAsString(responseWrapper));
				return null;
			}

			// Validation mandatory members
			if (!mJValidator.validateJsonKeysExist(actualObj, mandatoryParams)) {
				String missParams = "Missing params: "
						+ mJValidator.getMeissingKeysAsString();
				responseWrapper.setResponse(ACError.factory(
						ACErrorEnum.ERROR_JSON_KEY_IS_MISSING, missParams),
						null);
				LOG.error("JSON validation failed, error: "
						+ responseWrapper.ErrorObj.errorDesc + missParams);
				errorResponse.setError(jsonMapper
						.writeValueAsString(responseWrapper));
			}
		} catch (Exception e) {
			LOG.error("Excetion: " + e.getMessage() + ". "
					+ ACLogger.stackTraceToString(e));
			errorResponse.setError(generateUnknownErrorJson());
		}

		return actualObj;

	}

}
