/**
 * api信息树相关功能
 */
var apiInfo = {
		path:null,
		currentNode:null,
		
		
		/**
		 * 实例化对象
		 */
		launch:function(path_){
			apiInfo.path = path_ + 'apicenter/';                     
			return apiInfo;
		},

        /**
         * 初始化树
         */
		apiTreeInit: function(){
        	$("#api-tree li").remove();
        	$($("#tree-node-edit")[0].childNodes).remove();
        	var type_ = 'post';
            var url_ = apiInfo.path + 'ajax_api_info_list.do'; 
            var data_ = null;   
            var obj = JSON.parse(ajaxs.sendAjax(type_ , url_ , data_));  
            if(obj.status == 'success'){
                var zNodes = obj.list;
                $.fn.zTree.init($("#api-tree") , setting_ , zNodes);
                $("#callbackTrigger").bind("change", {}, setting_.setTrigger);
            }
        }, 

        // 允许移动到目标节点前面 即可以将同层最后一个节点放到同层的第一个。
        dropPrev:function(treeId, nodes, targetNode) {
            if(nodes[0].parentId == targetNode.parentId){  // 只允许同层节点之间进行拖拽
            	return true;
            }else{
            	return false;
            }
        },
        
        // 设置是否允许移动到同层节点的最后一个节点的后面 从而使被移动的节点成为最后一个节点
        dropNext:function(treeId, nodes, targetNode) {
            if(nodes[0].parentId == targetNode.parentId){  // 只允许同层节点之间进行拖拽
            	return true;
            }else{
            	return false;
            } 
        },
        
        // 拖拽到目标节点时 设置是否允许成为目标节点的子节点。
        dropInner:function(treeId, nodes, targetNode) {
            return false;
        },

        // 如果是root节点 禁止显示删除按钮
        showRemoveBtn:function(treeId, treeNode){
            if(treeNode.level == 0){
                return false;
            }else{
                return true;
            }
        },

        // 显示添加按钮 以及添加操作
        addHoverDom:function(treeId, treeNode) {
        	if(treeNode.level != 1){   
        		return false
        	}
            var newCount = 1;
            var sObj = $("#" + treeNode.tId + "_span");
            if (treeNode.editNameFlag || $("#addBtn_"+treeNode.tId).length>0)
                return;
            var addStr = "<span class='button add' id='addBtn_" + treeNode.tId + "' title='添加一个节点' onfocus='this.blur();'></span>";
            sObj.after(addStr);
            var btn = $("#addBtn_"+treeNode.tId);
            if (btn) {
                btn.bind("click", function(){
                    var zTree = $.fn.zTree.getZTreeObj("api-tree");
                    var new_ = { // 新建一个节点元素
                        id:(100 + newCount),
                        pId:treeNode.id,
                        flag:3,  // 新增节点标记
                        name:"新建结点"  // + (newCount++)
                    };
                    zTree.addNodes(treeNode ,  new_);
                    return false;
                });
            }

        },
        
        //  移除添加按钮
        removeHoverDom:function(treeId, treeNode) {
            $("#addBtn_"+treeNode.tId).unbind().remove();
        },
        
        // 捕获节点被删除之前的事件 
        beforeRemove: function(treeId , treeNode){ 
        	var type_ = false;
        	if(confirm("您确定要删除这个节点吗?")){
        		type_ = true;
        	}
        	return type_;	
        },
        
        // 用于捕获删除节点之后的事件回调函数。
        onRemove: function(event, treeId, tree){
            return false;
        }, 

        beforeDrag:function(treeId, treeNodes) {
            // TODO
            return true;
        },
        
        beforeDrop:function(treeId, treeNodes, targetNode, moveType, isCopy){
            return true;
        },
        
        beforeDragOpen:function(treeId, treeNode){

            return true;
        },
        
        onDrag:function(event, treeId, treeNodes){

            return true;
        },
        
        /**
         * 节点拖拽结束后|此处涉及到批量更新操作|同层节点之间的批量更新
         * @returns {Boolean}
         */
        onDrop:function(event, treeId, treeNodes, targetNode, moveType, isCopy){  
        	if(treeNodes[0].name == "新建结点"){
        		return false;
        	}
        	
        	
            return true;
        },
        
        onExpand:function(event, treeId, treeNode){

            return true;
        },
        
        /**
         * 捕获 勾选 或 取消勾选 之前的事件回调函数
         */
        beforeCheck : function(treeId, node){  
        	return true;  
        }, 
        
        onCheck : function(event, treeId, treeNode){
        	return true; 
        },
        
        /**
         * 商户节点选择唯一性验证
         * @param node -> treeNode
         * @param isSellerNode 是否为商户节点|true是 false 不是
         */
        isSellerNodeBeCheck : function(treeId , node , isSellerNode){ 
        	var flag = false;
        	
        	return flag;
        },
        
        // 响应节点单击事件
        ztOnClick:function(event, treeId, treeNode, clickFlag){
            var level_ = treeNode.level;
            switch(level_){
                case 0: // root节点
                    break;
                case 1: // API项目组节点 不允许编辑、添加、删除
                    break;
                case 2: // 具体的每一个API
                	apiInfo.apiInfo(event , treeNode);
                    break;
            }
        },
        
        // 添加API具体信息
        apiInfo : function(event , treeNode){
        	apiInfo.currentNode = treeNode;
            $($("#tree-node-edit")[0].childNodes).remove();
            var type_ = 'post';
            var url_ = ''; 
            if(treeNode.name == "新建结点"){
            	url_ = apiInfo.path + 'ajax_api_info_add.do'; 
            	var html_ = '系统接口名称：<input type="text" id="name" name="name" class="smallinput " placeholder="比如：TEST-PUBLIC-PROCESSOR" style="width: 300px; margin-bottom: 10px;"><br/>';
            	
				html_ += '<div style="margin-bottom: 10px;">系统接口类型：&nbsp&nbsp<input type="radio" name="atype" value="private" checked> 公司内部使用 &nbsp&nbsp';
				html_ += '<input type="radio" name="atype"  value="public"> 开放给第三方</div>';
				
				html_ += '业务处理实现：<input type="text" id="processor" name="processor" class="smallinput " placeholder="比如：publics.example.TestPublicProcessor" style="width: 300px; margin-bottom: 10px;"><br/>';
				
				html_ += '接口所属工程：<input type="text" id="module" name="module" class="smallinput " placeholder="比如：matrix-file" style="width: 300px; margin-bottom: 10px;" value="matrix-api"><br/>';
				
				html_ += '<div style="margin-bottom: 10px;">接口跨域限制：&nbsp&nbsp<input type="radio" name="domain" value="0" checked onclick="apiInfo.cleanDomainInfo()"> 不允许 &nbsp&nbsp';
				html_ += '<input type="radio" name="domain"  value="1" onclick="apiInfo.openDomainDialog()"> 允许';
				html_ += '<input type="hidden" name="domainList"  value=""></div>';

            	html_ += '<textarea cols="80" rows="5" maxlength="260"  name="remark"  class="longinput "  placeholder="备注信息描述" style="margin-bottom: 10px;width:386px"></textarea><br/>';
            	html_ += '<input type="hidden" name="parentId" value="' + treeNode.parentId +'" >';
            	var preNode = treeNode.getPreNode();   // seqnum  需要计算同层所有节点，然后得出顺序码
            	var seqnum_ = 1;
            	if(preNode != null){
            		seqnum_ = preNode.seqnum + 1;
            	} 
            	html_ += '<input type="hidden" name="seqnum" value="' + seqnum_ +'" >'; 
            	html_ += '<button class="stdbtn btn_orange " onclick="apiInfo.addApiInfo(\'' + url_ +'\')"> 提 交 </button>'
            }else{
            	url_ = apiInfo.path + 'ajax_api_info_edit.do';
            }
            $("#tree-node-edit").append(html_);
        },
        
        // 清空 domainList 隐藏域中的值
        cleanDomainInfo:function(){
        	
        },
        
        // 打开跨域列表弹窗
        openDomainDialog:function(){
        	var dialogId = "#ul-dialog-div";
    		// 自定义滚动条 | 执行此代码自定义滚动条则生效
    		$('#interface-list').slimscroll({
    			color: '#666',
    			size: '10px',
    			width: 'auto',
    			height: '180px' // '208px'
    		});
    		
    		$.blockUI({
    			showOverlay:true ,
    			css:{
    				cursor:'auto',
    				left:($(window).width() - $(dialogId).width())/2 + 'px',
    				width:$(dialogId).width()+'px',
    				height:350,
    				top:($(window).height()-$(dialogId).height())/2 + 'px',
    				position:'fixed', //居中
    				textAlign:'left',
    				border: '3px solid #FB9337'   // 边界,
    			},
    			message: $(dialogId),
    			fadeIn: 500,//淡入时间
    			fadeOut: 1000  //淡出时间
    		});
        },
        
        closeDialog:function(){
            $.unblockUI();
        }
}
 
