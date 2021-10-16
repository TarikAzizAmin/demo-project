import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Employee } from '../model/employee';
import { EmployeeService } from '../service/employee.service';

@Component({
  selector: 'app-create-employee',
  templateUrl: './create-employee.component.html',
  styleUrls: ['./create-employee.component.css']
})
export class CreateEmployeeComponent implements OnInit {

  employee:Employee = new Employee();

  public userFile:any= File;
  public formData:FormData = new FormData();

  constructor(private employeeService:EmployeeService,
    private router:Router) { }

  ngOnInit(): void {
  }




// // for image uploading
//  onFileChange(event:Event){

//   // const target = event.target as HTMLInputElement;
//   // const file: File = (target.files as FileList)[0];
//   // console.log(file)


//   // this.userFile = file;

// }








      onSubmit(){
      // console.log(this.employee)
        //this.saveForm()
        this.saveEmployee();
      }




  //works when we click the submit button
  saveForm(){

    // this.formData.append("employee",  JSON.stringify(this.employee));
    // this.formData.append("image", this.userFile);
    // console.log(this.formData);

   

  }
  

  
  //using sevice to send the employee through http post request to save in the DB
  saveEmployee(){
    this.employeeService.addEmployee(this.employee).subscribe(data=>{
      console.log(data);
      this.goToEmployeeList()
      
    },
    error=>console.log(error))
  }




  goToEmployeeList(){
      this.router.navigate(["/employees"])
      
  }





 









}
