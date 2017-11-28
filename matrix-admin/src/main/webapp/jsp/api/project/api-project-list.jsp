<%@ include file="/inc/resource.inc" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ include file="/inc/iframe-head.jsp" %>

<script type="text/javascript" src="${jsp}/api/project/api-project.js"></script>
<script type="text/javascript">
	$(function() {
		var type_ = 'post';
		var url_ = '${basePath}apicenter/ajax_api_project_list.do';
		var data_ = null; // 可以为null，后台会进行默认处理
		var obj = JSON.parse(ajaxs.sendAjax(type_, url_, data_));
		aForm.launch(url_, 'table-form', obj).init().drawForm(project.loadTable);
	});

	
</script>

<div class="centercontent tables">
	<!--这个跳转页面的功能及跳转路径等等-->
	<div class="pageheader notab">
		<h1 class="pagetitle">api所属项目-应对可能出现的多项目</h1>
		<span style="display: none">jsp/api/project/api-project-list.jsp</span>
	</div>

	<div id="contentwrapper" class="contentwrapper">

		<%-- table-form 这个id分页使用 --%>
		<div id="table-form" class="dataTables_wrapper">
			<div class="contenttitle2">
				<p style="margin: 0px">
					<label>项目名称：</label> 
					<span class="field"> 
						<input id="target" type="text" name="target" class="form-search" />
					</span> 
					
					<a onclick="project.openAddDialog()" class="btn btn_orange btn_search radius50 security-btn" key="btn-c30bd4b3bbd2485bb0de1699de16f468" style="float: right; cursor: pointer; margin-left: 10px"> 
						<span> 添 加 </span>
					</a> 
					<a onclick="project.searchReset()" class="btn btn_orange btn_search radius50 security-btn" key="btn-0fc78c45dc114367a29afc59631a2c8a" style="float: right; cursor: pointer; margin-left: 10px"> 
						<span> 重 置 </span>
					</a> 
					<a onclick="project.search()" class="btn btn_orange btn_search radius50 security-btn" key="btn-6b623665eba54cc295ce1783f345e551" style="float: right; cursor: pointer; margin-left: 20px"> 
						<span> 查 询 </span>
					</a>
				</p>
			</div>

			<div id="dyntable2_length" class="dataTables_length dialog-show-count">
				<label> 当前显示 <%-- TODO 注意：select-page-size 这个ID是写定的，如果没有这个显示条数，则默认显示10条 - Yangcl --%> 
					<select id="select-page-size" size="1" name="dyntable2_length" onchange="aForm.formPaging('1')">
						<option value="10">10</option>
						<option value="25">25</option>
						<option value="50">50</option>
						<option value="100">100</option>
					</select> 条记录
				</label>
			</div>

			<table id="dyntable2" cellpadding="0" cellspacing="0" border="0" class="stdtable">
				<thead>
					<tr>
						<th class="head0">项目名称</th>
						<th class="head0">开放方式</th>  
						<th class="head0">创建时间</th> 
						<th class="head0">更新时间</th>
						<th class="head0">更新人</th>
						<th class="head0 " width="100px">操作</th>
					</tr>
				</thead>
				<tbody id="ajax-tbody-1" class="page-list">
					<!--  class="page-list" 标识是页面数据列表 行变色使用 -->
					<%-- 等待填充 --%>
				</tbody>
			</table>

		</div>
	</div>

</div>


<!-- 添加弹层 -->
<div id="add-dialog-div" class="dialog-page-div" style="display: none;width: 350px;height: 200px">
    <p class="dialog-title">
        <a href="#" onclick="project.closeDialog()" class="dialog-close"></a>
        添加项目
    </p>

    <div id="dialog-content-wrapper" class="contentwrapper">
        <div id="dialog-table-form" class="dataTables_wrapper" >
            <form id="dialog-table" action="javascript:void(0)">   
	            <table class="dialog-table">
	                <tbody>
	                	<tr>
	                		<td style="text-align: right">
	                			项目名称：
	                		</td>
	                		<td style="text-align: left">
	                			<input type="text" id="target-add" name="target" class="dialog-form-input" style="width:200px;"/>
	                		</td>
	                	</tr>
	                	<tr></tr>
	                	<tr style="line-height:10px;">
	                		<td style="text-align: right">
	                			开放类型：
	                		</td>
	                		<td style="text-align: left">
	                			<select id="atype-add" name="atype" class="dialog-form-input"  style="width:212px;margin:0px">
	                				<option value="private" selected>公司内部使用接口</option>
	                				<option value="public" >开放给第三方的接口</option>
	                			</select>
	                		</td>
	                	</tr>
	                </tbody>
	                <tfoot>
		                <tr>
					      <td colspan="2" style="text-align: right;">
					      	<button class="stdbtn btn_orange" style="opacity:1; margin-top:20px;" onclick="project.addProject()" >提 &nbsp&nbsp&nbsp&nbsp&nbsp 交</button>
					      </td> 
					    </tr>
	                </tfoot>
	            </table>
            </form>
        </div>
    </div>
</div>
























