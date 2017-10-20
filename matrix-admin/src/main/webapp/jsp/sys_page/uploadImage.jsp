<%@ include file="/inc/resource.inc" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ include file="/inc/iframe-head.jsp" %>

<div class="field"> 
	<form enctype="multipart/form-data"  action="${basePath}file/api_file_remote_upload.do" method="post" id="upload-image" target="rtn-uploaded-image">
		<a href="javascript:void(0);" class="btn btn_orange btn_search radius50" style="cursor: pointer;"> 
			<span> 选择 </span>
		</a>
		<input type="file" name="file" id="select-pic" class="ae-form-input" style="width: 71px; height: 33px;position: absolute;left: 0;top: 0;opacity: 0;" />
	</form>
	<iframe id="rtn-uploaded-image-iframe" name="rtn-uploaded-image"  style="display:none;"></iframe>
</div>


<script type="text/javascript">
	$(function() {
		$("#select-pic").change(function(){
			$("#upload-image").submit();
		});
		
		$("#rtn-uploaded-image-iframe").load(function(){
			var imageJson = $(document.getElementById('rtn-uploaded-image-iframe').contentWindow.document.body).html();
			var obj = eval("("+imageJson+")");
			window.parent.uploadedImage(obj.imgs);
		});
	});
	
 </script>
