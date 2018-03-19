### FileUploadSample

This is a sample RESTFul web service used to upload, download and retrieve meta-data stored in local DB (H2).

### Functions:
• Upload file<br/>
HttpMethod.POST<br/>
/file/upload<br/><br/>
• Get meta-data for one file:<br/>
HttpMethod.GET<br/>
/file/get/{file_id}<br/><br/>
• Get meta-data for all files<br/>
HttpMethod.GET<br/>
/file/get<br/><br/>
• Get meta-data for certain type like pdf, txt etc:<br/>
HttpMethod.GET<br/>
/search/{file_type}<br/><br/>