<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<title>Download File Request Page</title>
<link href="bootstrap/css/bootstrap.css" rel="stylesheet">
<link href="css/main.css" rel="stylesheet">
<link href="bootstrap/css/bootstrap-responsive.css" rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Pragma" content="no-cache">
<script src="jquery.min.js"></script>
<link rel="stylesheet" href="jquery-ui.css" />
<script src="jquery-ui.min.js"></script>
</head>
<body>
<div class="container-fluid" width="100%">
      <div class="row-fluid">
       <div id="content" class="span9">
	<div class="row" style="margin-left: 0px !important; margin-top:20px;">
                    <div>
                        <div style="background-color: #E9E9E9; text-align: center;"><h5>File Details</h5></div>
                        <div class="datatableFix datatableFixPadding">
                        <div id="status" style="word-wrap: break-word;"></div>
                        <table class="table table-striped table-condensed" id="fileTable" >
                            <thead>
									<tr>
										<th width="14%">Rejected File</th>
										<th>Action</th>
									</tr>
								</thead>
                            <tbody>
                            </tbody>
                        </table>
                       
                        </div>
                    </div>
                </div>
               </div>
             </div>
 
		<!-- <form method="GET" action="downloadFile" class="elegant-aero">
			<input class="button" type="submit" value="Download"> Click here to download files
		</form> -->
	
</div>
</body>


<script type="text/javascript" src="js/json2.js"></script>
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootbox.min.js"></script>
<script type="text/javascript" src="js/services.js"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script type="text/javascript" src="js/jquery.dataTables.js"></script>
<script type="text/javascript" src="js/datatable.js"></script>
<script type="text/javascript" src="js/datatable.filterclear.js"></script>
<script type="text/javascript" src="js/datatable.findcellrownodes.js"></script>
<script type="text/javascript" src="js/datatable.sort.js"></script>
<script type="text/javascript" src="js/main.js"></script>
<script type="text/javascript" src="js/home.js"></script>

</html>