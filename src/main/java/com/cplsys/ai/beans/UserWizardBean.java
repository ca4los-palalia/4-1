package com.cplsys.ai.beans;

import java.util.ResourceBundle;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.event.FlowEvent;

import com.cplsys.ai.domain.User;
import com.cplsys.ai.utils.SendEmail;
import com.cplsys.ai.utils.SendEmail2;

@ManagedBean
@SessionScoped
public class UserWizardBean {

	private User user;
	private boolean skip;
    private static Logger logger;
    
    private String titleWizard1;
    private String titlePersonalDetails;
    private String titleWizard2;
    private String titleAddressDetails;
    private String titleWizard3;
    private String titleContactDetails;
    private String titleWizard4;
    private String titleConfirmationDetails;
    
    
    private String firstNameLabel;
	private String lastNameLabel;
	private String companyLabel;
	private String streetLabel;
	private String zipLabel;
	private String cityLabel;
	private String emailLabel;
	private String phoneLabel;
	private String commentLabel;
	private String outputName;
	private String outputAddress;
	private String sendButton;
  
    
    public UserWizardBean(){
    	user = new User();
    	logger = Logger.getLogger(UserWizardBean.class.getName());
    	initializerFormsText();
    }
    
    public User getUser() {  
        return user;  
    }  
  
    public void setUser(User user) {  
        this.user = user;  
    }  
      
    public void save(ActionEvent actionEvent) {  
        //Persist user  
          
        FacesMessage msg = new FacesMessage("Successful", "Thaks " + user.getFirstname() +", your message has been sended!");  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
        
        //SendEmail send = new SendEmail ();
        
        try{
        	String message =	"from: "+user.getEmail()+" | "+ user.getFirstname() +" "+ user.getLastname()+"\n"+
        						"Address: " + user.getStreet() +", "+user.getCity()+" | " +"phone: "+user.getPhone() + "\n"+
        						"zip: "+user.getPostalCode() + " | "+user.getCompany() + "\n\n" +
        						"MESSAGE:\n" + user.getInfo();
        	
        	//user.getAge()
        	
        	//send.Send("carlos.palalia", "palc840113", "carlos.palalia@aisa-automation.com", "Nuevo mensaje de contacto desde website AISA", message);
        	
        	SendEmail2 send;
        	send= new SendEmail2(user.getEmail(),"Nuevo mensaje de contacto desde website AISA",message);
        	
        	user.setCity("");
        	user.setEmail("");
        	user.setFirstname("");
        	user.setInfo("");
        	user.setLastname("");
        	user.setPhone("");
        	user.setPostalCode("");
        	user.setStreet("");
        	user.setCompany("");
        }
        catch(Exception em){}
        
    }  
      
    
    public String getOutputName() {
		return outputName;
	}

	public String getOutputAddress() {
		return outputAddress;
	}

	public String getTitlePersonalDetails() {
		return titlePersonalDetails;
	}

	public String getTitleAddressDetails() {
		return titleAddressDetails;
	}

	public String getTitleContactDetails() {
		return titleContactDetails;
	}

	public String getTitleConfirmationDetails() {
		return titleConfirmationDetails;
	}

	public boolean isSkip() {  
        return skip;  
    }  
  
    public void setSkip(boolean skip) {  
        this.skip = skip;  
    }  
    
    
    public String getTitleWizard1() {
		return titleWizard1;
	}

	public String getTitleWizard2() {
		return titleWizard2;
	}

	public String getTitleWizard3() {
		return titleWizard3;
	}

	public String getTitleWizard4() {
		return titleWizard4;
	}

	public String getFirstNameLabel() {
		return firstNameLabel;
	}

	public String getLastNameLabel() {
		return lastNameLabel;
	}

	public String getCompanyLabel() {
		return companyLabel;
	}

	public String getStreetLabel() {
		return streetLabel;
	}

	public String getZipLabel() {
		return zipLabel;
	}

	public String getCityLabel() {
		return cityLabel;
	}

	public String getEmailLabel() {
		return emailLabel;
	}

	public String getPhoneLabel() {
		return phoneLabel;
	}

	public String getCommentLabel() {
		return commentLabel;
	}

	public String getSendButton() {
		return sendButton;
	}
	
	
	public String onFlowProcess(FlowEvent event) {  
        logger.info("Current wizard step:" + event.getOldStep());  
        logger.info("Next step:" + event.getNewStep());  
          
        if(skip) {  
            skip = false;   //reset in case user goes back  
            return "confirm";  
        }  
        else {  
            return event.getNewStep();  
        }  
    }
    private void initializerFormsText() {
    	FacesContext jsfCtx= FacesContext.getCurrentInstance();
        ResourceBundle bundle = jsfCtx.getApplication().getResourceBundle(jsfCtx, "msg");
        
        
        titleWizard1 = bundle.getString("lbl.formTitle1");
    	titleWizard2 = bundle.getString("lbl.formTitle2");
    	titleWizard3 = bundle.getString("lbl.formTitle3");
    	titleWizard4 = bundle.getString("lbl.formTitle4");
    	
    	titlePersonalDetails = bundle.getString("lbl.formTitlePersonalDetails");
    	titleAddressDetails = bundle.getString("lbl.formTitleAddressDetails");
    	titleContactDetails = bundle.getString("lbl.formTitleContactDetails");
    	titleConfirmationDetails = bundle.getString("lbl.formTitleConfirmationDetails");		
    	
    	
    	firstNameLabel = bundle.getString("lbl.formFirstNameLabel");
    	lastNameLabel = bundle.getString("lbl.formLastNameLabel");
    	companyLabel = bundle.getString("lbl.formCompanyLabel");
    	
    	streetLabel = bundle.getString("lbl.formStreetLabel");
    	zipLabel = bundle.getString("lbl.formZipLabel");
    	cityLabel = bundle.getString("lbl.formCityLabel");
    	
    	emailLabel = bundle.getString("lbl.formEmailLabel");
    	phoneLabel = bundle.getString("lbl.formPhoneLabel");
		commentLabel = bundle.getString("lbl.formCommentLabel");
		
		outputName = bundle.getString("lbl.formLabelOutputName");
		outputAddress =bundle.getString("lbl.formLabelOutputAddress");
		
		
		
		sendButton =  bundle.getString("lbl.sendButton");
    }
}
