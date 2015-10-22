package org.itc.controller;

import java.io.EOFException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.itc.model.Document;
import org.itc.model.Role;
import org.itc.model.Status;
import org.itc.model.User;
import org.itc.model.UserDetails;
import org.itc.model.UserStatus;
import org.itc.service.DocumentService;
import org.itc.service.UserDetailsService;
import org.itc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;



@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private DocumentService documentService;
	
		
	@RequestMapping(value="/login",method = RequestMethod.POST, consumes={"application/json"})
    public @ResponseBody User getUserInfo(@RequestBody User user) throws EOFException  {
		
    	try{
    			
    			user = userService.findUser(user.getUserName(), user.getPassword(), user.getRole());
    		
    			if(user !=null)
    			{
    		    	return user;
    			}
    			else
    			{
    				return user;
    			}
    	    }
    	catch(Exception e)
    	        {
    	            e.printStackTrace();
    	        }
    	
    	return user;

    }
	
	@RequestMapping(value="/signup", method = RequestMethod.POST, consumes={"application/json"})
	 public @ResponseBody User addUser(@RequestBody User user) { 
		try
		{
			Role role = new Role();
			role.setRoleId(2);		
			user.setRole(role);
		
			UserStatus userstatus=new  UserStatus();
			userstatus.setUserstatusId(2);
			user.setUserstatus(userstatus);
		
			userService.addUser(user);
			return user;
		}
		catch(Exception se)
		{
			se.getMessage();
			return null;
			
		}
		
	}
	
	@RequestMapping(value="/logout", method = RequestMethod.POST, consumes={"application/json"})
	public @ResponseBody void LogoutUser(@RequestBody int userId) {
		
		userService.LogoutUser(userId);
		System.out.println("inside logout");
		

	}
	
	
	@RequestMapping(value="/userdetails", method = RequestMethod.POST, consumes={"application/json"})
	public @ResponseBody UserDetails addUserDetails(@RequestBody UserDetails userDetails) throws ParseException, DataIntegrityViolationException {
		
				
		if(userDetails.getId() == 0 )
		{
			Status status=new Status();
			status.setStatusId(1);
			userDetails.setStatus(status);
		}
		
		userDetails = userDetailsService.addUserDetails(userDetails);
		
		System.out.println("Inside adding new UserDetails block Controller Class");
	
		return userDetails;
	}
	
	
	@RequestMapping(value="/viewuserdetails", method = RequestMethod.POST, consumes={"application/json"})
	public @ResponseBody List<UserDetails> showUserDetails(@RequestBody int userId) throws ParseException {
	
		
		List<UserDetails> viewuserDetails = userDetailsService.showUserDetails(userId);
		
		System.out.println("Inside viewuserdetails block Controller Class");
		return  viewuserDetails;
		
	}
	
	
	@RequestMapping(value="/getAlldetails", method = RequestMethod.GET, produces={"application/json"})
	public @ResponseBody List<UserDetails> getAllDetails() throws ParseException {
		 
		List<UserDetails> viewuserDetails = userDetailsService.getAllDetails();
		  
		  System.out.println("Inside Admin Java Controller");
		  return viewuserDetails;
		 
		 }
	
	@RequestMapping(value="/editUserdetails", method = RequestMethod.POST, consumes={"application/json"})
	 public @ResponseBody UserDetails editUserdetails(@RequestBody int id) throws ParseException {
	  
	  UserDetails viewuserDetails = userDetailsService.editUserdetails(id);
	  
	  System.out.println("Inside viewuserdetails block Controller Class");
	  return viewuserDetails;
	 
	 }
	
	@RequestMapping(value="/checkforId", method = RequestMethod.POST, consumes={"application/json"})
	public @ResponseBody UserDetails checkforId(@RequestBody User user) throws ParseException {
	
		UserDetails viewuserDetails = userDetailsService.checkforId(user);
		
		System.out.println("Inside viewuserdetails block Controller Class");
		return viewuserDetails;
		
	}
	
	
	@RequestMapping(value="/recordforid", method = RequestMethod.POST, produces={"application/json"})
	public @ResponseBody UserDetails recordforid(@RequestBody int id) throws ParseException {
	
		UserDetails viewuserDetailsid = userDetailsService.recordforid(id);
		return viewuserDetailsid;
	
	}
	
	
	
	@RequestMapping(value = "/multipleSave", method = RequestMethod.POST)
	
	 public @ResponseBody void uploadFile(MultipartHttpServletRequest request, HttpServletResponse response) throws IOException {
        			
		System.out.println("HEEEEEEEEEEEEEEEEEEEE");
					Iterator<String> fileName=request.getFileNames();
        			System.out.println(fileName);
        			 MultipartFile file= request.getFile(fileName.next());
					System.out.println("inside File Upload controller");
		
		        /* Iterator<String> itr=request.getFileNames();
		             System.out.println(itr);
		             System.out.println(itr.hasNext());
		            System.out.println(request.getFileNames());*/
		             /*System.out.println(itr.toString());
		             MultipartFile file= request.getFile(itr.toString());
		             MultipartFile file1=request.getFile(itr.next());
		             String fileName=file1.getOriginalFilename();
		             System.out.println(fileName);*/
                  
             		/* Document doc = new Document();
            		 doc.setDocument(file.getBytes());
           		     documentService.addItem(doc); 
        	*/
	 }
	
	
	@RequestMapping(value = "/viewDoc", method = RequestMethod.POST, produces={"application/json"})
	
	 public @ResponseBody List<Document> viewFile(@RequestBody int id) throws IOException {
		
		List<Document> doc = documentService.getDoc(id);
		
		return doc;
	
		
		
	}

}

