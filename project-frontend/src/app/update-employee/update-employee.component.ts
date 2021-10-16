import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Employee } from '../model/employee';
import { EmployeeService } from '../service/employee.service';

@Component({
  selector: 'app-update-employee',
  templateUrl: './update-employee.component.html',
  styleUrls: ['./update-employee.component.css']
})
export class UpdateEmployeeComponent implements OnInit {

  employee:Employee = new Employee();
  id:number =0;
  constructor(private employeeService:EmployeeService,
    private activatedRoute:ActivatedRoute,
    private router:Router) { }

  ngOnInit(): void {
   
   this.id=this.activatedRoute.snapshot.params["id"];
   this.employeeService.getEmployeeById(this.id).subscribe(data=>{
     this.employee=data;
   },error=>console.log(error)
   );

  }

  onSubmit(){
    return this.employeeService.updateEmployee(this.id, this.employee).subscribe(data=>{
      this.employee=data;
      this.goTOEmployeeList();
    },
      error=>console.log(error)
    )
  }
goTOEmployeeList(){
  this.router.navigate(["/employees"])
}


onClick(){
  this.onSubmit();
}

}
