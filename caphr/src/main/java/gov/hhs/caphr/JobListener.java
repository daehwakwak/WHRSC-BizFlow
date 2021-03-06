package gov.hhs.caphr;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JobListener extends JobExecutionListenerSupport {

	@Autowired
	private EmailService emailService;

	private String jobName;
	private String exitStatus;	
	private String exitDescription;
	private Map<String,Object> parametersMap;
	
	private static final Logger log = LoggerFactory.getLogger(JobListener.class);
	
	@Value("${send.email.notification}")
	private boolean sendEmailNotification;

	//Callback before a job executes.
	@Override
	public void beforeJob(JobExecution jobExecution) {
	}

	//Callback after completion of a job. Called after both both successful and failed executions.
	@Override
	public void afterJob(JobExecution jobExecution) {
		this.jobName = jobExecution.getJobInstance().getJobName();
		this.exitStatus = jobExecution.getExitStatus().getExitCode().toString().replace("exitCode=", " "); 	
		this.exitDescription = jobExecution.getExitStatus().getExitDescription().toString().replace("exitDescription=", " ");
		
		this.parametersMap = new HashMap<String,Object>();
		if(exitDescription.length()>0){
			parametersMap.put("EXIT_DESCRIPTION", exitDescription);
		}

		if (sendEmailNotification) {
			emailService.sendEmail(jobName,exitStatus,parametersMap);
		}

	}
}
