import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Employee } from '../model/employee';
import { EmployeeService } from '../service/employee.service';

@Component({
  selector: 'app-employee-details',
  templateUrl: './employee-details.component.html',
  styleUrls: ['./employee-details.component.css']
})
export class EmployeeDetailsComponent implements OnInit {

  imageUrl:string="assets/images/avatar6.png";

  id:number=0;
  employee:Employee= new Employee();



  constructor(private activatedRoute:ActivatedRoute,
    private employeeService:EmployeeService,
    private router:Router) { }

  ngOnInit(): void {
    this.id=this.activatedRoute.snapshot.params['id'];
    this.employeeService.getEmployeeById(this.id).subscribe(data=>{
      this.employee=data
      
    })
  }


  goToEmployeeList(){
    this.router.navigate(["/"])
  }
  

}
