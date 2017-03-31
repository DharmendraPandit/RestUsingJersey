package com.rest.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import com.rest.exception.mapping.EmployeeNotFoundException;
import com.rest.exception.mapping.EmployeeNotFoundMapper;
import com.rest.model.Employee;
import com.rest.service.EmployeeService;
import com.rest.service.impl.EmployeeServiceImpl;

@Path("/employee")
public class EmployeeRestController {

	@Context 
	UriInfo uriInfo;
	
	
	public EmployeeRestController() {
		// TODO Auto-generated constructor stub
	}
	
	EmployeeService employeeService = new EmployeeServiceImpl();

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getEmployee(@PathParam("id") String id){
		
		
		System.out.println("getEmployee called.");
		Response response;
		
		try {
			Employee employee = employeeService.getEmployeeById(id);
			
			if(employee == null){
				throw new EmployeeNotFoundException();
			}
			response = Response.status(Response.Status.OK).entity(employee).build();
		}catch (EmployeeNotFoundException employeeNotFoundException) {
			response = new EmployeeNotFoundMapper().toResponse(employeeNotFoundException);
			System.out.println("in exception - "+response.getStatus());
		}
		
		
		return response;
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getEmployees(){
		List<Employee> employees = employeeService.getAllEmployees(); 
		
		return Response.status(Status.OK).entity(employees).build();
	}

	
	@GET
	  @Path("/list")
	  @Produces(MediaType.APPLICATION_JSON)
	  public Response employeeList() {
		
		MultivaluedMap<String, String> queryParams = uriInfo.getQueryParameters();
		
		String first = queryParams.getFirst("id");
		
		  System.out.println("employeeList() called...first - "+first);
		  
		  
	    Employee employee1 = new Employee();
	    employee1.setId("1");
	    employee1.setName("abc");
	    
	    Employee employee2 = new Employee();
	    employee2.setId("2");
	    employee2.setName("abc2");
	    
	    List<Employee> employees = new ArrayList<Employee>();
	    employees.add(employee1);
	    employees.add(employee2);
	    
	    return Response.status(Status.OK).entity(employees).build();
	  }
	  
	  @GET
	  @Path("/map")
	  @Produces(MediaType.APPLICATION_JSON)
	  public Response employeeMap() {
		  System.out.println("employeeMap() called");
		   
		  Map<String, Employee> employeeMap = new HashMap<String, Employee>();
		  
		  
	    Employee employee1 = new Employee();
	    employee1.setId("1");
	    employee1.setName("abc");
	    
	    Employee employee2 = new Employee();
	    employee2.setId("2");
	    employee2.setName("abc2");
	    
	    employeeMap.put("1", employee1);
	    employeeMap.put("2", employee2);
	    
	    return Response.status(Status.OK).entity(employeeMap).build();
	  }
	  
	  @POST
	  @Path("/post")
	  @Consumes(MediaType.APPLICATION_JSON)
	  @Produces(MediaType.APPLICATION_JSON)
	  public Response createEmployee(Employee employee){
		  
		  System.out.println("id - "+employee.getId()+", name - "+employee.getName());
		  
		  return Response.status(Status.CREATED).entity(employee).build();
		  
	  }
	  
	  @PUT
	  @Path("/put/{name}/query")
	  public String updateEmployee(@PathParam("name")String name, @QueryParam("queryparam")String queryParam){
		  System.out.println("path param - "+name);
		  System.out.println("queryParam - "+queryParam);
		  
		  return "employee updated.";
	  }
	  
	  @DELETE
	  @Path("/delete")
	  public String deleteEmployee(){
		  
		  return "employee deleted.";
	  }
	  
//	  @POST
	  @GET
		@Path("/add")
		public Response addUser(
			@FormParam("name") String name,
			@FormParam("age") String age) {

			return Response.status(200)
				.entity("addUser is called, name : " + name + ", age : " + age)
				.build();

		}
}
