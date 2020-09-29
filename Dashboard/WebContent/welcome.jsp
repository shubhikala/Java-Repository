<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.1/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function (){
	var request = {"hostUsername":"aayushi", "hostPassword":"jain", "userName":"saksham.gupta"};
	$.ajax({
        type: "POST",
        url:"login.do",
        dataType: "json",
        contentType: "application/json",
        data:JSON.stringify(request),
        success: function (data) {
        	alert(data.responseObject);
        	 var request = {"sessionId" : data.responseObject};
        	$.ajax({
                type: "POST",
                url:"listSubordinates.do",
                dataType: "json",
                contentType: "application/json",
                data:JSON.stringify(request),
                success: function (data) {
                	alert(data.responseMessage);
                	
                }
              }); 
        }
      });
});
</script>
</head>
<body>
<h1>welcome!</h1>
<!-- <form id="download" method="post" action="downloadReport.do">
   <input type="text" class="form-control" value = "650" name = "empCode" id = "empCode" required autofocus hidden>
   <input type="text" class="form-control" value = "1" name = "pageOffset" id = "pageOffset" required autofocus hidden>
   <input type="submit" value="Add" class="btn" >
   </form> -->
</body>
</html>