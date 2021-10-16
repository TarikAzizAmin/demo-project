package tarik.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import tarik.exception.ResourceNotFoundException;
import tarik.model.Employee;
import tarik.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
	
	@Autowired
	private  EmployeeRepository employeeRepository;
	
	
	@GetMapping("/all")
	public List<Employee> getAllEmployee(){
		return employeeRepository.findAll();
	}
	
	@PostMapping("/add")
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}
	
	@GetMapping("employee/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id) {
		Employee employee = employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("employee with id "+id+" does not exist"));
		return ResponseEntity.ok(employee);
	}
	
	@PutMapping("update/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long id,@RequestBody Employee employee){
		Employee employee2 = employeeRepository.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("employee with id "+id+" does not exist"));
		
		employee2.setFirstName(employee.getFirstName());
		employee2.setLastName(employee.getLastName());
		employee2.setEmailId(employee.getEmailId());
		employee2.setPhNo(employee.getPhNo());
		employee2.setImgUrl(employee.getImgUrl());
		employee2.setDesignation(employee.getDesignation());
		
		
		Employee updatedEmployee = employeeRepository.save(employee2);
		return ResponseEntity.ok(updatedEmployee);
	
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable("id") Long id){
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("employee with id "+id+" does not exist"));
		employeeRepository.delete(employee);
		Map<String, Boolean> response = new HashMap<String, Boolean>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
	
}
