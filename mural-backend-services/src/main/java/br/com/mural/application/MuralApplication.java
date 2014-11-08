/*
 * Pearson All Rights Reserved
 * Nelson Fernando da Silva Menetti - Developer 
 */
package br.com.mural.application;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import br.com.mural.services.EnterpriseServices;
import br.com.mural.services.ProfessionalServices;
import br.com.mural.services.UserServices;

/**
 * The Class ContentBundleApplication.
 *
 * @author Nelson Menetti
 */
public class MuralApplication extends Application
{
   
   /** The singletons. */
   HashSet<Object> singletons = new HashSet<Object>();

   /**
    * Instantiates a new content bundle application.
    */
   public MuralApplication()
   {
      singletons.add(new EnterpriseServices());
      singletons.add(new UserServices());
      singletons.add(new ProfessionalServices());      
   }

   /* (non-Javadoc)
    * @see javax.ws.rs.core.Application#getClasses()
    */
   @Override
   public Set<Class<?>> getClasses()
   {
      HashSet<Class<?>> set = new HashSet<Class<?>>();
      return set;
   }

   /* (non-Javadoc)
    * @see javax.ws.rs.core.Application#getSingletons()
    */
   @Override
   public Set<Object> getSingletons()
   {
      return singletons;  
   }
}