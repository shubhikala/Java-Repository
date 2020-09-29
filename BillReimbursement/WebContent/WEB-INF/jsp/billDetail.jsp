<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bill Reimbursement Form</title>
<style type="text/css">
#form {
	margin-top: 100px;
}
</style>
</head>
<body>
	<%@include file="index.jsp"%>
	<div id=form>
		<form class="form-horizontal" action="ControllerServlet" method="post" enctype="multipart/form-data">
			<div class="form-group">
				<label for="inputEmpId" class="control-label col-xs-2">Employee
					Id</label>
				<div class="col-xs-6">
					<input type="text" readonly="readonly" name="empId"
						class="form-control" id="inputEmpId"
						value="${ currentEmployee.empId }">
				</div>
			</div>
			<div class="form-group">
				<label for="inputName" class="control-label col-xs-2">Employee
					Name</label>
				<div class="col-xs-6">
					<input type="text" class="form-control" name="empName"
						id="inputName" value="${ currentEmployee.name }">
				</div>
			</div>
			<div class="form-group">
				<label for="inputBillType" class="control-label col-xs-2">Bill
					Type</label>

				<div class="col-xs-6">
					<select name="selectBillType" class="form-control">
						<c:forEach items="${billTypes}" var="type">
							<option value="${type.id}">${type.name}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label for="inputAmt" class="control-label col-xs-2">Total
					Amount</label>
				<div class="col-xs-6">
					<input type="text" class="form-control" id="inputAmt" name="amount">
				</div>
			</div>
			<div class="form-group">
				<label for="textAreaDetails" class="control-label col-xs-2">Details
					& Comments</label>
				<div class="col-xs-6">

					<textarea class="form-control" name="details" rows="5"
						id="textAreaDetails"></textarea>

				</div>
			</div>
			<input type="hidden" class="form-control" id="hdnManagerId"
				name=managerId value="${ manager.id }">

			<div class="form-group">
				<label for="inputManager" class="control-label col-xs-2">Sent
					To:</label>
				<div class="col-xs-6">
					<input type="text" class="form-control" id="inputManager"
						name=managerName value="${ manager.name }">
				</div>
			</div>	
			<div class="form-group">
				<label for="uploadFile" class="control-label col-xs-2">Select all the bills to upload:</label>
				<div class="col-xs-6">
					 <input type="file" name="uploadFile" multiple="muliple"/> <br />
				<br /> 
				</div>
			</div>	
			<div class="form-group">
				<label for="textAreaDescription" class="control-label col-xs-2"></label>
				<div class="col-xs-6">
					<textarea class="form-control" name="fileDescription" rows="5"
						id="textAreaDescription"></textarea>
				<br /> 
				</div>
			</div>
			<div class="form-group checkbox">
				<label for="uploadFile" class="control-label col-xs-2">Sent
					To:</label>
				<div class="col-xs-6">
					<input type="checkbox" name="chkRequestHelp" value="1"> Request Help from support <br />
				<br /> 
				</div>
			</div>				
			<div class="form-group">
				<div class="col-xs-offset-2 col-xs-10">
					<button type="submit" class="btn btn-primary">Submit</button>
				</div>
			</div>
		</form>
	</div>

</body>
</html>