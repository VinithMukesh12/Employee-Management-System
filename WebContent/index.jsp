<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="ISO-8859-1">
    <title>Employee Management System</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>

<body style="background-image: url('employee.webp'); background-repeat: no-repeat; background-size: 100%;">
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <a class="navbar-brand" href="#" onclick="window.location.reload();"><strong>Employee Management System</strong></a>
        <ul class="navbar-nav mr-auto">
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                  Employee
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="#" onclick="close_all();document.getElementById('add_employee').style.display='block'">Add Employee</a>
                    <a class="dropdown-item" href="#" onclick="close_all();document.getElementById('display_employee').style.display='block'">Display Employee</a>
                    <a class="dropdown-item" href="#" onclick="close_all();document.getElementById('delete_employee').style.display='block'">Delete Employee</a>
                    <a class="dropdown-item" href="#" onclick="close_all();document.getElementById('modify_employee').style.display='block'">Modify Employee</a>
                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                  TimeSheet
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="#" onclick="close_all();document.getElementById('timesheet_1').style.display='block'">Fetch Employee Working Hours</a>
                    <a class="dropdown-item" href="#" onclick="close_all();document.getElementById('timesheet_2').style.display='block'">Get TimeSheet Employee Details</a>
                    <a class="dropdown-item" href="#" onclick="close_all();document.getElementById('timesheet_3').style.display='block'">Remove Generation of Monthly Timestamp</a>
                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                  Salary
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="#" onclick="close_all();document.getElementById('salary_1').style.display='block'">Fetch Employee Salary</a>
                    <a class="dropdown-item" href="#" onclick="close_all();document.getElementById('salary_2').style.display='block'">Calculate Salary</a>
                    <a class="dropdown-item" href="#" onclick="close_all();document.getElementById('salary_3').style.display='block'">Generate Payslip</a>
                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                  Benefits
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="#" onclick="close_all();document.getElementById('report_1').style.display='block'">Fetch Benefit Details</a>
                    <a class="dropdown-item" href="#" onclick="close_all();document.getElementById('report_2').style.display='block'">Bill Reimbursement of Employee</a>
                </div>
            </li>
        </ul>
    </nav>
    <div class="container all_forms" id="add_employee" style="padding-top: 10vh; margin-top: 40px;  width: 40vw; background-color: white; opacity: 90%; display: none;">
        <form action="NewEmployeeController" method="POST" style="margin-left: 25%; margin-right: 25%; width: 30vw; height: 40vh;">
            <div class="header">
                <h4>
                    <strong>
                        Add Employee
                    </strong>
                    </h6>
            </div>
            <div class="form-group">
                <input type="text" id="firstname" name="firstname" placeholder="Firstname" />
                <span style="color: red;">${errorFName}</span>
            </div>
            <div class="form-group">
                <input type="text" id="lastname" name="lastname" placeholder="Lastname" />
                <span style="color: red;">${errorLName}</span>
            </div>
            <div class="form-group">
                <input type="text" id="email" name="email" placeholder="Email" />
                <span style="color: red;">${errorEmail}</span>
            </div>
            <div class="form-group">
                <input type="text" name="ID" id="ID" placeholder="Employee ID">
                <span style="color: red;">${errorID}</span>
            </div>
            <div class="form-group">
                <input type="reset" value="Clear" name="clear">
                <input type="submit" value="Submit" name="submit">
            </div>
        </form>
    </div>
    <div class="container all_forms" id="display_employee" style="padding-top: 10vh; margin-top: 40px;  width: 40vw; background-color: white; opacity: 90%; display: none;">
        <form action="DisEmployeeController" method="POST" style="margin-left: 25%; margin-right: 25%; width: 30vw; height: 40vh;">
            <div class="header">
                <h4>
                    <strong>
                        Display Employee
                    </strong>
                    </h6>
            </div>
            <div class="form-group">
                <input type="text" id="ID" name="ID" placeholder="Employee ID" />
                <span style="color: red;">${errorIDdis}</span>
            </div>
            <div class="form-group">
                <input type="reset" value="Clear" name="clear">
                <input type="submit" value="Submit" name="submit">
            </div>
        </form>
    </div>
    <div class="container all_forms" id="delete_employee" style="padding-top: 10vh; margin-top: 40px;  width: 40vw; background-color: white; opacity: 90%; display: none;">
        <form action="DelEmployeeController" method="POST" style="margin-left: 25%; margin-right: 25%; width: 30vw; height: 40vh;">
            <div class="header">
                <h4>
                    <strong>
                        Delete Employee
                    </strong>
                    </h6>
            </div>
            <div class="form-group">
                <input type="text" id="ID" name="ID" placeholder="Employee ID" />
                <span style="color: red;">${errorIDdel}</span>
            </div>
            <div class="form-group">
                <input type="reset" value="Clear" name="clear">
                <input type="submit" value="Delete" name="Delete">
            </div>
        </form>
    </div>
    <div class="container all_forms" id="modify_employee" style="padding-top: 10vh; margin-top: 40px;  width: 40vw; background-color: white; opacity: 90%; display: none;">
        <form action="ModEmployeeController" method="POST" style="margin-left: 25%; margin-right: 25%; width: 30vw; height: 40vh;">
            <div class="header">
                <h4>
                    <strong>
                        Modify Employee
                    </strong>
                    </h6>
            </div>
            <div class="form-group">
                <input type="text" name="ID" id="ID" placeholder="Employee ID">
                <span style="color: red;">${errorID}</span>
            </div>
            <div class="form-group">
                <input type="text" id="firstname" name="firstname" placeholder="Firstname" />
                <span style="color: red;">${errorFName}</span>
            </div>
            <div class="form-group">
                <input type="text" id="lastname" name="lastname" placeholder="Lastname" />
                <span style="color: red;">${errorLName}</span>
            </div>
            <div class="form-group">
                <input type="text" id="email" name="email" placeholder="Email" />
                <span style="color: red;">${errorEmail}</span>
            </div>
            <div class="form-group">
                <input type="reset" value="Clear" name="clear">
                <input type="submit" value="Modify" name="submit">
            </div>
        </form>
    </div>
    <div class="container all_forms" id="timesheet_1" style="padding-top: 10vh; margin-top: 40px;  width: 40vw; background-color: white; opacity: 90%; display: none;">
        <form action="AddTimeSheetcontroller" method="POST" style="margin-left: 25%; margin-right: 25%; width: 30vw; height: 40vh;">
            <div class="header">
                <h4>
                    <strong>
                        Employee Working Hours
                    </strong>
                    </h6>
            </div>
            <div class="form-group">
                <input type="text" name="ID" id="ID" placeholder="Employee ID">
                <span style="color: red;">${errorATSID}</span>
            </div>
            <div class="form-group">
                <input type="text" id="date" name="date" placeholder="Date" />
                <span style="color: red;">${errorATSDate}</span>
            </div>
            <div class="form-group">
                <input type="text" id="timein" name="timein" placeholder="Timein" />
                <span style="color: red;">${errorATSTimein}</span>
            </div>
            <div class="form-group">
                <input type="text" id="timeout" name="timeout" placeholder="Timeout" />
                <span style="color: red;">${errorATSTimeout}</span>
            </div>
            <div class="form-group">
                <input type="reset" value="Clear" name="clear">
                <input type="submit" value="Submit" name="submit">
            </div>
        </form>
    </div>
    <div class="container all_forms" id="timesheet_2" style="padding-top: 10vh; margin-top: 40px;  width: 40vw; background-color: white; opacity: 90%; display: none;">
        <form action="GetTimeSheetcontroller" method="POST" style="margin-left: 25%; margin-right: 25%; width: 30vw; height: 40vh;">
            <div class="header">
                <h4>
                    <strong>
                        Getting Worked Hours
                    </strong>
                    </h6>
            </div>
            <div class="form-group">
                <input type="text" name="ID" id="ID" placeholder="Employee ID">
                <span style="color: red;">${errorGTSID}</span>
            </div>
            <div class="form-group">
                <input type="reset" value="Clear" name="clear">
                <input type="submit" value="Submit" name="submit">
            </div>
        </form>
    </div>
    <div class="container all_forms" id="timesheet_3" style="padding-top: 10vh; margin-top: 40px;  width: 40vw; background-color: white; opacity: 90%; display: none;">
        <form action="RemTimeSheetcontroller" method="POST" style="margin-left: 25%; margin-right: 25%; width: 30vw; height: 40vh;">
            <div class="header">
                <h4>
                    <strong>
                        Remove Generation of Monthly Timestamp
                    </strong>
                    </h6>
            </div>
            <div class="form-group">
                <input type="text" id="MMMYYYY" name="MMMYYYY" placeholder="Enter Month and Year" />
                <span style="color: red;">${errorRTSMY}</span>
            </div>
            <div class="form-group">
                <input type="reset" value="Clear" name="clear">
                <input type="submit" value="Remove" name="Remove">
            </div>
        </form>
    </div>
    <div class="container all_forms" id="salary_1" style="padding-top: 10vh; margin-top: 40px;  width: 40vw; background-color: white; opacity: 90%; display: none;">
        <form action="FetEmpSalarycontroller" method="POST" style="margin-left: 25%; margin-right: 25%; width: 30vw; height: 40vh;">
            <div class="header">
                <h4>
                    <strong>
                        Fetch Employee Salary
                    </strong>
                    </h6>
            </div>
            <div class="form-group">
                <input type="text" id="ID" name="ID" placeholder="ID" />
                <span style="color: red;">${errorFESID}</span>
            </div>
            <div class="form-group">
                <input type="text" id="des" name="des" placeholder="Designation" />
                <span style="color: red;">${errorFESdes}</span>
            </div>
            <div class="form-group">
                <input type="text" id="sal" name="sal"  placeholder="Salary"/>
                <span style="color: red;">${errorFESsal}</span>
            </div>
             <div class="form-group">
                <input type="text" id="MMMYYYY" name="MMMYYYY" placeholder="Month&Year" />
                <span style="color: red;">${errorFESMMMYYYY}</span>
            </div>
            <div class="form-group">
                <input type="reset" value="Clear" name="clear">
                <input type="submit" value="Submit" name="Submit">
            </div>
        </form>
    </div>
    <div class="container all_forms" id="salary_2" style="padding-top: 10vh; margin-top: 40px;  width: 40vw; background-color: white; opacity: 90%; display: none;">
        <form action="CalEmplSalaryController" method="POST" style="margin-left: 25%; margin-right: 25%; width: 30vw; height: 40vh;">
            <div class="header">
                <h4>
                    <strong>
                        Calculation of Salary
                    </strong>
                    </h6>
            </div>
            <div class="form-group">
                <input type="text" id="ID" name="ID" placeholder="ID" />
                <span style="color: red;">${errorCESID}</span>
            </div>
            <div class="form-group">
                <input type="reset" value="Clear" name="clear">
                <input type="submit" value="Submit" name="Submit">
            </div>
        </form>
    </div>
    <div class="container all_forms" id="salary_3" style="padding-top: 10vh; margin-top: 40px;  width: 40vw; background-color: white; opacity: 90%; display: none;">
        <form action="GenPaySlipEmpController" method="GET" style="margin-left: 25%; margin-right: 25%; width: 30vw; height: 40vh;">
            <div class="header">
                <h4>
                    <strong>
                        Generate Payslip
                    </strong>
                    </h6>
            </div>
            <div class="form-group">
                <input type="text" id="ID" name="ID" placeholder="ID" />
                <span style="color: red;">${errorgGPSEID}</span>
            </div>
            <div class="form-group">
                <input type="reset" value="Clear" name="clear">
                <input type="submit" value="Generate" name="Generate">
            </div>
        </form>
    </div>
    <div class="container all_forms" id="report_1" style="padding-top: 10vh; margin-top: 40px;  width: 40vw; background-color: white; opacity: 90%; display: none;">
        <form action="FetEmpBenefitController" method="POST" style="margin-left: 25%; margin-right: 25%; width: 30vw; height: 40vh;">
            <div class="header">
                <h4>
                    <strong>
                        Fetch Employee Benefits
                    </strong>
                    </h6>
            </div>
            <div class="form-group">
                <input type="text" id="ID" name="ID" placeholder="ID" />
                <span style="color: red;">${errorFEBCID}</span>
            </div>
            <div class="form-group">
                <input type="reset" value="Clear" name="clear">
                <input type="submit" value="Generate" name="Generate">
            </div>
        </form>
    </div>
    
    
    <div class="container all_forms" id="report_2" style="padding-top: 10vh; margin-top: 40px;  width: 40vw; background-color: white; opacity: 90%; display: none;">
        <form action="BillReimbursementController" method="POST" style="margin-left: 25%; margin-right: 25%; width: 30vw; height: 40vh;">
            <div class="header">
                <h4>
                    <strong>
                        Bill Reimbursement of Employee
                    </strong>
                    </h6>
            </div>
            <div class="form-group">
                <input type="text" id="ID" name="ID" placeholder="ID" />
                <span style="color: red;">${errorBRCID}</span>
            </div>
            <div class="form-group">
                <input type="text" id="amount" name="amount" placeholder="Amount" />
                <span style="color: red;">${errorBRCamount}</span>
            </div>
            <div class="form-group">
                <input type="reset" value="Clear" name="clear">
                <input type="submit" value="Generate" name="Generate">
            </div>
        </form>
    </div>
    <script>
        function close_all() {
            eles = document.getElementsByClassName('all_forms');
            for (i of eles) {
                i.style.display = 'none';
            }
        }
    </script>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>

</html>