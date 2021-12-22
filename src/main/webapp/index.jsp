<%@ page import="java.util.*,java.sql.*" %>
<!DOCTYPE html>
<html lang="en">

<%
	String data = (String)request.getAttribute("data");
	String dataArray[]=new String[10];
if(data!=null)
{
	dataArray = data.split(",");
}
%>
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Result Management System</title>

    <!-- Custom fonts for this template-->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <!-- <link href="style.css" rel="stylesheet"> -->
    <link href="css/sb-admin-2.min.css" rel="stylesheet">
    
    <script type="text/javascript">
    function getStudenetData(data)
	 {
		location.replace("writeToExcel.jsp?data="+data);
	 }
  </script>
  <script type="text/javascript" src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>


</head>

<body id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

                <!-- Topbar -->
                <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                    <!-- Sidebar Toggle (Topbar) -->
                    <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                        <i class="fa fa-bars"></i>
                    </button>

                    
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item bg-light rounded">                            
                            <button class="btn btn-light font-weight-bold text-uppercase" type="button">
                                <i class="fas fa-laugh-wink"></i>
                                <a>Result Management System</a>
                            </button>
                        </li>
                    </ul>        
                    

                    <!-- Topbar Navbar -->
                    <ul class="navbar-nav ml-auto">
                        <div class="topbar-divider d-none d-sm-block"></div>
                        <!-- Nav Item - User Information -->
                        <li class="nav-item">
                            <button class="btn btn-primary" type="button">
                            <a style="color: inherit;" href="../ResultManagementSystem/SignIn.html">
                                <i class="fas fa-users fa-sm"></i>
                                Login</a>
                            </button>                            
                        </li>                       

                        <div class="topbar-divider d-none d-sm-block"></div>

                        <!-- Nav Item - User Information -->
                        <li class="nav-item">
                            <button class="btn btn-primary" type="button">
                            <a style="color: inherit;" href="../ResultManagementSystem/SignUp.html">
                                <i class="fas fa-users-cog fa-sm"></i>
                                Register</a>
                            </button>
                        </li>
                        <div class="topbar-divider d-none d-sm-block"></div>

                    </ul>

                </nav>
                <!-- End of Topbar --></br></br>

                <!-- Begin Page Content -->
                <div class="section full-height">
                    <div class="center">
            
                        <div class="section">
                            <div class="container">
                                <div class="row">
            
                                    <div class="col-12 text-center">
                                        <h1><i class="fas fa-laugh-wink"></i></h1>
                                        <h1><span>R</span><span>E</span><span>S</span><span>U</span><span>L</span><span>T</span></h1>
                                        <h1><span>M</span><span>A</span><span>N</span><span>A</span><span>G</span><span>E</span><span>M</span><span>E</span><span>N</span><span>T</span></h1>
                                        <h1><span>S</span><span>Y</span><span>S</span><span>T</span><span>E</span><span>M</span></h1>
                                    </div>
                                </div>
                                
                            </div></br>
                            <div class="col">
                                <div class="card border-left-primary shadow">
                                    <div class="card-body">
                                    <form action="getSearchData" method="post">
                                        <h5 class="text-primary font-weight-bold">Student Data</h5></br>
                                        <div class="row">                                        
                                        <div class="form-group col-3">
                                          <label for="exampleInput1">Student ID</label>
                                          <input type="text" class="form-control" id="exampleInput1" aria-describedby="emailHelp" placeholder="Student ID" name="studentId">
                                          
                                        </div>
                                          <div class="form-group col-3">
                                            <label for="exampleFormControlSelect1">Year</label>
                                            <select name="year" class="form-control" id="exampleFormControlSelect1">
                                              <option>F.E</option>
                                              <option>S.E</option>
                                              <option>T.E</option>
                                              <option>B.E</option>
                                              
                                            </select>
                                          </div>
                                          <div class="form-group col-3">
                                            <label for="exampleFormControlSelect2">Divsion</label>
                                            <select name="division" class="form-control" id="exampleFormControlSelect2">
                                              <option>A</option>
                                              <option>B</option>
                                              <option>C</option>                                  
                                            </select>
                                          </div>
                                          <div class="col-3">
                                            <label for="btn3">Search</label></br>
                                            <button type="submit" class="btn btn-primary float-end" id="btn3"><i class="fas fa-search fa-sm"></i></button>

                                          </div>
                                        </div>
                                        
                                        
                                        
                                      </form>
                                    </div>
                                  </div>
                            </div>
                        </div>
                    </div>
                </div>
                
               <%if(data!=null){%> 
                <div class="card shadow mb-4">
                            <div class="card-header py-3">
                                <h6 class="m-0 font-weight-bold text-primary">DataTables Example</h6>
                            </div>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                        <thead>
                                            <tr>
                                                <th>Id</th>
                                                <th>Name</th>
                                                <th>Year</th>
                                                <th>Division</th>
                                                <th>Subject 1</th>  
                                                <th>Subject 2</th>
                                                <th>Subject 3</th>
                                                <th>Subject 4</th>
                                                <th>Subject 5</th> 
                                                <th>Percentage</th>                                              
                                                <th>Download</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        <tr>
                                        <%
											for(int i=0;i<dataArray.length;i++)
											{ %>
												
													<td name=""><%out.print(dataArray[i]);%></td>
												<%}
													StringBuffer sb = new StringBuffer();
											    sb.append("[");
											    for(int k=0; k<dataArray.length; k++){
											        sb.append("\'").append(dataArray[k]).append("\'");
											        if(k+1 < dataArray.length){
											            sb.append(",");
											        }
											    }
											    sb.append("]");
												%>
												<td><a  href="#"><button type="button" onClick="getStudenetData(<%=sb.toString()%>);" class="btn btn-primary">Download</button></a></td>
												 </tr>
										<tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                        <%}%>

                    <!-- Page Heading -->
                    

                    <!-- Content Row -->

                    
            <!-- End of Main Content -->
        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>

    <!-- Logout Modal-->
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">Ã</span>
                    </button>
                </div>
                <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                    <a class="btn btn-primary" href="login.html">Logout</a>
                </div>
            </div>
        </div>
    </div>

    <!-- Bootstrap core JavaScript-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="js/sb-admin-2.min.js"></script>

    <!-- Page level plugins -->
    <script src="vendor/chart.js/Chart.min.js"></script>

    <!-- Page level custom scripts -->
    <script src="js/demo/chart-area-demo.js"></script>
    <script src="js/demo/chart-pie-demo.js"></script>

</body>

</html>