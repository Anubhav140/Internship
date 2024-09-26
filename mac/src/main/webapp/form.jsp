<jsp:include page="include/header.jsp"/>


<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Form</title>
    <link rel="stylesheet" href="form.css">
</head>
<body>
    
        <div id="wel">
            <h6>PNB Litigation Management Form</h6>
        </div>
        <div id="log">
            <div id="form">
                <h2 style="margin-left: 6%; margin-top: 5%; margin-bottom: 5%;">Case Form</h2>
                <form action="${pageContext.request.contextPath}/site" method="post" >
                    <label for="caseID"><b>CaseID:</b></label>
                    <input type="text" id="caseID" name="CaseID" style="margin-left: 15%; width:25%; height: 30px; border: transparent;"><br><br>
                    
                     <label for="caseType"><b>Case Type:</b></label>
                    <select name="CaseType" id="caseType" style="margin-left: 13%; width:25.8%; height: 30px; border: transparent;">
                        <option value="">Select Case Type:</option>
                        <option value="Income Tax">Income Tax</option>
                        <option value="ITR">ITR</option>
                        <option value="TT">TT</option>
                    </select><br><br>
                    


                    <label for="description"><b>Case Description:</b></label>
                    <textarea name="description" id="description" style="margin-left: 8%; width: 25%; height: 100px; border: transparent;"></textarea><br><br>

                    <label for="numFiles"><b>Number Of Documents:</b></label>
                    <input type="number" id="numFiles" name="numfiles" style="margin-left: 3.6%; width: 25%; height: 30px; border: transparent;"><br><br>

                   
                    <label for="files"><b>Upload Files:</b></label>  
                    <input type="file" id="files" name="files" multiple style="margin-left: 11%; height: 30px; border: transparent; background-color: transparent;"><br><br>
                   
                   
					<input type="hidden"  name="form" value="addcase"><br><br>


                    <input type="submit" value="Submit" style="margin-left: 30%; width: 10%; height: 30px; border: transparent; background-color: #fbbc09;">
                </form>            
            </div>
        </div>
   
</body>
</html>


<jsp:include page="include/footer.jsp"></jsp:include>