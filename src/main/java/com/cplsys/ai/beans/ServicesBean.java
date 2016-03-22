package com.cplsys.ai.beans;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.cplsys.ai.domain.Service;

@ManagedBean
@SessionScoped
public class ServicesBean {

	private Service service;
	private List<Service> servicesElectric;
	private List<Service> servicesSoftware;
	

	public ServicesBean() {  
    	servicesElectric = new ArrayList<Service>();
    	servicesSoftware = new ArrayList<Service>();
    	
    	
    	loadInformation();
    	 
    }
    
    
	public List<Service> getServicesElectric() {
		return servicesElectric;
	}
    
	public List<Service> getServicesSoftware() {
		return servicesSoftware;
	}
	
    private void loadInformation() {
		
		FacesContext jsfCtx= FacesContext.getCurrentInstance();
        ResourceBundle bundle = jsfCtx.getApplication().getResourceBundle(jsfCtx, "msg");
        
        for (int i = 1; i <= 23; i++) {
        	service = new Service();
        	service.setNombre(bundle.getString("lbl.proNservElectrical"+i+"SubName"));
        	service.setDescripcion(bundle.getString("lbl.proNservElectrical"+i+"SubDesc"));
        	service.setTipoServicio("Electric");
        	
        	servicesElectric.add(service);

		}
        
        for (int i = 1; i <= 9; i++) {
        	service = new Service();
        	service.setNombre(bundle.getString("lbl.proNservSoftware"+i+"SubName"));
        	service.setDescripcion(bundle.getString("lbl.proNservSoftware"+i+"SubDesc"));
        	service.setTipoServicio("Software");
        	
        	servicesSoftware.add(service);

		}
	}


	public Service getService() {
		return service;
	}


	public void setService(Service service) {
		this.service = service;
	}



	
    
}
