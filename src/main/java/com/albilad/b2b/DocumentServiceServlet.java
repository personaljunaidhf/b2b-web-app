package com.albilad.b2b;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;

import com.sap.ecm.api.AbstractCmisProxyServlet;
import com.sap.ecm.api.EcmService;
import com.sap.ecm.api.RepositoryOptions;
import com.sap.ecm.api.RepositoryOptions.Visibility;


public class DocumentServiceServlet extends AbstractCmisProxyServlet {

	private static final long serialVersionUID = 1L;
	
    @Override
    public void init() throws ServletException {
              super.init();
              RepositoryOptions options = new RepositoryOptions();
              options.setUniqueName(getRepositoryUniqueName());
              options.setRepositoryKey(getRepositoryKey());
              options.setVisibility(Visibility.PROTECTED);
              InitialContext ctx = null;
              try {
                        ctx = new InitialContext();
                        String lookupName = "java:comp/env/" + "EcmService";
                        EcmService ecmSvc = (EcmService) ctx.lookup(lookupName);
                        ecmSvc.createRepository(options);
              } catch (NamingException e) {
                        e.printStackTrace();
              }
    }

	 public DocumentServiceServlet() {
	        super();
	    }
		    protected boolean supportAtomPubBinding() {
		        return false;
		    }
		    
		    protected boolean supportBrowserBinding() {
		        return true;
		    }
		    
		    protected String getRepositoryKey() {
		        return "Yxw4Q4w73B";
		    }
		    
		    protected String getRepositoryUniqueName() {
		        return "B2B_Document_Center";
		    }
	  
	  

}