<%@ include file="/inc/resource.inc" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ include file="/inc/iframe-head.jsp"%>
<style type="text/css">
	.readme h1,h2,h3,div{
		margin-bottom:20px;
	}
	.title-2{
		margin-left: 50px;
		margin-bottom:50px;
	}
	p{
		font-size: 15px;
		/* color:#9BBB59; */
		color:black;
	}
</style>
<div class="centercontent">
	<div class="pageheader notab">
		<h1 class="pagetitle">开发规约</h1> 
	</div>
	
	<div class="subcontent" style="display: block; margin-top: 20px; margin-left: 20px">
		<div class="readme">
			<h1 >1. Controller层规范</h1> 
			<div class="title-2">
				<h3 >1.1 JSP页面返回规约</h1> 
				<img src="../images/readme/controller-a.png" title="controller命名规则示例截图" style="margin-bottom:20px;width:627px;height:162px;"></br>
				<img src="../images/readme/controller-b.png" title="controller层返回JSP的方法示例截图" style="margin-bottom:20px;width:820px;height:268px;">
				<div>
					<p>Controller层基本结构如上图。</p>
					<p>类上的@RequestMapping中的值以小写字母开头，一个单词表意，精简风格</p>
					<p>方法上的@RequestMapping中的值以小写字母page开头 + controller类上的映射名+业务描述+list(代表这是一个列表页面)</p>
					<p>如：page_media_released_list这样的描述方式。对于其下方法的命名则去掉下划线，并以Page结尾。</p>
					<p>如：mediaReleasedListPage</p>
					<p>每个Controller中的方法，都会传入HttpSession session，这个参数，以便于BaseController.java中的userBehavior()方法</p>
					<p>跟踪用户行为或记录日志。</p>
					<p>针对涉及到分页的方法，还要加入HttpServletRequest request参数。</p>
				</div>
			</div>
			<div class="title-2">
				<h3 >1.2 页面-服务器ajax交互规约</h1> 
				<img src="../images/readme/controller-c.png" title="controller层返ajax方法示例截图" style="margin-bottom:20px;width:849px;height:285px;">
				<div>
					<p>对于涉及到与jsp页面有数据交互的方法，其典型特点如上图所示。</p>
					<p>其RequestMapping中的值以“ajax_”的方式开头，后跟业务描述 + 交互类型(列表：list|添加：add|编辑：edit|删除：delete)</p>
					<p>比如：ajax_article_assort_list(获取【文章】【分类】管理【列表】数据)，article：文章|asort：分类</p>
					<p>ajax_assort_add 【分类】【添加】。命名禁止使用汉语拼音+英文的混淆方式。</p>	
					<p>方法内第一行记录用户行为，super.userBehavior()方法必须加!</p>
					<p>方法返回值规定为</p>
					<p style="color:red">&nbsp&nbsp&nbsp&nbsp com.alibaba.fastjson.JSONObject</p>
					<p>返回结构示例：</p>
						 <p>{</p>
						    <p style="color:red">&nbsp&nbsp&nbsp&nbsp"status": "success",				状态：success or error</p>
						    <p style="color:red">&nbsp&nbsp&nbsp&nbsp"msg": "文件上传完成",</p>
						    <p>&nbsp&nbsp&nbsp&nbsp"original": "bc.png",			图片原标题</p>
						    <p>&nbsp&nbsp&nbsp&nbsp"title": "bf92f1576b23470a948dbdcb8feba788.png",  		图片新标题</p>
						    <p>&nbsp&nbsp&nbsp&nbsp"size": "62091",        文件大小</p>
						    <p>&nbsp&nbsp&nbsp&nbsp"save": "image/29c10/bf92f1576b23470a948dbdcb8feba788.png",            用于保存到数据库</p>
						    <p>&nbsp&nbsp&nbsp&nbsp"type": "image",		文件类型</p>
						    <p>&nbsp&nbsp&nbsp&nbsp"url": "http://192.168.1.34:8080/matrix-file/image/29c10/bf92f1576b23470a948dbdcb8feba788.png",	可访问路径</p>
						    <p>&nbsp&nbsp&nbsp&nbsp"height": "247"		图片高</p>
						    <p>&nbsp&nbsp&nbsp&nbsp"width": "163",		图片宽</p>
						 <p>}</p>
					<p>随着项目的不断壮大和产品需求的不断迭代，使用JSONObject可以有效防止【类爆】的情况出现。</p>
					<p>status 和 msg 两个参数为必选值。其他消息体内容根据具体需求来定。</p>
					<p style="color:red;font-size:25px;margin-top:10px;">注意！</p>
					<p>&nbsp&nbsp&nbsp&nbsp controller层禁止出现任何形式的业务相关代码！</p>
					<p>&nbsp&nbsp&nbsp&nbsp 请书写结构完整的代码注释！</p>
					<p></p>
					<p></p>
				</div>
			</div>
		</div> 
		
		
	</div>
	
	<div class="subcontent" style="display: block; margin-top: 2000px; margin-left: 20px"></div>
</div>












