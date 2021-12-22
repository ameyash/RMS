<%@ page import="com.file.*"%>
<!DOCTYPE html>
<html>
<head>

<title>Insert title here</title>

<%
	try{
        String name=request.getParameter("data");
String strArray[] = name.split(",");
// Iterating over the string
		GeneratePdf gPdf = new GeneratePdf();
		int flag = gPdf.createPdf(strArray);%>
		<script type="text/javascript">
		 window.onload = function () {
	 		alert("Downloaded");
	 		history.back();
	 	 }
	</script>
	<%}catch(Exception e)
	{
	System.out.println(e);	%>
	<script type="text/javascript">
	 window.onload = function () {
		alert("Downloading Failed");
		history.back();
	 }
	<%}
	%>
</script>
</head>
<body>

</body>
</html>