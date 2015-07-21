<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
</head>

<body>
<h1>Struts 2 check box example</h1>

<s:form action="resultAction" namespace="/">

<h4>
	<s:checkbox name="checkMe" fieldValue="true" value="true" label="Check Me for testing"/>
</h4> 

<s:submit value="submit" name="submit" />
	
</s:form>

</body>
</html>