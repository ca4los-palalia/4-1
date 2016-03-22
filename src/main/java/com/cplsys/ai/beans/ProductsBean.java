package com.cplsys.ai.beans;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.cplsys.ai.domain.Product;

@ManagedBean
@SessionScoped
public class ProductsBean {

	private List<Product> products;
	private Product product;
	  
    public ProductsBean() {  
    	products = new ArrayList<Product>();
    	loadInformation();
    	 
    }
    
    public List<Product> getProducts() {
		return products;
	}



	public void setProducts(List<Product> products) {
		this.products = products;
	}



	private void loadInformation() {
		
		FacesContext jsfCtx= FacesContext.getCurrentInstance();
        ResourceBundle bundle = jsfCtx.getApplication().getResourceBundle(jsfCtx, "msg");
        
        for (int i = 1; i <= 18; i++) {
        	product = new Product();
        	product.setNameImage("img"+i+".png");
        	product.setName(bundle.getString("lbl.proNservProduct"+i+"Title"));
        	product.setDescripcion(bundle.getString("lbl.proNservProduct"+i+"Desc"));
        	products.add(product);
		}
	}
}
