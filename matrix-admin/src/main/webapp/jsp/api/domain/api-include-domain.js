
var domains = {
		rowId:null, // 一条记录的id
		
		loadTable : function(url_){
			if (url_ == undefined) { // 首次加载表单
				domains.draw(aForm.jsonObj);
				return;
			}
			// 这种情况是响应上一页或下一页的触发事件
			var type_ = 'post';
			var data_ = {
				domain : $("#domain").val() ,
				companyName : $("#company-name").val() 
			};
			var obj = JSON.parse(ajaxs.sendAjax(type_, url_, data_));
			aForm.launch(url_, 'table-form', obj).init();
			domains.draw(obj);
		},

		draw : function(obj){
			$('#ajax-tbody-1 tr').remove();
			var html_ = '';
			var list = obj.data.list;
			if (list.length > 0) {
				for (var i = 0; i < list.length; i++) {
					html_ += '<tr id="tr-' + list[i].id + '" class="gradeX">' 
							+ '<td width="200px" align="center">' + list[i].domain + '</td>'
							+ '<td align="center">' + list[i].companyName + '</td>'
							+ '<td align="center">' + list[i].createTime + '</td>'
							+ '<td align="center">' + list[i].updater + '</td>'
							+ '<td width="200px" align="center">'
								+ '<a onclick="domains.deleteRow(this)" eleId="' + list[i].id + '" title="删除"  style="cursor: pointer;" class="security-btn" key="btn-7ec99f2159e14847a0b9f6527ddc9ffb">删除</a> '
								+ '<a onclick="domains.openEditDialog(this)"  eleId="' + list[i].id + '"  title="修改"  style="cursor: pointer;" class="security-btn" key="btn-f45f1f0e5a844d5581d7f2f04aa7d009">修改</a> '
							+ '</td></tr>'
				}
			} else {
				html_ = '<tr><td colspan="11" style="text-align: center;">' + obj.msg + '</td></tr>';
			}
			$('#ajax-tbody-1').append(html_);
		},
		
		search : function(){
			aForm.formPaging(0);
			pageInit.security();
		},
		
		searchReset : function(){
			$(".form-search").val(""); 
			domains.search();
		},
		
		closeDialog : function(){
			$.unblockUI();
		},
		
		openAddDialog : function(){
			var dialogId = 'add-dialog-div';   // 弹窗ID
			$.blockUI({
	            showOverlay:true ,
	            css:  {
	                cursor:'auto',
	                left:($(window).width() - $("#" + dialogId).width())/2 + 'px',
	                width:$("#" + dialogId).width()+'px',
	                top:($(window).height()-$("#" + dialogId).height())/2 + 'px',
	                position:'fixed', //居中
	                border: '3px solid #FB9337'  // 边界
	            },
	            message: $('#' + dialogId),
	            fadeIn: 500,//淡入时间
	            fadeOut: 1000  //淡出时间
	        });
		},
		
		/**
		 * 添加一条记录
		 */
		addDomain : function(){
			var type_ = 'post';
			var url_ = 'ajax_api_domain_add.do';
			var data_ = $("#add-dialog-table").serializeArray() ;
			var obj = JSON.parse(ajaxs.sendAjax(type_, url_, data_));
			if(obj.status == 'success'){
				jAlert(obj.msg , '系统提示' , function(){
					domains.search();
					domains.closeDialog();
				});
			}else{
				jAlert(obj.msg , '系统提示');
			}
		},
		
		/**
		 * 打开编辑弹层
		 */
		openEditDialog : function(o){
			domains.drawEditDialog(o);  
			var dialogId = 'edit-dialog-div';   // 弹窗ID
			$.blockUI({
	            showOverlay:true ,
	            css:  {
	                cursor:'auto',
	                left:($(window).width() - $("#" + dialogId).width())/2 + 'px',
	                width:$("#" + dialogId).width()+'px',
	                top:($(window).height()-$("#" + dialogId).height())/2 + 'px',
	                position:'fixed', //居中
	                border: '3px solid #FB9337'  // 边界
	            },
	            message: $('#' + dialogId),
	            fadeIn: 500,//淡入时间
	            fadeOut: 1000  //淡出时间
	        });
		},
		/**
		 * 绘制编辑弹层
		 */
		drawEditDialog:function(o){
			$("#domain-edit").val("");
			$("#company-name-edit").val("");
			var id = $(o).attr("eleId");
			domains.rowId = id;
			var domain_ = $($("#tr-" + id).children("td")[0]).text(); 
			var company_ = $($("#tr-" + id).children("td")[1]).text(); 
			$("#domain-edit").val(domain_);
			$("#company-name-edit").val(company_);
		},
		
		/**
		 * 更新一条记录
		 */
		editDomain:function(){
			var domain_ = $("#domain-edit").val(); 
			var company_ = $("#company-name-edit").val(); 
			jConfirm( '您确定要修改这条记录吗? ' , '系统提示', function(flag) {
				if(flag){
					var type_ = 'post';
					var url_ = 'ajax_api_domain_edit.do';
					var data_ = {
						id:domains.rowId,
						domain : domain_,
						companyName : company_
					};
					var obj = JSON.parse(ajaxs.sendAjax(type_, url_, data_));
					if(obj.status == 'success'){
						domains.search();
						domains.closeDialog();  
					}else{
						jAlert(obj.msg , '系统提示');
					}
				}
			});
		},
		
		deleteRow:function(o){
			var id = $(o).attr("eleId"); 
			var domain_ = $($("#tr-" + id).children("td")[0]).text(); 
			var company_ = $($("#tr-" + id).children("td")[1]).text(); 
			
			jConfirm('您确定要删除【' + domain_ + '】吗?', '系统提示', function(flag) {
				if(flag){
					var type_ = 'post';
					var url_ = 'ajax_api_domain_edit.do';
					var data_ = {
						id:id ,
						domain : domain_ ,
						companyName : company_ ,
						flag:0 
					};
					var obj = JSON.parse(ajaxs.sendAjax(type_, url_, data_));
					if(obj.status == 'success'){
						domains.search();
					}else{
						jAlert(obj.msg , '系统提示');
					}
				}
			});
		}



}












