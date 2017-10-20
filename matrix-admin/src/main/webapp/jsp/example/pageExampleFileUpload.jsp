<%@ include file="/inc/resource.inc" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ include file="/inc/iframe-head.jsp"%>

<div class="centercontent">
	<div class="pageheader notab">
		<h1 class="pagetitle">图片与文件上传应用示例</h1>
		<span class="pagedesc"> 上传图片、文件什么的，页面路径：【jsp/example/pageExampleFileUpload.jsp】 </span> 
		<span style="display: none">jsp/example/pageExampleFileUpload.jsp</span>
	</div>

	<div id="validation" class="subcontent" style="display: block">
		<p>
				<label>图片上传</label>
				<iframe src="../jsp/sys_page/uploadImage.jsp" style="height:40px;"></iframe>
				
				<input type="hidden" name="titlePic" id="title-pic" />
				<div class="field" id="show-upload-image-div" ></div>
			</p>
	</div> 
	
	
</div>


<script type="text/javascript">
	/**
	 * uploadImage.jsp 回调此方法
	 */
	function uploadedImage(imgs) {
		$("#title-pic").val(imgs);
		var tHtml = '';
		var imgArr ;
		if(imgs.length > 0) {
			imgArr = imgs.split(",");
			for(var i=0;i<imgArr.length ;i++) {
				tHtml += '<img src="'+imgArr[i]+'" style="width:100px;" />';
			}
			$("#show-upload-image-div").html(tHtml);
		}
		
	}
</script>









