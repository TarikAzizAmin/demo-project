 import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from '../model/employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  
private baseUrl="http://localhost:8080/api/v1";


  constructor(private httpClient:HttpClient) { }

  getEmployeesList():Observable<Employee[]>{
    return this.httpClient.get<Employee[]>(`${this.baseUrl}/all`)
  }

  addEmployee(employee:Employee):Observable<Employee>{
    return this.httpClient.post<Employee>(`${this.baseUrl}/add`, employee);
  }

  getEmployeeById(id:number):Observable<Employee>{
    return this.httpClient.get<Employee>(`${this.baseUrl}/employee/${id}`)
  }


  updateEmployee(id:number, employee:Employee):Observable<Employee>{
      return this.httpClient.put<Employee>(`${this.baseUrl}/update/${id}`, employee);
  }

  deleteEmployee(id:number):Observable<Object>{
    return this.httpClient.delete<Object>(`${this.baseUrl}/delete/${id}`)
  }
  
}
