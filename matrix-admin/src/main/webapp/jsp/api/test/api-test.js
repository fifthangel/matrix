
var apiTest = {
		
		// onmouseout 事件    
		findRequestDto : function(o){
			$("#dto-json-str").val("");  
			var target_ = $(o).val();
			var type_ = 'post';
			var url_ = 'ajax_find_request_dto.do';
			var data_ = {target : target_};
			var obj = JSON.parse(ajaxs.sendAjax(type_, url_, data_));
			if (obj.status == 'success') {
				$("#dto-json-str").val(JSON.stringify(obj.dto));
			}else{
				jAlert(obj.msg, '系统提示');
				$("#dto-json-str").val("");  
			}
		}



}













