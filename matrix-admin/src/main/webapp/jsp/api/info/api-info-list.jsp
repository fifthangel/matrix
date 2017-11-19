<%@ include file="/inc/resource.inc" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ include file="/inc/iframe-head.jsp" %>

<link rel="stylesheet" href="${css}/ztree/zTreeStyle.css" type="text/css" />

<script type="text/javascript" src="${js}/ztree/jquery.ztree.all.js"></script>
<script type="text/javascript" src="${jsp}/api/info/api-info.js"></script>

<style type="text/css">
    .tree-left{
        /* border: solid #FB9337 2px; */
        height: 100%;
        width: 30%; 
        float: left;
    }
    .tree-right{
        /* border: solid #78CE07 2px; */
        height: 100%;
        width: 30%;
        margin-right: 400px;
        float: right;
        position:relative;
    }
    .tree-table-right{
        border: solid #78CE07 2px;
        height: 100%;
        width: 40%;
        margin-right: 400px;
        float: right;
        position:relative;
    }
    .right-padding{
        padding-top: 10px;
        padding-bottom: 10px;
    }
    .right-size{
        height: 25px;
        width: 200px;
    }
    .a-btn{
    	cursor: pointer;
    	color:#FB9337; 
    }
    .a-btn:hover {
    	color: red;
   	} 
   	
</style>


<div class="centercontent">

	<div class="pageheader notab">
		<h1 class="pagetitle">API树形结构列表</h1>
		<span class="pagedesc">同层节点之间可以进行拖动来调整其先后顺序 </span>
	</div>
	<div class="contentwrapper" style="padding-top: 0px;">
		<div id="nav-menu" class="subcontent">
			<div class="contenttitle2" style="margin-top: 5px; margin-bottom: 5px;">
				<h3>
					<a herf="javascript:void(0)" onclick="surfunc.closeNavi('api-tree')" class="a-btn" title="收起导航栏从而方便您的操作">收起</a>
				</h3>
			</div>
			<div class="stdform">
				<div class="tree-left">
					<div id="api-list" class="mousescroll">
						<ul id="api-tree" class="ztree"></ul>
					</div>
				</div>
				<div class="tree-right" style="padding: 5px">
					<form id="tree-node-edit" action="javascript:void(0)"></form>
				</div>
			</div>
		</div>
	</div>
</div>


<script type="text/javascript">
	$(document).ready(function(){
		// 开始初始化树型结构
		apiInfo.apiTreeInit(); 
		// 自定义滚动条 | 执行此代码自定义滚动条则生效
		$('#api-list').slimscroll({
			color: '#666',
			size: '10px',
			width: 'auto',
			height: '630px' // '208px'
		});
	});  
</script>
































