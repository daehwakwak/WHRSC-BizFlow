package gov.hhs.usas.dss;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import javax.net.ssl.SSLContext;
import javax.xml.rpc.ServiceException;

import org.apache.axis.message.SOAPHeaderElement;

import com.cognos.developer.schemas.bibus._3.AuthServiceBindingStub;
import com.cognos.developer.schemas.bibus._3.AuthServiceLocator;
import com.cognos.developer.schemas.bibus._3.ReportDataServicePort;
import com.cognos.developer.schemas.ccs.auth.types._1.CredentialElementType;
import com.cognos.developer.schemas.ccs.auth.types._1.CredentialType;
import com.cognos.developer.schemas.ccs.auth.types._1.LogoffRequestType;
import com.cognos.developer.schemas.ccs.auth.types._1.LogoffResponseType;
import com.cognos.developer.schemas.ccs.auth.types._1.LogonRequestType;
import com.cognos.developer.schemas.ccs.auth.types._1.LogonResponseType;
import com.cognos.developer.schemas.ccs.auth.types._1.ValueElementType;
import com.cognos.developer.schemas.rds.types._2.GetOutputRequest;
import com.cognos.developer.schemas.rds.types._2.GetOutputResponse;
import com.cognos.developer.schemas.rds.types._2.GetReportDataRequest;
import com.cognos.developer.schemas.rds.types._2.PromptValue;
import com.cognos.developer.schemas.rds.types._2.SessionTypeStatus;
import com.cognos.developer.schemas.rds.types._2.SourceTypeEnum;

public class Authentication {

    SOAPHeaderElement[] logon(String namespace, String username, String password, String url) throws MalformedURLException, ServiceException, RemoteException, NoSuchAlgorithmException, KeyManagementException {
		AuthServiceLocator authlocator = new AuthServiceLocator();
		//AuthServicePort authService = (AuthServicePort) authlocator.getAuthServicePort(new URL(serverURL));
		AuthServiceBindingStub authservice = (AuthServiceBindingStub) authlocator.getAuthServicePort(new URL(url)) ;
		CredentialType credentialType = new CredentialType();

		CredentialElementType nameSpaceElement = new CredentialElementType();
		ValueElementType nameSpaceValue = new ValueElementType();
		nameSpaceValue.setActualValue(namespace);
		nameSpaceElement.setName("CAMNamespace");
		nameSpaceElement.setValue(nameSpaceValue);

		CredentialElementType userNameElement = new CredentialElementType();
		ValueElementType userNameValue = new ValueElementType();
		userNameValue.setActualValue(username);
		userNameElement.setName("CAMUsername");
		userNameElement.setValue(userNameValue);

		CredentialElementType passWordElement = new CredentialElementType();
		ValueElementType passWordValue = new ValueElementType();
		passWordValue.setActualValue(password);
		passWordElement.setName("CAMPassword");
		passWordElement.setValue(passWordValue);

		//Login IBM Cognos server using the CMS Authentication Service
		System.setProperty("http.agent", "Mozilla/5.0 (compatible, MSIE 11, Windows NT 6.3; Trident/7.0;  rv:11.0)");
		System.setProperty("https.protocols", "TLSv1.1,TLSv1.2");
		//Force TLSv1.2 with JDK 1.7 runtime environment
		SSLContext ctx = SSLContext.getInstance("TLSv1.2");
		ctx.init(null, null, null);
		SSLContext.setDefault(ctx);		
		credentialType.setCredentialElements(new CredentialElementType[]{nameSpaceElement,userNameElement,passWordElement});
		LogonRequestType logonRequest = new LogonRequestType(credentialType, null);
		@SuppressWarnings("unused")
		LogonResponseType logonResponse = authservice.logon(logonRequest);
		//Copy the SOAP header from the Authentication Service to CMS
		return ((org.apache.axis.client.Stub) authservice).getResponseHeaders();    	
    }
    
    
	void logoff(ReportDataServicePort rdsservice, SOAPHeaderElement[] headers, String COGNOS_URL) throws Exception {
		AuthServiceLocator authlocator = new AuthServiceLocator();
		//AuthServicePort authService = (AuthServicePort) authlocator.getAuthServicePort(new URL(serverURL));
		AuthServiceBindingStub authservice = (AuthServiceBindingStub) 
				authlocator.getAuthServicePort(new URL(COGNOS_URL)) ;

		((org.apache.axis.client.Stub) authservice).setHeader(headers[0]);

		//The user is logged off from IBM Cognos server
		LogoffRequestType LogoffRequest = new LogoffRequestType();
		@SuppressWarnings("unused")
		LogoffResponseType logoff = authservice.logoff(LogoffRequest);
	}
	
	//Get report data from report with prompts
	String getReportData(ReportDataServicePort rdsservice, String reportPath, String format, PromptValue[] prompts) throws Exception {
		GetReportDataRequest reportFormatRequest = new GetReportDataRequest();
		
		reportFormatRequest.setFormat(format);
		reportFormatRequest.setSourceID(reportPath);
		reportFormatRequest.setSourceType(SourceTypeEnum.searchPath);
		reportFormatRequest.setPromptValues(prompts);
			
		GetOutputResponse response = rdsservice.getReportData(reportFormatRequest);
		//An asynchronous request, the application loops until the report output is returned
		while (response.getSession().getStatus().getValue() == SessionTypeStatus._working)
		{
			GetOutputRequest oreq = new GetOutputRequest(response.getSession(), null);
			SOAPHeaderElement[] headers = ((org.apache.axis.client.Stub) rdsservice).getResponseHeaders();
			((org.apache.axis.client.Stub) rdsservice).setHeader(headers[0]);
			response = rdsservice.getOutput(oreq);
		}

		return response.getOutput().getFormatOutput();    	
    }	
	
	//Get report data from report without prompts
	String getReportData(ReportDataServicePort rdsservice, String reportPath, String format) throws Exception {
		GetReportDataRequest reportFormatRequest = new GetReportDataRequest();
		
		reportFormatRequest.setFormat(format);
		reportFormatRequest.setSourceID(reportPath);
		reportFormatRequest.setSourceType(SourceTypeEnum.searchPath);
		//reportFormatRequest.setSourceType(SourceTypeEnum.path);	
		GetOutputResponse response = rdsservice.getReportData(reportFormatRequest);
		//An asynchronous request, the application loops until the report output is returned
		while (response.getSession().getStatus().getValue() == SessionTypeStatus._working)
		{
			GetOutputRequest oreq = new GetOutputRequest(response.getSession(), null);
			SOAPHeaderElement[] headers = ((org.apache.axis.client.Stub) rdsservice).getResponseHeaders();
			((org.apache.axis.client.Stub) rdsservice).setHeader(headers[0]);
			response = rdsservice.getOutput(oreq);
		}

		return response.getOutput().getFormatOutput();    	
    }
	
}