/**
 * 定义树的基本属性
 */
var setting_ = {
        view: {
            addHoverDom: apiInfo.addHoverDom,
            removeHoverDom: apiInfo.removeHoverDom, 
            selectedMulti: false    // 不允许同时选中多个节点
        },
        check:{
        	enable:true
        }, 
        edit: {
            drag: {
                autoExpandTrigger: true, // 拖拽时父节点自动展开是否触发 callback.onExpand 事件回调函数
                prev: false, //允许移动到目标节点前面 即可以将同层最后一个节点放到同层的第一个。 
                next: false,  // 设置是否允许移动到同层节点的最后一个节点的后面 从而使被移动的节点成为最后一个节点 
                inner: false // 拖拽到目标节点时 设置是否允许成为目标节点的子节点。
            },
            enable: false,  // 设置 zTree 是否处于编辑状态默认false|初始化后需要改变编辑状态请使用 zTreeObj.setEditable() 方法
            showRemoveBtn: false, // 树形控件显示删除按钮
            showRenameBtn: false  // 树形控件显示编辑按钮
        },
        data: {
            simpleData: {
                enable: true,
                idKey: "id",
                pIdKey: "parentId",
                rootPId: 0
            }
        },
        callback: {
            beforeDrag: false,         // 捕获节点被拖拽之前的事件回调函数，并且根据返回值确定是否允许开启拖拽操作 |默认值：null
            beforeDrop: false,         // 捕获节点拖拽操作结束之前的事件回调函数，并且根据返回值确定是否允许此拖拽操作 |默认值：null
            beforeDragOpen: false,  // 获拖拽节点移动到折叠状态的父节点后，即将自动展开该父节点之前的事件回调函数，并且根据返回值确定是否允许自动展开操作 |默认值：null
            onDrag: false,                     // 捕获节点被拖拽的事件回调函数 |默认值：null
            onDrop: false,                     // 捕获节点拖拽操作结束的事件回调函数 |默认值：null
            onExpand: false,           // 捕获节点被展开的事件回调函数 |默认值：null
            onClick: apiInfo.ztOnClick,   
            beforeRemove: false,       // 捕获删除之前的数据 
            beforeCheck: false,       //surfunc.beforeCheck,    // 捕获 勾选 或 取消勾选 之前的事件回调函数
            onCheck :false,       // surfunc.onCheck
        },
        setTrigger:function(){
            var zTree = $.fn.zTree.getZTreeObj("api-tree");
            zTree.setting.edit.drag.autoExpandTrigger = $("#callbackTrigger").attr("checked");
        }
    };








































